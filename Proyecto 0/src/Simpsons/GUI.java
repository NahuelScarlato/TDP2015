package Simpsons;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class GUI {

	private JFrame frmProyecto;

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
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProyecto = new JFrame();
		frmProyecto.setTitle("Proyecto0");
		frmProyecto.setResizable(false);
		frmProyecto.setBounds(100, 100, 536, 431);
		frmProyecto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProyecto.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 533, 418);
		frmProyecto.getContentPane().add(panel);
		panel.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textPane.setOpaque(false);
		textPane.setBounds(17, 324, 506, 79);
		panel.add(textPane);
		textPane.setText("No soy un hombre de plegarias, pero si estas en el cielo, salvame por favor superman");
		textPane.setVisible(false);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setBounds(0, 0, 538, 403);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("homero.PNG"));		
		
		JButton btnHablar = new JButton("Hablar");
		btnHablar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnHablar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setIcon(new ImageIcon("cuadro.PNG"));
				textPane.setVisible(true);
				btnHablar.setVisible(false);
				
			}
		});
		btnHablar.setBounds(10, 198, 94, 48);
		panel.add(btnHablar);		
		
		
		
	}
}
