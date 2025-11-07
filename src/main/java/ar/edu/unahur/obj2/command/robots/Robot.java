package ar.edu.unahur.obj2.command.robots;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ar.edu.unahur.obj2.command.comandos.Tarea;
import ar.edu.unahur.obj2.command.tareas.INFO;

public class Robot implements Programable{

    private Double bateria;
    private Boolean luz = Boolean.FALSE;
    private final HashMap<Tarea,Integer> registro;

    public Robot(Double bateria) {
        this.bateria = bateria;
        this.registro = new HashMap<>();
    }

    @Override
    public void run(List<Tarea> tareas) {
        tareas.forEach(t -> t.ejecutar(this));
    }

    @Override
    public void cargarBateria(Integer tiempo) {
        double carga = tiempo * 0.8;
        this.bateria += carga;
        this.bateria = Math.min(this.bateria, 100.0); 
    }

    @Override
    public void registrarTarea(Tarea tarea, Integer tiempo) {
        this.registro.put(tarea, tiempo);
    }

    @Override
    public void descargaBateria(Double energia) {
        this.bateria -= energia;
        this.bateria = Math.max(this.bateria, 0.0);
    }

    @Override
    public Boolean getEstadoLuz() {
        return this.luz;
    }

    @Override
    public void encenderLuz() {
        this.luz = Boolean.TRUE;
    }

    @Override
    public void apagarLuz() {
        this.luz = Boolean.FALSE;
    }

    @Override
    public void promedioDeTiempo() {
        Integer totalTiempo = 0;
        Integer cantidad = 0;

        for (Map.Entry<Tarea, Integer> entry : registro.entrySet()) {
            Tarea tarea = entry.getKey();
            int tiempo = entry.getValue();

        if (!(tarea instanceof INFO)) {
            totalTiempo += tiempo;
            cantidad++;
            }
        }

        if(cantidad > 0){
            double promedio = (double) totalTiempo / cantidad;
            System.out.println("Promedio de tiempo de tareas ejecutadas (sin INFO): " + promedio);
        } else{
            System.out.println("No hay tareas ejecutadas (sin contar INFO).");
        }
    }

    @Override
    public HashMap<Tarea,Integer> getRegistro() {
        return registro;
    }

    @Override
    public Double getBateria() {
        return this.bateria;
    }
}
