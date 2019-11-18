package ar.edu.undec.ServiceIntegrationTest;

import ar.edu.undec.Service.Controller.CrearTurnoController;
import ar.edu.undec.Service.ModeloService.ClienteDTO;
import ar.edu.undec.Service.ModeloService.EmpleadoDTO;
import ar.edu.undec.Service.ModeloService.TurnoDTO;
import ar.edu.undec.Service.ModeloService.VehiculoDTO;
import excepciones.TurnoExisteException;
import input.ICrearTurnoImput;
import modelo.Turno;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrearTurnoServiceIT {

    @Mock
    ICrearTurnoImput crearTurnoImput;

    @Test
    public void crearTurno_TurnoNoExiste_Devuelve200() throws Exception {


        ClienteDTO elCliente = new ClienteDTO(1,"Baista","Davila San Roman","El Asfalto","32458305");
        VehiculoDTO elVehiculo=new VehiculoDTO(1,"XAD456","Peugeot","2017", elCliente);
        EmpleadoDTO empleadoDTO= new EmpleadoDTO(1,"Luis",2345);
        TurnoDTO turno = new TurnoDTO(null,elVehiculo, LocalDate.of(2019,11,13),empleadoDTO,345);
        when(crearTurnoImput.crearTurno(any(Turno.class))).thenReturn(true);
        CrearTurnoController crearTurnoController = new CrearTurnoController(crearTurnoImput);
        assertEquals(crearTurnoController.crearTurno(turno).getStatusCodeValue(),HttpStatus.SC_OK);

    }
    @Test
    public void crearTurno_TurnoExiste_Devuelve412() throws Exception {

        ClienteDTO elCliente = new ClienteDTO(1,"Baista","Davila San Roman","El Asfalto","32458305");
        VehiculoDTO elVehiculo=new VehiculoDTO(1,"XAD456","Peugeot","2017", elCliente);
        EmpleadoDTO empleadoDTO= new EmpleadoDTO(1,"Luis",2345);
        TurnoDTO turno = new TurnoDTO(null,elVehiculo, LocalDate.of(2019,11,13),empleadoDTO,345);
        when(crearTurnoImput.crearTurno(any(Turno.class))).thenThrow(new TurnoExisteException("El Turno Existe"));
        CrearTurnoController crearTurnoController = new CrearTurnoController(crearTurnoImput);
        assertEquals(crearTurnoController.crearTurno(turno).getStatusCodeValue(),HttpStatus.SC_PRECONDITION_FAILED);


    }

}
