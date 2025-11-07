package ar.edu.unahur.obj2.command.tareas;

import ar.edu.unahur.obj2.command.comandos.TareaConRegistro;
import ar.edu.unahur.obj2.command.robots.Programable;

public class LIGOFF extends TareaConRegistro{

    public LIGOFF() {
        super(1);
    }

    @Override
    public Integer ejecutarTarea(Programable robot) {
        Double consumo = Boolean.TRUE.equals(robot.getEstadoLuz()) ? 5.0 : 1.0;

        robot.apagarLuz();
        robot.descargaBateria(consumo);

        return Boolean.TRUE.equals(robot.getEstadoLuz())  ? 90 : 25;
    }

}
