package repositorio;
import modelo.Turno;
import java.time.LocalDate;

public interface IRepositorioCrearTurno {
    boolean guardar(Turno turnoNuevo);
    Turno findByVehiculoYFecha(String matricula, LocalDate fecha);
}
