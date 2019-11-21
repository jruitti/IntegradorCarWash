package ar.edu.undec.DataIntegrationTest;

import ar.edu.undec.Data.RepositorioImplementacion.ObtenerMontoIngresadoPorTunoEntreFechasRepoImple;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ObtnerMontoIngresadoPorTunoEntreFechasIT {
    @Autowired
    private ObtenerMontoIngresadoPorTunoEntreFechasRepoImple obtenerMontoIngresadoPorTunoEntreFechasRepoImple;
    @Test
    public void obtenerMontoIngresadoPorTunoEntreFechas_Correctas_SeObtieneMonto(){
        Double total=0.0;
        assertEquals(total,obtenerMontoIngresadoPorTunoEntreFechasRepoImple.obtenerMonto(LocalDate.of(2019, 11, 9),LocalDate.of(2019, 11, 20)));
    }
}
