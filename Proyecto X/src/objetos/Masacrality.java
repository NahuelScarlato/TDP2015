package objetos;

import contenedores.Celda;
import entidades.Bomberman;
import grafica.MasacralityGrafica;
import threads.MiniContador;
/**
 * 
 */
public class Masacrality extends PowerUp {

    /**
     * Construye un objeto de tipo Masacrality con puntaje predefinido
     */
    public Masacrality(Celda c) {
    	super(50,c);
    	c.setCeldaGrafica(new MasacralityGrafica(c.getFila(),c.getColumna()));
    	miCelda.getMapa().getNivel().agregarGrafico(c);
    	
    }

    /**
     * Activa el modo dios del bomberman.
     * @param b Bomberman.
     */
    public void activar(Bomberman b) {
        b.toggleGMod();
        new MiniContador(b);
    }

}