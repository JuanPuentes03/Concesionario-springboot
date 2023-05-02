package com.crisprog.demoConcesionario.controlador;

import com.crisprog.demoConcesionario.dto.VentaDto;
import com.crisprog.demoConcesionario.entity.Venta;
import com.crisprog.demoConcesionario.implementacion.VentaImpl;
import com.crisprog.demoConcesionario.negocio.VentaNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/venta")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
public class VentaControlador {

    @Autowired
    private VentaNegocio ventaNegocio;

    @GetMapping("/All")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> all() {

        Map<String, Object> res = new HashMap<>();
        List<VentaDto> listDto = this.ventaNegocio.encontrarTodos();
        res.put("status", "ok");
        res.put("data", listDto);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/crear")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> crearVenta(@RequestBody Map<String, Object> request) {
        Map<String, Object> res = new HashMap<>();

        System.out.println("@@@@" + request.toString());
        VentaDto ventaDto = new VentaDto();
        ventaDto.setId_Venta(0);
        ventaDto.setFechaVenta(new Date());
        ventaDto.setMontoTotal(Integer.parseInt(request.get("montoTotal").toString()));
        ventaDto.setMetodosDePago(request.get("metodosDePago").toString());
        String respuesta = this.ventaNegocio.guardarVenta(ventaDto);
        res.put("status", "ok");
        res.put("data", respuesta);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/actualizar")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> actualizarVenta(@RequestBody Map<String, Object> request) {
        Map<String, Object> res = new HashMap<>();
        VentaDto ventaDto = new VentaDto();

        ventaDto.setId_Venta(Integer.parseInt(request.get("id_Venta").toString())); //lo que va en comillas tiene que ir igual a como se llamo en el dto
        ventaDto.setFechaVenta(new Date());
        ventaDto.setMontoTotal(Integer.parseInt(request.get("montoTotal").toString()));
        ventaDto.setMetodosDePago(request.get("metodosDePago").toString());
        String respuesta = this.ventaNegocio.guardarVenta(ventaDto);
        res.put("status", "ok");
        res.put("data", respuesta);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
