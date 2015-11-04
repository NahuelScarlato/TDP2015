package grafica;

import javax.swing.ImageIcon;

/**
 * Representa una EntidadGrafica de tipo RugulosGrafica.
 * @author Llano Jose, Scarlato Nahuel Hernan; Tecnologia de Programacion 2015.
 */
public class RugulosGrafica extends EntidadGrafica {

	/**
	 * Construye una EntidadGrafica de tipo RugulosGrafica, con su velocidad y posicion (x,y). 
	 * @param velocidad int.
	 * @param x int.
	 * @param y int.
	 */
	public RugulosGrafica(int velocidad, int x, int y) {
		super(velocidad, x, y);
		
		image[0] = new ImageIcon(getClass().getResource("/source/Rugulos/EspaldaParado.png"));
		image[1] = new ImageIcon(getClass().getResource("/source/Rugulos/FrenteParado.png"));
		image[2] = new ImageIcon(getClass().getResource("/source/Rugulos/IzquierdaParado.png"));
		image[3] = new ImageIcon(getClass().getResource("/source/Rugulos/DerechaParado.png"));
		
		moving[0] = new ImageIcon(getClass().getResource("/source/Rugulos/EspaldaCamina.gif"));
		moving[1] = new ImageIcon(getClass().getResource("/source/Rugulos/FrenteCamina.gif"));
		moving[2] = new ImageIcon(getClass().getResource("/source/Rugulos/IzquierdaCamina.gif"));
		moving[3] = new ImageIcon(getClass().getResource("/source/Rugulos/DerechaCamina.gif"));
		
		morir = new ImageIcon(getClass().getResource("/source/Rugulos/morir.gif"));
	}	
}
