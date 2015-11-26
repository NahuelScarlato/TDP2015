package threads;

import javax.swing.JLabel;

import contenedores.Celda;

/**
 * Esta clase crea un hilo que controla la explosion de las celdas.
 * @author Llano Jose, Scarlato Nahuel Hernan; Tecnologia de Programacion 2015.
 */
public class GraficaExplosion extends Thread{
	
	protected Celda c;
	
	protected JLabel label;
	
	/**
	 * Construye un el hilo con una celda y un label pasados por parametro.
	 * @param c Celdan
	 * @param label JLabel.
	 */
	public GraficaExplosion(Celda c,JLabel label) {
		this.c=c;
		this.label=label;
		start();
	}
		
	/**
	 * Inicia el hilo, lo duerme por 1 segundo y elimina la grafica de la celda.
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
