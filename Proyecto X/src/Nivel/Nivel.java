package Nivel;

import contenedores.Mapa;

/**
 * 
 */
public class Nivel {

    /**
     * 
     */
    protected int marcador;

    /**
     * 
     */
    public Nivel() {
        marcador=0;
        new Mapa(13,31,this);
    }

    /**
     * @return
     */
    public int getMarcador() {
        return marcador;
    }

    /**
     * @param m
     */
    public void sumarPuntaje(int m) {
        marcador+=m;
    }

}