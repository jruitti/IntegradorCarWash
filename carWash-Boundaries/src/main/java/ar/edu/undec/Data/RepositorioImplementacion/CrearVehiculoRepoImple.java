package ar.edu.undec.Data.RepositorioImplementacion;

import ar.edu.undec.Data.EntityMapper.VehiculoEntityMapper;
import ar.edu.undec.Data.ModeloEntity.VehiculoEntity;
import ar.edu.undec.Data.RepositorioCRUD.IBuscarVehiculoPorMatriculaCRUD;
import ar.edu.undec.Data.RepositorioCRUD.ICrearVehiculoCRUD;
import modelo.Vehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import repositorio.IRepositorioCrearVehiculo;

@Repository
public class CrearVehiculoRepoImple implements IRepositorioCrearVehiculo {
    @Autowired
    ICrearVehiculoCRUD crearVehiculoCRUD;
    @Autowired
    IBuscarVehiculoPorMatriculaCRUD buscarVehiculoPorMatriculaCRUD;

    public boolean guardar(Vehiculo vehiculoNuevo) {
        VehiculoEntity elVehiculoAGuardar = new VehiculoEntityMapper().mapeoCoreData(vehiculoNuevo);
        return crearVehiculoCRUD.save(elVehiculoAGuardar).getIdVehiculo()!= null;
    }

    @Override
    public Vehiculo findByMatricula(String matricula) {
        Vehiculo elVehiculo = new VehiculoEntityMapper().mapeoDataCore(buscarVehiculoPorMatriculaCRUD.findByMatricula(matricula));
        if(elVehiculo!= null)
            return elVehiculo;
        return null;
    }
}
