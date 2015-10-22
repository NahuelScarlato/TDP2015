package grafica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class SpeedUpGrafica extends CeldaGrafica {

	public SpeedUpGrafica(int x, int y) {
		super(x, y);

		image = new ImageIcon(getClass().getResource("/source/Objetos/PowerUp/SpeedUp.png"));
		morir = new ImageIcon(getClass().getResource("/source/Objetos/PowerUp/SpeeUp.png"));//Falta agregar imagen y direccion
		
		grafico=new JLabel(image);
	}

}
