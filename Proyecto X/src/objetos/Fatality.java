package objetos;

import entidades.Bomberman;

/**
 * 
 */
public class Fatality extends PowerUp {

    /**
     * Default constructor
     */
    public Fatality() {
    	super(35);
    }

    /**
     * @param b
     */
    public void activar(Bomberman b) {
        b.aumentarRangoBombas();
    }

}