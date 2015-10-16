package Logica;

/**
 * 
 */
public class Nivel {

    /**
     * 
     */
    protected int marcador;

    /**
     * 
     */
    protected int cantParedes;


    /**
     * 
     */
    protected Celda[][] miMatriz;

    /**
     * 
     */
    public Nivel() {
        marcador=0;
        crearMatriz();
    }

    /**
     * 
     */
    private void crearMatriz() {
    	miMatriz=new Celda[13][31];
    	
    	int filas=miMatriz.length;
    	int columnas=miMatriz[0].length;

    	Enemigo[] enemigos=crearEnemigos();
    	PowerUp[] powerUps=crearPowerUps();
    	
    	//Inicializo sin paredes
    	for(int f=0;f<miMatriz.length;f++)
    		for(int c=0;c<miMatriz[0].length;c++){
    			if(f==0 || c==0 || f==(filas-1) || c==(columnas-1))
    				miMatriz[f][c]=null;
    			else
    				miMatriz[f][c]=new Celda(f,c,this);
    		}
    	
    	//Seteo bomberman y sirius origen constante
    	miMatriz[0][0].setBomberman(new Bomberman());
    	miMatriz[filas][columnas].setEnemigo(new Sirius());
    	
    	//Falta algoritmo para crear las paredes junto con los powerups y los enemigos
    }

    /**
     * @return
     */
    private Enemigo[] crearEnemigos() {
        Enemigo[] enemigos=new Enemigo[5];
        
        //Creo 3 Rugulos
        int r;
        for(r=0;r<3;r++)
        	enemigos[r]=new Rugulos();
        //Creo 2 Altair
        int a;
        for(a=0;a<2;a++)
        	enemigos[a+r]=new Altair();
        		
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

}