package input;

import excepciones.FechaIncorrectaException;

import java.time.LocalDate;

public interface IObtenerMontoIngresadoPorTurnoEntreFechasInpu {

    Double montoObtenidoEntreFechas(LocalDate fechaInicio, LocalDate fechaFin) throws FechaIncorrectaException;
}
