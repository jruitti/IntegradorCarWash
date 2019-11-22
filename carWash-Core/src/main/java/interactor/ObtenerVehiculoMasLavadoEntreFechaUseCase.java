package interactor;

import input.IObtenerVehiculoMasLavadoEntreFechaInput;
import modelo.Vehiculo;
import org.springframework.format.annotation.DateTimeFormat;
import repositorio.IObtenerVehiculoMasLavadoEntreFechaRepo;

import java.time.LocalDate;

public class ObtenerVehiculoMasLavadoEntreFechaUseCase implements IObtenerVehiculoMasLavadoEntreFechaInput {

    private IObtenerVehiculoMasLavadoEntreFechaRepo obtenerVehiculoMasLavadoEntreFechaRepo;

    public ObtenerVehiculoMasLavadoEntreFechaUseCase(IObtenerVehiculoMasLavadoEntreFechaRepo iObtenerVehiculoMasLavadoEntreFechaRepo){
        this.obtenerVehiculoMasLavadoEntreFechaRepo = iObtenerVehiculoMasLavadoEntreFechaRepo;
    }


    @Override
    public Vehiculo obtenerVehiculoMasLavadoEntreFecha(LocalDate fechaInicio, LocalDate fechaFin) {
        return obtenerVehiculoMasLavadoEntreFechaRepo.obtenerVehiculoMasLavadoEntreFecha(fechaInicio,fechaFin);
    }
}
