package grafica;


import javax.swing.ImageIcon;

/**
 * Representa una CeldaGrafica de tipo ParedGrafica.
 * @author Llano Jose, Scarlato Nahuel Hernan; Tecnologia de Programacion 2015.
 */
public class TransitableGrafica extends CeldaGrafica {

	/**
	 * Construye una CeldaGrafica de tipo ParedGrafica, con su posicion (x,y). 
	 * @param x int.
	 * @param y int.
	 */
	public TransitableGrafica(int x, int y) {
		super(x, y);

		image = new ImageIcon(getClass().getResource("/source/Objetos/CeldaVacia.png"));

	}
}
