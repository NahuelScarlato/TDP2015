package threads;

import entidades.Enemigo;

public class EnemigoThread extends Thread {
	
	// Logica que implementa al malo.
	private Enemigo mLogica;
	
	// Flag que indica cuando debe detenerse la ejecución del hilo.
	// Es volatile porque es accedida concurrentemente desde diferentes threads.
	private volatile boolean mDetener;
	
	public EnemigoThread(Enemigo logica) {
		mLogica  = logica;
		mDetener = false;
	}
	
	@Override
	public void run() {
		// Ejecuto indefinidamente hasta que el flag sea verdadero.
		while(!mDetener){
			// Duermo el hilo 1 segundo.
			// De esta manera cada turno se ejecuta cada 1 segundo.
			try {
				Thread.sleep(1000);
				
				// Realizo el movimiento
				mLogica.pensarAvanzar();
			} catch (InterruptedException e) {}
		}
	}
	
	public void detener() {
		// Interrumpo el hilo para que no continue con su ejecución.
		interrupt(); 
		
		// Seteamos el flag para detener su ejecución.
		mDetener = true;
	}
	
	public void destruir() {
		// Detengo la ejecucion del hilo.
		detener();
		
		// Notificamos a la logica que este hilo se destruyo.
		mLogica.morir();
	}
}
