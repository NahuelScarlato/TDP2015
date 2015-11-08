package grafica;

import javax.swing.ImageIcon;

/**
 * Representa una EntidadGrafica de tipo AltairGrafica.
 * @author Llano Jose, Scarlato Nahuel Hernan; Tecnologia de Programacion 2015.
 */
public class AltairGrafica extends EntidadGrafica{

	/**
	 * Construye una EntidadGrafica de tipo AltairGrafica, con su velocidad y posicion (x,y). 
	 * @param velocidad int.
	 * @param x int.
	 * @param y int.
	 */
	public AltairGrafica(int x, int y) {
		super(x, y);
		
		image[0] = new ImageIcon(getClass().getResource("/source/Altair/EspaldaParado.png"));
		image[1] = new ImageIcon(getClass().getResource("/source/Altair/FrenteParado.png"));
		image[2] = new ImageIcon(getClass().getResource("/source/Altair/IzquierdaParado.png"));
		image[3] = new ImageIcon(getClass().getResource("/source/Altair/DerechaParado.png"));
		
		moving[0] = new ImageIcon(getClass().getResource("/source/Altair/EspaldaCamina.gif"));
		moving[1] = new ImageIcon(getClass().getResource("/source/Altair/FrenteCamina.gif"));
		moving[2] = new ImageIcon(getClass().getResource("/source/Altair/IzquierdaCamina.gif"));
		moving[3] = new ImageIcon(getClass().getResource("/source/Altair/DerechaCamina.gif"));
		
		morir = new ImageIcon(getClass().getResource("/source/Altair/morir.gif"));
	}
}
