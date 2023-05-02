package com.crisprog.demoConcesionario.implementacion;

import com.crisprog.demoConcesionario.entity.Vehiculo;
import com.crisprog.demoConcesionario.repositorio.RepositoryVehiculo;
import com.crisprog.demoConcesionario.servicio.VehiculoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoImpl implements VehiculoServicio {

    @Autowired
    RepositoryVehiculo repositoryVehiculo;

    @Override
    public List<Vehiculo> encontrarTodos() {
        return this.repositoryVehiculo.findAll();
    }

    @Override
    public Vehiculo encontrarPorId(int id) {
        return this.repositoryVehiculo.encontrarPorId(id);
    }


    @Override
    public void actualizarVehiculo(Vehiculo vehiculo) {
    this.repositoryVehiculo.save(vehiculo);
    }

    @Override
    public void crearVehiculo(Vehiculo vehiculo) {
     this.repositoryVehiculo.save(vehiculo);
    }

    @Override
    public void eliminarVehiculo(int id) {

    }
}