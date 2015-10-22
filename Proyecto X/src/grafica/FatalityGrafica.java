package grafica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class FatalityGrafica extends CeldaGrafica {

	public FatalityGrafica(int x, int y){
		super(x,y);
		
		image = new ImageIcon(getClass().getResource("/source/bombatnt.png"));
		morir = new ImageIcon(getClass().getResource("/source/bombatnt.png"));//Falta agregar imagen y direccion
		
		grafico=new JLabel(image);
	}

}
