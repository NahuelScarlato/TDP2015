package threads;

import objetos.Bomba;

public class BombaThread extends Thread {
	
	private Bomba mLogica;
		
	public BombaThread(Bomba logica) {
		mLogica  = logica;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(3000);			
			mLogica.explotar();
			interrupt();
		} catch (InterruptedException e) {}		
	}
}

