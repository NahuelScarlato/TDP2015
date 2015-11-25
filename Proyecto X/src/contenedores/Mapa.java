package contenedores;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import objetos.Bombality;
import objetos.Fatality;
import objetos.Masacrality;
import objetos.Pared;
import objetos.PowerUp;
import objetos.SpeedUp;
import Nivel.Nivel;
import entidades.Altair;
import entidades.Bomberman;
import entidades.Enemigo;
import entidades.Rugulos;
import entidades.Sirius;
import grafica.ParedGrafica;
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
    				crearIndestructible(f,c);
    			else{
    				if(f%2==0 && c%2==0){
						crearIndestructible(f,c);
    				}
    				else  {
    					miMatriz[f][c]=new Celda(f,c,this);
    					miNivel.agregarGrafico(miMatriz[f][c]);
    				}    						
    			}
    		}
    	
    }
    
    /**
    * Crea el bomberman, lo ubica en una celda predefinida y lo retorna.
    * @return b Bomberman.
    */
    public Bomberman crearBomberman(){
    	Bomberman b=new Bomberman(miMatriz[1][1]);
    	miMatriz[1][1].setBomberman(b);
    	miNivel.agregarEntidadGrafico(b);
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
        miMatriz[filas-2][columnas-2].setEnemigo(enemigos[0]);
        miNivel.agregarEntidadGrafico(enemigos[0]);
        //Creo 3 Rugulos
        int r;
        for(r=1;r<3;r++){
        	Celda aux=buscarCelda();
        	enemigos[r]=new Rugulos(aux);
        	aux.setEnemigo(enemigos[r]);
        	miNivel.agregarEntidadGrafico(enemigos[r]);
        }
        
        //Creo 2 Altair
        int a;
        for(a=0;a<2;a++){
        	Celda aux=buscarCelda();
		    enemigos[a+r]=new Altair(aux);
		    aux.setEnemigo(enemigos[a+r]);
		    miNivel.agregarEntidadGrafico(enemigos[a+r]);
		}
        
        return enemigos;
    }
    
    /**
     * Crea pared indestructible.
     */	
    private void crearIndestructible(int x, int y){
    	JLabel aux=new JLabel(new ImageIcon(getClass().getResource("/source/Objetos/ParedIndestructible.png")));
		aux.setBounds(y*32, x*32, 32, 32);
    	miNivel.getGUI().getFrame().add(aux);
    	
    	miMatriz[x][y]=null;
    }
    
    /**
     * Crea las paredes, las ubica en celdas apropiadas y retorna un arreglo con las celdas donde se crearo paredes.
     * @return paredes Celda[].
     */
	public Celda[] crearParedesDestruibles() {
    	Celda[] paredes=new Celda[125];
    	int p=0;
    	
        Random nR = new Random();
        int rndF;
 		int rndC;
    	
    	while(p<125){
    		rndF= nR.nextInt(filas-1);
         	rndC= nR.nextInt(columnas-1);
    		if(miMatriz[rndF][rndC]!=null && CeldaValida(rndF,rndC) && miMatriz[rndF][rndC].getPared()==null ){
	    		miMatriz[rndF][rndC].setPared(new Pared(miMatriz[rndF][rndC]));
	    		paredes[p]=miMatriz[rndF][rndC];
	    		
	    		miMatriz[rndF][rndC].setCeldaGrafica(new ParedGrafica(rndF,rndC));
	    		miNivel.agregarGrafico(miMatriz[rndF][rndC]);
	    		
	    		p++;
	    		
	    	}
	    }
    	
    	return paredes;
    }
    
	/**
	 * Retorna verdadero en caso de que el par de enteros sean la posicion de una celda valida
	 * para insertar una pared destruible, falso en caso contrario.
	 * @param x Int.
	 * @param y Int.
	 * @return es Boolean.
	 */
	private boolean CeldaValida(int x, int y){
		boolean es=true;
		
		if (x==1 || x==2 || x==10 || x==11)
			if ( y==1 || y==2 || y==28 || y==29 )
				es=false;
					
		return es;
	}
	
    /**
     * Crea los power up y los ubica en celdas apropiadas.
     * @param paredes Celda[].
     */
    public void crearPowerUps(Celda [] paredes) {
    	PowerUp[] powerUps=new PowerUp[11];
        
        //Creao 4 SpeedUp
        int s;
        Celda aux;
        for(s=0;s<4;s++){
        	aux= buscarCeldaPU(paredes);
        	powerUps[s]=new SpeedUp(aux);        	
        	aux.setPowerUp(powerUps[s]);
        }
        //Creo 3 Fatality
        int f;
        for(f=0;f<3;f++){
        	aux=buscarCeldaPU(paredes);        	
        	powerUps[f+s]=new Fatality(aux);
        	aux.setPowerUp(powerUps[s+f]);        		
        }
        //Creao 3 Bombality
        int b;
        for(b=0;b<3;b++){
        	aux=buscarCeldaPU(paredes);
        	powerUps[b+f+s]=new Bombality(aux);
        	aux.setPowerUp(powerUps[s+b+f]);
        }
        //Creo 1 Masacrality
        int m;
        for(m=0;m<1;m++){
        	aux=buscarCeldaPU(paredes);
        	powerUps[m+b+f+s]=new Masacrality(aux);   
        	aux.setPowerUp(powerUps[s+b+f]);
        }
        
    }
    
   
   /**
    * Busca una celda no nula aleatoria, sin enemigos y la retorna.
    * @return aux Celda
    */
    private Celda buscarCeldaPU(Celda [] paredes){
        Random nR = new Random();
        int rnd=nR.nextInt(paredes.length);
		
		Celda aux=null;
		boolean encontro=false;
		while(!encontro){
        	
        	if(paredes[rnd].getPowerUp()==null) {
        		aux=paredes[rnd];
        		encontro=true;
        	}
        	rnd=nR.nextInt(paredes.length);
    	}    	
    	
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
        		if(aux.getEnemigo()==null && aux.getPared()==null)
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
