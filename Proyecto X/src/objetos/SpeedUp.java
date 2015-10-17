package objetos;

import entidades.Bomberman;

/**
 * 
 */
public class SpeedUp extends PowerUp {

    /**
     * Default constructor
     */
    public SpeedUp() {
    	super(30);
    }

    /**
     * @param b
     */
    public void activar(Bomberman b) {
       	b.aumentarVelocidad();
    }

}