package com.crisprog.demoConcesionario.negocio;

import com.crisprog.demoConcesionario.dto.VehiculoDto;
import com.crisprog.demoConcesionario.entity.Vehiculo;
import com.crisprog.demoConcesionario.implementacion.VehiculoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VehiculoNegocio {

    @Autowired
    private VehiculoImpl vehiculoImpl;

    public List<VehiculoDto> listDtoVehiculos;

    public List<VehiculoDto> encontrarTodos() {
        listDtoVehiculos = new ArrayList<>();
        this.vehiculoImpl.encontrarTodos().forEach(vehiculo -> {
            VehiculoDto vehiculoDto = new VehiculoDto();
            vehiculoDto.setId_Vehiculo(vehiculo.getId_Vehiculo());
            vehiculoDto.setColor(vehiculo.getColor());
            vehiculoDto.setPlaca(vehiculo.getPlaca());
            vehiculoDto.setPrecio(vehiculo.getPrecio());
            vehiculoDto.setModelo(vehiculo.getModelo());
            vehiculoDto.setCentimetrosCubicos(vehiculo.getCentimetrosCubicos());
            this.listDtoVehiculos.add(vehiculoDto);
        });
        return this.listDtoVehiculos;
    }

    public String guardarVehiculo(VehiculoDto vehiculoDto) {
        Vehiculo vehiculo = new Vehiculo();
        try {
            if (vehiculoDto.getId_Vehiculo()!= 0) {
                vehiculo.setId_Vehiculo(vehiculoDto.getId_Vehiculo());
                vehiculo.setColor(vehiculoDto.getColor());
                vehiculo.setPlaca(vehiculoDto.getPlaca());
                vehiculo.setPrecio(vehiculoDto.getPrecio());
                vehiculo.setModelo(vehiculoDto.getModelo());
                vehiculo.setCentimetrosCubicos(vehiculoDto.getCentimetrosCubicos());
                this.vehiculoImpl.actualizarVehiculo(vehiculo);
            } else {
                vehiculoDto.setColor(vehiculoDto.getColor());
                vehiculoDto.setPlaca(vehiculoDto.getPlaca());
                vehiculoDto.setPrecio(vehiculoDto.getPrecio());
                vehiculoDto.setModelo(vehiculoDto.getModelo());
                vehiculoDto.setCentimetrosCubicos(vehiculoDto.getCentimetrosCubicos());
                this.vehiculoImpl.crearVehiculo(vehiculo);
            }
            return "Se guardaron los datos correctamente";
        } catch (Exception e) {
            return "Fallo algo";
        }
    }
}