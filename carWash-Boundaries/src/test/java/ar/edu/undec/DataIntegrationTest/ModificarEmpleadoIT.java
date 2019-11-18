package ar.edu.undec.DataIntegrationTest;

import ar.edu.undec.Data.RepositorioImplementacion.ModificarEmpleadoRepoImple;
import excepciones.EmpleadoIncompletoException;
import modelo.Empleado;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ModificarEmpleadoIT {

    @Autowired
    ModificarEmpleadoRepoImple modificarEmpleadoRepoImple;

    @Test
    public void ModificarEmpleado_EmpleadoGuardado_DevuelveTrue() throws EmpleadoIncompletoException {
        Empleado empleado = Empleado.factoryEmpleado(null,"Abraham",987654);
        assertTrue(modificarEmpleadoRepoImple.modificarEmpleado(empleado));
    }
}
