package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.excepciones.CantidadDeTiempoInvalidaException;
import ar.edu.unahur.obj2.command.robots.Programable;

public abstract class TareaConRegistro implements Tarea {

    protected final Integer tiempo;

    protected  TareaConRegistro(Integer tiempo) {
        if (tiempo == null || tiempo <= 0) {
            throw new CantidadDeTiempoInvalidaException();
        }
        this.tiempo = tiempo;
    }

    @Override
    public final void ejecutar(Programable robot) {
        robot.registrarTarea(this, ejecutarTarea(robot));
    }

    protected abstract Integer ejecutarTarea(Programable robot);
}

