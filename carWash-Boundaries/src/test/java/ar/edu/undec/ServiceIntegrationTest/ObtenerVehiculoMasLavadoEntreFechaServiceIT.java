package ar.edu.undec.ServiceIntegrationTest;

import ar.edu.undec.Data.ModeloEntity.VehiculoEntity;
import ar.edu.undec.Service.Controller.ObtenerVehiculoMasLavadoEntreFechaController;
import ar.edu.undec.Service.ModeloService.ClienteDTO;
import ar.edu.undec.Service.ModeloService.VehiculoDTO;
import ar.edu.undec.Service.ServiceMapper.VehiculoDTOMapper;
import input.IObtenerVehiculoMasLavadoEntreFechaInput;
import modelo.Turno;
import modelo.Vehiculo;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ObtenerVehiculoMasLavadoEntreFechaServiceIT {

    @Mock
    IObtenerVehiculoMasLavadoEntreFechaInput obtenerVehiculoMasLavadoEntreFechaInput;

    @Test
    public void ObtenerVehiculoMasLavadoEntreFecha_VehiculoCorrecto_Devuelve200(){

        ClienteDTO elCliente = new ClienteDTO(1,"Fred","El sapo 201","El pantano","31001200");
        VehiculoDTO elVehiculo=new VehiculoDTO(1,"VJR222","Ford","1992", elCliente);
        Vehiculo vehiculo = new VehiculoDTOMapper().mapeoDTOCore(elVehiculo);
        when(obtenerVehiculoMasLavadoEntreFechaInput.obtenerVehiculoMasLavadoEntreFecha(LocalDate.now().minusMonths(1),LocalDate.now())).thenReturn(vehiculo);
        ObtenerVehiculoMasLavadoEntreFechaController obtenerVehiculoMasLavadoEntreFechaController = new ObtenerVehiculoMasLavadoEntreFechaController(obtenerVehiculoMasLavadoEntreFechaInput);
        assertEquals(HttpStatus.SC_OK, obtenerVehiculoMasLavadoEntreFechaController.ObtenerVehiculoMasLavadoEntreFecha(LocalDate.now().minusMonths(1).toString(),LocalDate.now().toString()).getStatusCodeValue());

    }

    @Test
    public void ObtenerVehiculoMasLavadoEntreFecha_VehiculoVacio_Devuelve204(){
        Vehiculo vehiculo;
        vehiculo = obtenerVehiculoMasLavadoEntreFechaInput.obtenerVehiculoMasLavadoEntreFecha(LocalDate.now().minusMonths(1),LocalDate.now());
        when(obtenerVehiculoMasLavadoEntreFechaInput.obtenerVehiculoMasLavadoEntreFecha(LocalDate.now().minusMonths(1),LocalDate.now())).thenReturn(vehiculo);
        ObtenerVehiculoMasLavadoEntreFechaController obtenerVehiculoMasLavadoEntreFechaController = new ObtenerVehiculoMasLavadoEntreFechaController(obtenerVehiculoMasLavadoEntreFechaInput);
        assertEquals(HttpStatus.SC_NO_CONTENT,obtenerVehiculoMasLavadoEntreFechaController.ObtenerVehiculoMasLavadoEntreFecha(LocalDate.now().minusMonths(1).toString(),LocalDate.now().toString()).getStatusCodeValue());
    }

    @Test
    public void ObtenerVehiculoMasLavadoEntreFecha_VehiculoNoExiste_Devuelve500(){
        when(obtenerVehiculoMasLavadoEntreFechaInput.obtenerVehiculoMasLavadoEntreFecha(null,null)).thenReturn(null);
        ObtenerVehiculoMasLavadoEntreFechaController obtenerVehiculoMasLavadoEntreFechaController = new ObtenerVehiculoMasLavadoEntreFechaController(obtenerVehiculoMasLavadoEntreFechaInput);
        assertEquals(HttpStatus.SC_INTERNAL_SERVER_ERROR,obtenerVehiculoMasLavadoEntreFechaController.ObtenerVehiculoMasLavadoEntreFecha(null,null).getStatusCodeValue());
    }
}
