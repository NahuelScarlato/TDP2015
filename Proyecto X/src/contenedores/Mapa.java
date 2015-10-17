package contenedores;

import java.util.Random;

import Nivel.Nivel;
import entidades.Altair;
import entidades.Bomberman;
import entidades.Enemigo;
import entidades.Rugulos;
import entidades.Sirius;

import contenedores.Celda;

import objetos.Bombality;
import objetos.Fatality;
import objetos.Masacrality;
import objetos.PowerUp;
import objetos.SpeedUp;

/**
 * 
 */
public class Mapa {

   /**
     * 
     */
    protected int filas;
    
    /**
     * 
     */
    protected int columnas;

    /**
     * 
     */
    protected Celda[][] miMatriz;
    
    /**
     * 
     */
    protected Nivel miNivel;

    /**
     * 
     */
    public Mapa(int filas, int columnas,Nivel n) {
    	miMatriz=new Celda[filas][columnas];
    	
    	miNivel=n;
    	
    	this.filas=filas;
    	this.columnas=columnas;

    	//Inicializo sin paredes
    	for(int f=0;f<miMatriz.length;f++)
    		for(int c=0;c<miMatriz[0].length;c++){
    			if(f==0 || c==0 || f==(filas-1) || c==(columnas-1))
    				miMatriz[f][c]=null;
    			else
    				miMatriz[f][c]=new Celda(f,c,this);
    		}
    	
    	//Seteo bomberman y sirius origen constante
    	Bomberman bomberman=new Bomberman(miMatriz[1][1]);
    	miMatriz[1][1].setBomberman(bomberman);
    	miMatriz[filas-1][columnas-1].setEnemigo(new Sirius(miMatriz[filas-1][columnas-1]));
    	
    	
    	miNivel.setEnemigos(crearEnemigos());
    	miNivel.setBomberman(bomberman);
    	//Falta meter los powerUps y paredes
    }

    /**
     * @return
     */
    private Enemigo[] crearEnemigos() {
        Enemigo[] enemigos=new Enemigo[5];
        
        //Creo 3 Rugulos
        int r;
        for(r=0;r<3;r++)
        	enemigos[r]=new Rugulos(null);
        //Creo 2 Altair
        int a;
        for(a=0;a<2;a++)
        	enemigos[a+r]=new Altair(null);
        
        Random nR = new Random();
        int rndF;
		int rndC;
		int i=enemigos.length;
		
		//Busca celdas random del cuadrante der-inferior, y verifica si puede agregar un enemigo
        while(i>-1){
        	
        	do{
        		rndF= nR.nextInt(6);
            	rndC= nR.nextInt(15);
        	}
        	while(rndF==0||rndC==0);        		
        	
        	Celda aux=miMatriz[miMatriz.length-rndF][miMatriz[0].length-rndC];
        	if(aux.getPared()==null && aux.getEnemigo()==null){
        		aux.setEnemigo(enemigos[i]);
        		i--;
        	}        	
        }  
        return enemigos;
    }

    /**
     * @return
     */
    private PowerUp[] crearPowerUps() {
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
        
        return powerUps;
    }

    /**
     * @param x 
     * @param y 
     * @return
     */
    public Celda getCelda(int x, int y) {
        return miMatriz[x][y];
    }
    
    public Nivel getNivel(){
    	return miNivel;
    }
}
