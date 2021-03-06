package threads;

import GUI.GUI;
import Nivel.Nivel;

/**
 * Esta clase crea el hilo principal del juego.
 * @author Llano Jose, Scarlato Nahuel Hernan; Tecnologia de Programacion 2015.
 */
public class Juego extends Thread{
	
	private Nivel nivel;
	private GUI gui;

	/**
	 * Construye el hilo principal.
	 * @param n Nivel.
	 * @param gui GUI.
	 */
	public Juego(Nivel n, GUI gui) {
		nivel = n;
		this.gui = gui;
	}

	/**
	 * Inicia el hilo, ejecuta el movimiento del bomberman y los enemigos mientras el bomberman este vivo.
     */
	public void run() {
			
			while(nivel.getBomberman().getVivo() && nivel.getCantP()!=0){
				
				if(gui.getLock()){
					nivel.mover(gui.getDirection());
					gui.toggleLock();
				}	
				if(gui.getLockColoc()){
					nivel.ponerBomba(gui.getColocar());
					gui.toggleLockColoc();
				}
				
			}
			
			nivel.cortar();
			
			try {
				Thread.sleep(900);
			} catch (InterruptedException e) {
				e.printStackTrace();
			};
			
			if(nivel.getBomberman().getVivo()){
				int aux=nivel.getMarcador();
				gui.win(aux);							
			}
			else{			
				gui.gameOver();
			}
			
		}
}
