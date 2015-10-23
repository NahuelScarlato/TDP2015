package threads;

import entidades.Bomberman;

/**
 * Esta clase crea un hilo que representa un contador de 5 segundos.
 * @author Llano Jose, Scarlato Nahuel Hernan; Tecnologia de Programacion 2015.
 */
public class MiniContador extends Thread{

	Bomberman bomberman;
	
	/**
	 * Construye un contador con un bomberman pasado por parametro.
	 * @param b Bomberman.
	 */
	public MiniContador(Bomberman b) {
		bomberman=b;
		start();
	}	
	
	/**
	 * Inicia el hilo, lo duerme por 5 segundos y cambia el GMod de bomberman.
	 */
	public void run(){
		
		try {
			Thread.sleep(5000);
			bomberman.toggleGMod();
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}		
	}

}
