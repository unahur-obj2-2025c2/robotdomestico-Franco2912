package ar.edu.unahur.obj2.command.tareas;

import ar.edu.unahur.obj2.command.comandos.TareaConRegistro;
import ar.edu.unahur.obj2.command.robots.Programable;

public class LIGON extends TareaConRegistro{

    public LIGON() {
        super(1);
    }

    @Override
    public Integer ejecutarTarea(Programable robot) {
        Double consumo = Boolean.TRUE.equals(robot.getEstadoLuz()) ? 1.0 : 5.0;
        robot.encenderLuz();
        robot.descargaBateria(consumo);
        
        return Boolean.TRUE.equals(robot.getEstadoLuz())  ? 25 : 90;
    }
}
