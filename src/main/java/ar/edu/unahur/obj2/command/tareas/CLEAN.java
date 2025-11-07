package ar.edu.unahur.obj2.command.tareas;

import ar.edu.unahur.obj2.command.comandos.TareaConRegistro;
import ar.edu.unahur.obj2.command.excepciones.CantidadDeMetrosInvalidaException;
import ar.edu.unahur.obj2.command.robots.Programable;

public class CLEAN extends TareaConRegistro{

    private Integer metros;

    public CLEAN (Integer metros) {
        super(1);
        if (metros == null || metros <= 0) {
            throw new CantidadDeMetrosInvalidaException();
        }
        this.metros = metros;
    }

    @Override
    public Integer ejecutarTarea(Programable robot) {
        Double consumo = 5.00 * metros;
        robot.descargaBateria(consumo);
        return 180 * metros;
    }

}
