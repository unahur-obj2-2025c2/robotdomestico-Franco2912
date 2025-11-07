package ar.edu.unahur.obj2.command.excepciones;

public class CantidadDeTiempoInvalidaException extends RuntimeException{

    public CantidadDeTiempoInvalidaException(){
        super("La cantidad de tiempo es invalida, se ingreso null o es el valor es menor o igual a 0 (cero)");
    }

}
