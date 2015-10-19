package entidades;

import contenedores.Celda;

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
    public Enemigo(int p,Celda c) {
        super(c);
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
    public abstract void pensarAvanzar();
    
    /**
     * 
     */
    public void morir() {
        
    }

}