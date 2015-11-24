package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GUIPresentacion {

	private JFrame frame;
	private JTextField txtUser;
	
	private Ranking ranking;
	private String nombre;
	static GUIPresentacion windows;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					windows = new GUIPresentacion();
					windows.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	/**
	 * Create the application.
	 */
	public GUIPresentacion() {
		initialize();
		frame.dispose();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		ranking= new Ranking();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 601, 272);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBounds(0, 0, 1000, 483);
		panelPrincipal.setForeground(Color.BLACK);
		panelPrincipal.setBackground(new Color(0, 153, 204));
		frame.getContentPane().add(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		JButton btnComenzar = new JButton("Comenzar");
		btnComenzar.setVisible(false);
		btnComenzar.setOpaque(false);
		btnComenzar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GUI window = new GUI(nombre,windows);
				frame.setVisible(false);
			}
		});
		
		txtUser = new JTextField();
		txtUser.setHorizontalAlignment(SwingConstants.CENTER);
		txtUser.setText("user");
		txtUser.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtUser.setBounds(418, 26, 167, 42);
		panelPrincipal.add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblIngreseNombre = new JLabel("Ingrese nombre:");
		lblIngreseNombre.setForeground(new Color(255, 255, 255));
		lblIngreseNombre.setFont(new Font("Arial", Font.BOLD, 18));
		lblIngreseNombre.setBounds(426, 0, 159, 28);
		panelPrincipal.add(lblIngreseNombre);
		btnComenzar.setForeground(new Color(255, 255, 255));
		btnComenzar.setBackground(Color.WHITE);
		btnComenzar.setFont(new Font("Arial", Font.PLAIN, 25));
		btnComenzar.setBounds(418, 153, 165, 37);
		panelPrincipal.add(btnComenzar);
		
		JLabel labelFondo = new JLabel("");
		labelFondo.setBounds(0, 0, 420, 238);
		labelFondo.setIcon(new ImageIcon(getClass().getResource("/source/Objetos/FondoPresentacion.png")));
		panelPrincipal.add(labelFondo);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				nombre=txtUser.getText();
				nombre.trim();
				btnComenzar.setVisible(true);
			}
		});
		btnConfirmar.setBounds(452, 71, 104, 28);
		panelPrincipal.add(btnConfirmar);
		
		JButton btnRanking = new JButton("Ranking");
		btnRanking.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mostrarRanking();
				frame.dispose();
			}
		});
		btnRanking.setBackground(Color.WHITE);
		btnRanking.setOpaque(false);
		btnRanking.setForeground(Color.WHITE);
		btnRanking.setFont(new Font("Arial", Font.PLAIN, 25));
		btnRanking.setBounds(418, 197, 167, 35);
		panelPrincipal.add(btnRanking);
		
		JButton btnControles = new JButton("Controles");
		btnControles.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mostrarAyuda();
				frame.dispose();
			}
		});
		btnControles.setBackground(Color.WHITE);
		btnControles.setOpaque(false);
		btnControles.setForeground(Color.WHITE);
		btnControles.setFont(new Font("Arial", Font.PLAIN, 25));
		btnControles.setBounds(418, 110, 167, 37);
		panelPrincipal.add(btnControles);
		
		
		JButton btnNewButton = new JButton("Comenzar");
		btnNewButton.setBounds(183, 127, 89, 23);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				GUI gui=new GUI(nombre,windows);
			}
		});
		
		
		
	}

	public void mostrarRanking() {
		ranking.mostrar();
		
	}
	
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public Ranking getRanking() {
		return ranking;
	}



	public void setRanking(Ranking ranking) {
		this.ranking = ranking;
	}
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void mostrarAyuda() {
		JFrame frame = new JFrame("HIGH SCORES");
		frame.setBounds(170, 100, 611, 500);
		frame.getContentPane().setBackground(Color.BLACK);
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBounds(0, 0, 1000, 483);
		panelPrincipal.setForeground(Color.BLACK);
		panelPrincipal.setBackground(new Color(0, 153, 204));
		frame.getContentPane().add(panelPrincipal);
		panelPrincipal.setLayout(null);

		JLabel label1 = new JLabel();
		label1.setBounds(0, -41, 692, 402);
		label1.setIcon(new ImageIcon(getClass().getResource(
				"/source/Objetos/fondoManual.png")));
		label1.setForeground(Color.YELLOW);
		label1.setFont(new Font("Saiyan-Sans", Font.PLAIN, 30));
		label1.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 1));

		panelPrincipal.add(label1);
		
		JButton btnNewButton_1 = new JButton("Menu Principal");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				GUIPresentacion nuevo = new GUIPresentacion();
				nuevo.windows.main(new String[0]);
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnNewButton_1.setBounds(0, 360, 595, 101);
		JButton btnNewButton = new JButton("Menu Principal");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 28));
		btnNewButton.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 1));
		
		
		panelPrincipal.add(btnNewButton_1);

		frame.setVisible(true);
		
	}
}
