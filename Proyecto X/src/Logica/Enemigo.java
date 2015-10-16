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
        super();
    	puntaje=p;
    }

    /**
     * @return
     */
    public int serExplotado() {
        morir();
        return puntaje;
    }

    /**
     * @return
     */
    public int getPuntaje() {
        return puntaje;
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