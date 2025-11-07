package ar.edu.unahur.obj2.command.robots;

import java.util.HashMap;
import java.util.List;

import ar.edu.unahur.obj2.command.comandos.Tarea;

public interface Programable {

    void run(List<Tarea> tarea);

    void cargarBateria(Integer tiempo);

    void descargaBateria(Double energia);

    void encenderLuz();

    void apagarLuz();

    Boolean getEstadoLuz();

    void registrarTarea(Tarea tarea, Integer tiempo);

    void promedioDeTiempo();

    HashMap<Tarea,Integer> getRegistro();

    Double getBateria();
}
