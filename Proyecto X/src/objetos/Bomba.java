package objetos;

import grafica.BombaGrafica;
import contenedores.Celda;

/**
 * 
 */
public class Bomba extends Thread {

    protected int rango;

    protected Celda miCelda;
	
    
    /**
	 * Crea una bomba con un rango  y un celda, ambos pasados por parámetro.
	 * Crea e inicializa la grafica de la bomba.
	 * @param r int,  rango de la bomba. 
	 * @param c Celda, celda donde se coloca la bomba.
	 */
    public Bomba(int r,Celda c) {
    	rango=r;
    	miCelda=c;
    	c.setCeldaGrafica(new BombaGrafica(c.getFila(),c.getColumna(),r));
    	miCelda.getMapa().getNivel().agregarGrafico(c);
    }
    
    
    /**
	 * 
	*/
    @Override
	public void run() {
		try {
			Thread.sleep(3000);			
			explotar();
		} catch (InterruptedException e) {}		
	}
    
    

    /**
	 * Explota las celdas de su respectivo rango.
	 * Actualiza marcador y cantidad de bombas del bomberman.	 
	 */
    public void explotar() {
        Celda[] exp=miCelda.celdasParaExplotar(rango);
        miCelda.setBomba(null);
        int i=0;
        int puntos=0;
        while(exp[i]!=null){
        	puntos+=exp[i].serExplotada();
        	i++;
        }
        miCelda.getMapa().getNivel().getBomberman().aumentarCantBombas();
        miCelda.getMapa().getNivel().sumarPuntaje(puntos);
    }

    /**
     * Retorna la celda de la bomba.
     * @return miCelda Celda.
     */
    public Celda getCelda() {
        return miCelda;
    }

    /**
	 * Actualiza celda de la bomba.
	 * @param c Celda. 
	*/
    public void setCelda(Celda c) {
        miCelda=c;
    }

}