package Logica;

/**
 * 
 */
public class Masacrality extends PowerUp {

    /**
     * Default constructor
     */
    public Masacrality() {
    	super(50);
    }

    /**
     * @param b
     */
    public void activar(Bomberman b) {
        b.setGMod(true);
        //Tenemos q ver como apagarlo...
    }

}