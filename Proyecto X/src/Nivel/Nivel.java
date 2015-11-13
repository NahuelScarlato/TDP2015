package Nivel;

import java.awt.event.KeyEvent;

import javax.swing.JLabel;

import objetos.Bomba;
import GUI.GUI;
import contenedores.Celda;
import contenedores.Mapa;
import entidades.Bomberman;
import entidades.Enemigo;
import entidades.Entidad;
import grafica.BombaGrafica;
import grafica.CeldaGrafica;
import grafica.EntidadGrafica;

/**
 * Representa un nivel.
 * @author Llano Jose, Scarlato Nahuel Hernan; Tecnologia de Programacion 2015.
 */
public class Nivel {

   
    protected int marcador;
    
    protected Mapa miMapa;

    protected Enemigo[] enemigos;
    
    protected Bomberman bomberman;
    
    protected int cantParedes;
    
    protected GUI gui;
    
    
    /**
     * Construye un nivel con una gui asociada pasada por parametro.
     * Crea su bomberman, power ups, los respectivos enemigos e inicia los hilos de los enemigos.
     * @param gui GUI.
     */
    public Nivel(GUI gui) {
        marcador=0;
        
        this.gui=gui;
        miMapa=new Mapa(13,31,this);
        
        bomberman=miMapa.crearBomberman();        
                
        Celda[] paredes=miMapa.crearParedesDestruibles();
        
        cantParedes=paredes.length;
        
        miMapa.crearPowerUps(paredes);
        
        enemigos=miMapa.crearEnemigos();
        
        for(int i=0;i<enemigos.length-1;i++){			
			enemigos[i].start();
		}        
        

        gui.getLbllblCantParedes().setText(""+cantParedes);
      
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
     * Agrega la grafica de la celda pasada por prametro al contenedor.
     * @param c Celda.
     */
    public void agregarEntidadGrafico(Entidad e){
    	EntidadGrafica cAux=e.getGrafico();
    	JLabel aux=cAux.getGrafico();
    	gui.getFrame().add(aux,2);
    	
    }
 
    /**
     * Agrega la grafica de la celda pasada por prametro al contenedor.
     * @param c Celda.
     */
    public void agregarBombaGrafico(Bomba b){
    	BombaGrafica cAux=b.getGraficaB();
    	JLabel aux=cAux.getGrafico();
    	gui.getFrame().add(aux,1);
    	
    }
    
    /**
     * Termina la ejecucion de los hilos de los enemigos.
     */ 
    public void cortar(){
		
    	gui.getcT().toggleSeguir();
    	
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
		//if(dir==Celda.B)
		//	bomberman.ponerBomba();
	//	else
			bomberman.avanzar(dir);
	}
	
	public void ponerBomba(int dir){
		if(dir==KeyEvent.VK_B){
			bomberman.ponerBomba();
			//System.out.println("entro al poner bomba de nivel");
		}
		//else
			//bomberman.avanzar(dir);
	}
    
    /**
     * Retorna el puntaje acumulado.
     * @return marcador int.
     */
    public int getMarcador() {
        return marcador;
    }
    
    /**
     * Retorna cantidad actual de paredes destruibles sin destruir.
     * @return cantParedes int.
     */
    public int getCantP(){
    	return cantParedes;
    }
    
    public void disminuirCantP(){
    	cantParedes--;
    }

    /**
     * Aumenta el puntaje actual con m pasado por parametro.
     * @param m int.
     */
    public void sumarPuntaje(int m) {
        marcador+=m;
        gui.getMarcadorGUI().setText("    "+marcador);
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