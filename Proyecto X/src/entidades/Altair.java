package entidades;

import contenedores.Celda;

/**
 * 
 */
public class Altair extends Enemigo {

    /**
     * Default constructor
     */
    public Altair(Celda c) {
    	super(20,c);
    	this.setGMod(true);
    }

    /**
     * @param dir
     */
    public void pensarAvanzar() {
        // TODO implement here
    }

}