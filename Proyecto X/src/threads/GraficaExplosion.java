package threads;

import javax.swing.JLabel;

import contenedores.Celda;

public class GraficaExplosion extends Thread{
	
	protected Celda c;
	
	protected JLabel label;
	
	/**
	 * Construye un contador con un bomberman pasado por parametro.
	 * @param b Bomberman.
	 */
	public GraficaExplosion(Celda c,JLabel label) {
		this.c=c;
		this.label=label;
		start();
	}
		
	/**
	 * Inicia el hilo, lo duerme por 5 segundos y cambia el GMod de bomberman.
	 */
	public void run(){
		
		try {
			Thread.sleep(1000);
			c.getMapa().getNivel().getGUI().getFrame().remove(label);        	
			
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}		
	}
}
