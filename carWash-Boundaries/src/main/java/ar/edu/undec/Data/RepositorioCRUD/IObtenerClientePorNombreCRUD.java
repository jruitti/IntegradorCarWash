package ar.edu.undec.Data.RepositorioCRUD;

import ar.edu.undec.Data.ModeloEntity.ClienteEntity;

import java.util.List;

public interface IObtenerClientePorNombreCRUD {
    List<ClienteEntity> findByNombreContains(String nombreCliente);
}
