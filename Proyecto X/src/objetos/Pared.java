package objetos;

import contenedores.Celda;

/**
 * Representa una bomba.
 * @author Llano Jose, Scarlato Nahuel Hernan; Tecnologia de Programacion 2015.
 */
public class Pared {

    protected int puntaje;
    
    protected Celda miCelda;

    /**
     * Construye un objeto de tipo Pared con un puntaje predefinido.
     * @param c Celda.
     */
    public Pared(Celda c) {
        puntaje=10;
        miCelda=c;
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
    	miCelda.getMapa().getNivel().disminuirCantP();
    	miCelda.getMapa().getNivel().getGUI().getLbllblCantParedes().setText(""+miCelda.getMapa().getNivel().getCantP());
        
        return puntaje;
    }
}