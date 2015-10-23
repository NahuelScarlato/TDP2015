package grafica;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class Grafica {
	protected JLabel grafico;
	protected Icon explotar;
	
	//Tamaño de la imagen
	protected final int width = 30;
	protected final int height = 30;
	
	protected Point pos;
	
	protected Grafica(int x, int y) {
		pos = new Point(y*height,x*width);
		explotar = new ImageIcon(getClass().getResource("/source/Objetos/Explosion.gif"));
	}
	
	public Point getPos() {
		return pos;
	}
	
	public void explotar(){
		grafico.setIcon(explotar);
	}
	
	public abstract JLabel getGrafico();
	
	public void setGrafico(JLabel l){
		grafico=l;
	}

}
