package ar.edu.undec.DataIntegrationTest;

import ar.edu.undec.Data.RepositorioImplementacion.ObtenerClientePorNombreRepoImple;
import modelo.Cliente;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:ObtenerClientePorNombreAntes.sql"),
       // @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:ObtenerClientePorNombreDespues.sql")
})
public class ObtenerClientePorNombreIT {
    @Autowired
    private ObtenerClientePorNombreRepoImple obtenerClientePorNombreRepoImple;

    @Test

    public void buscarClientePorNombre_existenCliente_devuelveListado() {
        List<Cliente> losClientes = (List<Cliente>) obtenerClientePorNombreRepoImple.buscarClientePorNombre("Bautista");
        assertEquals(2, losClientes.size());
    }
}
