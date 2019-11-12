package ar.edu.undec.DataIntegrationTest;

import ar.edu.undec.Data.RepositorioImplementacion.CrearClienteRepoImple;
import excepciones.ClienteIncompletoException;
import modelo.Cliente;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest

public class CrearClienteIT {
    @Autowired
    private CrearClienteRepoImple crearClienteRepoImple;

    @Test
    public void guardarCliente_ClienteGuardado_devuelveTrue() throws ClienteIncompletoException {

        Cliente elCliente = Cliente.factoryCliente(null, "Bautista", "Davila San roman 124", "B° El Asfalto", "32458305");
        boolean resultado = crearClienteRepoImple.guardar(elCliente);
        assertTrue(resultado);
    }
}
