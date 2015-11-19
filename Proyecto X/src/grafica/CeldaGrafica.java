package grafica;

import javax.swing.Icon;
import javax.swing.JLabel;

/**
 * Representa una Grafica de tipo CeldaGrafica.
 * @author Llano Jose, Scarlato Nahuel Hernan; Tecnologia de Programacion 2015.
 */
public abstract class CeldaGrafica extends Grafica {
	
	protected Icon image;
	
	/**
	 * Construye una Grafica de tipo CeldaGrafica, con su posicion (x,y). 
	 * @param x int.
	 * @param y int.
	 */
	public CeldaGrafica(int x, int y) {
		super(x, y);		
	}
		
	public JLabel getGrafico(){
		if(this.grafico == null){
			this.grafico = new JLabel(image);
			this.grafico.setBounds(this.pos.x, this.pos.y, width, height);
		}
		
		return this.grafico;
	}
}
