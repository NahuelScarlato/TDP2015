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
 * 
 */
public class Mapa {

	protected int filas;
    protected int columnas;

    protected Celda[][] miMatriz;
    
    protected Nivel miNivel;

    /**
     * 
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
    
    public Bomberman crearBomberman(){
    	Bomberman b=new Bomberman(miMatriz[1][1]);
    	miMatriz[1][1].setBomberman(b);
    	return b;
    }
    
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
     * @return
     */
    public void crearPowerUps() {
    	PowerUp[] powerUps=new PowerUp[11];
        
        //Creao 4 SpeedUp
        int s;
        for(s=0;s<4;s++){
        	powerUps[s]=new SpeedUp();
        	Celda aux= buscarCeldaPU();
        	aux.setPowerUp(powerUps[s]);
        	getNivel().getGUI().getFrame().add(aux.getCeldaGrafica().getGrafico());
        }
        //Creo 3 Fatality
        int f;
        for(f=0;f<3;f++){
        	powerUps[f+s]=new Fatality();
        	buscarCeldaPU().setPowerUp(powerUps[s+f]);	
        }
        //Creao 3 Bombality
        int b;
        for(b=0;b<3;b++){
        	powerUps[b+f+s]=new Bombality();
        	buscarCeldaPU().setPowerUp(powerUps[s+b+f]);	
        }
        //Creo 1 Masacrality
        int m;
        for(m=0;m<1;m++){
        	powerUps[m+b+f+s]=new Masacrality();   
        	buscarCeldaPU().setPowerUp(powerUps[s+b+f+m]);	
        }
        
    }
    
   
    
    // temporal para creacion de power y para probar el prototipo
    private Celda buscarCeldaPU(){
        Random nR = new Random();
        int rndF;
		int rndC;
		Celda aux;
		boolean encontro=false;
    	do{
    		rndF= nR.nextInt();
        	rndC= nR.nextInt();
        	aux=miMatriz[rndF][rndC];
        	if(aux!=null)
        		if(aux.getEnemigo()==null)
        			encontro=true;
    	}
    	while(!encontro);
    	
    	return aux;
    }
    
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
     * @param x 
     * @param y 
     * @return
     */
    public Celda getCelda(int x, int y) {
        return miMatriz[x][y];
    }
    
    public int getFilas(){
    	return filas;
    }
    
    public int getColumnas(){
    	return columnas;
    }
    
    public Nivel getNivel(){
    	return miNivel;
    }
    
    public void setNivel(Nivel n){
    	miNivel=n;
    }
}
