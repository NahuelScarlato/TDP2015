package objetos;

import entidades.Bomberman;

/**
 * 
 */
public class SpeedUp extends PowerUp {

    /**
     * Construye un objeto de tipo SpeedUp con un puntaje predefinido.
     */
    public SpeedUp() {
    	super(30);
    }

    /**
     * Aumenta la velocidad del bomberman.
     * @param b Bomberman.
     */
    public void activar(Bomberman b) {
       	b.aumentarVelocidad();
    }

}