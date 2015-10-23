package grafica;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Representa la parte grafica.
 * @author Llano Jose, Scarlato Nahuel Hernan; Tecnologia de Programacion 2015.
 */
public abstract class Grafica {
	protected JLabel grafico;
	protected Icon explotar;
	
	//Tama�o de la imagen
	protected final int width = 30;
	protected final int height = 30;
	
	protected Point pos;
	
	/**
	 * Construye una Grafica, con su posicion (x,y). 
	 * @param x int.
	 * @param y int.
	 */
	protected Grafica(int x, int y) {
		pos = new Point(y*height,x*width);
		explotar = new ImageIcon(getClass().getResource("/source/Objetos/Explosion.gif"));
	}
	
	/**
     * Retorna la locacion de la grafica en el contenedor grafico.
     * @return pos Point.
     */
	public Point getPos() {
		return pos;
	}
	
	/**
     * Cambia el grafico asociado por el definido de explotar.
     */
	public void explotar(){
		grafico.setIcon(explotar);
	}
	
	/**
     * Retorna el grafico asociado. En caso de no tenerlo retorna uno predefinido.
     * @return grafico JLabel.
     */
	public abstract JLabel getGrafico();
	
}