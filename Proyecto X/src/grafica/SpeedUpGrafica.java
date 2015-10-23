package grafica;

import javax.swing.ImageIcon;

public class SpeedUpGrafica extends CeldaGrafica {

	public SpeedUpGrafica(int x, int y) {
		super(x, y);

		image = new ImageIcon(getClass().getResource("/source/Objetos/PowerUp/SpeedUp.png"));
	}

}
