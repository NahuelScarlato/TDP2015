package objetos;

import contenedores.Celda;
import entidades.Bomberman;
import grafica.MasacralityGrafica;
import threads.MiniContador;

/**
 * Representa un PowerUp de tipo Masacrality.
 * @author Llano Jose, Scarlato Nahuel Hernan; Tecnologia de Programacion 2015.
 */
public class Masacrality extends PowerUp {

	/**
     * Construye un objeto de tipo Masacrality con un puntaje predefinido y una celda pasada por parametro.
     * @param c Celda.
     */
    public Masacrality(Celda c) {
    	super(50,c);
    	c.setCeldaGrafica(new MasacralityGrafica(c.getFila(),c.getColumna()));
    	miCelda.getMapa().getNivel().agregarGrafico(c);
    	
    }

    /**
     * Activa el modo dios del bomberman e inicializa el hilo del modo dios.
     * @param b Bomberman.
     */
    public void activar(Bomberman b) {
        b.toggleGMod();
        miCelda.getCeldaGrafica().getGrafico().setIcon(null);
        new MiniContador(b);
    }

}