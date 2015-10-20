package entidades;

import java.util.Random;

import contenedores.Celda;
import grafica.RugulosGrafica;

/**
 * 
 */
public class Rugulos extends Enemigo {

    /**
     * Default constructor
     */
    public Rugulos(Celda c) {
    	super(15,c);
    	velocidad=1;
    	c.setEnemigo(this);
    	miGrafico=new RugulosGrafica(velocidad,c.getFila(),c.getColumna());
    }

    /**
     * @param dir
     */
    public void pensarAvanzar() {
    	Random ran = new Random();
		int dir = ran.nextInt(4);
		
		switch(dir){
		case 0 :
			dir = Celda.UP;
			break;
		case 1 :
			dir = Celda.RIGHT;
			break;
		case 2 :
			dir = Celda.DOWN;
			break;
		case 3 :
			dir = Celda.LEFT;
			break;	
		}

		Celda proxima = miCelda.celdaParaAvanzar(dir);

		if (proxima != null) {
			if (proxima.getPared() == null && proxima.getBomba() == null){
				proxima.setEnemigo(this);
				miCelda.setEnemigo(null);
				setCelda(proxima);
				miGrafico.mover(dir);	
				}				
				
			if (proxima.getBomberman() != null) 
				proxima.getBomberman().morir();
		}
    }
}