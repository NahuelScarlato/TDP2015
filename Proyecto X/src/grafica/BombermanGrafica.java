package grafica;

import javax.swing.ImageIcon;

/**
 * Representa una EntidadGrafica de tipo BombermanGrafica.
 * @author Llano Jose, Scarlato Nahuel Hernan; Tecnologia de Programacion 2015.
 */
public class BombermanGrafica extends EntidadGrafica{

	/**
	 * Construye una EntidadGrafica de tipo BombermanGrafica, con su velocidad y posicion (x,y). 
	 * @param velocidad int.
	 * @param x int.
	 * @param y int.
	 */
	public BombermanGrafica(int velocidad, int x, int y) {
		super(velocidad, x, y);
		
		image[0] = new ImageIcon(getClass().getResource("/source/Bomberman/EspaldaParado.png"));
		image[1] = new ImageIcon(getClass().getResource("/source/Bomberman/FrenteParado.png"));
		image[2] = new ImageIcon(getClass().getResource("/source/Bomberman/IzquierdaParado.png"));
		image[3] = new ImageIcon(getClass().getResource("/source/Bomberman/DerechaParado.png"));
		
		moving[0] = new ImageIcon(getClass().getResource("/source/Bomberman/EspaldaCamina.gif"));
		moving[1] = new ImageIcon(getClass().getResource("/source/Bomberman/FrenteCamina.gif"));
		moving[2] = new ImageIcon(getClass().getResource("/source/Bomberman/IzquierdaCamina.gif"));
		moving[3] = new ImageIcon(getClass().getResource("/source/Bomberman/DerechaCamina.gif"));
	
		morir = new ImageIcon(getClass().getResource("/source/Bomberman/morir.gif"));
	}	
}
