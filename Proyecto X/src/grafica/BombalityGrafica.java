package grafica;

import javax.swing.ImageIcon;

public class BombalityGrafica extends CeldaGrafica {
	
	public BombalityGrafica(int x, int y){
		super(x,y);
		
		image = new ImageIcon(getClass().getResource("/source/Objetos/PowerUp/Bombality.png"));
	}

}
