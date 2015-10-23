package GUI;

import java.awt.EventQueue;

import javax.swing.*;

import Nivel.Nivel;
import threads.Juego;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class GUI {
	private JFrame frmProyecto;
	private JLabel fondo;
	
	private volatile boolean lock = false;
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
		frmProyecto.getContentPane().setLayout(null);
		
		frmProyecto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProyecto.setResizable(false);
		frmProyecto.setBounds(20, 20, 936,418);
		frmProyecto.setTitle("Proyecto X");
		frmProyecto.setBackground(Color.GREEN);
				
		fondo = new JLabel();
		fondo.setIcon(new ImageIcon(this.getClass().getResource("/source/fondoBase.png")));
		frmProyecto.setContentPane(fondo);
		fondo.setLayout(null);		
		
		frmProyecto.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				mover(arg0);
			}
		});
		
		frmProyecto.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				ponerBomba(arg0);
			}
		});
		
		// Creo el nivel
		Nivel nivel=new Nivel(this);		
		Juego juego= new Juego(nivel,this);
				
		juego.start();
		
	}
	
	
	public JFrame getFrame(){
		return frmProyecto;
	}
	
	protected void mover(KeyEvent key){
		if(!lock){
			direction = key.getKeyCode();
			lock = true;
		}
	}	
	
	protected void ponerBomba(KeyEvent key){
		if(!lock){
			direction = key.getKeyCode();
			lock = true;
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
