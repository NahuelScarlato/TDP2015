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
		while(!nivel.getMurio()){
			/*
			try {
				//X alguna razon lo necesitamos el sleep para mover el bomberman
				Thread.sleep(10);				
			} catch (InterruptedException e) {}			
				
				*/			
			if(gui.getLock()){
				nivel.mover(gui.getDirection());
				gui.toggleLock();
			}
			
		}
		
		// Termino el juego y detengo todos los hilos
		System.out.println("Muriooooo");
	}
	
}
