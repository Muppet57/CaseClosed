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

import pt.caseclosed.model.Utilizador;

public class Core_User {

	// ------------------------------------------------------------------------------
	public static ArrayList<Utilizador> user = new ArrayList<Utilizador>();
	public static ArrayList<Utilizador> userlogged = new ArrayList<Utilizador>();

	// ------------------------------------------------------------------------------
	private static File UF = new File("Users.txt");
	private static File TUF = new File("TempUsers.txt");

	public static void LerUser() {
		try {
			if (UF.exists() == true) {
				user.clear();
				Scanner inputFile = new Scanner(UF);
				while (inputFile.hasNextLine()) {
					String line = inputFile.nextLine();
					String[] parts = line.split("#");
					Utilizador UL = new Utilizador(parts[0], parts[1], parts[2], parts[3], parts[4]);
					user.add(UL);
				}
				inputFile.close();
				Collections.sort(user, new Comparator<Utilizador>() {
					@Override
					public int compare(Utilizador o1, Utilizador o2) {
						return o1.getNome().compareTo(o2.getNome());
					}
				});
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		if (UF.exists() == false) {
			PrintWriter out = null;
			try {
				out = new PrintWriter(UF);

			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null,
						"O ficheiro de utilizadores estava danificado ou era inexistente, foi criado um novo com o utilizador admin!");
			}
			String linha = "Admin#1234#Administrador#Admin@caseclosed.com#Boss";
			out.println(linha);
			out.close();
		}
	}

	public static void RemoveUser(String Usertxt) {
		try {
			Scanner inputFile = new Scanner(UF);
			PrintWriter temp = new PrintWriter(TUF);

			while (inputFile.hasNextLine()) {
				String line = inputFile.nextLine();
				String[] parts = line.split("#");
				String UserName = parts[0];
				if (UserName.equals(Usertxt) == false) {

					temp.println(line);
				}
			}
			inputFile.close();
			temp.close();
			UF.delete();
			TUF.renameTo(UF);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void AddUser(String username, String password, String acesso, String email, String nome)
			throws IOException {
		Utilizador newuser = new Utilizador(username, password, acesso, email, nome);
		user.add(newuser);
		boolean flag = false, flag2 = false;

		Scanner inputFile = new Scanner(UF);
		try {
			while (inputFile.hasNextLine()) {
				flag2 = true;
				String line = inputFile.nextLine();
				String[] parts = line.split("[# ]");
				String part = parts[0];
				if (part.replaceAll(" ", "").toLowerCase()
						.equals(newuser.username.replaceAll(" ", "").toLowerCase()) == true) {

					flag = true;
				}
			}
			inputFile.close();
			if (flag == true && flag2 == true) {
				JOptionPane.showMessageDialog(null, "O user que está a tentar adicionar já se encontra no registo.");
			}
			if (flag == false && flag2 == true) {
				PrintWriter out = new PrintWriter(new FileWriter(UF, true));
				out.println(newuser.username + "#" + newuser.password + "#" + newuser.acesso + "#" + newuser.email + "#"
						+ newuser.nome);
				if (out != null) {
					out.close();
				}
			}
			if (UF.length() == 0) {

				PrintWriter out = null;
				out = new PrintWriter(new FileWriter(UF, true));
				out.println(newuser.username + "#" + newuser.password + "#" + newuser.acesso + "#" + newuser.email + "#"
						+ newuser.nome);
				if (out != null) {
					out.close();
				}
			}
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null,
					"O ficheiro de Utilizadores estava danificado ou era inexistente, foi criado um novo ficheiro.");
		}
	}
}