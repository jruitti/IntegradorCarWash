package ar.edu.undec.DataIntegrationTest;

import ar.edu.undec.Data.RepositorioImplementacion.ObtenerVehiculoMasLavadoEntreFechaRepoImple;
import modelo.Vehiculo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:ObtenerVehiculoMasLavadoEntreFechaAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:ObtenerVehiculoMasLavadoEntreFechaDespues.sql")
})
public class ObtenerVehiculoMasLavadoEntreFechaIT {

    @Autowired
    private ObtenerVehiculoMasLavadoEntreFechaRepoImple obtenerVehiculoMasLavadoEntreFechaRepoImple;

    @Test
    public void ObtenerVehiculoMasLavadoEntreFecha_VehiculoMasLavado_DevuelveVehiculo(){
        Vehiculo vehiculo = (Vehiculo) obtenerVehiculoMasLavadoEntreFechaRepoImple.obtenerVehiculoMasLavadoEntreFecha(LocalDate.of(2019,11,20),LocalDate.of(2019,12,20));
        assertEquals("NRP374",vehiculo.getMatricula());
    }

    @Test
    public void ObtenerVehiculoMasLavadoEntreFecha_VehiculoIncorrecto_DevuelveFalse(){
        Vehiculo vehiculo = (Vehiculo) obtenerVehiculoMasLavadoEntreFechaRepoImple.obtenerVehiculoMasLavadoEntreFecha(LocalDate.of(2019,11,20),LocalDate.of(2019,12,20));
        assertFalse(vehiculo.getMatricula().equals("NRP368"));
    }
}
