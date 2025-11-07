package ar.edu.unahur.obj2.command.excepciones;

public class CantidadDeMetrosInvalidaException extends RuntimeException{

    public CantidadDeMetrosInvalidaException(){
        super("Los metros ingresados no son validos, debe se superior a 0");
    }

}
