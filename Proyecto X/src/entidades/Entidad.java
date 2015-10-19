package entidades;

import javax.swing.JLabel;

import contenedores.Celda;
import grafica.EntidadGrafica;

/**
 * 
 */
public abstract class Entidad {
	
	protected int velocidad;
	
    protected boolean GMod;
    
    protected EntidadGrafica miGrafico;
    
    protected Celda miCelda;
    
    /**
     * Default constructor
     */
    public Entidad(Celda c) {
    	GMod=false;
    	miCelda=c;
    	miGrafico=null;    	
    }
    
    /**
     * @return
     */
    public boolean getGMod() {
        return GMod;
    }

    /**
     * @param gM
     */
    public void setGMod(boolean gM) {
     	GMod=gM;
    }
    
    /**
     * @return
     */
    public Celda getCelda() {
        return miCelda;
    }

    /**
     * @param c
     */
    public void setCelda(Celda c) {
    	miCelda=c;
    }
    
    /**
     * @return
     */
    public int getVelocidad() {
        return velocidad;
    }

    /**
     * @param v
     */
    public void setVelocidad(int v) {
        velocidad=v;
    }
    
    /**
     * 
     */
    public abstract void morir();
    
    public JLabel getGrafico(){
    	return miGrafico.getGrafico();    	
    }
  
    
}