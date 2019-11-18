package ar.edu.undec.ServiceIntegrationTest;

import ar.edu.undec.Service.Controller.CrearEmpleadoController;
import ar.edu.undec.Service.ModeloService.EmpleadoDTO;
import excepciones.EmpleadoExisteException;
import input.ICrearEmpleadoInput;
import modelo.Empleado;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrearEmpleadoServiceIT {

    @Mock
    ICrearEmpleadoInput crearEmpleadoInput;

    @Test
    public void CrearEmpleado_EmpleadoNoExiste_Devuelve200() throws Exception{
        EmpleadoDTO empleadoDTO = new EmpleadoDTO(null,"Pedro",123456);
        when(crearEmpleadoInput.crearEmpleado(any(Empleado.class))).thenReturn(true);
        CrearEmpleadoController crearEmpleadoController = new CrearEmpleadoController(crearEmpleadoInput);
        assertEquals(crearEmpleadoController.crearEmpleado(empleadoDTO).getStatusCodeValue(), HttpStatus.SC_OK);
    }

    @Test
    public void CrearEmpleado_EmpleadoExiste_Devuelve412()throws Exception{
        EmpleadoDTO empleadoDTO = new EmpleadoDTO(null,"Pedro",123456);
        when(crearEmpleadoInput.crearEmpleado(any(Empleado.class))).thenThrow(new EmpleadoExisteException("El Empleado Existe"));
        CrearEmpleadoController crearEmpleadoController = new CrearEmpleadoController(crearEmpleadoInput);
        assertEquals(crearEmpleadoController.crearEmpleado(empleadoDTO).getStatusCodeValue(), HttpStatus.SC_PRECONDITION_FAILED);
    }
}
