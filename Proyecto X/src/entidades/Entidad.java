package entidades;

import javax.swing.JLabel;

import contenedores.Celda;
import grafica.EntidadGrafica;

/**
 * 
 */
public abstract class Entidad extends Thread {
	
	protected int velocidad;
	
    protected boolean GMod;
    
    protected EntidadGrafica miGrafico;
    
    protected Celda miCelda;
    
    protected volatile boolean vivo=true;
    
    /**
     * Default constructor
     */
    public Entidad(Celda c) {
    	GMod=false;
    	miCelda=c;
    	miGrafico=null;    	
    }
    
    public boolean getVivo(){
    	return vivo;    	
    }
    
    public void toggleVivo(){
    	vivo=!vivo;
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
    public void morir(){
    	miCelda=null;
    	miGrafico.morir();
    }
    
    public JLabel getGrafico(){
    	return miGrafico.getGrafico();    	
    }
  
    public void avanzar(int dir){
    	miCelda=miCelda.celdaParaAvanzar(dir);
    	miGrafico.mover(dir);
    }
}