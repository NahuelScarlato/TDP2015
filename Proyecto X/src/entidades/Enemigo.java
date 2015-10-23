package entidades;

import contenedores.Celda;

/**
 * Representa una Entidad de tipo Enemigo.
 * @author Llano Jose, Scarlato Nahuel Hernan; Tecnologia de Programacion 2015.
 */
public abstract class Enemigo extends Entidad {

    protected int puntaje;

    /**
	 * Crea un enemigo con un puntaje y una celda. Ambos pasados por parametro.
	 * @param p int.
	 * @param c Celda.
	 */
    public Enemigo(int p,Celda c) {
        super(c);
    	puntaje=p;
    }
    
    /**
     * Inicializa el hilo y mueve al enemigo en intervalos de 1 segundo, mientras este vivo.
     */
    @Override
	public void run() {
		while(vivo){
			try {
				Thread.sleep(1000);
				if(vivo)
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
     * Retorna el puntaje de un enemigo.
     * @return puntaje int.
     */
    public int getPuntaje() {
        return puntaje;
    }

    /**
     * Realiza el movimiento del enemigo.
     */
    public abstract void pensarAvanzar();
    
    /**
     * Elimina el enemigo.
     */
    public void morir() {
    	miCelda.setEnemigo(null);
        toggleVivo();
        super.morir();
    }
    
    /**
	 * Mueve al enemigo, si es posible, dependiendo de la direccion pasada por parametro.
	 * @param dir int. 
	 */
    public void avanzar(int dir){
    	Celda proxima = miCelda.celdaParaAvanzar(dir);

		if (proxima != null) {
			if((proxima.getBomba() == null) && (GMod || proxima.getPared() == null)){
				actualizar(proxima,dir);						
				if (proxima.getBomberman() != null && !proxima.getBomberman().getGMod()) 
					proxima.getBomberman().morir();
			}
		}
    }   
    
    
    /**
	 * Elimina el enemigo de su celda anterior y lo coloca en su nueva Celda
	 * @param c Celda. 
	 * @param dir int.
	 */
    private void actualizar(Celda c, int dir){
    	c.setEnemigo(this);
    	miCelda.setEnemigo(null);
		
    	super.avanzar(dir);	
    }
    
    
    /**
	 * Determina que direccion tomar y la retorna.
	 * @param dir int. 
	 * @return dirr int.
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