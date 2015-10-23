package objetos;

import contenedores.Celda;
import entidades.Bomberman;

/**
 * Representa un PowerUp.
 * @author Llano Jose, Scarlato Nahuel Hernan; Tecnologia de Programacion 2015.
 */
public abstract class PowerUp {

    protected int puntaje;
    
    protected Celda miCelda;

    /**
     * Construye un objeto de tipo PowerUp con un puntaje predefinido y una celda pasada por parametro.
     * @param p int.
     * @param c Celda.
     */
    public PowerUp(int p,Celda c) {
       	puntaje=p;
       	miCelda=c;
    }

    /**
     * Activa el beneficio del PowerUp.
     * @param b Bomberman.
     */
    public abstract void activar(Bomberman b);

    /**
     * Retorna el puntaje de obtener el power up.
     * @return puntaje int.
     */
    public int getPuntaje() {
        return puntaje;
    }

}