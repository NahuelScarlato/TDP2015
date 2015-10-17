package entidades;

import contenedores.Celda;

/**
 * 
 */
public abstract class Entidad {
	
    /**
     * 
     */
    protected boolean GMod;
    
    /**
     * 
     */
    protected Celda miCelda;
    
    /**
     * Default constructor
     */
    public Entidad(Celda c) {
    	GMod=false;
    	miCelda=c;
    }
    
    /**
     * @return
     */
    public boolean getGMod() {
        return GMod;
    }

    /**
     * @param gM
     */
    public void setGMod(boolean gM) {
     	GMod=gM;
    }
    
    /**
     * @return
     */
    public Celda getCelda() {
        return miCelda;
    }

    /**
     * @param c
     */
    public void setCelda(Celda c) {
    	miCelda=c;
    }
    
    /**
     * 
     */
    public abstract void morir();

}