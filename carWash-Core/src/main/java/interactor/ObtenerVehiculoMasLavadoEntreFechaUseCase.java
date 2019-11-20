package interactor;

import input.IObtenerVehiculoMasLavadoEntreFechaInput;
import modelo.Vehiculo;
import repositorio.IObtenerVehiculoMasLavadoEntreFechaRepo;

import java.time.LocalDate;

public class ObtenerVehiculoMasLavadoEntreFechaUseCase implements IObtenerVehiculoMasLavadoEntreFechaInput {

    private IObtenerVehiculoMasLavadoEntreFechaRepo obtenerVehiculoMasLavadoEntreFechaRepo;

    public ObtenerVehiculoMasLavadoEntreFechaUseCase(IObtenerVehiculoMasLavadoEntreFechaRepo iObtenerVehiculoMasLavadoEntreFechaRepo){
        this.obtenerVehiculoMasLavadoEntreFechaRepo = iObtenerVehiculoMasLavadoEntreFechaRepo;
    }


    @Override
    public Vehiculo obtenerVehiculoMasLavadoEntreFecha(LocalDate fechaInicio, LocalDate fechaFin) {
        return (Vehiculo) obtenerVehiculoMasLavadoEntreFechaRepo.obtenerVehiculoMasLavadoEntreFecha(fechaInicio,fechaFin);
    }
}
