package grafica;

import javax.swing.Icon;
import javax.swing.ImageIcon;
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
	
	/**
	 * Retorna el atributo grafico de la clase.
	 * @return grafico JLabel.
	 */
	public JLabel getGrafico(){
		if(this.grafico == null){
			this.grafico = new JLabel(image);
			this.grafico.setBounds(this.pos.x, this.pos.y, width, height);
		}
		
		return this.grafico;
	}

	public void changeIcon(Icon i){
		image=i;
	}
	
	
	public void ponerEnBlanco(){
		
		image = new ImageIcon(getClass().getResource("/source/Objetos/ParedIndestructible.png"));
		System.out.println(this.getClass());
		
		this.grafico = new JLabel(image);
		//this.grafico.setBounds(0, 0, 100, 100);
		
	}
}
