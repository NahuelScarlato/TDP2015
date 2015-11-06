package entidades;

import java.util.Random;

import contenedores.Celda;
import grafica.RugulosGrafica;

/**
 * Representa una Enemigo de tipo Rugulos.
 * @author Llano Jose, Scarlato Nahuel Hernan; Tecnologia de Programacion 2015.
 */
public class Rugulos extends Enemigo {

    /**
     * Construye un objeto de tipo Rugulos con un puntaje predefinido y la celda pasada por parametro.
     * Inicializa su velocidad y su grafico con valores predefinidos.
     * @param c Celda.
     */
    public Rugulos(Celda c) {
    	super(15,c);
    	velocidad=1;
    	miGrafico=new RugulosGrafica(velocidad,c.getFila(),c.getColumna());
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