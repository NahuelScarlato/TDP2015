package objetos;

import entidades.Bomberman;

/**
 * 
 */
public class Fatality extends PowerUp {

    /**
     * Construye un objeto de tipo Fatality con un puntaje predefinido.
     */
    public Fatality() {
    	super(35);
    }

    /**
     * Aumenta el rango de explosion de la bomba.
     * @param b Bomberman.
     */
    public void activar(Bomberman b) {
        b.aumentarRangoBombas();
    }

}