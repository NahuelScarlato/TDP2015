package threads;

import javax.swing.JLabel;

/**
 * Esta clase crea un hilo que representa un contador de tiempo con precision de segundos.
 * @author Llano Jose, Scarlato Nahuel Hernan; Tecnologia de Programacion 2015.
 */
public class ContadorTiempo extends Thread{
	
	protected int hr;
	protected int min;
	protected int seg;
	
	protected JLabel lblT;
	
	protected volatile boolean seguir;
	
	/**
	 * Constructor de contador. Inicializa horas, minutos y segundos en 0, y guarda una referencia al label argumento.
	 * @param tL JLabel.
	 */
	public ContadorTiempo(JLabel tL){
		hr=min=seg=0;
		seguir=true;
		lblT=tL;
	}
	
	/**
	 * Inicia un hilo para representar el tiempo modificando el label atributo cada segundo.
	 */
	public void run(){
		try {
			
			String hora=""+hr;
			String minut=""+min;
			String segun=""+seg;
			
			while(seguir){
			
				sleep(1000);			
				seg++;
				if(seg>59){
					seg=0;
					min++;
				}
				if(min>59){
					min=0;
					hr++;
				}
				
				if(seg<10)
					segun="0"+seg;
				else
					segun=""+seg;
				
				if(min<10)
					minut="0"+min;
				else
					minut=""+min;
				
				if(hr<10)
					hora="0"+hr;
				else
					hora=""+hr;
				
				lblT.setText(hora+":"+minut+":"+segun);
			}
		} catch (InterruptedException e) {				
			e.printStackTrace();
		}
	}
	
	/*
	 * Cambia el valor de seguir por falso.
	 */	
	public void toggleSeguir(){
		seguir=false;
	}
}
