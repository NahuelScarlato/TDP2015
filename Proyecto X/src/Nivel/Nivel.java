package Nivel;

import javax.swing.JLabel;

import GUI.GUI;

import contenedores.Celda;
import contenedores.Mapa;
import entidades.Bomberman;
import entidades.Enemigo;
import grafica.CeldaGrafica;
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
        this.gui.getFrame().add(bomberman.getGrafico());	
        
        enemigos=miMapa.crearEnemigos();
        
        for(int i=0;i<cantEnemigos-1;i++){			
			this.gui.getFrame().add(enemigos[i].getGrafico());			
			enemigos[i].start();
		}
        
        miMapa.crearPowerUps();
    }
    
    /**
     * 
     * @param c Celda.
     */
    public void agregarGrafico(Celda c){
    	CeldaGrafica cAux=c.getCeldaGrafica();
    	JLabel aux=cAux.getGrafico();
    	gui.getFrame().add(aux);
    }
 
    /**
     *
     */ 
    public void cortar(){
		for(int i = 0; i < enemigos.length; i++){
			if(enemigos[i]!=null)
				enemigos[i].toggleVivo();
		}
	}
    
    /**
     * 
     * @return.
     */
	public void mover(){
		for(int i = 0; i < enemigos.length; i++){
			if(enemigos[i]!=null)
				enemigos[i].pensarAvanzar();
		}
	}
	
	
	/**
     * 
     * @param dir int.
     */
	public void mover(int dir){
		if(dir==Celda.B)
			bomberman.ponerBomba();
		
		bomberman.avanzar(dir);
	}
    
    /**
     * Retorna el puntaje acumulado.
     * @return marcador int.
     */
    public int getMarcador() {
        return marcador;
    }

    /**
     * Actualiza el contador en su valor actual mas un m, que es pasado por parametro.
     * @param m int.
     */
    public void sumarPuntaje(int m) {
        marcador+=m;
    }
    
    
    /**
   	 * Actualiza enemigos.
   	 * @param ene Enemigo[], arreglo de enemigos.
    */
    public void setEnemigos(Enemigo[] ene){
    	enemigos=ene;
    }

    
    /**
   	 * Retorna el los enemigos del nivel.
   	 * @return enemigos Enemigo[], arreglo de enemigos.
   	*/
    public Enemigo[] getEnemigos(){
    	return enemigos;
    }
    
    
    /**
   	 * Actualiza el valor del bomberman.
   	 * @param b Bomberman.
   	 */
    public void setBomberman(Bomberman b){
    	bomberman=b;
    }

    /**
	 * Retorna el bomberman.
	 * @return bomberman Bomberman.
	*/
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