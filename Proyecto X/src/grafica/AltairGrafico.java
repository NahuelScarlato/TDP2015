package grafica;

import javax.swing.ImageIcon;

public class AltairGrafico extends EntidadGrafica{

	public AltairGrafico(int velocidad, int x, int y) {
		super(velocidad, x, y);
		
		this.image[0] = new ImageIcon(this.getClass().getResource("/source/Background.jpg"));
		this.image[1] = new ImageIcon(this.getClass().getResource("/source/Background.jpg"));
		this.image[2] = new ImageIcon(this.getClass().getResource("/source/Background.jpg"));
		this.image[3] = new ImageIcon(this.getClass().getResource("/source/Background.jpg"));
	}
}
