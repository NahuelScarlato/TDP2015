package grafica;

import javax.swing.ImageIcon;

public class BombermanGrafica extends EntidadGrafica{

	public BombermanGrafica(int velocidad, int x, int y) {
		super(velocidad, x, y);
		
		image[0] = new ImageIcon(getClass().getResource("/source/Bomberman parado espalda.png"));
		image[1] = new ImageIcon(getClass().getResource("/source/Bomberman parado frente.png"));
		image[2] = new ImageIcon(getClass().getResource("/source/Bomberman parado izquierda.png"));
		image[3] = new ImageIcon(getClass().getResource("/source/Bomberman parado derecha.png"));
		
		moving[0] = new ImageIcon(getClass().getResource("/source/Bomberman-camina-arriba.gif"));
		moving[1] = new ImageIcon(getClass().getResource("/source/Bomberman-camina-abajo.gif"));
		moving[2] = new ImageIcon(getClass().getResource("/source/Bomberman-camina-izquierda.gif"));
		moving[3] = new ImageIcon(getClass().getResource("/source/Bomberman-camina-derecha.gif"));
		
		
	}
	
	public void morir(){
		grafico.setIcon(morir);
	}
}
