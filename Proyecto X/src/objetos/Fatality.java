package objetos;

import contenedores.Celda;
import entidades.Bomberman;
import grafica.FatalityGrafica;

/**
 * 
 */
public class Fatality extends PowerUp {

    /**
     * Construye un objeto de tipo Fatality con un puntaje predefinido.
     */
    public Fatality(Celda c) {
    	super(35,c);
    	c.setCeldaGrafica(new FatalityGrafica(c.getFila(),c.getColumna()));
    	miCelda.getMapa().getNivel().agregarGrafico(c);
    }

    /**
     * Aumenta el rango de explosion de la bomba.
     * @param b Bomberman.
     */
    public void activar(Bomberman b) {
        b.aumentarRangoBombas();
    }

}