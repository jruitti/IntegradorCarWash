package repositorio;

import modelo.Turno;

import java.time.LocalDate;

public interface IObtenerMontoIngresadoPorTurnosEntreFechasRepo {
    Double findByFechaInicioAndFechaFin(LocalDate fechaInicio, LocalDate fechaFina);


}
