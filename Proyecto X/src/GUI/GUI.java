package GUI;

import java.awt.EventQueue;

import javax.swing.*;

import Nivel.Nivel;
import threads.Juego;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Interefaz grafica del usuario.
 * @author Llano Jose, Scarlato Nahuel Hernan; Tecnologia de Programacion 2015.
 */
public class GUI {
	private JFrame frmProyecto;
	private JLabel fondo;
	
	private volatile boolean lock = false;
	private int direction = -1;
	
	/**
	 * Comienzo de la aplicacion.
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
	 * Crea la aplicacion.
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
			public void keyPressed(KeyEvent arg0) {
				mover(arg0);
			}
		});
		
		
		// Creo el nivel
		Nivel nivel=new Nivel(this);		
		Juego juego= new Juego(nivel,this);
				
		juego.start();
		
	}
	
	/**
	 * Retorna el frame.
	 * @return frmProyecto JLabel.
	 */
	public JFrame getFrame(){
		return frmProyecto;
	}
	
	/**
	 * Modifica el atributo direccion segun lock.
	 * @param key KeyEvent.
	 */
	protected void mover(KeyEvent key){
		if(!lock){
			direction = key.getKeyCode();
			lock = true;
		}
	}	
	
	/**
	 * Retorna el atributo lock.
	 * @return lock boolean.
	 */
	public boolean getLock(){
		return this.lock;
	}
	
	/**
	 * Cambia el estado del atributo lock por su negacion.
	 */
	public void toggleLock(){
		this.lock = !this.lock;
	}
	
	/**
	 * Retorna el atributo direction.
	 * @return direction int.
	 */
	public int getDirection(){
		return this.direction;
	}
}
