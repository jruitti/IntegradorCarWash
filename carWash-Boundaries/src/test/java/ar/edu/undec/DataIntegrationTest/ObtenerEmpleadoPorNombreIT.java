package ar.edu.undec.DataIntegrationTest;

import ar.edu.undec.Data.RepositorioImplementacion.ObtenerEmpleadoPorNombreRepoImple;
import modelo.Empleado;
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
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:ObtenerEmpleadoPorNombreAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:ObtenerEmpleadoPorNombreDespues.sql")
})
public class ObtenerEmpleadoPorNombreIT {

    @Autowired
    ObtenerEmpleadoPorNombreRepoImple obtenerEmpleadoPorNombreRepoImple;

    @Test
    public void BuscarEmpleadoPorNombre_ExistenEmpleados_DevuelveListado(){

        List<Empleado> empleadoList = (List<Empleado>) obtenerEmpleadoPorNombreRepoImple.buscarEmpleadoPorNombre("juan");
        assertEquals(2,empleadoList.size());
    }
}
