package entidades;

import java.util.Random;

import contenedores.Celda;
import grafica.RugulosGrafica;

/**
 * 
 */
public class Rugulos extends Enemigo {

    /**
     * Construye un objeto de tipo Rugulos con un puntaje predefinido y su respectiva celda, pasada por parametro.
     * Inicializa su velocidad y su grafico con valores predefinidos.
     * @param c Celda.
     */
    public Rugulos(Celda c) {
    	super(15,c);
    	velocidad=1;
    	c.setEnemigo(this);
    	miGrafico=new RugulosGrafica(velocidad,c.getFila(),c.getColumna());
    }

    /**
     * Avanza recorriendo aleatoriamente el mapa.
     */
    public void pensarAvanzar() {
    	Random ran = new Random();
		int dir = ran.nextInt(4);
		
		dir=determinarDireccion(dir);

		super.avanzar(dir);
    }
}