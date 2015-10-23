package entidades;



import contenedores.Celda;
import grafica.SiriusGrafica;

/**
 * 
 */
public class Sirius extends Enemigo {

    /**
     * Construye un objeto de tipo Sirius con un puntaje predefinido y con su respectiva celda pasada por parametro.
     * Inicializa su velocidad y su grafico con valores predefinidos.
     * @param c Celda.
     */
    public Sirius(Celda c) {
    	super(50,c);
    	velocidad=1;
    	c.setEnemigo(this);
    	miGrafico=new SiriusGrafica(velocidad,c.getFila(),c.getColumna());
    }

    /**
     * Avanza por el mapa de tal manera que siempre busca alcanzar bomberman.
     */
    public void pensarAvanzar() {
		int dir = -1;

		int xabs = -1;
		int yabs = -1;

		int yactual = miCelda.getFila();
		int xactual = miCelda.getColumna();
		
		Bomberman aux = this.miCelda.getMapa().getNivel().getBomberman();
	    
		if(aux!=null){
			int ybomber=aux.getCelda().getFila();
		    int xbomber=aux.getCelda().getColumna();
			
			xabs = Math.abs(xactual - xbomber);
	
			yabs = Math.abs(yactual - ybomber);
	
			dir=buscarInteligente(xabs,yabs,xbomber,ybomber,xactual,yactual);
		
			super.avanzar(dir);
		}
		
	}
    
    
    /**
	 * Busca el camino mas corto hacia el bomberman.
	 * @param int xabs , diferencia absoluta de las coordenadas X del Sirius y el bomberman. 
	 * @param int yabs, diferencia absoluta de las coordenadas Y del Sirius y el bomberman
	 * @param int xbomber, posicion del bomberman en la coordenada X.
	 * @param int ybomber, posicion del bomberman en la coordenada Y.
	 * @param int xenemigo,posicion del Sirius en la coordenada X.
	 * @param int yenemigo,posicion del Sirius en la coordenada Y.
	 * @return dir int, direccion a avanzar.
	 */
	private int buscarInteligente(int xabs, int yabs, int xbomber, int ybomber, int xenemigo, int yenemigo) {
		Celda moverse = null;
		int dir = -1;

		if (xabs == 0) {
			if (yenemigo < ybomber) {
				dir = 2; // flecha para abajo
			} else
				dir = 0; // flecha arriba
		} else {
			// caso que estan en la misma fila
			if (yabs == 0) {
				if (xenemigo < xbomber) {
					dir = 1; // flecha para derecha
				} else
					dir = 3; // flecha irquierda
			}
		}

		// caso normal
		if (xabs != 0 && yabs != 0) {

			if (xabs <= yabs) {
				if (yenemigo < ybomber) {
					dir = 2; // flecha para derecha
				} else
					dir = 0; // flecha para izquierda
			} else {
				if (xenemigo < xbomber) {
					dir = 1; // flecha para arriba
				} else
					dir = 3; // flecha para abajo
			}

		}

		dir = determinarDireccion(dir);

		moverse = miCelda.celdaParaAvanzar(dir);

		while (moverse == null) {// ojo pared destruible
			
			switch (dir) {
			case Celda.UP:
				dir = Celda.RIGHT;

				break;
			case Celda.LEFT:
				dir = Celda.UP;
				break;
			case Celda.RIGHT:
				dir = Celda.DOWN;
				break;
			case Celda.DOWN:
				dir = Celda.LEFT;
				break;
			}
			moverse = miCelda.celdaParaAvanzar(dir);

		}

		return dir;
	}
}