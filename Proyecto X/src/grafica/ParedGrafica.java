package grafica;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ParedGrafica extends CeldaGrafica {

	protected Icon image;

	public ParedGrafica(int x, int y) {
		super(x, y);

		image = new ImageIcon(getClass().getResource(null));
		morir = new ImageIcon(getClass().getResource(null));// Falta agregar
															// imagen y
															// direccion

	}
}
