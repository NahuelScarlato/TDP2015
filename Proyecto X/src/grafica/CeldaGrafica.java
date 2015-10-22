package grafica;

import javax.swing.Icon;
import javax.swing.JLabel;

public abstract class CeldaGrafica extends Grafica {
	
	protected Icon image;
	
	public CeldaGrafica(int x, int y) {
		super(x, y);
		
	}
	
	public JLabel getGrafico(){
		if(this.grafico == null){
			this.grafico = new JLabel(image);
			this.grafico.setBounds(this.pos.x, this.pos.y, width, height);
		}
		
		return this.grafico;
	}

}
