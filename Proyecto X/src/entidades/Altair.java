package entidades;

import java.util.Random;

import contenedores.Celda;
import grafica.AltairGrafica;

/**
 * Representa una Enemigo de tipo Altair.
 * @author Llano Jose, Scarlato Nahuel Hernan; Tecnologia de Programacion 2015.
 */
public class Altair extends Enemigo {

    /**
     * Construye un Enemigo de tipo Altair, con un puntaje y velocidad predefinido.
     * Inserta el enemigo en la celda pasada por parametro.
     */
    public Altair(Celda c) {
    	super(20,c);
    	velocidad=1;
    	miGrafico=new AltairGrafica(velocidad,c.getFila(),c.getColumna());
    	this.toggleGMod();
    }

    /**
     * Determina de manera aleatoria cual sera su siguiente movimiento y lo realiza.
     */
    public void pensarAvanzar() {
    	Random ran = new Random();
		int dir = ran.nextInt(4);
		
		dir=determinarDireccion(dir);

		super.avanzar(dir);
    }

}