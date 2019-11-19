package ar.edu.undec.ServiceIntegrationTest;

import ar.edu.undec.Service.Controller.ModificarEmpleadoController;
import ar.edu.undec.Service.ModeloService.EmpleadoDTO;
import excepciones.EmpleadoExisteException;
import input.IModificarEmpleadoInput;
import modelo.Empleado;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ModificarEmpleadoServiceIT {
   // EmpleadoDTO empleadoDTO = new EmpleadoDTO(null,"juan", 123456);

    @Mock
    IModificarEmpleadoInput modificarEmpleadoInput;

    @Test
    public void ModificarEmpleado_EmpleadoModificado_DevuelveTrue200() throws EmpleadoExisteException {
        EmpleadoDTO empleadoDTO = new EmpleadoDTO(null,"juan", 123456);
        when(modificarEmpleadoInput.modificarEmpleado(any(Empleado.class))).thenReturn(true);
        ModificarEmpleadoController modificarEmpleadoController = new ModificarEmpleadoController(modificarEmpleadoInput);
        assertEquals(modificarEmpleadoController.modificarEmpleado(empleadoDTO).getStatusCodeValue(),org.apache.http.HttpStatus.SC_OK);
    }
}
