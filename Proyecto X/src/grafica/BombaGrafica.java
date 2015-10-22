package grafica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BombaGrafica extends CeldaGrafica {
	
	public BombaGrafica(int x, int y, int r){
		super(x,y);
		
		switch(r){
        case 1:
        	image = new ImageIcon(getClass().getResource("/source/Objetos/Bomba/Bomba1.png"));
        	break;
        case 2:
        	image = new ImageIcon(getClass().getResource("/source/Objetos/Bomba/Bomba2.png"));
        	break;
        case 4:
        	image = new ImageIcon(getClass().getResource("/source/Objetos/Bomba/Bomba3.png"));
        	break;
        case 8:
        	image = new ImageIcon(getClass().getResource("/source/Objetos/Bomba/Bomba4.png"));
        	break;
        }
		
		morir = new ImageIcon(getClass().getResource("/source/Objetos/Bomba/Explosion.gif"));
		
		grafico=new JLabel(image);
	}
}
