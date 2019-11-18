package ar.edu.undec.ServiceIntegrationTest;

import ar.edu.undec.Service.Controller.ModificarTurnoController;
import ar.edu.undec.Service.ModeloService.ClienteDTO;
import ar.edu.undec.Service.ModeloService.EmpleadoDTO;
import ar.edu.undec.Service.ModeloService.TurnoDTO;
import ar.edu.undec.Service.ModeloService.VehiculoDTO;
import excepciones.TurnoExisteException;
import input.IModificarTurnoInput;
import modelo.Turno;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ModificarTurnoServiceIT {

    @Mock
    IModificarTurnoInput modificarTurnoInput;

    @Test
    public void modificarTurno_TurnoModificado_DevuelveTrue200() throws TurnoExisteException {

        ClienteDTO elCliente = new ClienteDTO(1,"Baista","Davila San Roman","El Asfalto","32458305");
        VehiculoDTO elVehiculo=new VehiculoDTO(1,"XAD456","Peugeot","2017", elCliente);
        EmpleadoDTO empleadoDTO= new EmpleadoDTO(1,"Luis",2345);
        TurnoDTO turnoAModificar = new TurnoDTO(null,elVehiculo, LocalDate.of(2019,11,13),empleadoDTO,345);
        when(modificarTurnoInput.modificarTurno(any(Turno.class))).thenReturn(true);
        ModificarTurnoController modificarTurnoController = new ModificarTurnoController(modificarTurnoInput);
        assertEquals(modificarTurnoController.modificarTurno(turnoAModificar).getStatusCodeValue(),HttpStatus.SC_OK);

    }

    @Test
    public void modificarTurno_TurnoModificado_DevuelveFalseError412() throws TurnoExisteException {

        ClienteDTO elCliente = new ClienteDTO(1,"Baista","Davila San Roman","El Asfalto","32458305");
        VehiculoDTO elVehiculo=new VehiculoDTO(1,"XAD456","Peugeot","2017", elCliente);
        EmpleadoDTO empleadoDTO= new EmpleadoDTO(1,"Luis",2345);
        TurnoDTO turnoAModificar = new TurnoDTO(null,elVehiculo, LocalDate.of(2019,11,13),empleadoDTO,345);
        when(modificarTurnoInput.modificarTurno(any(Turno.class))).thenThrow(new TurnoExisteException("Error Al Modificar El Cliente"));
        ModificarTurnoController modificarTurnoController = new ModificarTurnoController(modificarTurnoInput);
        assertEquals(modificarTurnoController.modificarTurno(turnoAModificar).getStatusCodeValue(), HttpStatus.SC_PRECONDITION_FAILED);

    }
}
