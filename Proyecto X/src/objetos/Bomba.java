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
     * Default constructor
     */
    public Bomba(int r,Celda c) {
    	rango=r;
    	miCelda=c;
    	c.setCeldaGrafica(new BombaGrafica(c.getFila(),c.getColumna()));
    	miCelda.getMapa().getNivel().agregarGrafico(c);
    }
    
    @Override
	public void run() {
		try {
			Thread.sleep(3000);			
			explotar();
		} catch (InterruptedException e) {}		
	}
    
    /**
     * 
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
     * @return
     */
    public Celda getCelda() {
        return miCelda;
    }

    /**
     * @param c
     */
    public void setCelda(Celda c) {
        miCelda=c;
    }

}