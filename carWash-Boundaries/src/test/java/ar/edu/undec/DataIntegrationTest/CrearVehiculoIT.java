package ar.edu.undec.DataIntegrationTest;

import ar.edu.undec.Data.RepositorioImplementacion.CrearVehiculoRepoImple;
import excepciones.ClienteIncompletoException;
import excepciones.VehiculoIncompletoException;
import modelo.Cliente;
import modelo.Vehiculo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertTrue;
/*
@RunWith(SpringRunner.class)
@SpringBootTest

public class CrearVehiculoIT {
    @Autowired
    CrearVehiculoRepoImple crearVehiculoRepoImple;

    @Test
    public void guardarVehiculo_VehiculoGuardado_devuelveTrue() throws VehiculoIncompletoException, ClienteIncompletoException {
        Cliente elCliente = Cliente.factoryCliente(1,"Sancho","Panza","Porahi 1","0303456");
        Vehiculo elVehiculo = Vehiculo.factoryVehiculo(1,"NRP374","Toyota","Etios", elCliente);
        boolean resultado = crearVehiculoRepoImple.guardar(elVehiculo);
        assertTrue(resultado);
    }
}*/
