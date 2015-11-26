package threads;

import entidades.Entidad;

/**
 * Esta clase crea un hilo que controla la grafica de las animacines de muertes.
 * @author Llano Jose, Scarlato Nahuel Hernan; Tecnologia de Programacion 2015.
 */
public class GraficaMorir extends Thread{
	
	protected Entidad e;
	
	/**
	 * Construye un contador con una entidad pasada por parametro.
	 * @param e Entidad.
	 */
	public GraficaMorir(Entidad e) {
		this.e=e;
		start();
	}
		
	/**
	 * Inicia el hilo, lo duerme por 5 segundos y cambia el GMod de bomberman.
	 */
	public void run(){
		
		try {
			Thread.sleep(450);
			e.getGrafico().getGrafico().setIcon(null);
			
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}		
	}
}
