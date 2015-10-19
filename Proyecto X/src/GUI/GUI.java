package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;

import Nivel.Nivel;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;





public class GUI {
	private JFrame frmProyecto;

	private boolean lock = false;
	private int direction = -1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frmProyecto.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		
		frmProyecto = new JFrame();
		frmProyecto.getContentPane().setBackground(Color.WHITE);
		frmProyecto.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 0));
		panel.setBounds(0, 0, 450, 346);
		frmProyecto.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		frmProyecto.setTitle("Proyecto X");
		frmProyecto.setResizable(false);
		frmProyecto.setBounds(40, 40, 454, 373);
		frmProyecto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frmProyecto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				mover(arg0);
			}
		});
		/*
		// creo el nivel
		Nivel nivel=new Nivel();
		Hilo hilo= new Hilo(nivel,this);
		hilo.start();*/
		
		
	}
	
	
	
	
	protected void mover(KeyEvent key){
		if(!lock){
			direction = key.getKeyCode();
			this.lock = true;
		}
	}
	
	
	public boolean getLock(){
		return this.lock;
	}
	
	public void toggleLock(){
		this.lock = !this.lock;
	}
	
	public int getDirection(){
		return this.direction;
	}
}
