package entidades;

import javax.swing.JLabel;

import contenedores.Celda;
import grafica.EntidadGrafica;

/**
 * Representa una entidad dinamica independiente.
 * @author Llano Jose, Scarlato Nahuel Hernan; Tecnologia de Programacion 2015.
 */
public abstract class Entidad extends Thread {
	
	protected int velocidad;
	
    protected boolean GMod;
    
    protected EntidadGrafica miGrafico;
    
    protected Celda miCelda;
    
    protected volatile boolean vivo=true;
    
    /**
     * Construye una Entidad con GMod en falso e inicializa su celda con la pasada por parametro.
     * @param c Celda.
     */
    public Entidad(Celda c) {
    	GMod=false;
    	miCelda=c;
    	miGrafico=null;    	
    }
    
    /**
     * Retorna verdadero en caso de que el bomberman siga vivo, falso en caso contrario.
     * @return vivo boolean.
     */
    public boolean getVivo(){
    	return vivo;    	
    }
    
    /**
     * Cambia el estado del atributo vivo por su negacion.
     */
    public void toggleVivo(){
    	vivo=false;
    }    
    
    /**
     * Retorna verdadero en caso de que el modo dios este actico, falso en caso contrario-
     * @return GMod boolean.
     */
    public boolean getGMod() {
        return GMod;
    }

    /**
     * Cambia el estado del atributo GMod por su negacion.
     */
    public void toggleGMod() {
     	GMod=!GMod;
    }
    
    /**
     * Retorna la la celda de la entidad.
     * @return miCelda Celda.
     */
    public Celda getCelda() {
        return miCelda;
    }

    /**
     * Modifica la celda de la entidad con una celda pasado por parametro.
     * @param c Celda.
     */
    public void setCelda(Celda c) {
    	miCelda=c;
    }
    
    /**
     * Retorna el atributo velocidad.
     * @return velocidad int.
     */
    public int getVelocidad() {
        return velocidad;
    }

    /**
     * Modifica la velocidad con un entero pasado por parametro.
     * @param v int.
     */
    public void setVelocidad(int v) {
        velocidad=v;
    }
    
    /**
     * Cambia miGrafico con imagen correspondiente de la entidad.
     */
    public void morir(){
    	miGrafico.morir();
    }
    
    /**
     * Retorna el grafico de la entidad.
     * @return miGrafico JLabel.
     */
    public JLabel getGrafico(){
    	return miGrafico.getGrafico();    	
    }
  
    /**
     * Actualiza el movimiento de miGrafico y modifica la celda de la entidad por la avanzada.
     * @param dir int.
     */
    public void avanzar(int dir){
    	miCelda=miCelda.celdaParaAvanzar(dir);
    	miGrafico.mover(dir);
    }
}