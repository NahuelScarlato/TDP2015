package grafica;

import javax.swing.ImageIcon;

public class AltairGrafica extends EntidadGrafica{

	public AltairGrafica(int velocidad, int x, int y) {
		super(velocidad, x, y);
		
		image[0] = new ImageIcon(getClass().getResource("/source/Sirius/parado-espalda.png"));
		image[1] = new ImageIcon(getClass().getResource("/source/Sirius/parado-frente.png"));
		image[2] = new ImageIcon(getClass().getResource("/source/Sirius/parado-izquierda.png"));
		image[3] = new ImageIcon(getClass().getResource("/source/Sirius/parado-derecha.png"));
		
		moving[0] = new ImageIcon(getClass().getResource("/source/Sirius/camina-espalda.gif"));
		moving[1] = new ImageIcon(getClass().getResource("/source/Sirius/camina-frente.gif"));
		moving[2] = new ImageIcon(getClass().getResource("/source/Sirius/camina-izquierda.gif"));
		moving[3] = new ImageIcon(getClass().getResource("/source/Sirius/camina-derecha.gif"));
		
		morir = new ImageIcon(getClass().getResource("/source/Sirius/morir.gif"));
	}
}
