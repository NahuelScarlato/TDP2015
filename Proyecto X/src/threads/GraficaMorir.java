package threads;

import entidades.Entidad;

public class GraficaMorir extends Thread{
	
	protected Entidad e;
	
	/**
	 * Construye un contador con un bomberman pasado por parametro.
	 * @param b Bomberman.
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
