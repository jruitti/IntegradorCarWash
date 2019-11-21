package ar.edu.undec.DataIntegrationTest;


import ar.edu.undec.Data.RepositorioImplementacion.ObtenerTop3EmpleadosPorTurnoRepoImple;
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

public class ObtenerTop3EmpleadosPorTurnoIT {

    @Autowired
    ObtenerTop3EmpleadosPorTurnoRepoImple obtenerTop3EmpleadosPorTurnoRepoImple;


    @Test
    @SqlGroup({
            @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:ObtenerTop3EmpleadosPorTurnoAntes.sql"),
            @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:ObtenerTop3EmpleadosPorTurnoDespues.sql")
    })
    public void obtenerTop3EmpleadosPorTurno_devuelveListaBien() {
        List<Empleado> los3Empleados = obtenerTop3EmpleadosPorTurnoRepoImple.obtenerTop3EmpleadosPorTurno();
        assertEquals("jose", los3Empleados.get(0).getNombre());
        assertEquals("pedro", los3Empleados.get(1).getNombre());
        assertEquals("juan", los3Empleados.get(2).getNombre());

    }

}
