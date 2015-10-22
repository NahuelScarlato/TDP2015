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
     * Crea un objeto de tipo PowerUp con su respectivo puntaje, pasado por parametro.
     * @param p int.
     */
    public PowerUp(int p) {
       	puntaje=p;
    }

    /**
     * Activa el beneficio del PowerUp.
     * @param b Bomberman.
     */
    public abstract void activar(Bomberman b);

    /**
     * Retorna el valor de destruir un enemigo.
     * @return puntaje int.
     */
    public int getPuntaje() {
        return puntaje;
    }

}