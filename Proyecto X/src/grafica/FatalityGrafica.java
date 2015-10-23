package grafica;

import javax.swing.ImageIcon;

public class FatalityGrafica extends CeldaGrafica {

	public FatalityGrafica(int x, int y){
		super(x,y);
		
		image = new ImageIcon(getClass().getResource("/source/Objetos/PowerUp/Fatality.png"));
	}

}
