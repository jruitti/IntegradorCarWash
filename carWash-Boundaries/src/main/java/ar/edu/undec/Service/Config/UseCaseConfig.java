package ar.edu.undec.Service.Config;

import interactor.CrearClienteUseCase;
import interactor.CrearVehiculoUseCase;
import interactor.ObtenerVehiculoPorMatriculaUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import repositorio.IObtenerVehiculoPorMatriculaRepo;
import repositorio.IRepositorioCrearCliente;
import repositorio.IRepositorioCrearVehiculo;

@Configuration
public class UseCaseConfig {

    @Autowired
    private IRepositorioCrearVehiculo iRepositorioCrearVehiculo;

    @Autowired
    private IObtenerVehiculoPorMatriculaRepo iObtenerVehiculoPorMatriculaRepo;

    @Autowired
        private IRepositorioCrearCliente iRepositorioCrearCliente;

    @Bean
    public CrearVehiculoUseCase crearVehiculoUseCase() {

        return new CrearVehiculoUseCase(iRepositorioCrearVehiculo);
    }

    @Bean
    public ObtenerVehiculoPorMatriculaUseCase obtenerVehiculoPorMatriculaUseCase() {

        return new ObtenerVehiculoPorMatriculaUseCase(iObtenerVehiculoPorMatriculaRepo);
    }
    @Bean
    public CrearClienteUseCase crearClienteUseCase(){
        return new CrearClienteUseCase(iRepositorioCrearCliente);
    }
}
