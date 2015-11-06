package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.TextField;

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
	private JLayeredPane panelJuego;
	private TextField textField_Puntaje;
	
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
		frmProyecto.setResizable(false);
		frmProyecto.setTitle("Proyecto X");
		frmProyecto.getContentPane().setBackground(Color.GREEN);
		frmProyecto.setBounds(50, 50, 936,512);
		frmProyecto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProyecto.getContentPane().setLayout(null);
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBounds(0, 0, 930, 483);
		panelPrincipal.setForeground(Color.BLACK);
		panelPrincipal.setBackground(Color.GRAY);
		frmProyecto.getContentPane().add(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		
		
		JPanel panelUsuario = new JPanel();
		panelUsuario.setBounds(0, 0, 930, 90);
		panelPrincipal.add(panelUsuario);
		panelUsuario.setLayout(null);
			
		JLabel lblPuntaje = new JLabel("Puntaje :");
		lblPuntaje.setBounds(39, 11, 123, 49);
		lblPuntaje.setFont(new Font("Arial", Font.PLAIN, 30));
		panelUsuario.add(lblPuntaje);
		
		
		
		JLabel lblTiempo = new JLabel("Tiempo :");
		lblTiempo.setBounds(575, 11, 116, 49);
		lblTiempo.setFont(new Font("Arial", Font.PLAIN, 30));
		panelUsuario.add(lblTiempo);
		
		textField_Puntaje = new TextField();
		textField_Puntaje.setEnabled(false);
		textField_Puntaje.setForeground(Color.RED);
		textField_Puntaje.setEditable(false);
		textField_Puntaje.setLocation(new Point(10, 10));
		textField_Puntaje.setFont(new Font("Dialog", Font.PLAIN, 30));
		textField_Puntaje.setText(" 0");
		textField_Puntaje.setBounds(168, 11, 116, 49);
		
		panelUsuario.add(textField_Puntaje);
		
		TextField textField_3 = new TextField();
		textField_3.setBounds(697, 11, 116, 49);
		textField_3.setEnabled(false);
		textField_3.setEditable(false);
		panelUsuario.add(textField_3);
		
		panelJuego = new JLayeredPane();
		panelJuego.setOpaque(false);
		panelJuego.setBounds(0, 91, 930,391);
		panelJuego.setBackground(new Color(34, 139, 34));
		panelJuego.setLayout(null);
		panelPrincipal.add(panelJuego);
		
		
		
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
	public JLayeredPane getFrame(){
		return panelJuego;
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
	
	public TextField getMarcadorGUI(){
		return textField_Puntaje;
	}
}
