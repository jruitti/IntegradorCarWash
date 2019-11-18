package ar.edu.undec.DataIntegrationTest;


import ar.edu.undec.Data.RepositorioImplementacion.ModificarTurnoRepoImple;
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
import repositorio.IModificarTurnoRepo;

import java.time.LocalDate;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ModificarTurnoIT {
    @Autowired
    private ModificarTurnoRepoImple modificarTurnoRepoImple;

    @Test
    public void modificarTurno_TurnoGuardado_devuelveTrue() throws TurnoIncompletoException, ClienteIncompletoException, VehiculoIncompletoException, EmpleadoIncompletoException {
        Cliente elCliente = Cliente.factoryCliente(1,"Pepe Salinas","Porahi 256","Los guapes 123","1234567");
        Vehiculo elVehiculo = Vehiculo.factoryVehiculo(1, "NRP374", "Toyota", "2016", elCliente);
        Empleado elEmpleado = Empleado.factoryEmpleado(2, "Pedro Anderson", 0303456);
        Turno turno = Turno.factoryTurno(null,elVehiculo, LocalDate.of(2019,11,13), elEmpleado,750);
        boolean resultado= modificarTurnoRepoImple.modificarTurno(turno);
        assertTrue(resultado);

    }
}
