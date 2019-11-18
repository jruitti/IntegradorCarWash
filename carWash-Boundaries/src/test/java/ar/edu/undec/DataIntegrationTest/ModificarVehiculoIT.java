package ar.edu.undec.DataIntegrationTest;

import ar.edu.undec.Data.RepositorioImplementacion.ModificarVehiculoRepoImple;
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

@RunWith(SpringRunner.class)
@SpringBootTest
public class ModificarVehiculoIT {
    @Autowired
    private ModificarVehiculoRepoImple modificarVehiculoRepoImple;

    @Test
    public void ModificarVehiculo_VehiculoGuardado_devuelveTrue() throws VehiculoIncompletoException, ClienteIncompletoException {
        Cliente elCliente = Cliente.factoryCliente(null, "Ricardo Bigotzky", "Córdoba 33", "Alta Gracia", "01012314");
        Vehiculo elVehiculo = Vehiculo.factoryVehiculo(1,"NRP374","Toyota","Etios", elCliente);
        boolean resultado = modificarVehiculoRepoImple.modificarVehiculo(elVehiculo);
        assertTrue(resultado);
    }
}
