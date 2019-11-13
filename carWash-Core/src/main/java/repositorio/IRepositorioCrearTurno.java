package repositorio;
import modelo.Turno;
import java.time.LocalDate;

public interface IRepositorioCrearTurno {
    boolean guardar(Turno turnoNuevo);

<<<<<<< HEAD:carWash-Core/src/main/java/repositorio/IRepositorioCrearTurno.java
    Turno findByVehiculoYFecha(String matricula, LocalDate fecha);
=======
    Turno findBFecha(LocalDate fecha);

>>>>>>> master:carWash-Core/src/main/java/repositorio/ICrearTurnoRepo.java
}
