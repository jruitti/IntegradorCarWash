package ar.edu.undec.DataIntegrationTest;

import ar.edu.undec.Data.RepositorioImplementacion.ObtenerVehiculoPorMatriculaRepoImple;
import modelo.Vehiculo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:ObtenerVehiculoPorMatriculaAntes.sql"),
})

public class ObtenerVehiculoPorMatriculaIT {
    @Autowired
    private ObtenerVehiculoPorMatriculaRepoImple obtenerVehiculoPorMatriculaRepoImple;

    @Test
    public void buscarVehiculoPorMatricula_existenVehiculos_DevuelveListado() {

    }

}
