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
		
		dir=determinarDireccion(dir);

		super.avanzar(dir);
    }

}