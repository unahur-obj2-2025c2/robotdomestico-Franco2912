package ar.edu.unahur.obj2.command.tareas;

import ar.edu.unahur.obj2.command.comandos.TareaConRegistro;
import ar.edu.unahur.obj2.command.robots.Programable;

public class CARGE extends TareaConRegistro{

    public CARGE(Integer tiempo) {
        super(tiempo);
    }

    @Override
    protected Integer ejecutarTarea(Programable robot) {
        robot.cargarBateria(tiempo);
        return tiempo;
    }
}
