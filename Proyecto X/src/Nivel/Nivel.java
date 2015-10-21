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
 
    /**
     * @return
     */
    private void crearPowerUps() {
    	PowerUp[] powerUps=new PowerUp[11];
        
        //Creao 4 SpeedUp
        int s;
        for(s=0;s<4;s++)
        	powerUps[s]=new SpeedUp();
        //Creo 3 Fatality
        int f;
        for(f=0;f<3;f++)
        	powerUps[f+s]=new Fatality();
        //Creao 3 Bombality
        int b;
        for(b=0;b<3;b++)
        	powerUps[b+f+s]=new Bombality();
        //Creo 1 Masacrality
        int m;
        for(m=0;m<1;m++)
        	powerUps[m+b+f+s]=new Masacrality();        
        
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
}