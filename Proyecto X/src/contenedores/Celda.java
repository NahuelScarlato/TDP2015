package contenedores;

import entidades.Bomberman;
import entidades.Enemigo;

import objetos.Bomba;
import objetos.Pared;
import objetos.PowerUp;

/**
 * 
 */
public class Celda {

    /**
     * 
     */
    protected int fila;

    /**
     * 
     */
    protected int columna;

    /**
     * 
     */
    protected PowerUp miPowerUp;


    /**
     * 
     */
    protected Mapa miMapa;

    /**
     * 
     */
    protected Pared miPared;

    /**
     * 
     */
    protected Enemigo miEnemigo;
    
    /**
     * 
     */
    protected Bomberman miBomberman;

    /**
     * 
     */
    protected Bomba miBomba;

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
        e.setCelda(this);
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
        b.setCelda(this);
    }
    
    /**
     * @return
     */
    public Mapa getMapa() {
        return miMapa;
    }

    /**
     * @param r 
     * @return
     */
    public Celda[] celdasParaExplotar(int r) {
        
    	
    	Celda[] exp=new Celda[(r*4)+1];    	
    	
    	int i=0;    	
    	//Izquierdas
    	int rango=r;
    	Celda aux=this;
    	while(rango>=0 ||aux!=null){
    		aux=miMapa.getCelda(fila-1, columna);
    		if(aux!=null){
    			exp[i]=aux;
    			i++;
    		}
    		rango--;    		
    	}
    	
    	//Derechas
    	rango=r;
    	aux=this;
    	while(rango>=0 ||aux!=null){
    		aux=miMapa.getCelda(fila+1, columna);
    		if(aux!=null){
    			exp[i]=aux;
    			i++;
    		}
    		rango--;
    	}
    	
    	//Superiores
    	rango=r;
    	aux=this;
    	while(rango>=0 ||aux!=null){
    		aux=miMapa.getCelda(fila, columna-1);
    		if(aux!=null){
    			exp[i]=aux;
    			i++;
    		}
    		rango--;
    	}
    	
    	//Inferiores
    	rango=r;
    	aux=this;
    	while(rango>=0 ||aux!=null){
    		aux=miMapa.getCelda(fila, columna+1);
    		if(aux!=null){
    			exp[i]=aux;
    			i++;
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
        case 0:
        	//Arriba
        	return miMapa.getCelda(fila-1,columna);
        case 1:
        	//Derecha
        	return miMapa.getCelda(fila,columna+1);
        case 2:
        	//Abajo
        	return miMapa.getCelda(fila+1,columna);
        case 3:
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
        	miBomberman=null;
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