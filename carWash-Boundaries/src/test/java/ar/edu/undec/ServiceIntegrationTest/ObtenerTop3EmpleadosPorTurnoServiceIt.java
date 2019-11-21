package ar.edu.undec.ServiceIntegrationTest;


import ar.edu.undec.Service.Controller.ObtenerTop3EmpleadosPorTurnoController;
import ar.edu.undec.Service.ModeloService.EmpleadoDTO;
import ar.edu.undec.Service.ServiceMapper.EmpleadoDTOMapper;
import input.IObtenerTop3EmpleadosPorTurnoInput;
import modelo.Empleado;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ObtenerTop3EmpleadosPorTurnoServiceIt {

    @Mock
    IObtenerTop3EmpleadosPorTurnoInput obtenerTop3EmpleadosPorTurnoInput;

    @Test
    public void ObtenerTop3EmpleadosPorTurnos_ListaCorrecta_Devuelve200(){
        List<Empleado> losEmpleados= new ArrayList<>();
        EmpleadoDTO emp1 = new EmpleadoDTO (1, "javier", 12345678);
        EmpleadoDTO emp2 = new EmpleadoDTO(2, "Juan", 12345465);
        EmpleadoDTO emp3 = new EmpleadoDTO(3, "Pedro", 12345987);
        losEmpleados.add(new EmpleadoDTOMapper().mapeoDTOCore(emp1));
        losEmpleados.add(new EmpleadoDTOMapper().mapeoDTOCore(emp2));
        losEmpleados.add(new EmpleadoDTOMapper().mapeoDTOCore(emp3));

        when(obtenerTop3EmpleadosPorTurnoInput.obtenerTop3EmpleadosPorTurno()).thenReturn(losEmpleados);
        ObtenerTop3EmpleadosPorTurnoController obtenerTop3EmpleadosPorTurnoController = new ObtenerTop3EmpleadosPorTurnoController(obtenerTop3EmpleadosPorTurnoInput);
        Assert.assertEquals(HttpStatus.SC_OK, obtenerTop3EmpleadosPorTurnoController.ObtenerTop3EmpleadosPorTurno().getStatusCodeValue());
    }

    @Test
    public void ObtenerTop3EmpleadosPorTurnos_ListaVacia_Devuelve204(){
        List<Empleado> losEmpleados= new ArrayList<>();
        when(obtenerTop3EmpleadosPorTurnoInput.obtenerTop3EmpleadosPorTurno()).thenReturn(losEmpleados);
        ObtenerTop3EmpleadosPorTurnoController obtenerTop3EmpleadosPorTurnoController = new ObtenerTop3EmpleadosPorTurnoController(obtenerTop3EmpleadosPorTurnoInput);
        Assert.assertEquals(HttpStatus.SC_NO_CONTENT, obtenerTop3EmpleadosPorTurnoController.ObtenerTop3EmpleadosPorTurno().getStatusCodeValue());
    }

    @Test
    public void ObtenerTop3EmpleadosPorTurnos_ListaNoExiste_Devuelve500(){
        when(obtenerTop3EmpleadosPorTurnoInput.obtenerTop3EmpleadosPorTurno()).thenReturn(null);
        ObtenerTop3EmpleadosPorTurnoController obtenerTop3EmpleadosPorTurnoController = new ObtenerTop3EmpleadosPorTurnoController(obtenerTop3EmpleadosPorTurnoInput);
        Assert.assertEquals(HttpStatus.SC_INTERNAL_SERVER_ERROR, obtenerTop3EmpleadosPorTurnoController.ObtenerTop3EmpleadosPorTurno().getStatusCodeValue());
    }

}
