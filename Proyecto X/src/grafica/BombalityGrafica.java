package grafica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BombalityGrafica extends CeldaGrafica {
	
	public BombalityGrafica(int x, int y){
		super(x,y);
		
		image = new ImageIcon(getClass().getResource("/source/Objetos/PowerUp/Bombality.png"));
		morir = new ImageIcon(getClass().getResource("/source/Objetos/PowerUp/Bombality.png"));//Falta agregar imagen y direccion
		
		grafico=new JLabel(image);
	}

}
