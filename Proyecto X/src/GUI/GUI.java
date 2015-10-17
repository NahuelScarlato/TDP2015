package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;

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
		frmProyecto = new JFrame();
		frmProyecto.setTitle("Proyecto X");
		frmProyecto.setResizable(false);
		frmProyecto.setBounds(640, 640, 640, 640);
		frmProyecto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProyecto.getContentPane().setLayout(null);
	}
}
