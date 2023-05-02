package com.crisprog.demoConcesionario.controlador;


import com.crisprog.demoConcesionario.dto.VehiculoDto;
import com.crisprog.demoConcesionario.entity.Vehiculo;
import com.crisprog.demoConcesionario.implementacion.VehiculoImpl;
import com.crisprog.demoConcesionario.negocio.VehiculoNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/vehiculo")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
public class  VehiculoControlador {

    @Autowired
    private VehiculoNegocio vehiculoNegocio;

    @GetMapping("/All")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> all() {

        Map<String, Object> res = new HashMap<>();
        List<VehiculoDto> listDto = this.vehiculoNegocio.encontrarTodos();
        res.put("status", "ok");
        res.put("data", listDto);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/crear")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> crearVehiculo(@RequestBody Map<String, Object> request) {
        Map<String, Object> res = new HashMap<>();
        VehiculoDto vehiculoDto = new VehiculoDto();

        vehiculoDto.setId_Vehiculo(0);
        vehiculoDto.setPrecio(Integer.parseInt(request.get("precio").toString()));
        vehiculoDto.setColor(request.get("color").toString());
        vehiculoDto.setPlaca(request.get("placa").toString());
        vehiculoDto.setCentimetrosCubicos(Integer.parseInt(request.get("centimetrosCubicos").toString()));
        vehiculoDto.setModelo(Integer.parseInt(request.get("modelo").toString()));
        String respuesta = this.vehiculoNegocio.guardarVehiculo(vehiculoDto);
        res.put("status", "ok");
        res.put("data", respuesta);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/actualizar")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> actualizarVehiculo(@RequestBody Map<String, Object> request) {
        Map<String, Object> res = new HashMap<>();
        VehiculoDto vehiculoDto = new VehiculoDto();

        vehiculoDto.setId_Vehiculo(Integer.parseInt(request.get("id_Vehiculo").toString()));
        vehiculoDto.setPrecio(Integer.parseInt(request.get("precio").toString()));
        vehiculoDto.setColor(request.get("color").toString());
        vehiculoDto.setPlaca(request.get("placa").toString());
        vehiculoDto.setCentimetrosCubicos(Integer.parseInt(request.get("centimetrosCubicos").toString()));
        vehiculoDto.setModelo(Integer.parseInt(request.get("modelo").toString()));
        String respuesta = this.vehiculoNegocio.guardarVehiculo(vehiculoDto);
        res.put("status", "ok");
        res.put("data", respuesta);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
