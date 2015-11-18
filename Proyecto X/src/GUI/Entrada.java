/**
 * 
 */
package GUI;


/**
 * @author 
 *
 */
public class Entrada{
	private String clave;
	private int valor;
	private String tiempo;
	
	public Entrada(String clave, int valor , String tiempo) {
		this.clave = clave;
		this.valor = valor;
		this.tiempo=tiempo;
	}
	public String getKey(){
		return clave;
	}
	public int getValue(){
		return valor;
	}
	public void setKey(String k){
		clave=k;
	}
	public void setValue(int v){
		valor=v;
	}
	public String getTiempo() {
		return tiempo;
	}
	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}
}

