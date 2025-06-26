package cl.prueba.uno.Excepcion;

public class CafeteriaNoEncontrada extends RuntimeException{
    public CafeteriaNoEncontrada(String message){
        super(message);
    }
}
