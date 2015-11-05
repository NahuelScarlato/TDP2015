package objetos;

import contenedores.Celda;
import grafica.ParedGrafica;

/**
 * Representa una bomba.
 * @author Llano Jose, Scarlato Nahuel Hernan; Tecnologia de Programacion 2015.
 */
public class Pared {

    protected int puntaje;
    
    protected Celda miCelda;

    /**
     * Construye un objeto de tipo Pared con un puntaje predefinido.
     */
    public Pared(Celda c) {
        puntaje=10;
        miCelda=c;
        c.setCeldaGrafica(new ParedGrafica(c.getFila(),c.getColumna()));
    	miCelda.getMapa().getNivel().agregarGrafico(c);        
    }

    /**
     * Retorna el valor de explotar una pared.
     * @return puntaje int.
     */
    public int getPuntaje() {
        return puntaje;
    }
    
    /**
     * Retorna el puntaje obtenido por explotar una pared.
     * @return puntaje int.
     */
    public int serExplotado() {
    	
        return puntaje;
    }
}