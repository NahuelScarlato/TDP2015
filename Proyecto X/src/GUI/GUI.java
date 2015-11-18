package GUI;

import java.awt.Font;

import javax.swing.*;

import Nivel.Nivel;
import threads.ContadorTiempo;
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
	
	protected ContadorTiempo cT;

	private String nombre;

	private GUIPresentacion guiPresentacion;
	
	private volatile boolean lockColoc = false;
	private int colocar=-1;
	
	private volatile boolean lock = false;
	private int direction = -1;
	private JPanel panelUsuario;
	
	/**
	 * Crea la aplicacion.
	 */
public GUI(String nom, GUIPresentacion pres) {
		
		nombre=nom;
		guiPresentacion = pres;
	 
		//Frame principal
		frmProyecto = new JFrame();
		frmProyecto.setResizable(false);
		frmProyecto.setSize(999, 566);
		frmProyecto.setLocationRelativeTo(null);		
		frmProyecto.setVisible(true);		
		frmProyecto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProyecto.getContentPane().setLayout(null);
		
		//Panel principal
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBounds(0, 0, 1049, 541);
		panelPrincipal.setLayout(null);
		frmProyecto.getContentPane().add(panelPrincipal);
		
		//Panel usuario	
		panelUsuario = new JPanel();
		panelUsuario.setBounds(0, 0, 1000, 122);
		panelUsuario.setLayout(null);
		panelPrincipal.add(panelUsuario);
		
		//Labels del panel usuario
		setLblMasImg(new JLabel());
		getLblMasImg().setIcon(new ImageIcon(getClass().getResource("/source/Objetos/imgMas.png")));
		lblMasImg.setVisible(false);
		
		lblSpe=new JLabel();
		lblSpe.setBounds(162, 86, 46, 36);
		panelUsuario.add(lblSpe);
		lblSpe.setText("x0");
		getLblSpe().setForeground(Color.RED);
		getLblSpe().setFont(new Font("Calibri", Font.BOLD, 29));
		
		lblBom=new JLabel();
		lblBom.setBounds(275, 86, 46, 36);		
		lblBom.setText("x0");
		lblBom.setFont(new Font("Calibri", Font.BOLD, 29));
		lblBom.setForeground(Color.RED);
		panelUsuario.add(lblBom);
		
		lblFat=new JLabel();
		lblFat.setBounds(219, 86, 46, 36);
		lblFat.setText("x0");
		lblFat.setForeground(Color.RED);
		lblFat.setFont(new Font("Calibri", Font.BOLD, 29));
		panelUsuario.add(lblFat);
		
		
		JLabel lblBomImg = new JLabel();
		lblBomImg.setBounds(275, 56, 32, 32);
		panelUsuario.add(lblBomImg);
		lblBomImg.setIcon(new ImageIcon(getClass().getResource("/source/Objetos/PowerUp/Bombality.png")));
		
		JLabel lblFatImg = new JLabel("");
		lblFatImg.setBounds(219, 56, 32, 32);
		panelUsuario.add(lblFatImg);
		lblFatImg.setIcon(new ImageIcon(getClass().getResource("/source/Objetos/PowerUp/Fatality.png")));
		
		JLabel lblSpeImg = new JLabel("");
		lblSpeImg.setBounds(162, 56, 32, 32);
		panelUsuario.add(lblSpeImg);
		lblSpeImg.setIcon(new ImageIcon(getClass().getResource("/source/Objetos/PowerUp/SpeedUp.png")));
		
		
		JLabel labelCPared = new JLabel();
		labelCPared.setHorizontalAlignment(SwingConstants.CENTER);
		labelCPared.setBounds(512, 10, 32, 32);
		labelCPared.setIcon(new ImageIcon(getClass().getResource("/source/Objetos/ParedDestruible.png")));
		panelUsuario.add(labelCPared);
		
		lblCantParedes = new JLabel();
		lblCantParedes.setFont(new Font("Century Gothic", Font.BOLD, 32));
		lblCantParedes.setForeground(Color.RED);
		lblCantParedes.setBounds(500, 50, 74, 61);
		panelUsuario.add(lblCantParedes);
		
					
		JLabel lblPuntaje = new JLabel("Puntaje");
		lblPuntaje.setForeground(Color.DARK_GRAY);
		lblPuntaje.setBounds(60, 10, 145, 35);
		lblPuntaje.setFont(new Font("Castellar", Font.BOLD, 26));
		panelUsuario.add(lblPuntaje);
			
		textField_Puntaje = new JLabel();
		textField_Puntaje.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Puntaje.setForeground(new Color(255, 0, 0));
		textField_Puntaje.setFont(new Font("Century Gothic", Font.BOLD, 28));
		textField_Puntaje.setText("0");
		textField_Puntaje.setBounds(178, 3, 152, 43);		
		panelUsuario.add(textField_Puntaje);
		
		
		JLabel lblTiempo = new JLabel("Tiempo");
		lblTiempo.setForeground(Color.DARK_GRAY);
		lblTiempo.setBounds(685, 10, 133, 35);
		lblTiempo.setFont(new Font("Castellar", Font.BOLD, 26));
		panelUsuario.add(lblTiempo);
					
		textField_Tiempo = new JLabel();
		textField_Tiempo.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Tiempo.setForeground(new Color(255, 0, 0));
		textField_Tiempo.setBounds(793, 0, 180, 49);
		textField_Tiempo.setFont(new Font("Century Gothic", Font.BOLD, 28));
		textField_Tiempo.setText(" 00:00:00 ");
		panelUsuario.add(textField_Tiempo);
		
		JLabel labelFondoUsuario = new JLabel();
		labelFondoUsuario.setBounds(0, 0, 1031, 122);
		labelFondoUsuario.setIcon(new ImageIcon(getClass().getResource("/source/FondoUsuario.png")));
		panelUsuario.add(labelFondoUsuario);
		
		panelJuego = new JLayeredPane();
		panelJuego.setOpaque(false);
		panelJuego.setBounds(0, 123, 996,417);
		panelJuego.setBackground(new Color(34, 139, 34));
		panelJuego.setLayout(null);
		panelPrincipal.add(panelJuego);		
		
		frmProyecto.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				mover(arg0);
			}
			@Override
			public void keyReleased(KeyEvent e) {
				ponerBomba(e);
			}
			
		});	
		
				
		// Creo el nivel
		Nivel nivel=new Nivel(this);
		
		Juego juego= new Juego(nivel,this);
				
		cT=new ContadorTiempo(textField_Tiempo);	
				
		juego.start();
		
		cT.start();
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
	
	protected void ponerBomba(KeyEvent key){
		if(!lockColoc){
			colocar = key.getKeyCode();
			lockColoc = true;
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
	
	public int getColocar(){
		return this.colocar;
	}
	
	public boolean getLockColoc() {
		return lockColoc;
	}
	
	public void toggleLockColoc() {
		this.lockColoc = !this.lockColoc;
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
	
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public ContadorTiempo getcT() {
		return cT;
	}
	
	
	
	public void mostrarRanking() {
		guiPresentacion.getRanking().mostrar();
		
	}
	
	public GUIPresentacion getGuiPresentacion() {
		return guiPresentacion;
	}
	
	public void setGuiPresentacion(GUIPresentacion guiPresentacion) {
		this.guiPresentacion = guiPresentacion;
	}
}