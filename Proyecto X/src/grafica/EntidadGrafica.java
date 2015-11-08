package grafica;

import javax.swing.Icon;
import javax.swing.JLabel;

import contenedores.Celda;
import entidades.Entidad;
import threads.GraficaMorir;

/**
 * Representa una Grafica de tipo EntidadGrafica.
 * @author Llano Jose, Scarlato Nahuel Hernan; Tecnologia de Programacion 2015.
 */
public abstract class EntidadGrafica extends Grafica{
	protected Icon image[];
	protected Icon moving[];
	protected Icon morir;	
	
	/**
	 * Construye una Grafica de tipo EntidadGrafica, con su velocidad y posicion (x,y). 
	 * @param velocidad int.
	 * @param x int.
	 * @param y int.
	 */
	protected EntidadGrafica(int x, int y) {
		super(x,y);
		image = new Icon[4];
		moving = new Icon[4];
	}
	
	public JLabel getGrafico(){
		if(grafico == null){
			grafico = new JLabel(image[1]);
			grafico.setBounds(pos.x, pos.y, width, height);
		}
		
		return grafico;
	}
	
	/**
	 * Cambia el atributo grafico por el definido de morir.
     */
	public void morir(Entidad e){
		grafico.setIcon(morir);
		new GraficaMorir(e);
	}
	
	/**
	* Cambia la imagen del grafico dependiendo de un entero dir,pasado por parametro.
	* @param dir int.
    */
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
		
		grafico.setIcon(image[direccion]);
	}
	
	
	/**
	 * Cambia la imagen del grafico dependiendo de un entero dir,pasado por parametro.
	 *@param dir int.
     */
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
		
		grafico.setIcon(moving[direccion]);
	}
	
	
	/**
	 * Cambia la imagen del grafico realizando la transicion entre celdas de forma dinamica.
	 *@param dir int.
     */
	public void mover(int dir,int velocidad){
		
		this.changeMoving(dir);
		
		try {
			switch (dir){
				case Celda.UP: // Arriba
					for(int i = 0; i < height; i += velocidad){
						grafico.setBounds(pos.x, pos.y -= velocidad, width, height);
						Thread.sleep(10);
					}
					break;
				case Celda.DOWN: // Abajo
					for(int i = 0; i < height; i += velocidad){
						grafico.setBounds(pos.x, pos.y += velocidad, width, height);
						Thread.sleep(10);
					}
					break;
				case Celda.RIGHT: // Derecha
					for(int i = 0; i < width; i += velocidad){
						grafico.setBounds(pos.x += velocidad, pos.y, width, height);
						Thread.sleep(10);
					}
					break;
				case Celda.LEFT: // Izquierda
					for(int i = 0; i < width; i += velocidad){
						grafico.setBounds(pos.x -= velocidad, pos.y, width, height);
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
