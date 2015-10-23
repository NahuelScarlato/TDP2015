package grafica;

import javax.swing.ImageIcon;

/**
 * Representa una CeldaGrafica de tipo FatalityGrafica.
 * @author Llano Jose, Scarlato Nahuel Hernan; Tecnologia de Programacion 2015.
 */
public class FatalityGrafica extends CeldaGrafica {

	/**
	 * Construye una CeldaGrafica de tipo FatalityGrafica, con su posicion (x,y). 
	 * @param x int.
	 * @param y int.
	 */
	public FatalityGrafica(int x, int y){
		super(x,y);
		
		image = new ImageIcon(getClass().getResource("/source/Objetos/PowerUp/Fatality.png"));
	}

}
