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
import static org.junit.Assert.assertEquals;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:ObtenerVehiculoPorMatriculaAntes.sql"),
        //@Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:ObtenerVehiculoPorMatriculaDespues.sql")
})

public class ObtenerVehiculoPorMatriculaIT {
    @Autowired
    private ObtenerVehiculoPorMatriculaRepoImple obtenerVehiculoPorMatriculaRepoImple;

    @Test
    public void buscarVehiculoPorMatricula_existenVehiculos_DevuelveVehiculo() {
        List<Vehiculo> losVehiculos = (List<Vehiculo>) obtenerVehiculoPorMatriculaRepoImple.buscarVehiculoPorMatricula("NRP374");
        assertEquals("NRP374", losVehiculos.get(0).getMatricula());
    }

}
