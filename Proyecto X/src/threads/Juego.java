package threads;

import GUI.GUI;
import Nivel.Nivel;
import entidades.Enemigo;;

public class Juego extends Thread{
	
	private Nivel nivel;
	private GUI gui;

	public Juego(Nivel n, GUI gui) {
		nivel = n;
		this.gui = gui;
	}

	public void run() {
		while(true){
			try {
				//X alguna razon lo necesitamos para mover el bomberman
				Thread.sleep(10);				
			} catch (InterruptedException e) {}			
				
			if(gui.getLock()){
				nivel.mover(gui.getDirection());
				gui.toggleLock();
			}
			
		}
	}
	
}
