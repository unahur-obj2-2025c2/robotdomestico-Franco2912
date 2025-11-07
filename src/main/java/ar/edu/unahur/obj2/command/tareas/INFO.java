package ar.edu.unahur.obj2.command.tareas;

import ar.edu.unahur.obj2.command.comandos.TareaConRegistro;
import ar.edu.unahur.obj2.command.robots.Programable;

public class INFO extends TareaConRegistro{

    public INFO() {
        super(1);
    }

    @Override
    protected Integer ejecutarTarea(Programable robot) {
        robot.promedioDeTiempo();
        return 0;
    }

}
