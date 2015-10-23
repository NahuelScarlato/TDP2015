package objetos;

import contenedores.Celda;
import entidades.Bomberman;
import grafica.SpeedUpGrafica;

/**
 * Representa un PowerUp de tipo SpeedUp.
 * @author Llano Jose, Scarlato Nahuel Hernan; Tecnologia de Programacion 2015.
 */
public class SpeedUp extends PowerUp {

	/**
     * Construye un objeto de tipo SpeedUp con un puntaje predefinido y una celda pasada por parametro.
     * @param c Celda.
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
       	miCelda.getCeldaGrafica().getGrafico().setIcon(null);
    }

}