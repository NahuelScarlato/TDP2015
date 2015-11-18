package contenedores;

import java.awt.event.KeyEvent;

import entidades.Bomberman;
import entidades.Enemigo;
import grafica.CeldaGrafica;
import grafica.TransitableGrafica;
import objetos.Bomba;
import objetos.Pared;
import objetos.PowerUp;

/**
 * Representa un contenedor para componentes logicos.
 * @author Llano Jose, Scarlato Nahuel Hernan; Tecnologia de Programacion 2015.
 */
public class Celda {

	public static final int LEFT = KeyEvent.VK_LEFT;
	public static final int RIGHT = KeyEvent.VK_RIGHT;
	public static final int UP = KeyEvent.VK_UP;
	public static final int DOWN = KeyEvent.VK_DOWN;

	public static final int B = KeyEvent.VK_B;
	
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
     * Construye una celda vacia,con su respectivo mapa,numero de fila y numero de columna.
     * @param fila int.
     * @param columna int.
     * @param mapa Mapa.
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
    	miGrafico=new TransitableGrafica(fila,columna);
    }
    
    /*
     * Retorna el numero de fila de la celda.
     * @return fila int.
     */
    public int getFila(){
    	return fila;
    }
    
    
    /*
     * Retorna el numero de columna de la celda.
     * @return columna int.
     */
    public int getColumna(){
    	return columna;
    }

    /**
     * Retorna el PowerUp de la celda. Retorna null en caso de que la celda no contenga uno.
     * @return miPowerUp PowerUp.
     */
    public PowerUp getPowerUp() {
        return miPowerUp;
    }

    /**
     * Modifica el PowerUp con un PowerUp pasado por parametro.
     * @param pu PowerUp.
     */
    public void setPowerUp(PowerUp pu) {
        miPowerUp=pu;
    }

    /**
     * Retorna la pared. Retorna null en caso de que la celda no contenga una pared.
     * @return miPared Pared.
     */
    public Pared getPared() {
        return miPared;
    }

    /**
     * Modifica la Pared con una Pared pasada por parametro.
     * @param p Pared.
     */
    public void setPared(Pared p) {
       miPared=p;
    }

    /**
     * Retorna la bomba. Retorna null en caso de que no tengo una bomba.
     * @return miBomba Bomba
     */
    public Bomba getBomba() {
        return miBomba;
    }

    /**
     * Modifica la bomba con una bomba pasado por parametro.
     * @param b Bomba.
     */
    public void setBomba(Bomba b) {
       miBomba=b;
    }

    /**
     * Retorna el enemigo. Retorna null en caso de que no tenga un enemigo.
     * @return miEnemigo Enemigo.
     */
    public Enemigo getEnemigo() {
        return miEnemigo;
    }

    /**
     * Modifica el enemigo con un enemigo pasado por parametro.
     * @param e Enemigo.
     */
    public void setEnemigo(Enemigo e) {
        miEnemigo=e;
    }
    
    /**
     * Retona el bomberman. Retorna null en caso de que no tenga un bomberman.
     * @return miBomberman Bomberman.
     */
    public Bomberman getBomberman() {
        return miBomberman;
    }

    /**
     * Modifica el bomberman con un bomberman que es pasado por parametro.
     * @param b Bomberman.
     */
    public void setBomberman(Bomberman b) {
        miBomberman=b;
    }
    
    /**
     * Retorna el mapa.
     * @return miMapa Mapa.
     */
    public Mapa getMapa() {
        return miMapa;
    }
    
    /*
     * Retorna el grafico.
     * @return miGrafico CeldaGrafica.
     */
    public CeldaGrafica getCeldaGrafica(){
			
		return miGrafico;
	}
	
    /*
     * Modifica el grafico con un grafico que es pasado por parametro.
     * @param cg CeldaGrafica.
     */
	public void setCeldaGrafica(CeldaGrafica cg){
		miMapa.getNivel().getGUI().getFrame().remove(this.getCeldaGrafica().getGrafico());
		miGrafico=cg;
	}
    

    /** 
     * Retorna la celdas que se encuentran dentro del rango r que deben explotar.
     * @param r int.
     * @return exp Celda[].
     */
    public Celda[] celdasParaExplotar(int r) {
        
    	
    	Celda[] exp=new Celda[(r*4)+1];   	
    	
    	int i=0;    	
    	//Superiores
    	int rango=r;
    	int f=fila;
    	int c=columna;
    	Celda aux=this;
    	while(rango>0 && aux!=null){
    		aux=miMapa.getCelda(--f, c);
    		if(aux!=null){
    			exp[i]=aux;
    			i++;
    			if(aux.getPared()!=null)
    				aux=null;
    		}
    		rango--;
    	}
    	
    	//Inferiores
    	f=fila;
    	c=columna;
    	rango=r;
    	aux=this;
    	while(rango>0 && aux!=null){
    		aux=miMapa.getCelda(++f, c);
    		if(aux!=null){
    			exp[i]=aux;
    			i++;
    			if(aux.getPared()!=null)
    				aux=null;
    		}
    		rango--;
    	}
    	
    	//Izquierdas
    	f=fila;
    	c=columna;
    	rango=r;
    	aux=this;
    	while(rango>0 && aux!=null){
    		aux=miMapa.getCelda(f, --c);
    		if(aux!=null){
    			exp[i]=aux;
    			i++;
    			if(aux.getPared()!=null)
    				aux=null;
    		}
    		rango--;
    	}
    	
    	//Derechas
    	f=fila;
    	c=columna;
    	rango=r;
    	aux=this;
    	while(rango>0 && aux!=null){
    		aux=miMapa.getCelda(f, ++c);
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
     * Retorna la celda a avanzar, dpeendiendo de la direcion, que es pasada por parametro.
     * @param dir int.
     * @return Celda.
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
     * Explota el contenido de la celda y retorna su respectivo puntaje.
     * @return puntos int.
     */
public int serExplotada() {
    	
    	miGrafico.explotar(this);   	
    	
    	int puntos=0;
    	
    	if(miBomberman!=null){
        	miBomberman.morir();
        }    	
        
        if(miEnemigo!=null){
        	puntos+=miEnemigo.serExplotado();
        	miEnemigo=null;
        }
        	
       
        	
        if(miPowerUp!=null)
        	if(miPared==null){
        		miPowerUp=null;
        		setCeldaGrafica(new TransitableGrafica(fila,columna));
        		miMapa.getNivel().agregarGrafico(this);
        	}
        
        if(miPared!=null){
        	puntos+=miPared.serExplotado();
        	//Si hay una pared con powerup debo cambir la grafica x la del powerup.
        	if(miPowerUp!=null){
        		setCeldaGrafica(miPowerUp.getGraficaPU());
        		miMapa.getNivel().agregarGrafico(this);
        	}
        	//Si hay una pared sin powerup debo cambiar la grafica x la celda vacia.
        	else{
        		setCeldaGrafica(new TransitableGrafica(fila, columna));
        		miMapa.getNivel().agregarGrafico(this);
        	}
        	miPared=null;
        } 
        
        if(miBomba!=null){
        	miBomba.interrupt();
        	miBomba.explotar();       	
        	
        }
        
        return puntos;

    }

}