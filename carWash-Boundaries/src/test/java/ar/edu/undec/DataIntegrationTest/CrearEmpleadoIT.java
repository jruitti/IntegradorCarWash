package ar.edu.undec.DataIntegrationTest;

import ar.edu.undec.Data.RepositorioImplementacion.CrearEmpleadoRepositoryImplemens;
import excepciones.EmpleadoIncompletoException;
import modelo.Empleado;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrearEmpleadoIT {
    @Autowired
    private CrearEmpleadoRepositoryImplemens crearEmpleadoRepositoryImplemens;

    @Test
    public void guardarEmpleado_EmpleadoGuardado_DevuelveTrue() throws EmpleadoIncompletoException {
        Empleado empleado = Empleado.factoryEmpleado(1,"juan",123456);
        boolean resultado = crearEmpleadoRepositoryImplemens.guardarEmpleado(empleado);
        assertTrue(resultado);
    }
}
