package grafica;

import javax.swing.ImageIcon;

/**
 * Representa una CeldaGrafica de tipo BombaGrafica.
 * @author Llano Jose, Scarlato Nahuel Hernan; Tecnologia de Programacion 2015.
 */
public class BombaGrafica extends CeldaGrafica {
	
	/**
	 * Construye una CeldaGrafica de tipo BombaGrafica, con su posicion (x,y) y su rango. 
	 * @param x int.
	 * @param y int.
	 * @param r int.
	 */
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
	}
}
