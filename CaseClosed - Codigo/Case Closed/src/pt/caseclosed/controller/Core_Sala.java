package pt.caseclosed.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import javax.swing.JOptionPane;
import pt.caseclosed.model.Sala;

public class Core_Sala {

	public static ArrayList<Sala> Sala = new ArrayList<Sala>();
	private static File SF = new File("Salas.txt");
	private static File TSF = new File("TempSalas.txt");

	// ------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------

	public static void LerSalas() {
		try {
			if (SF.exists() == true) {
				Sala.clear();// Array list limpar
				Scanner inputFile = new Scanner(SF);
				while (inputFile.hasNextLine()) {
					String line = inputFile.nextLine();
					Sala s1 = new Sala(line);
					Sala.add(s1);
				}
				inputFile.close();
				// Sort Array
				Collections.sort(Sala, new Comparator<Sala>() {
					@Override
					public int compare(Sala o1, Sala o2) {
						return o1.getSalas().compareTo(o2.getSalas());
					}
				});
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		if (SF.exists() == false) {
			PrintWriter out = null;
			try {
				out = new PrintWriter(SF);

			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null,
						"O ficheiro de utilizadores estava danificado ou era inexistente, foi criado um novo com o utilizador admin!");
			}
			out.close();
		}
	}

	public static void Write_Salas(String sala) throws IOException {
		if (sala.length() == 3) {
			sala = sala.substring(0, 1) + "0" + sala.substring(1, sala.length());
		}
		if (sala.length() == 2) {
			sala = sala.substring(0, 1) + "00" + sala.substring(1, sala.length());
		}

		Sala s1 = new Sala(sala);
		Sala.add(s1);
		boolean flag = false, flag2 = false;
		Scanner inputFile = new Scanner(SF);
		try {
			while (inputFile.hasNextLine()) {
				flag2 = true;
				String line = inputFile.nextLine();
				if (line.toLowerCase().equals(s1.getSalas().toLowerCase()) == true) {
					flag = true;
				}
			}
			inputFile.close();
			if (flag == true && flag2 == true) {
				JOptionPane.showMessageDialog(null, "A Sala que está a tentar adicionar já se encontra no registo.");
			}
			if (flag == false && flag2 == true) {
				PrintWriter out = new PrintWriter(new FileWriter(SF, true));
				out.println(s1.getSalas());
				if (out != null) {
					out.close();
				}
			}
			if (SF.length() == 0) {
				PrintWriter out = null;
				out = new PrintWriter(new FileWriter(SF, true));
				out.println(s1.getSalas());
				if (out != null) {
					out.close();
				}
			}

		}

		catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null,
					"O ficheiro das Salas estava danificado ou era inexistente, foi criado um novo ficheiro.");
		}
	}

	public static void RemoveSala(String Salatxt) {
		try {
			Scanner inputFile = new Scanner(SF);
			PrintWriter temp = new PrintWriter(TSF);

			while (inputFile.hasNextLine()) {
				String line = inputFile.nextLine();
				if (line.equals(Salatxt) == false) {
					temp.println(line);
				}
			}
			inputFile.close();
			temp.close();
			SF.delete();
			TSF.renameTo(SF);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
