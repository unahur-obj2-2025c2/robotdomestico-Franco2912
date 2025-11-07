package ar.edu.unahur.obj2.command.invoker;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.command.comandos.Tarea;
import ar.edu.unahur.obj2.command.robots.Programable;
import ar.edu.unahur.obj2.command.tareas.CARGE;
import ar.edu.unahur.obj2.command.tareas.CLEAN;
import ar.edu.unahur.obj2.command.tareas.INFO;
import ar.edu.unahur.obj2.command.tareas.LIGOFF;
import ar.edu.unahur.obj2.command.tareas.LIGON;

public class Programa {

    private final List<Tarea> tareas;

    public Programa() {
        this.tareas = new ArrayList<>();
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public void agregarTarea(Tarea tarea){
        tareas.add(tarea);
    }

    public void sacarTarea(Tarea tarea){
        tareas.remove(tarea);
    }

    public void agregarCARGE(Integer tiempo){
        tareas.add(new CARGE(tiempo));
    }

    public void agregarCLEAN(Integer metros){
        tareas.add(new CLEAN(metros));
    }

    public void agregarLIGON(){
        tareas.add(new LIGON());
    }

    public void agregarLIGOFF(){
        tareas.add(new LIGOFF());
    }

    public void agregarINFO(){
        tareas.add(new INFO());
    }

    public void vaciarLista(){
        tareas.clear();
    }

    public void ejecutarLista(Programable robot){
        robot.run(tareas);
    }
}
