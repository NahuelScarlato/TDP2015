package grafica;

import javax.swing.ImageIcon;

/**
 * Representa una CeldaGrafica de tipo BombalityGrafica.
 * @author Llano Jose, Scarlato Nahuel Hernan; Tecnologia de Programacion 2015.
 */
public class BombalityGrafica extends CeldaGrafica {
	
	/**
	 * Construye una CeldaGrafica de tipo BombalityGrafica, con su posicion (x,y). 
	 * @param x int.
	 * @param y int.
	 */
	public BombalityGrafica(int x, int y){
		super(x,y);
		
		image = new ImageIcon(getClass().getResource("/source/Objetos/PowerUp/Bombality.png"));
	}

}
