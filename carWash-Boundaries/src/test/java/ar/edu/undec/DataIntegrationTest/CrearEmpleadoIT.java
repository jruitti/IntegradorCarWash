package ar.edu.undec.DataIntegrationTest;
import ar.edu.undec.Data.RepositorioImplementacion.CrearEmpleadoRepoImple;
import excepciones.EmpleadoIncompletoException;
import modelo.Empleado;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:crearEmpleadoAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD,scripts = "classpath:crearEmpleadoDespues.sql")
})

public class CrearEmpleadoIT {
    @Autowired
    private CrearEmpleadoRepoImple crearEmpleadoRepositoryImplemens;

    @Test
    public void guardarEmpleado_EmpleadoGuardado_DevuelveTrue() throws EmpleadoIncompletoException {
        Empleado empleado = Empleado.factoryEmpleado(1,"juan",123456);
        boolean resultado = crearEmpleadoRepositoryImplemens.guardarEmpleado(empleado);
        assertTrue(resultado);
    }
}