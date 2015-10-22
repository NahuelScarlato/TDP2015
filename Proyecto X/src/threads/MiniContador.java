package threads;

import entidades.Bomberman;

/**
 * Esta clase crea un contador de 5 segudnos
 * @author llano
 *
 */
public class MiniContador extends Thread{

	Bomberman bomberman;
	
	/**
	 * Constructor de la clase que hace algo
	 * @param b
	 */
	public MiniContador(Bomberman b) {
		bomberman=b;
		start();
	}
	
	
	/**
	 * Metodo run que se va a ejecutar solo una vez :P
	 */
	public void run(){
		
		try {
			Thread.sleep(5000);
			bomberman.toggleVivo();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
