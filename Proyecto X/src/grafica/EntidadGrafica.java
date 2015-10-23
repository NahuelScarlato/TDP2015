package grafica;

import javax.swing.Icon;
import javax.swing.JLabel;

import contenedores.Celda;

public abstract class EntidadGrafica extends Grafica{
	protected Icon image[];
	protected Icon moving[];
	protected Icon morir;
	
	protected int velocidad;	
	
	protected EntidadGrafica(int velocidad, int x, int y) {
		super(x,y);
		this.velocidad = velocidad;
		image = new Icon[4];
		moving = new Icon[4];
	}
	
	public JLabel getGrafico(){
		if(this.grafico == null){
			this.grafico = new JLabel(image[0]);
			this.grafico.setBounds(this.pos.x, this.pos.y, width, height);
		}
		
		return this.grafico;
	}
	
	public int getVelocidad() {
		return velocidad;
	}	
	
	public void morir(){
		grafico.setIcon(morir);
	}
	
	protected void changeIcon(int dir){
		int direccion = -1;
		
		switch (dir){
			case Celda.UP : 
				direccion = 0;
				break;
			case Celda.DOWN : 
				direccion = 1;
				break;
			case Celda.LEFT : 
				direccion = 2;
				break;
			case Celda.RIGHT : 
				direccion = 3;
				break;
		}
		
		this.grafico.setIcon(this.image[direccion]);
	}
	
	protected void changeMoving(int dir){
		int direccion = -1;
		
		switch (dir){
			case Celda.UP : 
				direccion = 0;
				break;
			case Celda.DOWN : 
				direccion = 1;
				break;
			case Celda.LEFT : 
				direccion = 2;
				break;
			case Celda.RIGHT : 
				direccion = 3;
				break;
		}
		
		this.grafico.setIcon(this.moving[direccion]);
	}
	
	public void mover(int dir){
		
		this.changeMoving(dir);
		
		try {
			switch (dir){
				case Celda.UP: // Arriba
					for(int i = 0; i < this.height; i += this.velocidad){
						this.grafico.setBounds(this.pos.x, this.pos.y -= this.velocidad, width, height);
						Thread.sleep(10);
					}
					break;
				case Celda.DOWN: // Abajo
					for(int i = 0; i < this.height; i += this.velocidad){
						this.grafico.setBounds(this.pos.x, this.pos.y += this.velocidad, width, height);
						Thread.sleep(10);
					}
					break;
				case Celda.RIGHT: // Derecha
					for(int i = 0; i < this.width; i += this.velocidad){
						this.grafico.setBounds(this.pos.x += this.velocidad, this.pos.y, width, height);
						Thread.sleep(10);
					}
					break;
				case Celda.LEFT: // Izquierda
					for(int i = 0; i < this.width; i += this.velocidad){
						this.grafico.setBounds(this.pos.x -= this.velocidad, this.pos.y, width, height);
						Thread.sleep(10);
					}
					break;				
			}
			
			this.changeIcon(dir);
		} 
		catch (InterruptedException e){
			e.printStackTrace();			
		}
	}

}
