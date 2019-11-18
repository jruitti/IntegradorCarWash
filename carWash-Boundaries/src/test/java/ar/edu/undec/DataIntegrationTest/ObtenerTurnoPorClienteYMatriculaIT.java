package ar.edu.undec.DataIntegrationTest;

import ch.qos.logback.core.net.server.Client;
import modelo.Cliente;
import modelo.Turno;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ObtenerTurnoPorClienteYMatriculaIT {

    @Autowired
    private ObtenerTurnoPorClienteYMatrigulaRepoImple obtenerTurnoPorClienteYMatrigulaRepoImple;

    public void obtenerTurnoPorClienteYMatricula_existenTurnos_devuelveListado() {

        List<Turno> losTurnos = (List<Turno>) obtenerTurnoPorClienteYMatrigulaRepoImple.obternerTurnoPorClienteYMatricula();

        List<Piloto> losPilotos = (List<Piloto>) buscarPilotosPorNombreRepoImpl.buscarPilotosPorNombre("Juan");
        assertEquals(2, losPilotos.size());
    }

}
