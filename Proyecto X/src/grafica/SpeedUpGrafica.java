package grafica;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class SpeedUpGrafica extends CeldaGrafica {

	protected Icon image;

	public SpeedUpGrafica(int x, int y) {
		super(x, y);

		image = new ImageIcon(getClass().getResource("/source/bombatnt.png"));
		morir = new ImageIcon(getClass().getResource("/source/bombatnt.png"));//Falta agregar imagen y direccion
		
		grafico=new JLabel(image);
	}

}
