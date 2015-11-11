package threads;

import javax.swing.JLabel;

public class ContadorTiempo extends Thread{
	
	protected int hr;
	protected int min;
	protected int seg;
	
	protected JLabel lblT;
	
	protected volatile boolean seguir;
	
	public ContadorTiempo(JLabel tL){
		hr=min=seg=0;
		seguir=true;
		lblT=tL;
	}
	
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
	
	public void toggleSeguir(){
		seguir=false;
	}
}
