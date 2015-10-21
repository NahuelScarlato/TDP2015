package grafica;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.JLabel;

public abstract class Grafica {
	protected JLabel grafico;
	protected Icon morir;
	
	//Tamaño de la imagen
	protected final int width = 30;
	protected final int height = 30;
	
	protected Point pos;
	
	protected Grafica(int x, int y) {
		pos = new Point(y*height,x*width);
	}
	
	public Point getPos() {
		return pos;
	}
	
	public void morir(){
		grafico.setIcon(morir);
	}
	
	public JLabel getGrafico(){
		grafico.setBounds(this.pos.x, this.pos.y, width, height);
		
		return grafico;
	}
	
	public void setGrafico(JLabel l){
		grafico=l;
	}

}
