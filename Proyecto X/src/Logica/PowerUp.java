package Logica;

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
        // TODO implement here
    }

    /**
     * @param b
     */
    public abstract void activar(Bomberman b);

    /**
     * @return
     */
    public int getPuntaje() {
        // TODO implement here
        return 0;
    }

}