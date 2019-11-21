package ar.edu.undec.Data.RepositorioImplementacion;

import ar.edu.undec.Data.EntityMapper.ClienteEntityMapper;
import ar.edu.undec.Data.EntityMapper.TurnoEntityMapper;
import ar.edu.undec.Data.ModeloEntity.ClienteEntity;
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


@Service
public class ObtenerTurnoPorClienteYVehiculoRepoImple implements IObtenerTurnoPorClienteYVehiculoRepo {

    @Autowired
    IObtenerTurnoPorClienteYVehiculoCRUD obtenerTurnoPorClienteYVehiculoCRUD;


    @Override
    public Collection<Turno> obtenerTurnoPorClienteyVehiculo( Cliente cliente,Vehiculo vehiculo) {
        ClienteEntity clienteEntity = new ClienteEntityMapper().mapeoCoreData(cliente);

        List<Turno> turnos= new ArrayList<>();
        for (TurnoEntity elturno: obtenerTurnoPorClienteYVehiculoCRUD.findAll()){
            if(elturno.getVehiculo().getCliente().equals(cliente)||elturno.getVehiculo().equals(vehiculo)) {
                turnos.add(new TurnoEntityMapper().mapeoDataCore(elturno));
            }
        }
        return turnos;

    }

}

