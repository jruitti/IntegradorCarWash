package input;

import excepciones.TurnoExisteException;
import modelo.Turno;

public interface IModificarTurnoInput {
    boolean modificarTurno(Turno turnoAModificar) throws TurnoExisteException;
}
