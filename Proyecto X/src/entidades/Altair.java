package entidades;

import java.util.Random;

import contenedores.Celda;

/**
 * 
 */
public class Altair extends Enemigo {

    /**
     * Default constructor
     */
    public Altair(Celda c) {
    	super(20,c);
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
			if ( proxima.getBomba() == null) 
					proxima.setEnemigo(this);
				
			if (proxima.getBomberman() != null) 
				// debe verificr este esto? osea q encuentra al bomberman y lo mata, o solo se encarga el bomberman de eso? 
				//si el bomberman esta parado creo q este if sirve, porq el bicho se mueve hacia el y lo mata
					proxima.getBomberman().morir();
				

			
		}
    }

}