package interactorUnitTest;

import excepciones.*;
import interactor.ObtenerMontoPorTurnoEntreFechasUseCase;
import mockito.MockitoExtension;
import modelo.Cliente;
import modelo.Empleado;
import modelo.Turno;
import modelo.Vehiculo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import repositorio.IObtenerMontoIngresadoPorTurnosEntreFechasRepo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerMontoIngresadoPorTurnosEntreFechasUnitTest {
    @Mock
    IObtenerMontoIngresadoPorTurnosEntreFechasRepo obtenerMontoIngresadoPorTurnosEntreFechasRepo;

    @Test
    public void obtenerMontoIngresadoPorTurnosEntreFechas_FechasCorrecta_DevolveMonto() throws ClienteIncompletoException, EmpleadoIncompletoException, VehiculoIncompletoException, TurnoIncompletoException, FechaIncorrectaException {
        Cliente lucas=Cliente.factoryCliente(1,"Lucas", "Davila San roman 124","B° El Asfalto","32458305");
        Cliente bautista=Cliente.factoryCliente(1,"Bautista", "San roman 124","B° Las Torres","20458098");
        Cliente daniel=Cliente.factoryCliente(1,"Daniel", "Davila 124","B° Paiman Sur","30987789");

        List<Turno> losTurnos=new ArrayList<>();
        Turno turnoUno=Turno.factoryTurno(1, Vehiculo.factoryVehiculo(1,"IXI056","Ford","2019", bautista), LocalDate.of(2019, 11, 9), Empleado.factoryEmpleado(1,"Pedro",234),100);
        Turno turnoDos=Turno.factoryTurno(2, Vehiculo.factoryVehiculo(2,"GFH987","Toyota","2019", lucas), LocalDate.of(2019, 11, 11), Empleado.factoryEmpleado(2,"Luis",235),350);
        Turno turnoTres=Turno.factoryTurno(3, Vehiculo.factoryVehiculo(3,"ADS208","Renult","2010", daniel), LocalDate.of(2019, 11, 15), Empleado.factoryEmpleado(2,"Luis",235),450);
        Turno turnoCuatros=Turno.factoryTurno(4, Vehiculo.factoryVehiculo(4,"POI123","Fiat","2018", lucas), LocalDate.of(2019, 11, 20), Empleado.factoryEmpleado(1,"Pedro",234),200);


        when(obtenerMontoIngresadoPorTurnosEntreFechasRepo.findByFechaInicioAndFechaFin(LocalDate.of(2019, 11, 9),LocalDate.of(2019, 11, 20))).thenReturn(1.100);
        ObtenerMontoPorTurnoEntreFechasUseCase obtenerMontoPorTurnoEntreFechasUseCase=new ObtenerMontoPorTurnoEntreFechasUseCase(obtenerMontoIngresadoPorTurnosEntreFechasRepo);
        assertEquals(1.100,obtenerMontoPorTurnoEntreFechasUseCase.montoObtenidoEntreFechas(LocalDate.of(2019, 11, 9),LocalDate.of(2019, 11, 20)));
        System.out.println(losTurnos);
    }

    @Test
    public void obtenerMontoIngresadoPorTurnosEntreFechas_FechasIncorrectas_SeGeneraUnaException(){

        ObtenerMontoPorTurnoEntreFechasUseCase obtenerMontoPorTurnoEntreFechasUseCase=new ObtenerMontoPorTurnoEntreFechasUseCase(obtenerMontoIngresadoPorTurnosEntreFechasRepo);
        Assertions.assertThrows(FechaIncorrectaException.class,()-> obtenerMontoPorTurnoEntreFechasUseCase.montoObtenidoEntreFechas(LocalDate.of(2019, 11, 9),LocalDate.of(2018, 11, 20)));
    }

}
