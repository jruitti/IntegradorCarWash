package repositorio;

import modelo.Turno;

import java.time.LocalDate;

public interface IObtenerMontoIngresadoPorTurnosEntreFechasRepo {
    Double obtenerMonto(LocalDate fechaInicio, LocalDate fechaFina);


}
