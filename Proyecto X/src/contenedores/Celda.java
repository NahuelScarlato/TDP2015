package contenedores;

import java.awt.event.KeyEvent;

import javax.swing.JLabel;

import entidades.Bomberman;
import entidades.Enemigo;
import grafica.CeldaGrafica;
import objetos.Bomba;
import objetos.Pared;
import objetos.PowerUp;

/**
 * 
 */
public class Celda {

	public static final int LEFT = KeyEvent.VK_LEFT;
	public static final int RIGHT = KeyEvent.VK_RIGHT;
	public static final int UP = KeyEvent.VK_UP;
	public static final int DOWN = KeyEvent.VK_DOWN;
	
	protected int fila;
	protected int columna;

	protected Mapa miMapa;
	
    protected PowerUp miPowerUp;
    protected Pared miPared;
    protected Enemigo miEnemigo;
    protected Bomberman miBomberman;
    protected Bomba miBomba;
    
    protected CeldaGrafica miGrafico;

    /**
     * 
     */
    public Celda(int fila, int columna,Mapa mapa) {
    	this.fila=fila;
    	this.columna=columna;
    	miPowerUp=null;
    	miMapa=mapa;
    	miPared=null;
    	miEnemigo=null;
    	miBomberman=null;
    	miBomba=null;
    }
    
    public int getFila(){
    	return fila;
    }
    
    public int getColumna(){
    	return columna;
    }

    /**
     * @return
     */
    public PowerUp getPowerUp() {
        return miPowerUp;
    }

    /**
     * @param pu
     */
    public void setPowerUp(PowerUp pu) {
        miPowerUp=pu;
    }

    /**
     * @return
     */
    public Pared getPared() {
        return miPared;
    }

    /**
     * @param p
     */
    public void setPared(Pared p) {
       miPared=p;
    }

    /**
     * @return
     */
    public Bomba getBomba() {
        return miBomba;
    }

    /**
     * @param b
     */
    public void setBomba(Bomba b) {
       miBomba=b;
       b.setCelda(this);
    }

    /**
     * @return
     */
    public Enemigo getEnemigo() {
        return miEnemigo;
    }

    /**
     * @param e
     */
    public void setEnemigo(Enemigo e) {
        miEnemigo=e;
    }
    
    /**
     * @return
     */
    public Bomberman getBomberman() {
        return miBomberman;
    }

    /**
     * @param e
     */
    public void setBomberman(Bomberman b) {
        miBomberman=b;
    }
    
    /**
     * @return
     */
    public Mapa getMapa() {
        return miMapa;
    }
    
    public CeldaGrafica getCeldaGrafica(){
			
		return miGrafico;
	}
	
	public void setCeldaGrafica(CeldaGrafica cg){
		miGrafico=cg;
	}
    

    /**
     * @param r 
     * @return
     */
    public Celda[] celdasParaExplotar(int r) {
        
    	
    	Celda[] exp=new Celda[(r*4)+1];   	
    	
    	int i=0;    	
    	//Superiores
    	int rango=r;
    	Celda aux=this;
    	while(rango>0 || aux!=null){
    		aux=miMapa.getCelda(fila-1, columna);
    		if(aux!=null){
    			exp[i]=aux;
    			i++;
    			if(aux.getPared()!=null)
    				aux=null;
    		}
    		rango--;
    	}
    	
    	//Inferiores
    	rango=r;
    	aux=this;
    	while(rango>0 || aux!=null){
    		aux=miMapa.getCelda(fila+1, columna);
    		if(aux!=null){
    			exp[i]=aux;
    			i++;
    			if(aux.getPared()!=null)
    				aux=null;
    		}
    		rango--;
    	}
    	
    	//Izquierdas
    	rango=r;
    	aux=this;
    	while(rango>0 || aux!=null){
    		aux=miMapa.getCelda(fila, columna-1);
    		if(aux!=null){
    			exp[i]=aux;
    			i++;
    			if(aux.getPared()!=null)
    				aux=null;
    		}
    		rango--;
    	}
    	
    	//Derechas
    	rango=r;
    	aux=this;
    	while(rango>0 || aux!=null){
    		aux=miMapa.getCelda(fila, columna+1);
    		if(aux!=null){
    			exp[i]=aux;
    			i++;
    			if(aux.getPared()!=null)
    				aux=null;
    		}
    		rango--;
    	}
    	
    	exp[i]=null;
    		
        return exp;
    }

    /**
     * @param dir
     */
    public Celda celdaParaAvanzar(int dir) {
        switch(dir){
        case UP:
        	//Arriba
        	return miMapa.getCelda(fila-1,columna);
        case RIGHT:
        	//Derecha
        	return miMapa.getCelda(fila,columna+1);
        case DOWN:
        	//Abajo
        	return miMapa.getCelda(fila+1,columna);
        case LEFT:
        	//Izquierda
        	return miMapa.getCelda(fila,columna-1);
        }
        return null;
    }

    /**
     * 
     */
    public int serExplotada() {
    	int puntos=0;
    	
    	if(miBomberman!=null){
        	miBomberman.morir();
        }
    	
    	if(miPared!=null){
        	puntos+=miPared.serExplotado();
        	miPared=null;
        } 
        
        if(miEnemigo!=null){
        	puntos+=miEnemigo.serExplotado();
        	miEnemigo=null;
        }
        	
        if(miBomba!=null){
        	miBomba.explotar();
        	miBomba=null;
        }
        	
        if(miPowerUp!=null)
        	miPowerUp=null;
        
        return puntos;

    }

}