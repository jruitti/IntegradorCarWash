package ar.edu.undec.Service.Config;

import interactor.CrearVehiculoUseCase;
import interactor.ObtenerVehiculoPorMatriculaUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import repositorio.IObtenerVehiculoPorMatriculaRepo;
import repositorio.IRepositorioCrearVehiculo;

@Configuration
public class UseCaseConfig {

    @Autowired
    private IRepositorioCrearVehiculo iRepositorioCrearVehiculo;

    @Autowired
    private IObtenerVehiculoPorMatriculaRepo iObtenerVehiculoPorMatriculaRepo;

    @Bean
    public CrearVehiculoUseCase crearVehiculoUseCase() {

        return new CrearVehiculoUseCase(iRepositorioCrearVehiculo);
    }

    @Bean
    public ObtenerVehiculoPorMatriculaUseCase obtenerVehiculoPorMatriculaUseCase() {

        return new ObtenerVehiculoPorMatriculaUseCase(iObtenerVehiculoPorMatriculaRepo);
    }
}
