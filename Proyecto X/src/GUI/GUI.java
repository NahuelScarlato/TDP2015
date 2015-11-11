package GUI;

import java.awt.EventQueue;
import java.awt.Font;
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
	private JLabel textField_Puntaje;
	private JLabel textField_Tiempo;
	private JLabel lblSpe;
	private JLabel lblFat;
	private JLabel lblBom;
	private JLabel lblMasImg;
	private JLabel lblCantParedes;
	
	private int colocar=-1;
	
	
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
		frmProyecto.setBounds(50, 50, 1006,512);
		frmProyecto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProyecto.getContentPane().setLayout(null);
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBounds(0, 0, 1000, 483);
		panelPrincipal.setForeground(Color.BLACK);
		panelPrincipal.setBackground(Color.GRAY);
		frmProyecto.getContentPane().add(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		
		
		JPanel panelUsuario = new JPanel();
		panelUsuario.setBounds(0, 0, 1000, 90);
		panelPrincipal.add(panelUsuario);
		panelUsuario.setLayout(null);
		
		lblCantParedes = new JLabel();
		lblCantParedes.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantParedes.setFont(new Font("Castellar", Font.BOLD, 24));
		lblCantParedes.setForeground(Color.RED);
		lblCantParedes.setBounds(429, 36, 94, 35);
		panelUsuario.add(lblCantParedes);
		
		JLabel lblParedes = new JLabel("Paredes");
		lblParedes.setForeground(Color.MAGENTA);
		lblParedes.setFont(new Font("Castellar", Font.BOLD, 24));
		lblParedes.setBounds(419, 1, 133, 35);
		panelUsuario.add(lblParedes);
		
					
		JLabel lblPuntaje = new JLabel("Puntaje");
		lblPuntaje.setForeground(Color.MAGENTA);
		lblPuntaje.setBounds(114, 0, 145, 35);
		lblPuntaje.setFont(new Font("Castellar", Font.BOLD, 27));
		panelUsuario.add(lblPuntaje);
		
		
		
		JLabel lblTiempo = new JLabel("Tiempo");
		lblTiempo.setForeground(Color.MAGENTA);
		lblTiempo.setBounds(772, 0, 133, 35);
		lblTiempo.setFont(new Font("Castellar", Font.BOLD, 27));
		panelUsuario.add(lblTiempo);
		
		textField_Puntaje = new JLabel();
		textField_Puntaje.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Puntaje.setForeground(new Color(255, 0, 0));
		textField_Puntaje.setFont(new Font("Dialog", Font.PLAIN, 40));
		textField_Puntaje.setText("0");
		textField_Puntaje.setBounds(107, 36, 152, 43);
		
		panelUsuario.add(textField_Puntaje);
		
		textField_Tiempo = new JLabel();
		textField_Tiempo.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Tiempo.setForeground(new Color(255, 0, 0));
		textField_Tiempo.setBounds(749, 34, 180, 49);
		textField_Tiempo.setFont(new Font("Dialog", Font.PLAIN, 40));
		textField_Tiempo.setText(" 00:00:00 ");
		panelUsuario.add(textField_Tiempo);
		
		JLabel labelFondoUsuario = new JLabel("");
		labelFondoUsuario.setBounds(0, 0, 1000, 90);
		labelFondoUsuario.setIcon(new ImageIcon(getClass().getResource("/source/Objetos/fondoPanelUsuario.png")));
		panelUsuario.add(labelFondoUsuario);
		
		JPanel panelPowerUps = new JPanel();
		panelPowerUps.setBackground(new Color(0, 128, 0));
		panelPowerUps.setBounds(929, 90, 71, 392);
		panelPowerUps.setLayout(null);
		
		
	
		lblSpe=new JLabel();
		lblSpe.setText("x0");
		getLblSpe().setForeground(Color.RED);
		getLblSpe().setFont(new Font("Calibri", Font.BOLD, 29));
		getLblSpe().setBounds(15, 5, 46, 36);
		panelPowerUps.add(getLblSpe());
		
		JLabel lblSpeImg = new JLabel("");
		lblSpeImg.setBounds(20, 40, 30, 30);
		lblSpeImg.setIcon(new ImageIcon(getClass().getResource("/source/Objetos/PowerUp/SpeedUp.png")));
		panelPowerUps.add(lblSpeImg);
		
		lblBom=new JLabel();
		lblBom.setText("x0");
		getLblBom().setFont(new Font("Calibri", Font.BOLD, 29));
		getLblBom().setForeground(Color.RED);
		getLblBom().setBounds(15, 142, 46, 36);
		panelPowerUps.add(getLblBom());
		
		JLabel lblBomImg = new JLabel("");
		lblBomImg.setBounds(20, 179, 30, 30);

		lblBomImg.setIcon(new ImageIcon(getClass().getResource("/source/Objetos/PowerUp/Bombality.png")));
		panelPowerUps.add(lblBomImg);
		
		lblFat=new JLabel();
		lblFat.setText("x0");
		getLblFat().setForeground(Color.RED);
		getLblFat().setFont(new Font("Calibri", Font.BOLD, 29));
		getLblFat().setBounds(15, 74, 46, 36);
		panelPowerUps.add(getLblFat());
		
		JLabel lblFatImg = new JLabel("");
		lblFatImg.setBounds(20, 110, 30, 30);

		lblFatImg.setIcon(new ImageIcon(getClass().getResource("/source/Objetos/PowerUp/Fatality.png")));
		panelPowerUps.add(lblFatImg);
		
		setLblMasImg(new JLabel(""));
		getLblMasImg().setBounds(15, 240, 46, 90);
		getLblMasImg().setIcon(new ImageIcon(getClass().getResource("/source/Objetos/imgMas.png")));
		lblMasImg.setVisible(false);
		panelPowerUps.add(getLblMasImg());
		
		
		panelPrincipal.add(panelPowerUps);
		
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
	
	public JLabel getMarcadorGUI(){
		return textField_Puntaje;
	}
	
	public JLabel getMarcadorTiempo(){
		return textField_Tiempo;
	}
	
	public JLabel getLblMasImg() {
		return lblMasImg;
	}

	public void setLblMasImg(JLabel lblMasImg) {
		this.lblMasImg = lblMasImg;
	}

	public JLabel getLblBom() {
		return lblBom;
	}

	public void setLblBom(JLabel lblBom) {
		this.lblBom = lblBom;
	}

	public JLabel getLblFat() {
		return lblFat;
	}

	public void setLblFat(JLabel lblFat) {
		this.lblFat = lblFat;
	}

	public JLabel getLblSpe() {
		return lblSpe;
	}

	public void setLblSpe(JLabel lblSpe) {
		this.lblSpe = lblSpe;
	}
	
	public JLabel getLbllblCantParedes() {
		return lblCantParedes;
	}

	public void setLbllblCantParedes(JLabel lblCantParedes) {
		this.lblCantParedes = lblCantParedes;
	}
}
