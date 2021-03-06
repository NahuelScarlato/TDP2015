package grafica;

import javax.swing.ImageIcon;

/**
 * Representa una CeldaGrafica de tipo SpeedUpGrafica.
 * @author Llano Jose, Scarlato Nahuel Hernan; Tecnologia de Programacion 2015.
 */
public class SpeedUpGrafica extends CeldaGrafica {
	
	/**
	 * Construye una CeldaGrafica de tipo SpeedUpGrafica, con su posicion (x,y). 
	 * @param x int.
	 * @param y int.
	 */
	public SpeedUpGrafica(int x, int y) {
		super(x, y);

		image = new ImageIcon(getClass().getResource("/source/Objetos/PowerUp/SpeedUp.png"));
	}

}
