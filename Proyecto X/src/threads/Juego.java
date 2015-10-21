package threads;

import GUI.GUI;
import Nivel.Nivel;

public class Juego extends Thread{
	
	private Nivel nivel;
	private GUI gui;

	public Juego(Nivel n, GUI gui) {
		nivel = n;
		this.gui = gui;
	}

	public void run() {
		while(nivel.getBomberman().getVivo()){
			
			
			if(gui.getLock()){
				nivel.mover(gui.getDirection());
				gui.toggleLock();
			}			
		}		
		nivel.cortar();
	}
	
}
