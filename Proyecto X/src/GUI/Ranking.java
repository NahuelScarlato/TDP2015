package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.*;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Class Entrada
 * 
 * Almacena 2 tipos de datos, de una manera parecida a un mapeo.
 * 
 * @author Peratta,Franco; Piersigilli Joaquín.
 * 
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
	 * Crea un nuevo JFrame que muestra el estado actual de la tabla de puntajes
	 * @wbp.parser.entryPoint
	 */
	public JFrame mostrar() {

		JFrame frame = new JFrame("HIGH SCORES");
		frame.setSize(500, 500);
		frame.setBounds(170, 100, 500, 500);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setResizable(false);

		GridLayout layout = new GridLayout(5, 2);
		frame.getContentPane().setLayout(layout);

		JLabel label1 = new JLabel(arr[0].getKey() + "   "
				+ arr[0].getValue() + "   " +  arr[0].getTiempo());
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setBounds(20, 50, 300, 100);
		label1.setForeground(Color.YELLOW);
		label1.setFont(new Font("Saiyan-Sans", Font.PLAIN, 30));
		label1.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 1));

		JLabel label2 = new JLabel(arr[1].getKey() + "   "
				+ arr[1].getValue() + "   "+  arr[1].getTiempo());
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setBounds(20, 100, 300, 100);
		label2.setForeground(Color.YELLOW);
		label2.setFont(new Font("Saiyan-Sans", Font.PLAIN, 30));
		label2.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 1));

		JLabel label3 = new JLabel(arr[2].getKey() + "   "
				+ arr[2].getValue()+ "   "+  arr[2].getTiempo());
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		label3.setBounds(20, 150, 300, 100);
		label3.setForeground(Color.YELLOW);
		label3.setFont(new Font("Saiyan-Sans", Font.PLAIN, 30));
		label3.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 1));

		JLabel label4 = new JLabel(arr[3].getKey() + "   "
				+ arr[3].getValue()+ "   " +  arr[3].getTiempo());
		label4.setHorizontalAlignment(SwingConstants.CENTER);
		label4.setBounds(20, 300, 300, 100);
		label4.setForeground(Color.YELLOW);
		label4.setFont(new Font("Saiyan-Sans", Font.PLAIN, 30));
		label4.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 1));

		JLabel label5 = new JLabel(arr[4].getKey() + "   "
				+ arr[4].getValue()+ "   " +  arr[4].getTiempo());
		label5.setHorizontalAlignment(SwingConstants.CENTER);
		label5.setBounds(20, 350, 300, 100);
		label5.setForeground(Color.YELLOW);
		label5.setFont(new Font("Saiyan-Sans", Font.PLAIN, 30));
		label5.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 1));

		frame.getContentPane().add(label1);
		frame.getContentPane().add(label2);
		frame.getContentPane().add(label3);
		frame.getContentPane().add(label4);
		frame.getContentPane().add(label5);
		frame.setVisible(true);

		return frame;
	}

	/**
	 * Ordena el arreglo de entradas de mayor a menor segun la cantidad de
	 * puntos de cada entrada
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
			writer.println(   arr[0].getKey() + " "
					+ arr[0].getValue()+ " "+arr[0].getTiempo() );
			writer.println(   arr[1].getKey() + " "
					+ arr[1].getValue()+ " "+arr[1].getTiempo());
			writer.println(   arr[2].getKey() + " "
					+ arr[2].getValue()+ " "+arr[2].getTiempo());
			writer.println(   arr[3].getKey() + " "
					+ arr[3].getValue()+ " "+arr[3].getTiempo());
			writer.println(   arr[4].getKey() + " "
					+ arr[4].getValue()+ " "+arr[4].getTiempo());
			writer.close();

		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
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
	 * 
	 * @return Si inserto o no
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