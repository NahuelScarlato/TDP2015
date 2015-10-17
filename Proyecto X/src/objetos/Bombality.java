package objetos;

import entidades.Bomberman;

/**
 * 
 */
public class Bombality extends PowerUp {

    /**
     * Default constructor
     */
    public Bombality() {
    	super(35);
    }

    /**
     * @param b
     */
    public void activar(Bomberman b) {
        b.aumentarCantBombas();        
    }
}