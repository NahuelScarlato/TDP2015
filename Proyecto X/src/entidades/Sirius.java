package entidades;



import contenedores.Celda;
import grafica.SiriusGrafica;

/**
 * 
 */
public class Sirius extends Enemigo {

    /**
     * Default constructor
     */
    public Sirius(Celda c) {
    	super(50,c);
    	velocidad=1;
    	c.setEnemigo(this);
    	miGrafico=new SiriusGrafica(velocidad,c.getFila(),c.getColumna());
    }

    /**
     * @param dir
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
	
			System.out.println();
			System.out.println("enemigo");
			System.out.println("x: "+xactual + "  y: " + yactual);
			System.out.println("del bomberman");
			System.out.println("x: "+aux.miCelda.getFila() + "  y : "+ aux.miCelda.getColumna());


			dir=buscarInteligente(xabs,yabs,xbomber,ybomber,xactual,yactual);
		
			super.avanzar(dir);
		}
		
	}
    
	private int buscarInteligente(int xabs, int yabs, int xbomber, int ybomber, int xenemigo, int yenemigo){
		Celda moverse=null;
		int dir=-1;
		
		
			
			if (xabs == 0) {
				if (yenemigo < ybomber) {
					dir = 2; // flecha para abajo
				} else
					dir = 0; // flecha arriba
			} 
			else {
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
			}
			else {
				if (xenemigo < xbomber) {
					dir = 1; // flecha para arriba
				} else
					dir = 3; // flecha para abajo
			}

		}
			
			dir=determinarDireccion(dir);
			
			moverse=miCelda.celdaParaAvanzar(dir);
			System.out.println("moverse es null? "+(moverse==null));
			
			while (moverse == null  ) {// ojo pared destruible
					System.out.println("entro while sirius");
					
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
					
					System.out.println("entro al down");
					break;
				}
				moverse=miCelda.celdaParaAvanzar(dir);
				
			}
		
		
	return dir;	
	}
}