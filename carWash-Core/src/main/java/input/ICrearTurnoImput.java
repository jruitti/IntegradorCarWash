package input;

import excepciones.TurnoExisteException;
import modelo.Turno;

public interface ICrearTurnoImput {
    public boolean crearTurno(Turno turnoCrear) throws TurnoExisteException;
}
