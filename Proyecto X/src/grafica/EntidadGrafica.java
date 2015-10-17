package grafica;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.JLabel;

public abstract class EntidadGrafica {
	protected JLabel grafico;
	protected Icon image[];
	//Tamaño de la imagen
	protected final int width = 32;
	protected final int height = 32;
	
	protected int velocidad;
	
	protected Point pos;
	
	protected EntidadGrafica(int velocidad, int x, int y) {
		this.pos = new Point(x * this.width, y * this.height);
		this.velocidad = velocidad;
		
		this.image = new Icon[4];
	}
	
	public int getVelocidad() {
		return velocidad;
	}

	public Point getPos() {
		return pos;
	}
	
	protected void changeIcon(int dir){
		this.grafico.setIcon(this.image[dir]);
	}
	
	public void mover(int dir){
		
		//ACA PONER LA ANIMACION DE CORRER .GIF segun corresponda
		
		try {
			switch (dir){
				case 0: // Arriba
					for(int i = 0; i < this.height; i += this.velocidad){
						this.grafico.setBounds(this.pos.x, this.pos.y -= this.velocidad, width, height);
						Thread.sleep(100);
					}
					break;
				case 2: // Abajo
					for(int i = 0; i < this.height; i += this.velocidad){
						this.grafico.setBounds(this.pos.x, this.pos.y += this.velocidad, width, height);
						Thread.sleep(100);
					}
					break;
				case 1: // Derecha
					for(int i = 0; i < this.width; i += this.velocidad){
						this.grafico.setBounds(this.pos.x += this.velocidad, this.pos.y, width, height);
						Thread.sleep(100);
					}
					break;
				case 3: // Izquierda
					for(int i = 0; i < this.width; i += this.velocidad){
						this.grafico.setBounds(this.pos.x -= this.velocidad, this.pos.y, width, height);
						Thread.sleep(100);
					}
					break;
				
			}
			
			this.changeIcon(dir);
		} 
		catch (InterruptedException e){
			e.printStackTrace();			
		}
	}
	
	public JLabel getGrafico(){
		if(this.grafico == null){
			this.grafico = new JLabel(image[0]);
			this.grafico.setBounds(this.pos.x, this.pos.y, width, height);
		}
		
		return this.grafico;
	}

}
