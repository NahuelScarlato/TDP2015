package objetos;

import contenedores.Celda;
import entidades.Bomberman;
import grafica.FatalityGrafica;

/**
 * Representa un PowerUp de tipo Fatality.
 * @author Llano Jose, Scarlato Nahuel Hernan; Tecnologia de Programacion 2015.
 */
public class Fatality extends PowerUp {

    /**
     * Construye un objeto de tipo Fatality con un puntaje predefinido y una celda pasada por parametro.
     * @param c Celda.
     */
    public Fatality(Celda c) {
    	super(35,c);
    	grafica=new FatalityGrafica(c.getFila(),c.getColumna());
    }

    /**
     * Aumenta el rango de explosion de la bomba.
     * @param b Bomberman.
     */
    public void activar(Bomberman b) {
        b.aumentarRangoBombas();
    	String aux=	miCelda.getMapa().getNivel().getGUI().getLblFat().getText();
    	char valorNumerico= aux.charAt(1);
        valorNumerico++;
       	miCelda.getMapa().getNivel().getGUI().getLblFat().setText("x"+valorNumerico);
       
        super.activar(b);
    }

}