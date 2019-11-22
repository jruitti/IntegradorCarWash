package ar.edu.undec.DataIntegrationTest;

import ar.edu.undec.Data.RepositorioImplementacion.ObtenerMontoIngresadoPorTunoEntreFechasRepoImple;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ObtnerMontoIngresadoPorTunoEntreFechasIT {
    @Autowired
    private ObtenerMontoIngresadoPorTunoEntreFechasRepoImple obtenerMontoIngresadoPorTunoEntreFechasRepoImple;
    @Test
    @SqlGroup({
            @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:ObtenerMontoIngresadoPorTurnoEntreFechasAntes.sql"),
            //@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:ObtenerMontoIngresadoPorTurnoEntreFechasDespues.sql")
    })

    public void obtenerMontoIngresadoPorTunoEntreFechas_Correctas_SeObtieneMonto(){
        Double total = Double.valueOf(300);
        assertEquals(total ,obtenerMontoIngresadoPorTunoEntreFechasRepoImple.obtenerMonto(LocalDate.of(2019, 11, 20),LocalDate.of(2019, 11, 22)));
    }
}
