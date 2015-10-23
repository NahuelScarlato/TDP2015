package Nivel;

import javax.swing.JLabel;

import GUI.GUI;

import contenedores.Celda;
import contenedores.Mapa;
import entidades.Bomberman;
import entidades.Enemigo;
import grafica.CeldaGrafica;

/**
 * Representa un nivel.
 * @author Llano Jose, Scarlato Nahuel Hernan; Tecnologia de Programacion 2015.
 */
public class Nivel {

   
    protected int marcador;
    
    protected Mapa miMapa;

    protected Enemigo[] enemigos;
    
    protected int cantEnemigos=6;
    
    protected Bomberman bomberman;
    
    protected GUI gui;
    
    
    /**
     * Construye un nivel con una gui asociada pasada por parametro.
     * Crea su bomberman, power ups, los respectivos enemigos e inicia los hilos de los enemigos.
     * @param gui GUI.
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
     * Agrega la grafica de la celda pasada por prametro al contenedor.
     * @param c Celda.
     */
    public void agregarGrafico(Celda c){
    	CeldaGrafica cAux=c.getCeldaGrafica();
    	JLabel aux=cAux.getGrafico();
    	gui.getFrame().add(aux);
    }
 
    /**
     * Termina la ejecucion de los hilos de los enemigos.
     */ 
    public void cortar(){
		for(int i = 0; i < enemigos.length; i++){
			if(enemigos[i]!=null)
				enemigos[i].toggleVivo();
		}
	}
    
    /**
     * Dispara el movimiento de cada enemigo.
     */
	public void mover(){
		for(int i = 0; i < enemigos.length; i++){
			if(enemigos[i]!=null)
				enemigos[i].pensarAvanzar();
		}
	}
	
	
	/**
     * Dispara el movimiento del bomberman o el de poner una bomba.
     * @param dir int.
     */
	public void mover(int dir){
		if(dir==Celda.B)
			bomberman.ponerBomba();
		else
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
     * Aumenta el puntaje actual con m pasado por parametro.
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
   	 * Retorna el arreglo enemigos.
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
    
    /**
     * Retorna la gui.
     * @return gui GUI.
     */
    public GUI getGUI(){
    	return gui;
    }
}