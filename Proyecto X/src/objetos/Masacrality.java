package objetos;

import entidades.Bomberman;

/**
 * 
 */
public class Masacrality extends PowerUp {

    /**
     * Construye un objeto de tipo Masacrality con puntaje predefinido
     */
    public Masacrality() {
    	super(50);
    }

    /**
     * Activa el modo dios del bomberman.
     * @param b Bomberman.
     */
    public void activar(Bomberman b) {
        b.setGMod(true);
        //Tenemos q ver como apagarlo...
    }

}