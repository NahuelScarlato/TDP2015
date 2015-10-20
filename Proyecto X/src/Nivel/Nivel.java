package Nivel;

import GUI.GUI;
import contenedores.Mapa;
import entidades.Bomberman;
import entidades.Enemigo;
import objetos.Bombality;
import objetos.Fatality;
import objetos.Masacrality;
import objetos.PowerUp;
import objetos.SpeedUp;
import threads.EnemigoThread;

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
    
    //Para cortar el hilo principal
    protected boolean murio = false;
    
    /**
     * 
     */
    public Nivel(GUI gui) {
        marcador=0;
        miMapa=new Mapa(13,31,this);
        
        bomberman=miMapa.crearBomberman();
        gui.getFrame().add(bomberman.getGrafico());	
        
        enemigos=miMapa.crearEnemigos();
        EnemigoThread[] hiloE = new EnemigoThread[enemigos.length];
        
        for(int i=0;i<cantEnemigos-1;i++){			
			hiloE[i]=new EnemigoThread(enemigos[i]);			
			
			gui.getFrame().add(enemigos[i].getGrafico());
			
			hiloE[i].start();
		}						
    }
    
    public boolean getMurio(){
    	return murio;
    }
    
    public void setMurio(boolean m){
    	murio=m;
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

    
    public void pausar(){
		for(int i = 0; i < enemigos.length; i++){
			enemigos[i].pensarAvanzar();
		}
	}
    
	public void mover(){
		for(int i = 0; i < enemigos.length; i++){
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