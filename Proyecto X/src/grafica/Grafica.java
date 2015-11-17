package grafica;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import contenedores.Celda;
import threads.GraficaExplosion;

/**
 * Representa la parte grafica.
 * @author Llano Jose, Scarlato Nahuel Hernan; Tecnologia de Programacion 2015.
 */
public abstract class Grafica {
	protected JLabel grafico;
	protected Icon explotar;
	
	//Tamaño de la imagen
	protected final int width = 32;
	protected final int height = 32;
	
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
	public void explotar(Celda c){
		JLabel nuevo=new JLabel(explotar);
		nuevo.setBounds(this.pos.x, this.pos.y, width, height);
		c.getMapa().getNivel().getGUI().getFrame().add(nuevo,1);
		new GraficaExplosion(c,nuevo);
	}
	
	/**
     * Retorna el grafico asociado. En caso de no tenerlo retorna uno predefinido.
     * @return grafico JLabel.
     */
	public abstract JLabel getGrafico();
	
}
