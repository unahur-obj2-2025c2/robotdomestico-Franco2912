package ar.edu.unahur.obj2.command;

import java.util.List;
import java.util.Map.Entry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.command.comandos.Tarea;
import ar.edu.unahur.obj2.command.excepciones.CantidadDeMetrosInvalidaException;
import ar.edu.unahur.obj2.command.excepciones.CantidadDeTiempoInvalidaException;
import ar.edu.unahur.obj2.command.invoker.Programa;
import ar.edu.unahur.obj2.command.robots.Robot;
import ar.edu.unahur.obj2.command.tareas.INFO;
import ar.edu.unahur.obj2.command.tareas.LIGOFF;

class MainTest {

    private Robot robot;
    private Programa programa;

    @BeforeEach
    void setUp() {
        robot = new Robot(50.0); 
        programa = new Programa();
    }
    
    @Test
    void testAgregarYEjecutarCARGE() {
        programa.agregarCARGE(10);
        programa.ejecutarLista(robot);

        List<Tarea> tareas = programa.getTareas();
        assertEquals(1, tareas.size());
        assertTrue(robot.getRegistro().containsKey(tareas.get(0)));
        assertEquals(58.0, robot.getBateria(), 0.01);
    }

    @Test
    void testAgregarMultiplesTareas() {
        programa.agregarCARGE(10);
        programa.agregarLIGON();
        programa.agregarINFO();

        assertEquals(3, programa.getTareas().size());
    }

    @Test
    void testLimpiarPiso() {
        programa.agregarCLEAN(5);
        programa.agregarTarea(new INFO());
        programa.ejecutarLista(robot);

        assertEquals(25.0, robot.getBateria());
    }

    @Test
    void testVaciarLista() {
        programa.agregarCARGE(10);
        programa.agregarINFO();
        programa.vaciarLista();

        assertTrue(programa.getTareas().isEmpty());
    }

    @Test
    void testEjecutarYPromedioSinINFO() {
        programa.agregarCARGE(10);
        programa.agregarLIGON();
        programa.agregarLIGOFF();
        programa.sacarTarea(new LIGOFF());
        programa.agregarINFO();

        programa.ejecutarLista(robot);

        // Calcular promedio manualmente sin INFO
        int total = robot.getRegistro().entrySet().stream()
                .filter(e -> !(e.getKey() instanceof INFO))
                .mapToInt(Entry::getValue)
                .sum();

        long cantidad = robot.getRegistro().entrySet().stream()
                .filter(e -> !(e.getKey() instanceof INFO))
                .count();

        double promedio = (double) total / cantidad;
        assertTrue(promedio >= 10); 
    }

    @Test
    void testCantidadDeMetrosInvalidaException() {   
        Exception exception = assertThrows(CantidadDeMetrosInvalidaException.class, () -> programa.agregarCLEAN(0));
        assertEquals("Los metros ingresados no son validos, debe se superior a 0", exception.getMessage());
    }

    @Test
    void testCantidadDeTiempoInvalidaException() {
        Exception exception = assertThrows(CantidadDeTiempoInvalidaException.class, () -> programa.agregarCARGE(-10));
        assertEquals("La cantidad de tiempo es invalida, se ingreso null o es el valor es menor o igual a 0 (cero)", exception.getMessage());
    }
}

