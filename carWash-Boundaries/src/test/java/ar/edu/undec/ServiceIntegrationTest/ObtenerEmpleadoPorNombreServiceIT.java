package ar.edu.undec.ServiceIntegrationTest;

import ar.edu.undec.Service.Controller.ObtenerEmpleadoPorNombreController;
import ar.edu.undec.Service.ModeloService.EmpleadoDTO;
import ar.edu.undec.Service.ServiceMapper.EmpleadoDTOMapper;
import input.IObtenerEmpleadoPorNombreInput;
import modelo.Empleado;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ObtenerEmpleadoPorNombreServiceIT {
    @Mock
    IObtenerEmpleadoPorNombreInput obtenerEmpleadoPorNombreInput;

    @Test
    public void ObtenerEmpleadoPorNombre_EmpleadoExiste_Devuelve_200(){
        List<Empleado> empleadoList = new ArrayList<>();
        EmpleadoDTO empleadoDTO = new EmpleadoDTO(null,"juan",123456);
        empleadoList.add(new EmpleadoDTOMapper().mapeoDTOCore(empleadoDTO));
        when(obtenerEmpleadoPorNombreInput.buscarEmpleadoPorNombre("juan")).thenReturn(empleadoList);
        ObtenerEmpleadoPorNombreController obtenerEmpleadoPorNombreController = new ObtenerEmpleadoPorNombreController(obtenerEmpleadoPorNombreInput);
        assertEquals(HttpStatus.SC_OK,obtenerEmpleadoPorNombreController.consultarEmpleadoPorNombre("juan").getStatusCodeValue());
    }

    @Test
    public void ObtenerEmpleadoPorNombre_EmpleadoNoExiste_Devuelve_204(){
        List<Empleado> empleadoList = new ArrayList<>();
        empleadoList = obtenerEmpleadoPorNombreInput.buscarEmpleadoPorNombre("juan");
        when(obtenerEmpleadoPorNombreInput.buscarEmpleadoPorNombre("juan")).thenReturn(empleadoList);
        ObtenerEmpleadoPorNombreController obtenerEmpleadoPorNombreController = new ObtenerEmpleadoPorNombreController(obtenerEmpleadoPorNombreInput);
        assertEquals(HttpStatus.SC_NO_CONTENT,obtenerEmpleadoPorNombreController.consultarEmpleadoPorNombre("juan").getStatusCodeValue());
    }
}
