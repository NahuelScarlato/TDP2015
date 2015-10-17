package objetos;

import entidades.Bomberman;

/**
 * 
 */
public abstract class PowerUp {

    /**
     * 
     */
    protected int puntaje;


    /**
     * @param p
     */
    public PowerUp(int p) {
       	puntaje=p;
    }

    /**
     * @param b
     */
    public abstract void activar(Bomberman b);

    /**
     * @return
     */
    public int getPuntaje() {
        return puntaje;
    }

}