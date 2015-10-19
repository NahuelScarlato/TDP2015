package entidades;

import objetos.PowerUp;
import contenedores.Celda;
import java.util.Random;

/**
 * 
 */
public class Rugulos extends Enemigo {

    /**
     * Default constructor
     */
    public Rugulos(Celda c) {
    	super(15,c);
    }

    /**
     * @param dir
     */
	public void pensarAvanzar() {

		Random ran = new Random();
		int dir = ran.nextInt(4);

		Celda proxima = miCelda.celdaParaAvanzar(dir);

		if (proxima != null) {

			if (proxima.getPared() == null && proxima.getBomba() == null) 
				proxima.setEnemigo(this);
				
			if (proxima.getBomberman() != null) 
				// debe verificr este esto? osea q encuentra al bomberman y lo mata, o solo se encarga el bomberman de eso? si el bomberman esta parado creo q este if sirve, porq el bicho se mueve hacia el y lo mata
					proxima.getBomberman().morir();
				

			
		}
			
	}

}