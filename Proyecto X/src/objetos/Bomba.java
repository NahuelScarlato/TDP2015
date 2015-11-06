package objetos;

import grafica.BombaGrafica;
import contenedores.Celda;

/**
 * Representa una bomba.
 * @author Llano Jose, Scarlato Nahuel Hernan; Tecnologia de Programacion 2015.
 */
public class Bomba extends Thread {

    protected int rango;

    protected Celda miCelda;
    
    protected BombaGrafica grafica;
	
    
    /**
	 * Crea una bomba con un rango  y un celda, ambos pasados por parámetro.
	 * Crea e inicializa la grafica de la bomba.
	 * @param r int. 
	 * @param c Celda.
	 */
    public Bomba(int r,Celda c) {
    	rango=r;
    	miCelda=c;
    	grafica=new BombaGrafica(c.getFila(),c.getColumna(),r);
    }
    
    
    /**
	 * Inicia el hilo, lo duerme por 3 segundos y explota la bomba.
	 */
    @Override
	public void run() {
		try {
			Thread.sleep(3000);			
			
			explotar();
		} catch (InterruptedException e) {
			
		}		
	}
    
    

    /**
	 * Explota las celdas de su respectivo rango.
	 * Actualiza marcador y cantidad de bombas del bomberman.	 
	 */
    public void explotar() {
    	
    	Celda[] exp=miCelda.celdasParaExplotar(rango);
        
        int i=0;
        int puntos=0;

        miCelda.setBomba(null);
        
        while(exp[i]!=null){
        	puntos+=exp[i].serExplotada();
        	i++;
        }
        
        miCelda.getMapa().getNivel().getGUI().getFrame().remove(grafica.getGrafico());  
        puntos+=miCelda.serExplotada();
        
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
	 * Modifica celda de la bomba.
	 * @param c Celda. 
	*/
    public void setCelda(Celda c) {
        miCelda=c;
    }
    
    public BombaGrafica getGraficaB(){
    	return grafica;
    }

}