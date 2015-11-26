package GUI;

import java.awt.Color;
import java.awt.Font;
import java.io.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Class Entrada 
 * Almacena 2 tipos de datos, de una manera parecida a un mapeo.
 */

public class Ranking {

	private Entrada[] arr;

	// Constructor
	/**
	 * Crea un nuevo ranking y carga el archivo en el arreglo de entradas
	 */
	public Ranking() {
		arr = new Entrada[5];
		cargarArchivo();
	}

	/**
	 * Crea un nuevo JFrame que muestra el estado actual de la tabla de puntajes.
	 * @return frame JFrame.
	 */
	public JFrame mostrar() {

		JFrame frame = new JFrame("HIGH SCORES");
		frame.setSize(500, 589);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setResizable(false);
		
		JPanel panelSecundario = new JPanel();
		panelSecundario.setBounds(0, 0, 500, 500);
		
		frame.getContentPane().add(panelSecundario);
		
		
		JLabel label1 = new JLabel(arr[0].getKey() + "      "
				+ arr[0].getValue() + "      " +  arr[0].getTiempo());
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setBounds(0, 0, 494, 95);
		label1.setForeground(Color.RED);
		label1.setFont(new Font("Dialog", Font.BOLD, 30));

		JLabel label2 = new JLabel(arr[1].getKey() + "      "
				+ arr[1].getValue() + "      "+  arr[1].getTiempo());
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setBounds(0, 95, 494, 95);
		label2.setForeground(Color.RED);
		label2.setFont(new Font("Dialog", Font.BOLD, 30));

		JLabel label3 = new JLabel(arr[2].getKey() + "      "
				+ arr[2].getValue()+ "      "+  arr[2].getTiempo());
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		label3.setBounds(0, 190, 494, 95);
		label3.setForeground(Color.RED);
		label3.setFont(new Font("Dialog", Font.BOLD, 30));

		JLabel label4 = new JLabel(arr[3].getKey() + "      "
				+ arr[3].getValue()+ "      " +  arr[3].getTiempo());
		label4.setHorizontalAlignment(SwingConstants.CENTER);
		label4.setBounds(0, 285, 494, 95);
		label4.setForeground(Color.RED);
		label4.setFont(new Font("Dialog", Font.BOLD, 30));
		
		JLabel label5 = new JLabel(arr[4].getKey() + "      "
				+ arr[4].getValue()+ "      " +  arr[4].getTiempo());
		label5.setHorizontalAlignment(SwingConstants.CENTER);
		label5.setBounds(0, 380, 494, 95);
		label5.setForeground(Color.RED);
		label5.setFont(new Font("Dialog", Font.BOLD, 30));
		panelSecundario.setLayout(null);
		
		panelSecundario.add(label1);
		panelSecundario.add(label2);
		panelSecundario.add(label3);		
		panelSecundario.add(label4);		
		panelSecundario.add(label5);		
		
		JButton btnNewButton = new JButton("Menu Principal");
		btnNewButton.setBounds(0, 475, 494, 85);
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 28));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				GUIPresentacion nuevo = new GUIPresentacion();
				nuevo.windows.main(new String[0]);
				frame.dispose();
			}
		});
		panelSecundario.add(btnNewButton);
		
		JLabel fondo= new JLabel();
		fondo.setIcon(new ImageIcon(getClass().getResource("/source/Objetos/Ranking4.png")));
		
		frame.getContentPane().add(panelSecundario);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, -12, 494, 582);
		panel.add(fondo);
		
		panelSecundario.add(panel);
		
		frame.setVisible(true);

		return frame;
	}

	/**
	 * Ordena el arreglo de entradas de mayor a menor segun la cantidad de
	 * puntos de cada entrada.
	 */
	private void ordenar() {
		for (int i = 0; i < (arr.length - 1); i++) {
			for (int j = i + 1; j < arr.length; j++) {
				
				if ( (arr[i].getTiempo()).compareTo(arr[j].getTiempo()) > 0  ) {
						Entrada variableauxiliar = arr[i];
						arr[i] = arr[j];
						arr[j] = variableauxiliar;
				}
				else{
					if ( (arr[i].getTiempo()).compareTo(arr[j].getTiempo()) == 0 && arr[i].getValue() < arr[j].getValue()) {
						Entrada variableauxiliar = arr[i];
						arr[i] = arr[j];
						arr[j] = variableauxiliar;
					}
				}
			}
		}
	}

	/**
	 * Sobreescribe el archivos con el contenido del arreglo de entradas
	 */
	private void sobreEscribir() {
		PrintWriter writer;
		try {
			writer = new PrintWriter("rank.txt", "UTF-8");
			
			for(int i=0;i<5;i++){
				writer.println(   arr[i].getKey() + " "
						+ arr[i].getValue()+ " "+arr[i].getTiempo());
			}			
			writer.close();

		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Carga el archivo en el arreglo de entradas
	 */
	private void cargarArchivo() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("rank.txt"));
			String line;
			int i = 0;
			while ((line = br.readLine()) != null) {
				String[] str = line.split(" ");
				Entrada e = new Entrada(str[0],Integer.parseInt(str[1]),str[2]);
				arr[i++] = e;
			}
			br.close();

		} catch (IOException e) {
			PrintWriter writer;
			try {
				writer = new PrintWriter("rank.txt", "UTF-8");
				writer.println("empty 0 99:99:99 ");
				writer.println("empty 0 99:99:99 ");
				writer.println("empty 0 99:99:99 ");
				writer.println("empty 0 99:99:99 ");
				writer.println("empty 0 99:99:99 ");
				writer.close();
				cargarArchivo();
			} catch (FileNotFoundException | UnsupportedEncodingException ex) {
				System.out.println("nope2");
			}
		}
		ordenar();
	}

	/**
	 * Verifica si el puntaje es mayor a alguno de las entradas existentes y lo
	 * inserta.
	 * @param u String. Nombre.
	 * @param puntos int.
	 * @param tiempo String.
	 * 
	 * @return true si inserto o false en caso contrario.
	 */
	public boolean agregarEntrada(String u, int puntos, String tiempo) {
		int indice = -1;
		boolean accion = false;
		for (int i = arr.length - 1; i >= 0; i--) {
			if (!accion && (arr[i].getTiempo()).compareTo(tiempo) > 0 ){
				indice = i;
				accion = true;
				
			}
			if (!accion && (arr[i].getTiempo()).compareTo(tiempo) == 0 ){
				if( arr[i].getValue() < puntos) {
				indice = i;
				accion = true;
				}
			}
		}

		if (indice != -1) {
			Entrada e = new Entrada(u, puntos, tiempo);
			arr[indice] = e;
			ordenar();
		}

		if (accion)
			sobreEscribir();

		return accion;
	}
}