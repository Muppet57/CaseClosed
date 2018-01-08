package pt.caseclosed.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;
import javax.swing.JOptionPane;
import pt.caseclosed.model.Institui��o;

public class Core_Inst {

	private static int nT = 0;
	public static int contaInst = 1;
	public static ArrayList<Institui��o> InstList = new ArrayList<Institui��o>();
	private static File IF = new File("Institui��es.txt");
	private static File TIF = new File("TempInst.txt");

	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------

	/**
	 * Cria um numero aleatorio de 1-9999 para o codigo das Institui��es Supress
	 * Utilizado para aviso de DeadCode no ciclo for devido a breaks
	 * 
	 * @return
	 */
	@SuppressWarnings("unused")
	public static int random() {
		boolean flag2 = false;
		LerInst();
		Random rnd = new Random();
		String[] parts;
		int[] Atrib = new int[InstList.size()];
		int devolve = 0;
		nT = 9999;
		for (int i = 0; i < InstList.size(); i++) {
			flag2 = true;
			parts = InstList.get(i).getCodigo_IS().toString().split("#");
			Atrib[i] = Integer.parseInt(parts[0]);
		}

		for (int i = 0; i < InstList.size(); i++) {

			boolean flag;
			int numer = rnd.nextInt(nT - 1 + 1) + 1;

			flag = IntStream.of(Atrib).anyMatch(x -> x == numer);
			if (flag == false) {
				devolve = numer;
				break;
			} else {
				flag = IntStream.of(Atrib).anyMatch(x -> x == nT);
				if (flag == false) {

					devolve = nT;
					nT = nT - 1;
					break;
				} else {
					while (flag == true) {
						nT = nT - 1;
						flag = IntStream.of(Atrib).anyMatch(x -> x == nT);
					}
					devolve = nT;
					break;
				}
			}
		}
		if (flag2 == false) {
			return rnd.nextInt(nT - 1 + 1) + 1;
		}
		return devolve;
	}

	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------

	/**
	 * Le ficheiro ou cria ficheiro "Institui��es.txt" se n�o existe.
	 */
	public static void LerInst() {
		try {
			if (IF.exists() == true) {
				InstList.clear();// Array list limpar
				Scanner inputFile = new Scanner(IF);
				while (inputFile.hasNextLine()) {
					String line = inputFile.nextLine();
					String[] parts = line.split("#");
					Institui��o UL = new Institui��o(parts[0], parts[1]);
					InstList.add(UL);
				}
				inputFile.close();
				Collections.sort(InstList, new Comparator<Institui��o>() {
					@Override
					public int compare(Institui��o o1, Institui��o o2) {
						return o1.getNome_IS().compareTo(o2.getNome_IS());
					}
				});
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		if (IF.exists() == false) {
			PrintWriter out = null;
			try {
				out = new PrintWriter(IF);

			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null,
						"O ficheiro de Institui��es estava danificado ou era inexistente, foi criado um novo ficheiro.");
			}
			out.close();
		}
	}

	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------

	/**
	 * Procura Institui��o no Ficheiro Institui��es Remove Institui��o Cria
	 * Ficheiro Temporario onde Guarda todas as Institui��es menos a Inst. a
	 * remover Apaga ficheiro Original Troca nome do Ficheiro Temp. pelo do
	 * Original
	 * 
	 * @param Insttxt
	 */
	public static void RemoveInst(String Insttxt) {
		try {
			Scanner inputFile = new Scanner(IF);
			PrintWriter temp = new PrintWriter(TIF);

			while (inputFile.hasNextLine()) {
				String line = inputFile.nextLine();
				String[] parts = line.split("#");
				String Inst = parts[1];
				if (Inst.equals(Insttxt) == false) {

					temp.println(line);
				}
			}
			inputFile.close();
			temp.close();
			IF.delete();
			TIF.renameTo(IF);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Procura Tipo de Objeto Conforme Institui��o selecionada
	 * 
	 * @param Inst
	 * @return
	 */
	public static boolean ProcuraTipo(String Inst) {
		boolean flag = false;
		Scanner inputFile;
		try {
			inputFile = new Scanner(Core_Objetos.TO);
			while (inputFile.hasNextLine()) {
				String line = inputFile.nextLine();
				String[] parts = line.split("[#]");
				if (parts[2].toString().equals(Inst) == true) {
					flag = true;
				}
			}
			inputFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return flag;
	}

	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------

	/**
	 * Verifica se a Institui��o a adicionar existe. Alerta se j� existe.
	 * Adiciona a Institui��o ao ficheiro Institui��es.txt Cria um ficheiro de
	 * texto com o nome da Institui��o adicionada.
	 * 
	 * @param Codigo_IS
	 * @param Nome_IS
	 * @throws IOException
	 */
	public static void CriaIS(String Codigo_IS, String Nome_IS) throws IOException {
		Institui��o ins = new Institui��o(Codigo_IS, Nome_IS);
		InstList.add(ins);
		contaInst = 1;
		String part = "";
		boolean flag = false, flag2 = false;

		Scanner inputFile = new Scanner(IF);
		try {
			while (inputFile.hasNextLine()) {
				flag2 = true;
				part = "";
				String line = inputFile.nextLine();
				String[] parts = line.split("[# ]");
				for (int i = 1; i < parts.length; i++) {
					part = part + parts[i] + " ";
				}

				if (part.replaceAll(" ", "").toLowerCase()
						.equals(ins.getNome_IS().replaceAll(" ", "").toLowerCase()) == true) {

					flag = true;
				}
			}
			inputFile.close();
			if (flag == true && flag2 == true) {
				JOptionPane.showMessageDialog(null,
						"A institui��o que est� a tentar adicionar j� se encontra no registo.");
			}
			if (flag == false && flag2 == true) {
				if (Integer.parseInt(ins.getCodigo_IS()) > 0) {
					PrintWriter instF = new PrintWriter(ins.getNome_IS() + ".txt");
					instF.close();
					PrintWriter out = new PrintWriter(new FileWriter(IF, true));
					out.println(ins.getCodigo_IS() + "#" + ins.getNome_IS());
					if (out != null) {
						out.close();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Atingiu o Maximo de Institui��es");
				}
			}
			if (IF.length() == 0) {
				if (Integer.parseInt(ins.getCodigo_IS()) > 0) {
					PrintWriter instF = new PrintWriter(ins.getNome_IS() + ".txt");
					instF.close();
					PrintWriter out = null;
					out = new PrintWriter(new FileWriter(IF, true));
					out.println(ins.getCodigo_IS() + "#" + ins.getNome_IS());
					if (out != null) {
						out.close();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Atingiu o Maximo de Institui��es");
				}
			}
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null,
					"O ficheiro de Institui��es estava danificado ou era inexistente, foi criado um novo ficheiro.");
		}
	}
	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------
}
