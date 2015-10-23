package contenedores;

import java.util.Random;

import objetos.Bombality;
import objetos.Fatality;
import objetos.Masacrality;
import objetos.PowerUp;
import objetos.SpeedUp;
import Nivel.Nivel;
import entidades.Altair;
import entidades.Bomberman;
import entidades.Enemigo;
import entidades.Rugulos;
import entidades.Sirius;
import contenedores.Celda;

/**
 * Representa un contenedor para celdas.
 * @author Llano Jose, Scarlato Nahuel Hernan; Tecnologia de Programacion 2015.
 */
public class Mapa {

	protected int filas;
    protected int columnas;

    protected Celda[][] miMatriz;
    
    protected Nivel miNivel;

    /**
     * Crea una matriz de filas filas y columnas columnas.
     * Inicializa su nivel,filas y columnas con valores pasados por parametro.
     * 
     * @param filas int.
     * @param columnas int.
     * @param nivel Nivel.
     */
    public Mapa(int filas, int columnas,Nivel nivel) {
    	miMatriz=new Celda[filas][columnas];
    	
    	miNivel=nivel; 
    	
    	this.filas=filas;
    	this.columnas=columnas;

    	//Inicializo sin paredes
    	for(int f=0;f<filas;f++)
    		for(int c=0;c<columnas;c++){
    			if(f==0 || c==0 || f==(filas-1) || c==(columnas-1))
    				miMatriz[f][c]=null;
    			else
    				miMatriz[f][c]=new Celda(f,c,this);
    		}
    	
    	//Falta meter los powerUps y paredes
    	
    	
    	
    	
    }
    
    /**
    * Crea el bomberman, lo ubica en una celda predefinida y lo retorna.
    * @return b Bomberman.
    */
    public Bomberman crearBomberman(){
    	Bomberman b=new Bomberman(miMatriz[1][1]);
    	miMatriz[1][1].setBomberman(b);
    	return b;
    }
    
    /**
     * Crea los enemigos, los ubica en una celda apropiada y los retorna. 
     * @return enemigos Enemigo[].
     */
    public Enemigo[] crearEnemigos(){
    	Enemigo[] enemigos=new Enemigo[6];
        
    	//Creo Sirius
        enemigos[0]=new Sirius(miMatriz[filas-2][columnas-2]);
        
        //Creo 3 Rugulos
        int r;
        for(r=1;r<3;r++)
        	enemigos[r]=new Rugulos(buscarCelda());        
        
        //Creo 2 Altair
        int a;
        for(a=0;a<2;a++)
		    enemigos[a+r]=new Altair(buscarCelda());
        
        return enemigos;
    }
    
    /**
     * Crea los power up y los ubica en celdas apropiadas.
     */
    public void crearPowerUps() {
    	PowerUp[] powerUps=new PowerUp[11];
        
        //Creao 4 SpeedUp
        int s;
        Celda aux;
        for(s=0;s<4;s++){
        	aux= buscarCeldaPU();
        	powerUps[s]=new SpeedUp(aux);        	
        	aux.setPowerUp(powerUps[s]);
        }
        //Creo 3 Fatality
        int f;
        for(f=0;f<3;f++){
        	aux=buscarCeldaPU();        	
        	powerUps[f+s]=new Fatality(aux);
        	aux.setPowerUp(powerUps[s+f]);        		
        }
        //Creao 3 Bombality
        int b;
        for(b=0;b<3;b++){
        	aux=buscarCeldaPU();
        	powerUps[b+f+s]=new Bombality(aux);
        	aux.setPowerUp(powerUps[s+b+f]);
        }
        //Creo 1 Masacrality
        int m;
        for(m=0;m<1;m++){
        	aux=buscarCeldaPU();
        	powerUps[m+b+f+s]=new Masacrality(aux);   
        	aux.setPowerUp(powerUps[s+b+f]);
        }
        
    }
    
   
   /**
    * Busca una celda no nula aleatoria, sin enemigos y la retorna.
    * @return aux Celda
    */
    private Celda buscarCeldaPU(){
        Random nR = new Random();
        int rndF;
		int rndC;
		Celda aux;
		boolean encontro=false;
    	do{
    		rndF= nR.nextInt(filas-1);
        	rndC= nR.nextInt(columnas-1);
        	aux=miMatriz[rndF][rndC];
        	if(aux!=null)
        		if(aux.getEnemigo()==null)
        			encontro=true;
    	}
    	while(!encontro);
    	
    	return aux;
    }
    
    /**
     * Busca una celda no nula aleatoria, sin enemigos, en el cuadrante inferior derecho y la retorna.
     * @return aux Celda.
     */
    private Celda buscarCelda(){
        Random nR = new Random();
        int rndF;
		int rndC;
		Celda aux;
		boolean encontro=false;
    	do{
    		rndF= nR.nextInt(6);
        	rndC= nR.nextInt(15);
        	aux=miMatriz[filas-rndF-1][columnas-rndC-1];
        	if(aux!=null)
        		if(aux.getEnemigo()==null)
        			encontro=true;
    	}
    	while(!encontro);
    	
    	return aux;
    }
    
    /**
     * Retorna la celda que se encuentra en la posicion (x,y).
     * @param x int.
     * @param y int.
     * @return miMatriz[x][y] Celda.
     */
    public Celda getCelda(int x, int y) {
        return miMatriz[x][y];
    }
    
    /**
     * Retorna la cantidad de filas.
     * @return filas int.
     */
    public int getFilas(){
    	return filas;
    }
    
    /**
     * Retorna la cantidad de columnas.
     * @return columnas int.
     */
    public int getColumnas(){
    	return columnas;
    }
    
    /**
     * Retorna el nivel del mapa.
     * @return miNivel Nivel.
     */
    public Nivel getNivel(){
    	return miNivel;
    }
  
}
