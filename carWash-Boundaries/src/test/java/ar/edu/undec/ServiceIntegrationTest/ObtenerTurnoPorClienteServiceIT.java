package ar.edu.undec.ServiceIntegrationTest;

import ar.edu.undec.Data.EntityMapper.TurnoEntityMapper;
import ar.edu.undec.Service.Controller.ObtenerTurnoPorClienteYVehiculoController;
import ar.edu.undec.Service.ModeloService.ClienteDTO;
import ar.edu.undec.Service.ModeloService.EmpleadoDTO;
import ar.edu.undec.Service.ModeloService.TurnoDTO;
import ar.edu.undec.Service.ModeloService.VehiculoDTO;
import ar.edu.undec.Service.ServiceMapper.ClienteDTOMapper;
import ar.edu.undec.Service.ServiceMapper.TurnoDTOMapper;
import ar.edu.undec.Service.ServiceMapper.VehiculoDTOMapper;
import excepciones.TurnoIncompletoException;
import input.IObtenerTurnoPorClienteYVehiculoInput;
import modelo.Cliente;
import modelo.Turno;
import modelo.Vehiculo;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ObtenerTurnoPorClienteServiceIT {
    @Mock
    IObtenerTurnoPorClienteYVehiculoInput obtenerTurnoPorClienteYVehiculoInput;

    @Test
    public void obtenerTurnoPorClienteYVehiculo_devuelveOK_200() throws Exception{
        List<Turno>turnos=new ArrayList<>();
        ClienteDTO elCliente = new ClienteDTO(1,"Baista","Davila San Roman","El Asfalto","32458305");
        VehiculoDTO elVehiculo=new VehiculoDTO(1,"XAD456","Peugeot","2017", elCliente);
        EmpleadoDTO empleadoDTO= new EmpleadoDTO(1,"Luis",2345);
        TurnoDTO turno = new TurnoDTO(1,elVehiculo, LocalDate.of(2019,11,13),empleadoDTO,345);
        turnos.add(new TurnoDTOMapper().mapeoDTOCore(turno));
        when(obtenerTurnoPorClienteYVehiculoInput.obtenerturnoPorClienteYVehiculo(any(Cliente.class),any(Vehiculo.class))).thenReturn(turnos);
        ObtenerTurnoPorClienteYVehiculoController obtenerTurnoPorClienteYVehiculoController= new ObtenerTurnoPorClienteYVehiculoController(obtenerTurnoPorClienteYVehiculoInput);
        assertEquals(obtenerTurnoPorClienteYVehiculoController.obtenerTurnos(elCliente,elVehiculo).getStatusCodeValue(), HttpStatus.SC_OK);

    }
    @Test
    public void obtenerTurnoPorClienteYVehiculo_Turno_NoSeEncuentra_vuelveError_204() throws Exception{
        List<Turno>turnos=new ArrayList<>();
        ClienteDTO elCliente = new ClienteDTO(1,"Baista","Davila San Roman","El Asfalto","32458305");
        VehiculoDTO elVehiculo=new VehiculoDTO(1,"XAD456","Peugeot","2017", elCliente);
        EmpleadoDTO empleadoDTO= new EmpleadoDTO(1,"Luis",2345);
        TurnoDTO turno = new TurnoDTO(1,elVehiculo, LocalDate.of(2019,11,13),empleadoDTO,345);

        when(obtenerTurnoPorClienteYVehiculoInput.obtenerturnoPorClienteYVehiculo(any(Cliente.class),any(Vehiculo.class))).thenReturn(turnos);
        ObtenerTurnoPorClienteYVehiculoController obtenerTurnoPorClienteYVehiculoController= new ObtenerTurnoPorClienteYVehiculoController(obtenerTurnoPorClienteYVehiculoInput);
        assertEquals(obtenerTurnoPorClienteYVehiculoController.obtenerTurnos(elCliente,elVehiculo).getStatusCodeValue(), HttpStatus.SC_NO_CONTENT);

    }

    @Test
    public void obtenerTurnoPorClienteYVehiculo_Turno_NoExiste_vuelveError_500() throws Exception{
        List<Turno>turnos=new ArrayList<>();
        ClienteDTO elCliente = new ClienteDTO(1,"Baista","Davila San Roman","El Asfalto","32458305");
        VehiculoDTO elVehiculo=new VehiculoDTO(1,"XAD456","Peugeot","2017", elCliente);
        EmpleadoDTO empleadoDTO= new EmpleadoDTO(1,"Luis",2345);
        TurnoDTO turno = new TurnoDTO(1,elVehiculo, LocalDate.of(2019,11,13),empleadoDTO,345);

        when(obtenerTurnoPorClienteYVehiculoInput.obtenerturnoPorClienteYVehiculo(any(Cliente.class),any(Vehiculo.class))).thenReturn(null);
        ObtenerTurnoPorClienteYVehiculoController obtenerTurnoPorClienteYVehiculoController= new ObtenerTurnoPorClienteYVehiculoController(obtenerTurnoPorClienteYVehiculoInput);
        assertEquals(obtenerTurnoPorClienteYVehiculoController.obtenerTurnos(elCliente,elVehiculo).getStatusCodeValue(), HttpStatus.SC_INTERNAL_SERVER_ERROR);

    }





}
