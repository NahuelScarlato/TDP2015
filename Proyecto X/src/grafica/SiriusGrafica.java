package grafica;

import javax.swing.ImageIcon;

/**
 * Representa una EntidadGrafica de tipo SiriusGrafica.
 * @author Llano Jose, Scarlato Nahuel Hernan; Tecnologia de Programacion 2015.
 */
public class SiriusGrafica extends EntidadGrafica{

	/**
	 * Construye una EntidadGrafica de tipo SiriusGrafica, con su velocidad y posicion (x,y). 
	 * @param velocidad int.
	 * @param x int.
	 * @param y int.
	 */
	public SiriusGrafica(int velocidad, int x, int y) {
		super(velocidad, x, y);
		
		image[0] = new ImageIcon(getClass().getResource("/source/Sirius/EspaldaParado.png"));
		image[1] = new ImageIcon(getClass().getResource("/source/Sirius/FrenteParado.png"));
		image[2] = new ImageIcon(getClass().getResource("/source/Sirius/IzquierdaParado.png"));
		image[3] = new ImageIcon(getClass().getResource("/source/Sirius/DerechaParado.png"));
		
		moving[0] = new ImageIcon(getClass().getResource("/source/Sirius/EspaldaCamina.gif"));
		moving[1] = new ImageIcon(getClass().getResource("/source/Sirius/FrenteCamina.gif"));
		moving[2] = new ImageIcon(getClass().getResource("/source/Sirius/IzquierdaCamina.gif"));
		moving[3] = new ImageIcon(getClass().getResource("/source/Sirius/DerechaCamina.gif"));
		
		morir = new ImageIcon(getClass().getResource("/source/Sirius/morir.gif"));
	}
}
