package grafica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MasacralityGrafica extends CeldaGrafica {

	public MasacralityGrafica(int x, int y) {
		super(x, y);

		image = new ImageIcon(getClass().getResource("/source/Objetos/PowerUp/Masacrality.png"));
		morir = new ImageIcon(getClass().getResource("/source/Objetos/PowerUp/Masacrality.png"));//Falta agregar imagen y direccion
		
		grafico=new JLabel(image);
	}

}
