package grafica;

import javax.swing.ImageIcon;

public class MasacralityGrafica extends CeldaGrafica {

	public MasacralityGrafica(int x, int y) {
		super(x, y);

		image = new ImageIcon(getClass().getResource("/source/Objetos/PowerUp/Masacrality.png"));
	}

}
