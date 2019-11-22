package interactor;

import excepciones.FechaIncorrectaException;
import input.IObtenerMontoIngresadoPorTurnoEntreFechasInpu;
import org.springframework.format.annotation.DateTimeFormat;
import repositorio.IObtenerMontoIngresadoPorTurnosEntreFechasRepo;

import java.time.LocalDate;

public class ObtenerMontoPorTurnoEntreFechasUseCase implements IObtenerMontoIngresadoPorTurnoEntreFechasInpu {
    private IObtenerMontoIngresadoPorTurnosEntreFechasRepo obtenerMontoIngresadoPorTurnosEntreFechasRepo;

    public ObtenerMontoPorTurnoEntreFechasUseCase(IObtenerMontoIngresadoPorTurnosEntreFechasRepo obtenerMontoIngresadoPorTurnosEntreFechasRepo) {
        this.obtenerMontoIngresadoPorTurnosEntreFechasRepo=obtenerMontoIngresadoPorTurnosEntreFechasRepo;
    }

    public Double montoObtenidoEntreFechas(LocalDate fechaInicio, LocalDate fechaFin) throws FechaIncorrectaException {
        if(fechaInicio.isBefore(fechaFin)){
            return obtenerMontoIngresadoPorTurnosEntreFechasRepo.obtenerMonto(fechaInicio,fechaFin);
        }else throw new FechaIncorrectaException("la FechaInicio no debe ser posterior a la fechaFin");
    }
}
