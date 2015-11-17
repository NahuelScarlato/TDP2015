package GUI;

import java.awt.Color;
import java.awt.EventQueue;
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
	private String nombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIPresentacion windows = new GUIPresentacion();
					windows.frame.setVisible(true);
					//GUI window = new GUI();
					
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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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
				GUI window = new GUI(nombre);
				frame.setVisible(false);
			}
		});
		
		txtUser = new JTextField();
		txtUser.setHorizontalAlignment(SwingConstants.CENTER);
		txtUser.setText("\"user\"");
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
		btnComenzar.setBounds(420, 139, 165, 37);
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
				btnComenzar.setVisible(true);
			}
		});
		btnConfirmar.setBounds(452, 71, 104, 28);
		panelPrincipal.add(btnConfirmar);
		
		JButton btnNewButton = new JButton("Comenzar");
		btnNewButton.setBounds(183, 127, 89, 23);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				GUI gui=new GUI(nombre);
			}
		});
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
