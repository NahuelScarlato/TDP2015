package objetos;

import entidades.Bomberman;

/**
 * 
 */
public class Bombality extends PowerUp {

    /**
     * Construye un objeto de tipo Bombality con un puntaje predefinido.
     */
    public Bombality() {
    	super(35);
    }

    /**
     * Aumenta la cantidad de bombas que puede colocar el bomberman.
     * @param b Bomberman.
     */
    public void activar(Bomberman b) {
        b.aumentarCantBombas();        
    }
}