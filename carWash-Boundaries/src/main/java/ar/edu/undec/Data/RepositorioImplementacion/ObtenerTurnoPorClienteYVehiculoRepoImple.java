package ar.edu.undec.Data.RepositorioImplementacion;

import ar.edu.undec.Data.EntityMapper.TurnoEntityMapper;
import ar.edu.undec.Data.ModeloEntity.TurnoEntity;
import ar.edu.undec.Data.RepositorioCRUD.IObtenerTurnoPorClienteYVehiculoCRUD;
import modelo.Cliente;
import modelo.Turno;
import modelo.Vehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorio.IObtenerTurnoPorClienteYVehiculoRepo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/*
@Service
public class ObtenerTurnoPorClienteYVehiculoRepoImple implements IObtenerTurnoPorClienteYVehiculoRepo {

    @Autowired
    IObtenerTurnoPorClienteYVehiculoCRUD obtenerTurnoPorClienteYVehiculoCRUD;


    @Override
    public Collection<Turno> obtenerTurnoPorClienteyVehiculo( Cliente cliente,Vehiculo vehiculo) {

        List<Turno> turnosBuscados=new ArrayList<>();
        for (TurnoEntity elturno: obtenerTurnoPorClienteYVehiculoCRUD.findByClienteAndVehiculo(vehiculo.getCliente(),vehiculo)){
            Turno turno=new TurnoEntityMapper().mapeoDataCore(elturno);
            turnosBuscados.add(turno);
        }
        return turnosBuscados;


    }


}*/
