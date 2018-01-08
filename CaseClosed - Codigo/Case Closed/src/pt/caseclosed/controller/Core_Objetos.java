package pt.caseclosed.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;
import javax.swing.JOptionPane;
import pt.caseclosed.model.Registo_Objeto;
import pt.caseclosed.model.Tipo_Objeto;

public class Core_Objetos {

	private static int nT = 0;
	public static ArrayList<Registo_Objeto> newObjAdmin = new ArrayList<Registo_Objeto>();
	public static ArrayList<Registo_Objeto> newObjSeg = new ArrayList<Registo_Objeto>();
	public static ArrayList<Registo_Objeto> newObjDoa = new ArrayList<Registo_Objeto>();
	public static ArrayList<Tipo_Objeto> TipoObj = new ArrayList<Tipo_Objeto>();

	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------

	public static final String Date1 = "MM-yyyy";
	public static final String Date2 = "dd-MM-yyyy";
	public static final String Hour = "HH:mm";
	public static final String Hour2 = "HH:mm:ss";

	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------

	private static File OF = new File(date() + ".txt");
	private static File TOF = new File("Temp" + date() + ".txt");
	public static File TO = new File("Tipo Objetos.txt");
	public static File DOA = new File("Doações.txt");
	private static File TTO = new File("Temp Tipo.txt");

	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------
	/**
	 * Hora para Registo
	 * 
	 * @return
	 */
	public static String hour() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(Hour);
		return sdf.format(cal.getTime());
	}

	/**
	 * Hora para display
	 * 
	 * @return
	 */
	public static String hour2() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(Hour2);
		return sdf.format(cal.getTime());
	}

	/**
	 * Data para Registo
	 * 
	 * @return
	 */
	public static String date() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(Date1);
		return sdf.format(cal.getTime());
	}

	/**
	 * Data para Display
	 * 
	 * @return
	 */
	public static String date2() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(Date2);
		return sdf.format(cal.getTime());
	}

	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------
	// ++++++++++++++++++++++++++++++++++++++++ REGISTOS
	// ++++++++++++++++++++++++++++++++++++++++++++++
	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------

	/**
	 * Cria Codigo de Registo para o Registo de Objetos Codigo Gerado
	 * Aleatoriamente de 1 a 9999
	 * 
	 * @return
	 */
	@SuppressWarnings("unused")
	public static int randomRegisto() {
		boolean flag2 = false;
		;
		LerRegObj();
		Random rnd = new Random();
		String[] parts;
		int[] Atrib = new int[newObjAdmin.size()];
		int devolve = 0;
		nT = 9999;
		for (int i = 0; i < newObjAdmin.size(); i++) {
			flag2 = true;
			parts = newObjAdmin.get(i).getCodregisto().toString().split("#");
			Atrib[i] = Integer.parseInt(parts[0]);
		}

		for (int i = 0; i < newObjAdmin.size(); i++) {

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
	 * * Le Ficheiro de Registo de Objetos. O ficheiro tem o nome da data atual
	 * (MM-yyyy). Se não existir cria ficheiro novo. Sempre que a data altera
	 * cria novo ficheiro.
	 */
	public static void LerRegObj() {
		try {
			if (OF.exists() == true) {
				newObjAdmin.clear();// Array list limpar
				Scanner inputFile = new Scanner(OF);
				while (inputFile.hasNextLine()) {
					String line = inputFile.nextLine();
					String[] parts = line.split("#");
					Registo_Objeto rObj = new Registo_Objeto(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5],
							parts[6], parts[7], parts[8], parts[9]);
					newObjAdmin.add(rObj);
				}
				inputFile.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		if (OF.exists() == false) {
			PrintWriter out = null;
			try {
				out = new PrintWriter(OF);

			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null,
						"O ficheiro de Objetos estava danificado ou era inexistente, foi criado um novo ficheiro.");
			}
			out.close();
		}
	}

	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------

	/**
	 * Remove Registo do Objeto.Em Reclamação remove do ficheiro de Registo
	 * correspondente á data de registo do item. Em Doações remove do ficheiro
	 * Doações e do ficheiro de Registo correspondente á data do item. Cria um
	 * ficheiro "temporario" Passa todas as linhas excepto a linha a remover
	 * para o ficheiro temporario,apaga ficheiro original e troca o nome do
	 * Ficheiro temporario para o de Original.
	 * 
	 * @param nomereg
	 * @param mailreg
	 * @param sala
	 * @param data
	 * @param hora
	 * @param cod_to
	 * @param cor
	 * @param estado
	 * @param descrição
	 */
	public static void RemoveRegObj(String Codigo_Registo, String file) {
		File f = new File(file);
		try {
			Scanner inputFile = new Scanner(f);
			PrintWriter temp = new PrintWriter(TOF);

			while (inputFile.hasNextLine()) {
				String line = inputFile.nextLine();
				String[] parts = line.split("#");
				if (parts[0].toString().equals(Codigo_Registo) == false) {
					temp.println(line);
				}
			}
			inputFile.close();
			temp.close();
			f.delete();
			TOF.renameTo(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Doa objeto selecionado que é filtrado por codigo e Instituição. Adiciona
	 * ao respetivo ficheiro.
	 * 
	 * @param Codigo_Registo
	 * @param file
	 * @param FileSave
	 */
	public static void AdicionaDoa(String Codigo_Registo, String file, String FileSave) {
		File f = new File(file);
		File fs = new File(FileSave);
		try {
			Scanner inputFile = new Scanner(f);
			PrintWriter temp = new PrintWriter(fs);

			while (inputFile.hasNextLine()) {
				String line = inputFile.nextLine();
				String[] parts = line.split("#");
				if (parts[10].toString().equals(FileSave.replaceAll(".txt", "")) == true
						&& parts[0].toString().equals(Codigo_Registo) == true) {
					temp.println(line);
				}
			}
			inputFile.close();
			temp.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------

	/**
	 * Cria um novo registo de um Item Utilizado em Registo de Objetos
	 * 
	 * @param nomereg
	 * @param mailreg
	 * @param sala
	 * @param data
	 * @param hora
	 * @param cod_to
	 * @param cor
	 * @param estado
	 * @param descrição
	 * @throws IOException
	 */
	public static void AddRegAdmin(String nomereg, String mailreg, String sala, String data, String hora, String cod_to,
			String cor, String estado, String descrição) throws IOException {
		Registo_Objeto nvReg = new Registo_Objeto(Integer.toString(randomRegisto()), nomereg, mailreg, sala, data, hora,
				cod_to, cor, estado, descrição);
		newObjAdmin.add(nvReg);
		PrintWriter out = new PrintWriter(new FileWriter(OF, true));
		out.println(nvReg.getCodregisto() + "#" + nvReg.getNomereg() + "#" + nvReg.getMailreg() + "#" + nvReg.getSala()
				+ "#" + nvReg.getData() + "#" + nvReg.getHora() + "#" + nvReg.getCod_to() + "#" + nvReg.getCor() + "#"
				+ nvReg.getEstado() + "#" + nvReg.getDescrição());
		if (out != null) {
			out.close();
		}
		if (OF.length() == 0) {
			out.println(nvReg.getCodregisto() + "#" + nvReg.getNomereg() + "#" + nvReg.getMailreg() + "#"
					+ nvReg.getSala() + "#" + nvReg.getData() + "#" + nvReg.getHora() + "#" + nvReg.getCod_to() + "#"
					+ nvReg.getCor() + "#" + nvReg.getEstado() + "#" + nvReg.getDescrição());
			if (out != null) {
				out.close();
			}
		}
	}

	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------
	// ++++++++++++++++++++++++++++++++++++++++IMPORTA
	// REGISTOS++++++++++++++++++++++++++++++++++++++++
	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------

	/**
	 * Lê ficheiro selecionado pelo utilizador Se o caminho do ficheiro for nulo
	 * não faz nada Se o formato do ficheiro não condizer com o de registos
	 * online devolve uma mensagem de erro em ambos os casos
	 * 
	 * @param RO
	 */
	public static void LerRegOnline(File RO) {
		if (RO != null) {
			try {
				newObjSeg.clear();// Array list limpar
				Scanner inputFile = new Scanner(RO);
				while (inputFile.hasNextLine()) {
					String line = inputFile.nextLine();
					String[] parts = line.split("[;#]");
					String[] parts2 = parts[0].split(" ");
					Registo_Objeto rObj = new Registo_Objeto(parts2[0], parts2[1], parts[1], parts[2], parts[3],
							parts[4], parts[5], parts[6], parts[7]);
					newObjSeg.add(rObj);
				}
				inputFile.close();
			} catch (IndexOutOfBoundsException | FileNotFoundException e) {
				JOptionPane.showMessageDialog(null,
						"O ficheiro selecionado não condiz com o formato de Registos Online.\nPor favor selecione outro ficheiro.");
			}
		}
	}

	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------
	// ++++++++++++++++++++++++LE FICHEIRO LISTAGENS SELECIONADO EM
	// LISTAGEN+++++++++++++++++++++++++++
	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------
	/**
	 * Preenche a tabela em listagens conforme a seleção de ficheiro feita pelo
	 * utilizador
	 * 
	 * @param File
	 */
	public static void CustomFillList(String File) {
		File date = new File(File);
		try {
			Scanner inputFile = new Scanner(date);
			newObjAdmin.clear();
			while (inputFile.hasNextLine()) {
				String line = inputFile.nextLine();
				String[] parts = line.split("#");
				Registo_Objeto lObj = new Registo_Objeto(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5],
						parts[6], parts[7], parts[8], parts[9]);
				newObjAdmin.add(lObj);
			}
			inputFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Preenche a tabela em Reclamações conforme a seleção de ficheiro feita
	 * pelo utilizador
	 * 
	 * @param File
	 */
	public static void CustomFillList2(String File, String Tipo) {
		File date = new File(File);
		try {
			Scanner inputFile = new Scanner(date);
			newObjAdmin.clear();
			while (inputFile.hasNextLine()) {
				String line = inputFile.nextLine();
				String[] parts = line.split("#");
				if (parts[6].toString().equals(GetCodigo(Tipo))) {
					Registo_Objeto lObj = new Registo_Objeto(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5],
							parts[6], parts[7], parts[8], parts[9]);
					newObjAdmin.add(lObj);
				}
			}
			inputFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------
	// +++++++++++++++++++++++++++++++++++++++++DOAÇÕES++++++++++++++++++++++++++++++++++++++++++++++++
	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------

	public static String expireDate(String Data) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date textFieldAsDate = null;

		try {
			textFieldAsDate = sdf.parse(Data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		cal.setTime(textFieldAsDate);
		cal.add(Calendar.MONTH, 1);
		return sdf.format(cal.getTime());
	}

	public static void CheckDoa(String File) throws ParseException {
		boolean flag = false, flag2 = false;
		File date = new File(File);
		try {
			
			Scanner inputFile = new Scanner(date);
			newObjDoa.clear();
			while (inputFile.hasNextLine()) {
				String line = inputFile.nextLine();
				String[] parts = line.split("#");
				Calendar cal = Calendar.getInstance();
				Calendar cal2 = Calendar.getInstance();
				SimpleDateFormat sdf = new SimpleDateFormat(Date2);
				cal.setTime(sdf.parse(date2()));
				cal2.setTime(sdf.parse(expireDate(parts[4]).toString()));
				

				if ((parts[8].toString().equals("Bom") || parts[8].toString().equals("Novo"))
						&& cal.compareTo(cal2) > 0) {
					if(DOA.exists()==false)
					{
						DOA.createNewFile();
					}
					if (DOA.length() == 0) {
						PrintWriter out = new PrintWriter(new FileWriter(DOA, true));
						out.println(line + "#" + GetInst2(parts[6].toString()));
						Registo_Objeto lObj = new Registo_Objeto(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5],
								parts[6], parts[7], parts[8], parts[9], GetInst2(parts[6].toString()));
						newObjDoa.add(lObj);
						out.close();
					}
					PrintWriter out = new PrintWriter(new FileWriter(DOA, true));
					Scanner inputFile2 = new Scanner(DOA);
					flag = false;
					flag2 = false;
					while (inputFile2.hasNextLine()) {
						flag2 = true;
						String line2 = inputFile2.nextLine();
						String line3 = line + "#" + GetInst2(parts[6].toString());
						if (line3.equals(line2) == true && line2.equals("") == false) {
							flag = true;
						}
					}
					inputFile2.close();
					if (flag == false && flag2 == true) {
						out.println(line + "#" + GetInst2(parts[6].toString()));
						Registo_Objeto lObj = new Registo_Objeto(parts[0], parts[1], parts[2], parts[3], parts[4],
								parts[5], parts[6], parts[7], parts[8], parts[9], GetInst2(parts[6].toString()));
						newObjDoa.add(lObj);
						out.close();
					}
					out.close();
				}
			}
			inputFile.close();
			
			} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void LerDoa() {
		try {
			newObjDoa.clear();
			Scanner inputFile = new Scanner(DOA);
			while (inputFile.hasNextLine()) {
				String line = inputFile.nextLine();
				String[] parts = line.split("#");
				Registo_Objeto DObj = new Registo_Objeto(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5],
						parts[6], parts[7], parts[8], parts[9], parts[10]);
				newObjDoa.add(DObj);
			}
			inputFile.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "O ficheiro não existe.");
		}
	}

	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------
	// +++++++++++++++++++++++++++++++++GET CODIGO OU INST DE
	// OBJETOS++++++++++++++++++++++++++++++++++
	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------

	/**
	 * Vai Buscar o Objeto do Codigo Selecionado Utilizado em Reclamação de
	 * Objetos
	 * 
	 * @param Objeto
	 * @return
	 * @throws IOException
	 */
	public static String GetObj(String Codigo) throws IOException {
		String part = "", codigo = "";
		Scanner inputFile = new Scanner(TO);
		while (inputFile.hasNextLine()) {
			String line = inputFile.nextLine();
			String[] parts = line.split("#");
			part = parts[0];
			if (part.equals(Codigo) == true) {
				codigo = parts[1];
			}
		}
		inputFile.close();
		return codigo;
	}

	/**
	 * Vai Buscar o Codigo do Objeto Selecionado Utilizado em Registo de Objetos
	 * 
	 * @param Objeto
	 * @return
	 * @throws IOException
	 */
	public static String GetCodigo(String Objeto) throws IOException {
		String part = "", codigo = "";
		Scanner inputFile = new Scanner(TO);
		while (inputFile.hasNextLine()) {
			String line = inputFile.nextLine();
			String[] parts = line.split("#");
			part = parts[1];
			if (part.equals(Objeto) == true) {
				codigo = parts[0];
			}
		}
		inputFile.close();
		return codigo;
	}

	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------
	/**
	 * Vai buscar o nome da instituição associado ao objeto
	 * 
	 * @param Objeto
	 * @return
	 * @throws IOException
	 */
	public static String GetInst(String Objeto) throws IOException {
		String part = "", inst = "";
		Scanner inputFile = new Scanner(TO);
		while (inputFile.hasNextLine()) {
			String line = inputFile.nextLine();
			String[] parts = line.split("#");
			part = parts[1];
			if (part.equals(Objeto) == true) {
				inst = parts[2];
			}
		}
		inputFile.close();
		return inst;
	}

	/**
	 * Devolve Inst Conforme codigo introduzido
	 * 
	 * @param Codigo
	 * @return
	 * @throws IOException
	 */
	public static String GetInst2(String Codigo) throws IOException {
		String part = "", inst = "";
		Scanner inputFile = new Scanner(TO);
		while (inputFile.hasNextLine()) {
			String line = inputFile.nextLine();
			String[] parts = line.split("#");
			part = parts[0];
			if (part.equals(Codigo) == true) {
				inst = parts[2];
			}
		}
		inputFile.close();
		return inst;
	}

	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------
	// ++++++++++++++++++++++++++++++++++++++++TIPO DE OBJETOS+++++++++++++++++++++++++++++++++++++++++
	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------

	/**
	 * Cria um numero aleatorio de 1-9999 para o codigo dos tipos de Objetos.
	 * 
	 * @return
	 */
	@SuppressWarnings("unused")
	public static int randomTipo() {
		boolean flag2 = false;
		LerTipo();
		Random rnd = new Random();
		String[] parts;
		int[] Atrib = new int[TipoObj.size()];
		int devolve = 0;
		nT = 9999;
		for (int i = 0; i < TipoObj.size(); i++) {
			parts = TipoObj.get(i).getAddCod_to().toString().split("#");
			Atrib[i] = Integer.parseInt(parts[0]);
		}

		for (int i = 0; i < TipoObj.size(); i++) {

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
	 * Cria ficheiro com tipo de Objetos Codigo#Objeto#Inst
	 * 
	 * @param cod_to
	 * @param objeto
	 * @throws IOException
	 */

	public static void LerTipo() {
		if (TO.exists() == true) {
			try {
				TipoObj.clear();
				Scanner inputFile;
				inputFile = new Scanner(TO);
				while (inputFile.hasNextLine()) {
					String line = inputFile.nextLine();
					String[] parts = line.split("[#]");
					Tipo_Objeto LT = new Tipo_Objeto(parts[0], parts[1], parts[2]);
					TipoObj.add(LT);

				}
				inputFile.close();
				Collections.sort(TipoObj, new Comparator<Tipo_Objeto>() {
					@Override
					public int compare(Tipo_Objeto o1, Tipo_Objeto o2) {
						return o1.getObjeto().compareTo(o2.getObjeto());
					}
				});
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

		}

		if (TO.exists() == false) {
			PrintWriter out = null;
			try {
				out = new PrintWriter(TO);

			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null,
						"O ficheiro de Tipo de Objetos estava danificado ou era inexistente, foi criado um novo ficheiro.");
			}
			out.close();
		}
	}

	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------

	/**
	 * Remove Tipo Objetos Cria um ficheiro "temporario" Passa todas as linhas
	 * excepto a linha a remover Apaga ficheiro original Troca o nome do
	 * Ficheiro temporario para o de Original Utilizado em Reclamação de Objetos
	 * 
	 * @param Tipotxt
	 */
	public static void RemoveTipo(String Tipotxt) {
		try {
			Scanner inputFile = new Scanner(TO);
			PrintWriter temp = new PrintWriter(TTO);

			while (inputFile.hasNextLine()) {
				String line = inputFile.nextLine();
				String[] parts = line.split("#");
				String Inst = parts[1];
				if (Inst.equals(Tipotxt) == false) {
					temp.println(line);
				}
			}
			inputFile.close();
			temp.close();
			TO.delete();
			TTO.renameTo(TO);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------

	/**
	 * Adiciona Tipo de Objetos Codigo#Objeto#Instituição
	 * 
	 * @param Inst
	 * @param objeto
	 * @throws IOException
	 */
	public static void AddTipo_Objetos(String Inst, String objeto) throws IOException {
		String part = "";
		Tipo_Objeto newType = new Tipo_Objeto();
		newType.setInst(Inst);
		newType.setObjeto(objeto);
		boolean flag = false, flag2 = false;
		Scanner inputFile = new Scanner(TO);
		try {
			while (inputFile.hasNextLine()) {
				flag2 = true;
				String line = inputFile.nextLine();
				String[] parts = line.split("#");
				part = parts[1];
				if (part.replaceAll(" ", "").equals(newType.getObjeto().replaceAll(" ", "")) == true) {
					flag = true;
				}
			}
			newType.setAddCod_to(Integer.toString(randomTipo()));
			TipoObj.add(newType);
			inputFile.close();
			if (flag == true && flag2 == true) {
				JOptionPane.showMessageDialog(null,
						"O tipo de objeto que está a tentar adicionar já se encontra no registo.");
			}
			if (flag == false && flag2 == true) {
				PrintWriter out = new PrintWriter(new FileWriter(TO, true));
				out.println(newType.getAddCod_to() + "#" + newType.getObjeto() + "#" + newType.getInst());
				if (out != null) {
					out.close();
				}
			}
			if (TO.length() == 0) {
				PrintWriter out = null;
				out = new PrintWriter(new FileWriter(TO, true));
				out.println(newType.getAddCod_to() + "#" + newType.getObjeto() + "#" + newType.getInst());
				if (out != null) {
					out.close();
				}
			}
		}

		catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null,
					"O ficheiro Tipo de Objetos estava danificado ou era inexistente, foi criado um novo ficheiro.");
		}
	}
	public static void EditTipo_Objetos(String Inst, String objeto,String Cod) throws IOException {
		String part = "";
		Tipo_Objeto newType = new Tipo_Objeto();
		newType.setInst(Inst);
		newType.setObjeto(objeto);
		boolean flag = false, flag2 = false;
		Scanner inputFile = new Scanner(TO);
		try {
			while (inputFile.hasNextLine()) {
				flag2 = true;
				String line = inputFile.nextLine();
				String[] parts = line.split("#");
				part = parts[1];
				if (part.replaceAll(" ", "").equals(newType.getObjeto().replaceAll(" ", "")) == true) {
					flag = true;
				}
			}
			newType.setAddCod_to(Cod);
			TipoObj.add(newType);
			inputFile.close();
			if (flag == true && flag2 == true) {
				JOptionPane.showMessageDialog(null,
						"O tipo de objeto que está a tentar adicionar já se encontra no registo.");
			}
			if (flag == false && flag2 == true) {
				PrintWriter out = new PrintWriter(new FileWriter(TO, true));
				out.println(newType.getAddCod_to() + "#" + newType.getObjeto() + "#" + newType.getInst());
				if (out != null) {
					out.close();
				}
			}
			if (TO.length() == 0) {
				PrintWriter out = null;
				out = new PrintWriter(new FileWriter(TO, true));
				out.println(newType.getAddCod_to() + "#" + newType.getObjeto() + "#" + newType.getInst());
				if (out != null) {
					out.close();
				}
			}
		}

		catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null,
					"O ficheiro Tipo de Objetos estava danificado ou era inexistente, foi criado um novo ficheiro.");
		}
	}
}
