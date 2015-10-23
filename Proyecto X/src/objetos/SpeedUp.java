package objetos;

import contenedores.Celda;
import entidades.Bomberman;
import grafica.SpeedUpGrafica;

/**
 * 
 */
public class SpeedUp extends PowerUp {

    /**
     * Construye un objeto de tipo SpeedUp con un puntaje predefinido.
     */
    public SpeedUp(Celda c) {
    	super(30,c);
    	c.setCeldaGrafica(new SpeedUpGrafica(c.getFila(),c.getColumna()));
    	miCelda.getMapa().getNivel().agregarGrafico(c);
    }

    /**
     * Aumenta la velocidad del bomberman.
     * @param b Bomberman.
     */
    public void activar(Bomberman b) {
       	b.aumentarVelocidad();
    }

}