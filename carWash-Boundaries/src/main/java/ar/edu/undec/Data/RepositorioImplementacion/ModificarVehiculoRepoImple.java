package ar.edu.undec.Data.RepositorioImplementacion;

import ar.edu.undec.Data.EntityMapper.VehiculoEntityMapper;
import ar.edu.undec.Data.ModeloEntity.VehiculoEntity;
import ar.edu.undec.Data.RepositorioCRUD.IModificarVehiculoCRUD;
import modelo.Vehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorio.IModificarVehiculoRepo;

@Service
public class ModificarVehiculoRepoImple implements IModificarVehiculoRepo {

    @Autowired
    IModificarVehiculoCRUD modificarVehiculoCRUD;

    @Override
    public boolean modificarVehiculo(Vehiculo vehiculoDatosNuevo) {
        VehiculoEntity elVehiculoAGuardar= new VehiculoEntityMapper().mapeoCoreData(vehiculoDatosNuevo);
        return modificarVehiculoCRUD.save(elVehiculoAGuardar)!=null;
    }

    @Override
    public Vehiculo findByMatricula(String matricula){
        Vehiculo elVehiculo = new VehiculoEntityMapper().mapeoDataCore(modificarVehiculoCRUD.findByMatricula(matricula));
        if(elVehiculo!= null) {
            return elVehiculo;
        }
        return null;
    }
}
