package objetos;

/**
 * 
 */
public class Pared {

    /**
     * 
     */
    protected int puntaje;


    /**
     * Construye un objeto de tipo Pared con un puntaje predefinido.
     */
    public Pared() {
        puntaje=10;
    }

    /**
     * Retorna el valor de explotar una pared.
     * @return puntaje int.
     */
    public int getPuntaje() {
        
        return puntaje;
    }
    
    /**
     * Retorna el puntaje obtenido por explotar una pared.
     * @return puntaje int.
     */
    public int serExplotado() {
        	// falta grafica 
        return puntaje;
    }
}