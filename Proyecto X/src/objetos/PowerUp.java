package objetos;

import contenedores.Celda;
import entidades.Bomberman;
import grafica.CeldaGrafica;
import grafica.TransitableGrafica;

/**
 * Representa un PowerUp.
 * @author Llano Jose, Scarlato Nahuel Hernan; Tecnologia de Programacion 2015.
 */
public abstract class PowerUp {

    protected int puntaje;
    
    protected Celda miCelda;
    
    protected CeldaGrafica grafica;

    /**
     * Construye un objeto de tipo PowerUp con un puntaje predefinido y una celda pasada por parametro.
     * @param p int.
     * @param c Celda.
     */
    public PowerUp(int p,Celda c) {
       	puntaje=p;
       	miCelda=c;
    }

    /**
     * Activa el beneficio del PowerUp.
     * @param b Bomberman.
     */
    public void activar(Bomberman b){
    	miCelda.setCeldaGrafica(new TransitableGrafica(miCelda.getFila(),miCelda.getColumna()));
		miCelda.getMapa().getNivel().agregarGrafico(miCelda);
		miCelda.getMapa().getNivel().sumarPuntaje(puntaje);
    }

    /**
     * Retorna el puntaje de obtener el power up.
     * @return puntaje int.
     */
    public int getPuntaje() {
        return puntaje;
    }
    
    /**
     * Retorna el grafico asociado al powerUp.
     * @return grafica CeldaGrafica.
     */
    public CeldaGrafica getGraficaPU(){
    	return grafica;
    }
    	

}