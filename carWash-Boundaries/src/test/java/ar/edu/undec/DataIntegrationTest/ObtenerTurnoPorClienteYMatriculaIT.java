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
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:ObtenerTurnoPorClienteYVehiculoAntes.sql"),
       // @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:ObtenerTurnoPorClienteYVehiculoAntes.sql")
})
public class ObtenerTurnoPorClienteYMatriculaIT {

    @Autowired
    private ObtenerTurnoPorClienteYVehiculoRepoImple obtenerTurnoPorClienteYVehiculoRepoImple;

    @Test
    public void obtenerTurnoPorClienteYMatricula_existenTurnos_devuelveListado() {
       List<Turno> losTurnos = (List<Turno>) obtenerTurnoPorClienteYVehiculoRepoImple.obtenerTurnoPorClienteyVehiculo("34724669","NRP374");
       assertEquals(2, losTurnos.size());
       assertEquals("Matías de la Fuente", losTurnos.get(0).getVehiculo().getCliente().getNombre());

    }


}

