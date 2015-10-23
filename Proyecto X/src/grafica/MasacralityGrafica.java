package grafica;

import javax.swing.ImageIcon;

/**
 * Representa una CeldaGrafica de tipo MasacralityGrafica.
 * @author Llano Jose, Scarlato Nahuel Hernan; Tecnologia de Programacion 2015.
 */
public class MasacralityGrafica extends CeldaGrafica {
	
	/**
	 * Construye una CeldaGrafica de tipo MasacralityGrafica, con su posicion (x,y). 
	 * @param x int.
	 * @param y int.
	 */
	public MasacralityGrafica(int x, int y) {
		super(x, y);

		image = new ImageIcon(getClass().getResource("/source/Objetos/PowerUp/Masacrality.png"));
	}

}
