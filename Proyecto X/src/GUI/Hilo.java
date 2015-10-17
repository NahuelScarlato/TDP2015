package GUI;

import GUI.GUI;
import Nivel.Nivel;;

public class Hilo extends Thread{
	
	private Nivel nivel;
	private GUI gui;

	Hilo(Nivel n, GUI gui) {
		this.nivel = n;
		this.gui = gui;
	}

	public void run() {
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			nivel.mover();
			if(gui.getLock()){
				nivel.mover(gui.getDirection());
				gui.toggleLock();
			}
		}
	}
	
}
