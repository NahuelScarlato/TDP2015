package objetos;

import contenedores.Celda;
import entidades.Bomberman;
import grafica.BombalityGrafica;

/**
 * Representa un PowerUp de tipo Bombality.
 * @author Llano Jose, Scarlato Nahuel Hernan; Tecnologia de Programacion 2015.
 */
public class Bombality extends PowerUp {

    /**
     * Construye un objeto de tipo Bombality con un puntaje predefinido y una celda pasada por parametro.
     * @param c Celda.
     */
    public Bombality(Celda c) {
    	super(35,c);
    	c.setCeldaGrafica(new BombalityGrafica(c.getFila(),c.getColumna()));
    	miCelda.getMapa().getNivel().agregarGrafico(c);
    }

    /**
     * Aumenta la cantidad de bombas del bomberman pasado por parametro.
     * @param b Bomberman.
     */
    public void activar(Bomberman b) {
        b.aumentarCantBombas();  
        miCelda.getCeldaGrafica().getGrafico().setIcon(null);
    }
}