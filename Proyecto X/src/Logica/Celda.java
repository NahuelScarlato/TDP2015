package Logica;

/**
 * 
 */
public class Celda {

    /**
     * 
     */
    protected int fila;

    /**
     * 
     */
    protected int columna;

    /**
     * 
     */
    protected PowerUp miPowerUp;


    /**
     * 
     */
    protected Nivel miNivel;

    /**
     * 
     */
    protected Pared miPared;

    /**
     * 
     */
    protected Enemigo miEnemigo;
    
    /**
     * 
     */
    protected Bomberman miBomberman;

    /**
     * 
     */
    protected Bomba miBomba;

    /**
     * 
     */
    public Celda(int fila, int columna,Nivel nivel) {
    	this.fila=fila;
    	this.columna=columna;
    	miPowerUp=null;
    	miNivel=nivel;
    	miPared=null;
    	miEnemigo=null;
    	miBomberman=null;
    	miBomba=null;
    }

    /**
     * @return
     */
    public PowerUp getPowerUp() {
        return miPowerUp;
    }

    /**
     * @param pu
     */
    public void setPowerUp(PowerUp pu) {
        miPowerUp=pu;
    }

    /**
     * @return
     */
    public Pared getPared() {
        return miPared;
    }

    /**
     * @param p
     */
    public void setPared(Pared p) {
       miPared=p;
    }

    /**
     * @return
     */
    public Bomba getBomba() {
        return miBomba;
    }

    /**
     * @param b
     */
    public void setBomba(Bomba b) {
       miBomba=b;
    }

    /**
     * @return
     */
    public Enemigo getEnemigo() {
        return miEnemigo;
    }

    /**
     * @param e
     */
    public void setEnemigo(Enemigo e) {
        miEnemigo=e;
    }
    
    /**
     * @return
     */
    public Bomberman getBomberman() {
        return miBomberman;
    }

    /**
     * @param e
     */
    public void setBomberman(Bomberman b) {
        miBomberman=b;
    }

    /**
     * @param r 
     * @return
     */
    public Celda[] celdasParaExplotar(int r) {
        
    	int total=r*6;
    	Celda[] exp=new Celda[total];    	
    	//Algoritmo para conseguir celdas
        return exp;
    }

    /**
     * @param dir
     */
    public Celda celdaParaAvanzar(int dir) {
        switch(dir){
        case 0:
        	//Arriba
        	return miNivel.getCelda(fila-1,columna);
        case 1:
        	//Derecha
        	return miNivel.getCelda(fila,columna+1);
        case 2:
        	//Abajo
        	return miNivel.getCelda(fila+1,columna);
        case 3:
        	//Izquierda
        	return miNivel.getCelda(fila,columna-1);
        }
        return null;
    }

    /**
     * 
     */
    public void serExplotada() {
    	if(miBomberman!=null){
        	miBomberman.morir();
        	miBomberman=null;
        }
    	
    	if(miPared!=null){
        	miPared.serExplotado();
        	miPared=null;
        } 
        
        if(miEnemigo!=null){
        	miEnemigo.serExplotado();
        	miEnemigo=null;
        }
        	
        if(miBomba!=null){
        	miBomba.explotar();
        	miBomba=null;
        }
        	
        if(miPowerUp!=null)
        	miPowerUp=null;

    }

}