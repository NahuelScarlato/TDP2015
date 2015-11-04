package threads;

import contenedores.Celda;

public class GraficaExplosion extends Thread{
	
	protected Celda c;
	
	/**
	 * Construye un contador con un bomberman pasado por parametro.
	 * @param b Bomberman.
	 */
	public GraficaExplosion(Celda c) {
		this.c=c;
		start();
	}
		
	/**
	 * Inicia el hilo, lo duerme por 5 segundos y cambia el GMod de bomberman.
	 */
	public void run(){
		
		try {
			Thread.sleep(950);
			c.getCeldaGrafica().getGrafico().setIcon(null);
			
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}		
	}
}
