package entidades;



import java.util.Random;

import contenedores.Celda;

/**
 * 
 */
public class Sirius extends Enemigo {

    /**
     * Default constructor
     */
    public Sirius(Celda c) {
    	super(50,c);
    }

    /**
     * @param dir
     */
	public void pensarAvanzar() {

		int dir = -1;

		int xabs = -1;
		int yabs = -1;

		

			xabs = Math.abs(xactual	- this.miCelda.getMapa().getNivel().getBomberman().getX());

			yabs = Math.abs(yactual	- this.miCelda.getMapa().getNivel().getBomberman().getY());

			// caso que estan en la misma columna 
			if (xabs == 0) {
				if (yactual < this.miCelda.getMapa().getNivel().getBomberman().getY()) {
					dir = 2; // flecha para abajo
				} else
					dir = 0; // flecha arriba
			} else {
				// caso que estan en la misma fila
				if (yabs == 0) {
					if (xactual < this.miCelda.getMapa().getNivel().getBomberman().getX()) {
						dir = 1; // flecha para derecha
					} else
						dir = 3; // flecha irquierda
				}
			}

			// caso normal
			if (xabs <= yabs) {
				if (xactual < this.miCelda.getMapa().getNivel().getBomberman().getX()) {
					dir = 1; // flecha para derecha
				} else
					dir = 3; // flecha para izquierda
			} else {
				if (yactual < this.miCelda.getMapa().getNivel().getBomberman().getY()) {
					dir = 0; // flecha para arriba
				} else
					dir = 2; // flecha para abajo
			}

			
			Celda proxima = miCelda.celdaParaAvanzar(dir);
			
			boolean seMovio=false;
		while (!seMovio) {

			if (proxima != null) {
				seMovio = true;
				if (proxima.getPared() == null && proxima.getBomba() == null)
					proxima.setEnemigo(this);

				if (proxima.getBomberman() != null)
					proxima.getBomberman().morir();

			} else {
				// caso que no se puede mover sirius
				Random ran = new Random();
				int esquivarPared = ran.nextInt(2);

				if (xabs == 0) { 
					// debera moverse para la izquierda o la derecha
					if (esquivarPared == 0)
						dir = 3;
					else
						dir = 1;
				} else {
					if (yabs == 0) {
						// debera moverse arriba o abajo
						if (esquivarPared == 0)
							dir = 0;
						else
							dir = 2;
					}
				}
				proxima = miCelda.celdaParaAvanzar(dir);
			}

		}
	}


// agrego jose para el pensar avanzar del siruis
private int xactual;
private int yactual;

public int getX(){
	return xactual;
}

public int getY(){
	return yactual;
}

// fin agrego jose
}