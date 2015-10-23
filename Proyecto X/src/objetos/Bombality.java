package objetos;

import contenedores.Celda;
import entidades.Bomberman;
import grafica.BombalityGrafica;

/**
 * 
 */
public class Bombality extends PowerUp {

    /**
     * Construye un objeto de tipo Bombality con un puntaje predefinido.
     */
    public Bombality(Celda c) {
    	super(35,c);
    	c.setCeldaGrafica(new BombalityGrafica(c.getFila(),c.getColumna()));
    	miCelda.getMapa().getNivel().agregarGrafico(c);
    }

    /**
     * Aumenta la cantidad de bombas que puede colocar el bomberman.
     * @param b Bomberman.
     */
    public void activar(Bomberman b) {
        b.aumentarCantBombas();        
    }
}