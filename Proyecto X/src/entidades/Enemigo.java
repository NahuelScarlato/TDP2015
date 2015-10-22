package entidades;

import contenedores.Celda;

/**
 * 
 */
public abstract class Enemigo extends Entidad {

    protected int puntaje;

    /**
	 * Crea un enemigo con un puntaje y su respectiva celda. Ambos pasados por parámetro.
	 * @param p int, puntaje del enemigo.
	 * @param c Celda, celda del enemigo.
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
     * Destruye al enemigo.
     * Retorna el valor de eliminar al enemigo.
     * @return puntaje int.
     */
    public int serExplotado() {
        morir();
        return puntaje;
    }

    /**
     * Retorna el puntaje de eliminar a un enemigo.
     * @return puntaje int.
     */
    public int getPuntaje() {
        return puntaje;
    }

    /**
     * 
     */
    public abstract void pensarAvanzar();
    
    /**
     * 
     */
    public void morir() {
        // TODO implement here}
    }
    
    
    /**
	 * Enemigo avanza hacia una celda.
	 * @param dir int, direccion a moverse. 
	 */
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
    
    
    /**
	 * Elimina el enemigo de su celda anterior y lo coloca en su nueva Celda
	 * @param c Celda. 
	 * @param dir int.
	 */
    private void actualizar(Celda c, int dir){
    	c.setEnemigo(this);
    	Celda anterior=miCelda;	
		
    	super.avanzar(dir);	

		anterior.setEnemigo(null);
    }
    
    
    /**
	 * Determina que direccion tomar.
	 * @param dir int, direccion a descodificar. 
	 * @return dirr int, direccion a avanzar.
	 */
    protected int determinarDireccion(int dir){
    	int dirr=-1;
    	switch (dir) {
		case 0:
			dirr = Celda.UP;
			break;
		case 1:
			dirr = Celda.RIGHT;
			break;
		case 2:
			dirr = Celda.DOWN;
			break;
		case 3:
			dirr = Celda.LEFT;
			break;
		}
    	
    	return dirr;
    }
    
}