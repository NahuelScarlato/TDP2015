package entidades;

import objetos.Bomba;
import objetos.PowerUp;
import contenedores.Celda;
import grafica.BombermanGrafica;

/**
 * Representa una Entidad de tipo Bomberman.
 * @author Llano Jose, Scarlato Nahuel Hernan; Tecnologia de Programacion 2015.
 */
public class Bomberman extends Entidad {

    protected int cantBombas;

    protected int rangoBombas;
    
    /**
     * Construye un bomberman con velocidad, cantidad de bombas y rango de bombas con sus valores predefinidos.
     * Inicializa su celda con una celda c, pasada por parametro y crea la grafica apropiada. 
     * @param c Celda.
     */
    public Bomberman(Celda c) {
    	super(c);
    	velocidad=1;
    	cantBombas=1;
    	rangoBombas=1;
    	miGrafico=new BombermanGrafica(c.getFila(),c.getColumna());
    }
    
    /**
     * Mueve al bomberman, si es posible, dependiendo de la direccion pasada por parametro.
     * @param dir int.
     */
	public void avanzar(int dir) {
		Celda proxima = miCelda.celdaParaAvanzar(dir);

		if (proxima != null) {
			
			if ((proxima.getBomba() == null) && (GMod || proxima.getPared() == null)) {
				proxima.setBomberman(this);
				miCelda.setBomberman(null);
				
				super.avanzar(dir);
				
				if (proxima.getEnemigo() != null && !GMod) {
					morir();				
				} 
				else {
					PowerUp pu = proxima.getPowerUp();
					if (pu != null) {
						pu.activar(this);
						proxima.setPowerUp(null);						
					}
				}

			}
		}
	}

    /**
    * Crea una bomba y la setea en la celda actual.
    */
    public void ponerBomba() {
        if(cantBombas>0 || GMod){
        	Bomba b=new Bomba(rangoBombas,miCelda);
        	miCelda.setBomba(b);
        	miCelda.getMapa().getNivel().agregarBombaGrafico(b);
        	b.start();
        	cantBombas--;
        }
    }
    
      
    /**
     * Aumenta en 1 la velocidad del bomberman.
     */
    public void aumentarVelocidad() {
        velocidad*=2;
    }

    /**
     * Devuelve la cantidad actual de bombas del bomberman.
     * @return cantBombas int.
     */
    public int getCantBombas() {
        return cantBombas;
    }

    /**
     * Aumenta la cantidad de bombas en 1.
     */
    public void aumentarCantBombas() {
        cantBombas++;
    }
    
    /**
     * Retorna el rango de explosion de una bomba.
     * @return rangoBombas int.
     */
    public int getRangoBombas() {
        return rangoBombas;
    }

    /**
     * Duplica el atributo rangoBombas.
     */
    public void aumentarRangoBombas() {
        rangoBombas*=2;
    }

    /**
     * Elimina el bomberman.
     */
    public void morir() {
        miCelda.setBomberman(null);
        toggleVivo();
        super.morir(this);
    }

}