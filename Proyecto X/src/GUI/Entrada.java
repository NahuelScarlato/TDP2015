/**
 * 
 */
package GUI;


/**
 * Representa un contenedor para componentes de puntajes.
 * @author Llano Jose, Scarlato Nahuel Hernan; Tecnologia de Programacion 2015.
 */
public class Entrada{
	private String clave;
	private int valor;
	private String tiempo;
	
	/**
     * Construye una entrada,con su respectivo nombre,puntaje y tiempo de juego.
     * @param clave String.
     * @param valor int.
     * @param tiempo String.
     */
	public Entrada(String clave, int valor , String tiempo) {
		this.clave = clave;
		this.valor = valor;
		this.tiempo=tiempo;
	}
	
	 /**
     * Retorna la clave de la entrada.
     * @return clave String.
     */
	public String getKey(){
		return clave;
	}
	
	 /**
     * Retorna el valor de la entrada.
     * @return valor int.
     */
	public int getValue(){
		return valor;
	}
	
	/**
     * Modifica la clave con una clave pasada por parametro.
     * @param k String.
     */
	public void setKey(String k){
		clave=k;
	}
	
	/**
     * Modifica el valor con un valor pasado por parametro.
     * @param v int..
     */
	public void setValue(int v){
		valor=v;
	}
	
	 /**
     * Retorna el tiempo de la entrada.
     * @return tiempo String.
     */
	public String getTiempo() {
		return tiempo;
	}
	
	/**
     * Modifica el tiempo con un tiempo pasado por parametro.
     * @param tiempo String.
     */
	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}
}

