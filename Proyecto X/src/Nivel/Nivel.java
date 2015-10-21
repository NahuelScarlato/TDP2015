package Nivel;

import GUI.GUI;
import contenedores.Celda;
import contenedores.Mapa;
import entidades.Bomberman;
import entidades.Enemigo;
import objetos.Bomba;
import objetos.Bombality;
import objetos.Fatality;
import objetos.Masacrality;
import objetos.PowerUp;
import objetos.SpeedUp;

/**
 * 
 */
public class Nivel {

    /**
     * 
     */
    protected int marcador;
    
    protected Mapa miMapa;

    protected Enemigo[] enemigos;
    
    protected int cantEnemigos=6;
    
    protected Bomberman bomberman;
    
    protected GUI gui;
    
    
    /**
     * 
     */
    public Nivel(GUI gui) {
        marcador=0;
        miMapa=new Mapa(13,31,this);
        this.gui=gui;
        
        bomberman=miMapa.crearBomberman();
        gui.getFrame().add(bomberman.getGrafico());	
        
        enemigos=miMapa.crearEnemigos();
        
        for(int i=0;i<cantEnemigos-1;i++){			
			gui.getFrame().add(enemigos[i].getGrafico());			
			enemigos[i].start();
		}        
        
    }
    
    public void agregarGrafico(Celda c){
    	gui.getFrame().add(c.getCeldaGrafica().getGrafico());
    }
 
        
    public void cortar(){
		for(int i = 0; i < enemigos.length; i++){
			if(enemigos[i]!=null)
				enemigos[i].toggleVivo();
		}
	}
    
	public void mover(){
		for(int i = 0; i < enemigos.length; i++){
			if(enemigos[i]!=null)
				enemigos[i].pensarAvanzar();
		}
	}
	
	public void mover(int dir){
		bomberman.avanzar(dir);
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
    
    public void setEnemigos(Enemigo[] ene){
    	enemigos=ene;
    }

    public Enemigo[] getEnemigos(){
    	return enemigos;
    }
    
    public void setBomberman(Bomberman b){
    	bomberman=b;
    }

    public Bomberman getBomberman(){
    	return bomberman;
    }
    
    // para el prototipo agregamos los seteter y getters para probar los power ups
    public void setGUI(GUI gui){
    	this.gui=gui;
    }
    
    public GUI getGUI(){
    	return gui;
    }
}