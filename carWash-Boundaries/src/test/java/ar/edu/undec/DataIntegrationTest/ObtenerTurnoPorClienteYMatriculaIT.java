package ar.edu.undec.DataIntegrationTest;

import ar.edu.undec.Data.RepositorioImplementacion.ObtenerTurnoPorClienteYVehiculoRepoImple;
import excepciones.ClienteIncompletoException;
import excepciones.EmpleadoIncompletoException;
import excepciones.TurnoIncompletoException;
import excepciones.VehiculoIncompletoException;
import modelo.Cliente;
import modelo.Empleado;
import modelo.Turno;
import modelo.Vehiculo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ObtenerTurnoPorClienteYMatriculaIT {

    @Autowired
    private ObtenerTurnoPorClienteYVehiculoRepoImple obtenerTurnoPorClienteYVehiculoRepoImple;

    @Test
    public void obtenerTurnoPorClienteYMatricula_existenTurnos_devuelveListado() throws VehiculoIncompletoException, ClienteIncompletoException, EmpleadoIncompletoException, TurnoIncompletoException {
       Cliente clienteNuevo = Cliente.factoryCliente(1,"Pepe","Porahi 333", "Los guapos","32458305");
        Cliente bautista=Cliente.factoryCliente(2,"Bautista", "San roman 124","B° Las Torres","20458098");
        Cliente daniel=Cliente.factoryCliente(3,"Daniel", "Davila 124","B° Paiman Sur","30987789");


        Vehiculo vehiculoNuevo = Vehiculo.factoryVehiculo(1,"IXI056","Toyota","2019", clienteNuevo);


       List<Turno> losTurnos = (List<Turno>) obtenerTurnoPorClienteYVehiculoRepoImple.obtenerTurnoPorClienteyVehiculo(clienteNuevo,vehiculoNuevo);

        Turno turnoUno=Turno.factoryTurno(1, Vehiculo.factoryVehiculo(1,"IXI056","Toyota","2019", clienteNuevo), LocalDate.of(2019, 11, 9), Empleado.factoryEmpleado(1,"Pedro",234),100);
        Turno turnoDos=Turno.factoryTurno(2, Vehiculo.factoryVehiculo(2,"GFH987","Ford","2019", bautista), LocalDate.of(2019, 11, 11), Empleado.factoryEmpleado(2,"Luis",235),350);
        Turno turnoTres=Turno.factoryTurno(3, Vehiculo.factoryVehiculo(3,"ADS208","Renult","2010", daniel), LocalDate.of(2019, 11, 15), Empleado.factoryEmpleado(2,"Luis",235),450);
        losTurnos.add(turnoUno);
        losTurnos.add(turnoDos);
        losTurnos.add(turnoTres);

        assertEquals(3, losTurnos.size());



    }


}

