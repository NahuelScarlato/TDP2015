package Logica;

/**
 * 
 */
public class Bomberman extends Entidad {

    /**
     * 
     */
    protected int velocidad;

    /**
     * 
     */
    protected int cantBombas;

    /**
     * 
     */
    protected int rangoBombas;
    
    
    	
    /**
     * Default constructor
     */
    public Bomberman() {
    	super();
    	velocidad=1;
    	cantBombas=1;
    	rangoBombas=1;
    }
    
    /**
     * @param dir
     */
    public void avanzar(int dir) {
        // TODO implement here
    }

    /**
     * 
     */
    public void ponerBomba() {
        if(cantBombas>0){
        	miCelda.setBomba(new Bomba(rangoBombas));
        	cantBombas--;
        }
        //Cuando explota la bomba aumenta la cantidad
    }

    /**
     * @return
     */
    public int getVelocidad() {
        return velocidad;
    }

    /**
     * @param v
     */
    public void setVelocidad(int v) {
        velocidad=v;
    }
    
    /**
     *
     */
    public void aumentarVelocidad() {
        velocidad++;
    }

    /**
     * @return
     */
    public int getCantBombas() {
        return cantBombas;
    }

    /**
     * @param cB
     */
    public void setCantBombas(int cB) {
        cantBombas=cB;
    }
    
    /**
     *
     */
    public void aumentarCantBombas() {
        cantBombas++;
    }
    
    /**
     * @return
     */
    public int getRangoBombas() {
        return rangoBombas;
    }

    /**
     * @param rB
     */
    public void setRangoBombas(int rB) {
        rangoBombas=rB;
    }
    
    /**
     * @param rB
     */
    public void aumentarRangoBombas() {
        rangoBombas*=2;
    }

    /**
     * 
     */
    public int serExplotado() {
		return 0;
    }
    
    /**
     * 
     */
    public void morir() {
        
    }

}