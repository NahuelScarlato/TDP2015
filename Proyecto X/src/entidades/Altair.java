package entidades;

import java.util.Random;

import contenedores.Celda;
import grafica.AltairGrafica;

/**
 * 
 */
public class Altair extends Enemigo {

    /**
     * Default constructor
     */
    public Altair(Celda c) {
    	super(20,c);
    	velocidad=1;
    	c.setEnemigo(this);
    	miGrafico=new AltairGrafica(velocidad,c.getFila(),c.getColumna());
    	this.setGMod(true);
    }

    /**
     * @param dir
     */
    public void pensarAvanzar() {
    	Random ran = new Random();
		int dir = ran.nextInt(4);

		Celda proxima = miCelda.celdaParaAvanzar(dir);

		if (proxima != null) {
			//	le saque el  proxima.getPared() == null && del if, 
			// ya que verificamos q no era intrasitable en el if de arriba
			if ( proxima.getBomba() == null) {
					proxima.setEnemigo(this);
					miCelda.setEnemigo(null);
					
					super.avanzar(dir);					
			}
				
			if (proxima.getBomberman() != null) 
				proxima.getBomberman().morir();
				

			
		}
    }

}