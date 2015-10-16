package Logica;

/**
 * 
 */
public abstract class Entidad {
	
    /**
     * 
     */
    protected boolean GMod;
    
    /**
     * Default constructor
     */
    public Entidad() {
    }

    /**
     * @param dir
     */
    public abstract void avanzar(int dir);

    /**
     * @return
     */
    public abstract int serExplotado();

    /**
     * @return
     */
    public Celda getCelda() {
        // TODO implement here
        return null;
    }

    /**
     * @param c
     */
    public void setCelda(Celda c) {
        // TODO implement here
    }

    /**
     * @return
     */
    public boolean getGMod() {
        // TODO implement here
        return false;
    }

    /**
     * @param gM
     */
    public void setGMod(boolean gM) {
        // TODO implement here
    }
    
    /**
     * 
     */
    public abstract void morir();

}