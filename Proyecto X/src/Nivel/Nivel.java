package Nivel;

import contenedores.Mapa;
import entidades.Bomberman;
import entidades.Enemigo;

/**
 * 
 */
public class Nivel {

    /**
     * 
     */
    protected int marcador;

    protected Enemigo[] enemigos;
    
    protected Bomberman bomberman;
    /**
     * 
     */
    public Nivel() {
        marcador=0;
        new Mapa(13,31,this);
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