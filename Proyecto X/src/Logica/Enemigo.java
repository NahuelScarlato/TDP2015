package Logica;

/**
 * 
 */
public abstract class Enemigo extends Entidad {

    /**
     * 
     */
    protected int puntaje;
    
    /**
     * 
     */
    protected Celda miCelda;

    /**
     * @param p
     */
    public Enemigo(int p) {
        // TODO implement here
    }

    /**
     * @return
     */
    public int serExplotado() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public int getPuntaje() {
        // TODO implement here
        return 0;
    }

    /**
     * @param dir
     */
    public void avanzar(int dir){
    	
    }
    
    /**
     * 
     */
    public void morir() {
        // TODO implement here
    }

}