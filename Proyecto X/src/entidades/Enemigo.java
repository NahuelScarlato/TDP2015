package entidades;

import contenedores.Celda;

/**
 * 
 */
public abstract class Enemigo extends Entidad {

    protected int puntaje;

    /**
     * @param p
     */
    public Enemigo(int p,Celda c) {
        super(c);
    	puntaje=p;
    }
    
    @Override
	public void run() {
		while(vivo){
			try {
				Thread.sleep(1000);
				pensarAvanzar();
			} catch (InterruptedException e) {}
		}
	}
    
    /**
     * @return
     */
    public int serExplotado() {
        morir();
        return puntaje;
    }

    /**
     * @return
     */
    public int getPuntaje() {
        return puntaje;
    }

    /**
     * @param dir
     */
    public abstract void pensarAvanzar();
    
    /**
     * 
     */
    public void morir() {
        // TODO implement here}
    }
    
    public void avanzar(int dir){
    	super.avanzar(dir);
    }    
    
    /*Revisar desp de terminar el movimiento del sirius
    public void avanzar(int dir){
    	Celda proxima = miCelda.celdaParaAvanzar(dir);

		if (proxima != null) {
			if(proxima.getBomba() == null)
				if (proxima.getPared() == null)
					actualizar(proxima,dir);				
				else
					if(GMod)
						actualizar(proxima,dir);						
				
			if (proxima.getBomberman() != null) 
				proxima.getBomberman().morir();
		}
	}
    
    private void actualizar(Celda c, int dir){
    	c.setEnemigo(this);
		miCelda.setEnemigo(null);	
		super.avanzar(dir);	
    }
    */

}