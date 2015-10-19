package grafica;

import javax.swing.ImageIcon;

public class SiriusGrafica extends EntidadGrafica{

	public SiriusGrafica(int velocidad, int x, int y) {
		super(velocidad, x, y);
		
		image[0] = new ImageIcon(getClass().getResource("/source/Sirius parado espalda.png"));
		image[1] = new ImageIcon(getClass().getResource("/source/Sirius parado frente.png"));
		image[2] = new ImageIcon(getClass().getResource("/source/Sirius parado izquierda.png"));
		image[3] = new ImageIcon(getClass().getResource("/source/Sirius parado derecha.png"));
	}
	
	public void morir(){}
}
