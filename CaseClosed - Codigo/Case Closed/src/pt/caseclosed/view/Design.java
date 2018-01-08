package pt.caseclosed.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import pt.caseclosed.controller.Core_Inst;
import pt.caseclosed.controller.Core_Objetos;
import pt.caseclosed.controller.Core_Sala;
import pt.caseclosed.controller.Core_User;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import pt.caseclosed.model.Registo_Objeto;
import pt.caseclosed.model.Utilizador;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import pt.caseclosed.view.JTextFieldLimit;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.SystemColor;

public class Design extends JFrame {

	private static final long serialVersionUID = 1L;

	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------
	// ++++++++++++++++++++++++++++++++++++++++++ COMPONENTES +++++++++++++++++++++++++++++++++++++++++
	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------

	// Janela
	private JPanel contentPane;
	private JLabel SubTitulo;
	private JLabel LblTimer;
	private JLabel LblNomeUser;
	private JButton Logout;

	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------

	// Painel de Login
	private JPanel Login;
	private JTextField userTXT;
	private JTextField pwTXT;
	private JButton ConfirmLogin;

	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------

	// Painel de Menu
	private JPanel Menu = new JPanel();
	private JButton ReclamaB;
	private JButton RegistoB;
	private JButton ListaB;
	private JButton ImportaB;
	private JButton DoaB;
	private JButton ConfigB;
	private JLabel FundoMenu;

	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------

	// Painel de Registo
	private JPanel Registo;
	private JComboBox<String> TipoRegBox;
	private JComboBox<String> EstadoRegBox;
	private JTextArea DescriRegtxt;
	private JTextField NomeRegtxt;
	private JTextField CodigotxtReg;
	private JComboBox<String> SalaRegBox;
	private JTextField EmailRegtxt;
	private JComboBox<String> CorRegBox;

	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------

	// Painel de Reclamação
	private JPanel Reclamação;
	private JButton ConfirmarBRec;
	private JComboBox<String> SalaRecBox;
	private JComboBox<String> DataRecBox;
	private JComboBox<String> LimiteRecBox;
	private JComboBox<String> CorRecBox;
	private JComboBox<String> EstadoRecBox;
	private JComboBox<String> TipoRecBox;
	private DefaultTableModel mdlRec = new DefaultTableModel();
	private JTable table;
	private TableRowSorter<DefaultTableModel> sorterReclama = new TableRowSorter<DefaultTableModel>(mdlRec);

	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------

	// Painel de Listagens
	private JPanel Listagens;
	private JTable TableListagens;
	private JComboBox<String> SalaListBox;
	private JComboBox<String> DataListBox;
	private JComboBox<String> LimiteListBox;
	private JComboBox<String> EstadoListBox;
	private JComboBox<String> CorListBox;
	private JComboBox<String> TipoListBox;
	private JComboBox<String> FicheiroBox;
	private DefaultTableModel mdlList = new DefaultTableModel();
	private TableRowSorter<DefaultTableModel> sorterListagens = new TableRowSorter<DefaultTableModel>(mdlList);

	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------

	// Importação
	private JPanel Importação;
	private JTable TableImport;
	private JFileChooser jfc;
	private DefaultTableModel mdlImport = new DefaultTableModel();

	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------

	// Doações
	private JPanel Doações;
	private String acesso, nome;
	private JTable TableDoa;
	private JComboBox<String> InstDoaBox;
	private DefaultTableModel mdlDoa = new DefaultTableModel();
	private TableRowSorter<DefaultTableModel> sorterDoa = new TableRowSorter<DefaultTableModel>(mdlDoa);

	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------

	// Painel de Configuração
	private JPanel Configs;
	private JTextField TipoAdd;
	private JTextField SalaAdd;
	private JTextField UtilizadorAdd;
	private JTextField PassAdd;
	private JTextField InstAdd;
	private JTextField EmailAdd;
	private JTextField NomeAdd;
	private JTextField EmailEdit;
	private JTextField NomeEdit;
	private JTextField UserEdit;
	private JTextField PassEdit;
	private JTextField SalaEditTXT;
	private JTextField InstEditTXT;
	private JTextField ObjEditTXT;
	private JButton ConfirmEdit;
	private JRadioButton UserRemove;
	private JRadioButton SalaRemove;
	private JRadioButton ObjRemove;
	private JRadioButton InstRemove;
	private JComboBox<String> TipoEdit;
	private JComboBox<String> AcessAdd;
	private JComboBox<String> SelectInstEdit;
	private JComboBox<String> InstTipo;
	private JComboBox<String> AcessEdit;
	private JComboBox<String> SelectUser;
	private JComboBox<String> SalaEdit;
	private JComboBox<String> InstTipoEdit;

	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------

	//Variaveis
	private String[] niveis = { "Administrador", "Segurança", "Instituição" };
	private static String[] Estado = { "", "Mau", "Usado", "Bom", "Novo" };
	/*
	 * flags são utilizadas para evitar o accionamento de action listeners quando se atualiza certos campos com nova informação
	 */
	private static boolean flagconfig = false, flagreg = false, flagrec = false, flaglist = false, flagdoa = false;;
	private JTextField PathFileTXT;
	private File filename;

	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------
	// ++++++++++++++++++++++++++++++++++++++++++++ DOAÇÕES +++++++++++++++++++++++++++++++++++++++++++
	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------
	/**
	 * Verifica se existem Registos
	 * eligiveis para doação
	 * @throws ParseException
	 */
	public static void CheckDoações() throws ParseException {
		/*
		 * Procura por nome de ficheiros no diretorio da aplicação que condizem
		 * com certos parametros. Guarda nome ficheiro na Lista
		 */
		File dir = new File(".");
		List<File> list = Arrays.asList(dir.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {

				return name.matches("[0-9]{2}[-][0-9]{4}(.txt)"); 
			}
		}));
		for (int i = 0; i < list.size(); i++) {
			Core_Objetos.CheckDoa(list.get(i).toString().substring(2, list.get(i).toString().length()));
		}
	}

	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------
	
	/**
	 * Preenche Tabela Doações
	 */
	private void FillDoaTable() {
		mdlDoa.setColumnCount(0);
		mdlDoa.addColumn("Data");
		mdlDoa.addColumn("Limite");
		mdlDoa.addColumn("Tipo");
		mdlDoa.addColumn("Cor");
		mdlDoa.addColumn("Sala");
		mdlDoa.addColumn("Registo");
		mdlDoa.addColumn("Inst.");
		mdlDoa.setRowCount(0);
		/*
		 * Ordenar Por data
		 */
		Core_Objetos.LerDoa();
		Collections.sort(Core_Objetos.newObjDoa, new Comparator<Registo_Objeto>() {
			@Override
			public int compare(Registo_Objeto o1, Registo_Objeto o2) {
				return o1.getData().compareTo(o2.getData());
			}
		});
		for (int i = 0; i < Core_Objetos.newObjDoa.size(); i++) {
			mdlDoa.addRow(new Object[] { Core_Objetos.newObjDoa.get(i).getData().toString(),
					expireDate(Core_Objetos.newObjDoa.get(i).getData().toString()),
					Core_Objetos.newObjDoa.get(i).getCod_to().toString(),
					Core_Objetos.newObjDoa.get(i).getCor().toString(),
					Core_Objetos.newObjDoa.get(i).getSala().toString(),
					Core_Objetos.newObjDoa.get(i).getCodregisto().toString(),
					Core_Objetos.newObjDoa.get(i).getInst().toString() });
		}
	}

	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------
	
	/**
	 * Preenche Combobox
	 * Instituições
	 */
	private void FillDoa() {
		flagdoa = false;
		InstDoaBox.removeAllItems();
		InstDoaBox.addItem("");

		Core_Inst.LerInst();
		for (int i = 0; i < Core_Inst.InstList.size(); i++) {
			InstDoaBox.addItem(Core_Inst.InstList.get(i).toString());
		}
		flagdoa = true;
	}

	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------
	
	/**
	 * Cria Filtro para Doações
	 */
	private void FilterDoa() {
		List<RowFilter<Object, Object>> rfs = new ArrayList<RowFilter<Object, Object>>();

		RowFilter<DefaultTableModel, Object> rf = null;
		if (InstDoaBox.getSelectedItem().toString().equals("") == false) {
			rfs.add(RowFilter.regexFilter(InstDoaBox.getSelectedItem().toString(), 6));
		}
		rf = RowFilter.andFilter(rfs);
		sorterDoa.setRowFilter(rf);
	}
	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------
	// ++++++++++++++++++++++++++++++++++++++++ DATA LIMITE +++++++++++++++++++++++++++++++++++++++++++
	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------

	/**
	 * Lê data presente no registo 
	 * Converte string para util.Date
	 * é adicionado um mes para obter o prazo limite 
	 * devolve essa data
	 */
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

	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------
	// ++++++++++++++++++++++++++++++++++++++++ LISTAGENS +++++++++++++++++++++++++++++++++++++++++++++
	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------

	/**
	 * Preenche a Tabela em Listagens
	 */
	public void FillListListagens(String Ficheiro) {

		mdlList.setColumnCount(0);
		mdlList.addColumn("Data");
		mdlList.addColumn("Limite");
		mdlList.addColumn("Tipo");
		mdlList.addColumn("Cor");
		mdlList.addColumn("Sala");
		mdlList.addColumn("Estado");
		mdlList.addColumn("Descri.");

		mdlList.setRowCount(0);
		/*
		 * Ordena Por data
		 */
		Core_Objetos.CustomFillList(Ficheiro);
		Collections.sort(Core_Objetos.newObjAdmin, new Comparator<Registo_Objeto>() {
			@Override
			public int compare(Registo_Objeto o1, Registo_Objeto o2) {
				return o1.getData().compareTo(o2.getData());
			}
		});
		for (int i = 0; i < Core_Objetos.newObjAdmin.size(); i++) {
			mdlList.addRow(new Object[] { Core_Objetos.newObjAdmin.get(i).getData().toString(),
					expireDate(Core_Objetos.newObjAdmin.get(i).getData().toString()),
					Core_Objetos.newObjAdmin.get(i).getCod_to().toString(),
					Core_Objetos.newObjAdmin.get(i).getCor().toString(),
					Core_Objetos.newObjAdmin.get(i).getSala().toString(),
					Core_Objetos.newObjAdmin.get(i).getEstado().toString(),
					Core_Objetos.newObjAdmin.get(i).getDescrição().toString() });
		}
	}

	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------
	
	/**
	 * Cria filtros para Listagens
	 */
	public void FilterListagens() {
		List<RowFilter<Object, Object>> rfs = new ArrayList<RowFilter<Object, Object>>();

		RowFilter<DefaultTableModel, Object> rf = null;
		// Se não tem um item selecionado não atualiza a Tabela
		try {
			if (TipoListBox.getSelectedItem().toString().equals("") == false) {
				rfs.add(RowFilter.regexFilter(Core_Objetos.GetCodigo(TipoListBox.getSelectedItem().toString()), 2));
			}
			if (DataListBox.getSelectedItem().toString().equals("") == false) {
				rfs.add(RowFilter.regexFilter(DataListBox.getSelectedItem().toString(), 0));
			}
			if (CorListBox.getSelectedItem().toString().equals("") == false) {
				rfs.add(RowFilter.regexFilter(CorListBox.getSelectedItem().toString(), 3));
			}
			if (LimiteListBox.getSelectedItem().toString().equals("") == false) {
				rfs.add(RowFilter.regexFilter(LimiteListBox.getSelectedItem().toString(), 1));
			}
			if (SalaListBox.getSelectedItem().toString().equals("") == false) {
				rfs.add(RowFilter.regexFilter(SalaListBox.getSelectedItem().toString(), 4));
			}
			if (EstadoListBox.getSelectedItem().toString().equals("") == false) {
				rfs.add(RowFilter.regexFilter(EstadoListBox.getSelectedItem().toString(), 5));
			}
			rf = RowFilter.andFilter(rfs);
		} catch (java.util.regex.PatternSyntaxException e) {
			return;
		} catch (IOException e) {
			e.printStackTrace();
		}
		sorterListagens.setRowFilter(rf);
	}

	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------
	
	/**
	 * Preenche as combobox
	 * Sala
	 * Data
	 * Limite
	 * Tipo
	 * conforme o ficheiro selecionado.
	 */
	public void FillBoxListagens() {
		SalaListBox.removeAllItems();
		DataListBox.removeAllItems();
		LimiteListBox.removeAllItems();
		TipoListBox.removeAllItems();

		TipoListBox.addItem("");
		SalaListBox.addItem("");
		DataListBox.addItem("");
		LimiteListBox.addItem("");
		/*
		 * Ordena-se os Items nas comboboxs
		 */
		FillListListagens(FicheiroBox.getSelectedItem().toString());
		Core_Objetos.CustomFillList(FicheiroBox.getSelectedItem().toString());
		
		Collections.sort(Core_Objetos.newObjAdmin, new Comparator<Registo_Objeto>() {
			@Override
			public int compare(Registo_Objeto o1, Registo_Objeto o2) {
				return o1.getSala().compareTo(o2.getSala());
			}
		});
		for (int i = 0; i < Core_Objetos.newObjAdmin.size(); i++) {
			boolean flag = false;

			for (int f = 0; f < SalaListBox.getItemCount(); f++) {
				if (Core_Objetos.newObjAdmin.get(i).getSala().toString().equals(SalaListBox.getItemAt(f)) == true) {
					flag = true;
				}
			}
			if (flag == false) {
				SalaListBox.addItem(Core_Objetos.newObjAdmin.get(i).getSala().toString());
			}
		}

		Collections.sort(Core_Objetos.newObjAdmin, new Comparator<Registo_Objeto>() {
			@Override
			public int compare(Registo_Objeto o1, Registo_Objeto o2) {
				return o1.getData().compareTo(o2.getData());
			}
		});
		for (int i = 0; i < Core_Objetos.newObjAdmin.size(); i++) {
			boolean flag = false;

			for (int f = 0; f < DataListBox.getItemCount(); f++) {
				if (Core_Objetos.newObjAdmin.get(i).getData().toString().equals(DataListBox.getItemAt(f)) == true) {
					flag = true;
				}
			}
			if (flag == false) {
				DataListBox.addItem(Core_Objetos.newObjAdmin.get(i).getData().toString());
				LimiteListBox.addItem(expireDate(Core_Objetos.newObjAdmin.get(i).getData().toString()));
			}
		}		
		for (int i = 0; i < Core_Objetos.newObjAdmin.size(); i++) {
			boolean flag = false;

			for (int f = 0; f < TipoListBox.getItemCount(); f++) {
				try {
					if (Core_Objetos.newObjAdmin.get(i).getCod_to().toString()
							.equals(Core_Objetos.GetCodigo(TipoListBox.getItemAt(f).toString())) == true) {
						flag = true;
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (flag == false) {

				try {
					TipoListBox.addItem(Core_Objetos.GetObj(Core_Objetos.newObjAdmin.get(i).getCod_to().toString()));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------
	
	/**
	 * Preenche a Combobox Ficheiro
	 * Estado 
	 * Cor
	 * em Listagens
	 */
	public void FillListagens() {

		FicheiroBox.removeAllItems();
		CorListBox.removeAllItems();
		EstadoListBox.removeAllItems();

		EstadoListBox.setModel(new javax.swing.DefaultComboBoxModel<String>(Estado));
		CorListBox.addItem("");
		CorListBox.addItem("Amarelo");
		CorListBox.addItem("Azul");
		CorListBox.addItem("Branco");
		CorListBox.addItem("Cinza");
		CorListBox.addItem("Laranja");
		CorListBox.addItem("Lilás");
		CorListBox.addItem("Preto");
		CorListBox.addItem("Rosa");
		CorListBox.addItem("Verde");
		CorListBox.addItem("Vermelho");
		FicheiroBox.addItem("");

		/*
		 * Procura por nome de ficheiros no diretorio da aplicação que condizem
		 * com certos parametros. Guarda nome ficheiro no Array
		 */
		if (acesso.equalsIgnoreCase(niveis[2]) == false) {
			File dir = new File(".");
			List<File> list = Arrays.asList(dir.listFiles(new FilenameFilter() {
				@Override
				public boolean accept(File dir, String name) {

					return name.matches("[0-9]{2}[-][0-9]{4}(.txt)");

				}
			}));

			for (int i = 0; i < list.size(); i++) {
				FicheiroBox.addItem(list.get(i).toString().substring(2, list.get(i).toString().length()));
			}
		}
		if (acesso.equalsIgnoreCase(niveis[2]) == true) {
			FicheiroBox.addItem(nome + ".txt");
		}
	}

	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------
	// ++++++++++++++++++++++++++++++++++++++++ RECLAMAÇÃO ++++++++++++++++++++++++++++++++++++++++++++
	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------

	public void LimpaReclamação() {
		mdlRec.setColumnCount(0);
		mdlRec.setRowCount(0);
	}

	/*
	 * Gere filtros da tabela em Reclamação
	 */
	public void FilterRec() {
		List<RowFilter<Object, Object>> rfs = new ArrayList<RowFilter<Object, Object>>();

		RowFilter<DefaultTableModel, Object> rf = null;
		// Se não tem um item selecionado não atualiza a Tabela
		try {
			if (TipoRecBox.getSelectedItem().toString().equals("") == false) {
				rfs.add(RowFilter.regexFilter(Core_Objetos.GetCodigo(TipoRecBox.getSelectedItem().toString()), 6));
			}
			if (DataRecBox.getSelectedItem().toString().equals("") == false) {
				rfs.add(RowFilter.regexFilter(DataRecBox.getSelectedItem().toString(), 0));
			}
			if (CorRecBox.getSelectedItem().toString().equals("") == false) {
				rfs.add(RowFilter.regexFilter(CorRecBox.getSelectedItem().toString(), 4));
			}
			if (LimiteRecBox.getSelectedItem().toString().equals("") == false) {
				rfs.add(RowFilter.regexFilter(LimiteRecBox.getSelectedItem().toString(), 1));
			}
			if (SalaRecBox.getSelectedItem().toString().equals("") == false) {
				rfs.add(RowFilter.regexFilter(SalaRecBox.getSelectedItem().toString(), 5));
			}
			if (EstadoRecBox.getSelectedItem().toString().equals("") == false) {
				rfs.add(RowFilter.regexFilter(EstadoRecBox.getSelectedItem().toString(), 3));
			}
			rf = RowFilter.andFilter(rfs);
		} catch (java.util.regex.PatternSyntaxException e) {
			return;
		} catch (IOException e) {
			e.printStackTrace();
		}
		sorterReclama.setRowFilter(rf);
	}

	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------

	/**
	 * Preenche a Tabela com Registos que tenham o objeto selecionado
	 * Independentemente do ficheiro
	 */
	public void FillListRec() {
		flagrec = false;
		mdlRec.setColumnCount(0);
		mdlRec.addColumn("Data");
		mdlRec.addColumn("Limite");
		mdlRec.addColumn("Registo");
		mdlRec.addColumn("Estado");
		mdlRec.addColumn("Cor");
		mdlRec.addColumn("Sala");
		mdlRec.addColumn("Tipo");
		mdlRec.setRowCount(0);

		/*
		 * Procura por nome de ficheiros no diretorio da aplicação que condizem
		 * com certos parametros. Guarda nome ficheiro no Array
		 */
		File dir = new File(".");
		List<File> list = Arrays.asList(dir.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {

				return name.matches("[0-9]{2}[-][0-9]{4}(.txt)");

			}
		}));

		for (int i = 0; i < list.size(); i++) {
			Core_Objetos.CustomFillList2(list.get(i).toString().substring(2, list.get(i).toString().length()),
					TipoRecBox.getSelectedItem().toString());
			Collections.sort(Core_Objetos.newObjAdmin, new Comparator<Registo_Objeto>() {
				@Override
				public int compare(Registo_Objeto o1, Registo_Objeto o2) {
					return o1.getData().compareTo(o2.getData());
				}
			});
			for (int f = 0; f < Core_Objetos.newObjAdmin.size(); f++) {
				mdlRec.addRow(new Object[] { Core_Objetos.newObjAdmin.get(f).getData().toString(),
						expireDate(Core_Objetos.newObjAdmin.get(f).getData().toString()),
						Core_Objetos.newObjAdmin.get(f).getCodregisto().toString(),
						Core_Objetos.newObjAdmin.get(f).getEstado().toString(),
						Core_Objetos.newObjAdmin.get(f).getCor().toString(),
						Core_Objetos.newObjAdmin.get(f).getSala().toString(),
						Core_Objetos.newObjAdmin.get(f).getCod_to() });
			}
		}
		flagrec = true;
	}

	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------

	/**
	 * Lê os ficheiros todos de registos de objetos preenche as combobox com as
	 * salas e datas presentes no ficheiro para facilitar filtragens ao
	 * utilizador
	 */
	public void FillRec() {
		TipoRecBox.removeAllItems();
		DataRecBox.removeAllItems();
		LimiteRecBox.removeAllItems();
		SalaRecBox.removeAllItems();
		/*
		 * Cor e Estado Não é necessário estarem aqui pois os seus items sao
		 * constantes estão apenas aqui por motivos de organização
		 */
		CorRecBox.removeAllItems();
		EstadoRecBox.removeAllItems();

		CorRecBox.addItem("");
		CorRecBox.addItem("Amarelo");
		CorRecBox.addItem("Azul");
		CorRecBox.addItem("Branco");
		CorRecBox.addItem("Cinza");
		CorRecBox.addItem("Laranja");
		CorRecBox.addItem("Lilás");
		CorRecBox.addItem("Preto");
		CorRecBox.addItem("Rosa");
		CorRecBox.addItem("Verde");
		CorRecBox.addItem("Vermelho");
		EstadoRecBox.setModel(new javax.swing.DefaultComboBoxModel<String>(Estado));
		TipoRecBox.addItem("");
		DataRecBox.addItem("");
		LimiteRecBox.addItem("");
		SalaRecBox.addItem("");

		/*
		 * Procura por nome de ficheiros no diretorio da aplicação que condizem
		 * com certos parametros. Guarda nome ficheiro no Array
		 */
		File dir = new File(".");
		List<File> list = Arrays.asList(dir.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {

				return name.matches("[0-9]{2}[-][0-9]{4}(.txt)");
			}
		}));
		for (int j = 0; j < list.size(); j++) {

			Core_Objetos.CustomFillList(list.get(j).toString().substring(2, list.get(j).toString().length()));
			Collections.sort(Core_Objetos.newObjAdmin, new Comparator<Registo_Objeto>() {
				@Override
				public int compare(Registo_Objeto o1, Registo_Objeto o2) {
					return o1.getSala().compareTo(o2.getSala());
				}
			});
			for (int i = 0; i < Core_Objetos.newObjAdmin.size(); i++) {
				boolean flag = false;

				for (int f = 0; f < SalaRecBox.getItemCount(); f++) {
					if (Core_Objetos.newObjAdmin.get(i).getSala().toString().equals(SalaRecBox.getItemAt(f)) == true) {
						flag = true;
					}
				}
				if (flag == false) {
					SalaRecBox.addItem(Core_Objetos.newObjAdmin.get(i).getSala().toString());
				}
			}

			Collections.sort(Core_Objetos.newObjAdmin, new Comparator<Registo_Objeto>() {
				@Override
				public int compare(Registo_Objeto o1, Registo_Objeto o2) {
					return o1.getData().compareTo(o2.getData());
				}
			});
			for (int i = 0; i < Core_Objetos.newObjAdmin.size(); i++) {
				boolean flag = false;

				for (int f = 0; f < DataRecBox.getItemCount(); f++) {
					if (Core_Objetos.newObjAdmin.get(i).getData().toString().equals(DataRecBox.getItemAt(f)) == true) {
						flag = true;
					}
				}
				if (flag == false) {
					DataRecBox.addItem(Core_Objetos.newObjAdmin.get(i).getData().toString());
					LimiteRecBox.addItem(expireDate(Core_Objetos.newObjAdmin.get(i).getData().toString()));
				}
			}

			for (int i = 0; i < Core_Objetos.newObjAdmin.size(); i++) {
				boolean flag = false;

				for (int f = 0; f < TipoRecBox.getItemCount(); f++) {
					try {
						if (Core_Objetos.newObjAdmin.get(i).getCod_to().toString()
								.equals(Core_Objetos.GetCodigo(TipoRecBox.getItemAt(f).toString())) == true) {
							flag = true;
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (flag == false) {

					try {
						TipoRecBox.addItem(Core_Objetos.GetObj(Core_Objetos.newObjAdmin.get(i).getCod_to().toString()));
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------
	// ++++++++++++++++++++++++++++++++++++++++++ REGISTO +++++++++++++++++++++++++++++++++++++++++++++
	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------

	/**
	 * 
	 * Preenche todas as Combobox na Opção Registo
	 * @throws IOException
	 */
	public void FillReg() throws IOException {
		flagreg = false;
		SalaRegBox.removeAllItems();
		TipoRegBox.removeAllItems();
		CorRegBox.removeAllItems();
		EstadoRegBox.removeAllItems();

		EstadoRegBox.setModel(new javax.swing.DefaultComboBoxModel<String>(Estado));
		CorRegBox.addItem("");
		CorRegBox.addItem("Amarelo");
		CorRegBox.addItem("Azul");
		CorRegBox.addItem("Branco");
		CorRegBox.addItem("Cinza");
		CorRegBox.addItem("Laranja");
		CorRegBox.addItem("Lilás");
		CorRegBox.addItem("Preto");
		CorRegBox.addItem("Rosa");
		CorRegBox.addItem("Verde");
		CorRegBox.addItem("Vermelho");
		SalaRegBox.addItem("");
		TipoRegBox.addItem("");
		Core_Sala.LerSalas();
		for (int i = 0; i < Core_Sala.Sala.size(); i++) {
			SalaRegBox.addItem(Core_Sala.Sala.get(i).toString());
		}

		Core_Objetos.LerTipo();
		for (int i = 0; i < Core_Objetos.TipoObj.size(); i++) {
			TipoRegBox.addItem(Core_Objetos.TipoObj.get(i).toString());
		}
		flagreg = true;
	}
	/**
	 * Limpa campos 
	 * em Registo de Objetos
	 */
	public void LimpaRegisto() {
		flagreg = false;
		NomeRegtxt.setText("");
		EmailRegtxt.setText("");
		CodigotxtReg.setText("");
		DescriRegtxt.setText("");
		SalaRegBox.setSelectedIndex(-1);
		CorRegBox.setSelectedIndex(-1);
		EstadoRegBox.setSelectedIndex(-1);
		TipoRegBox.setSelectedIndex(-1);
		flagreg = true;
	}

	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------
	// ++++++++++++++++++++++++++++++++++++++++++ CONFIGURAÇÃO ++++++++++++++++++++++++++++++++++++++++
	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------

	/**
	 * Limpa todos os campos na Opção Configuração
	 */
	public void CleanConfig() {
		EmailEdit.setText("");
		NomeEdit.setText("");
		UserEdit.setText("");
		PassEdit.setText("");
		SalaEditTXT.setText("");
		ObjEditTXT.setText("");
		InstEditTXT.setText("");

		SalaRemove.setSelected(false);
		UserRemove.setSelected(false);
		InstRemove.setSelected(false);
		ObjRemove.setSelected(false);

		if (SelectInstEdit.getSelectedIndex() > 0) {
			SelectInstEdit.setSelectedIndex(0);
		}
		if (TipoEdit.getSelectedIndex() > 0) {
			TipoEdit.setSelectedIndex(0);
		}
		EmailAdd.setText("");
		NomeAdd.setText("");
		TipoAdd.setText("");
		if (InstTipo.getSelectedIndex() > 0) {
			InstTipo.setSelectedIndex(0);
		}
		SalaAdd.setText("");
		UtilizadorAdd.setText("");
		PassAdd.setText("");
		InstAdd.setText("");

	}

	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------

	/**
	 * Preenche todas as Combobox na Opção Configuração
	 */
	public void FillConfig() {
		InstTipo.removeAllItems();
		TipoEdit.removeAllItems();
		InstTipoEdit.removeAllItems();
		SelectInstEdit.removeAllItems();
		AcessAdd.removeAllItems();
		AcessEdit.removeAllItems();
		SalaEdit.removeAllItems();
		SelectUser.removeAllItems();

		TipoEdit.addItem("");
		InstTipo.addItem("");
		InstTipoEdit.addItem("");
		SelectInstEdit.addItem("");
		AcessAdd.addItem("");
		AcessEdit.addItem("");
		SalaEdit.addItem("");
		SelectUser.addItem("");

		Core_Objetos.LerTipo();
		for (int i = 0; i < Core_Objetos.TipoObj.size(); i++) {
			TipoEdit.addItem(Core_Objetos.TipoObj.get(i).toString());
		}

		Core_Inst.LerInst();
		for (int i = 0; i < Core_Inst.InstList.size(); i++) {
			InstTipo.addItem(Core_Inst.InstList.get(i).toString());
			InstTipoEdit.addItem(Core_Inst.InstList.get(i).toString());
			SelectInstEdit.addItem(Core_Inst.InstList.get(i).toString());
		}

		Core_Sala.LerSalas();
		for (int i = 0; i < Core_Sala.Sala.size(); i++) {
			SalaEdit.addItem(Core_Sala.Sala.get(i).toString());
		}

		Core_User.LerUser();
		for (int i = 0; i < Core_User.user.size(); i++) {
			SelectUser.addItem(Core_User.user.get(i).toString());
		}
		for (int i = 0; i < niveis.length; i++) {
			AcessAdd.addItem(niveis[i]);
			AcessEdit.addItem(niveis[i]);
		}
	}

	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------
	// ++++++++++++++++++++++++++++++++++++++++++ ACESSOS E LOGIN +++++++++++++++++++++++++++++++++++++
	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------

	/**
	 * Verifica acessos e Guarda Utilizador que faz login.
	 */
	public void Acessos() {
		Utilizador ul = Core_User.userlogged.get(0);
		nome = ul.getNome();
		acesso = ul.getAcesso();

		if (acesso.equalsIgnoreCase(niveis[1]) == true) {

			ListaB.setEnabled(false);
			ConfigB.setEnabled(false);
		}
		if (acesso.equalsIgnoreCase(niveis[2]) == true) {

			RegistoB.setEnabled(false);
			ReclamaB.setEnabled(false);
			ImportaB.setEnabled(false);
			ConfigB.setEnabled(false);
			DoaB.setEnabled(false);
		}
		Login.setVisible(false);
		Menu.setVisible(true);
		LblNomeUser.setText(nome);
		SubTitulo.setText("Menu");
	}

	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------

	/**
	 * 
	 * Verificação de Login Limpa Array de Utilizador Atual e guarda nova
	 * informação se todos os dados são corretos
	 * @param Us
	 * @param Pw
	 */
	public void Login(String Us, String Pw) {
		Core_User.LerUser();
		Utilizador u;
		boolean flag = false;
		for (int i = 0; i < Core_User.user.size(); i++) {
			u = Core_User.user.get(i);
			if (u.getUsername().toLowerCase().equals(Us.toLowerCase())
					&& u.getPassword().toLowerCase().equals(Pw.toLowerCase())) {
				Core_User.userlogged.clear();
				flag = true;
				Utilizador ul = new Utilizador(Core_User.user.get(i).getUsername().toString(),
						Core_User.user.get(i).getPassword().toString(), Core_User.user.get(i).getAcesso().toString(),
						Core_User.user.get(i).getEmail().toString(), Core_User.user.get(i).getNome().toString());
				Core_User.userlogged.add(ul);
				Acessos();
				Logout.setVisible(true);
				break;
			}
		}
		if (flag == false) {
			JOptionPane.showMessageDialog(null,
					"O nome de utilizador e/ou palavra-passe introduzidos estão incorretos.", "Erro de Login",
					JOptionPane.INFORMATION_MESSAGE);
			userTXT.setText("");
			pwTXT.setText("");
		}
	}

	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------
	// ++++++++++++++++++++++++++++++++++++++++++ UI ++++++++++++++++++++++++++++++++++++++++++
	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------

	/**
	 * Esconde os Paineis Todos Ativa os Butoes todos E verifica Acesso para
	 * voltar a bloquear Butoes
	 */
	private void HideAll() {
		Login.setVisible(false);

		Registo.setVisible(false);
		RegistoB.setEnabled(true);

		Reclamação.setVisible(false);
		ReclamaB.setEnabled(true);

		ImportaB.setEnabled(true);
		Importação.setVisible(false);

		ListaB.setEnabled(true);
		Listagens.setVisible(false);
		Doações.setVisible(false);
		DoaB.setEnabled(true);

		Configs.setVisible(false);
		ConfigB.setEnabled(true);

		Menu.setBounds(0, 0, 170, 667);
		Menu.setVisible(false);
		FundoMenu.setIcon(null);
		Acessos();
	}

	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------

	public Design() {
		setTitle("Case Closed - Perdidos e Achados");
		setResizable(false);
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(Design.class.getResource("/pt/caseclosed/resources/Logo36.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 727, 702);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel Titulo = new JLabel("Sistema de Perdidos e Achados da ESEIG");
		Titulo.setBounds(367, 0, 342, 25);
		contentPane.add(Titulo);
		Titulo.setHorizontalAlignment(SwingConstants.RIGHT);
		Titulo.setForeground(new Color(100, 149, 237));
		Titulo.setFont(new Font("Simply Rounded", Font.PLAIN, 16));
		Titulo.setBackground(Color.WHITE);
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				LblTimer.setText(Core_Objetos.date2() + " // " + Core_Objetos.hour2());
			}
		};
		timer.scheduleAtFixedRate(task, 100, 1000);

		LblNomeUser = new JLabel("");
		LblNomeUser.setHorizontalAlignment(SwingConstants.RIGHT);
		LblNomeUser.setForeground(new Color(100, 149, 237));
		LblNomeUser.setFont(new Font("Simply Rounded", Font.BOLD, 16));
		LblNomeUser.setBounds(506, 51, 203, 25);
		contentPane.add(LblNomeUser);

		Logout = new JButton("Sair");
		Logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HideAll();
				Menu.setVisible(false);
				Menu.setBounds(275, 0, 170, 673);
				FundoMenu.setIcon(
						new ImageIcon(Design.class.getResource("/pt/caseclosed/resources/BackgroundMenu.png")));
				Login.setVisible(true);
				LblNomeUser.setText("");
				SubTitulo.setText("Login");
				Logout.setVisible(false);
				userTXT.setText("");
				pwTXT.setText("");
				LimpaRegisto();
				CleanConfig();

			}
		});
		Logout.setBorderPainted(false);
		Logout.setForeground(new Color(100, 149, 237));
		Logout.setFont(new Font("Simply Rounded", Font.PLAIN, 16));
		Logout.setBorder(null);
		Logout.setBounds(674, 74, 35, 25);
		Logout.setVisible(false);
		contentPane.add(Logout);

		LblTimer = new JLabel("");
		LblTimer.setHorizontalAlignment(SwingConstants.LEFT);
		LblTimer.setBounds(22, -1, 305, 25);
		LblTimer.setForeground(new Color(100, 149, 237));
		LblTimer.setFont(new Font("Arial", Font.BOLD, 16));
		contentPane.add(LblTimer);

		SubTitulo = new JLabel("Login");
		SubTitulo.setHorizontalAlignment(SwingConstants.RIGHT);
		SubTitulo.setForeground(new Color(100, 149, 237));
		SubTitulo.setFont(new Font("Simply Rounded", Font.BOLD, 22));
		SubTitulo.setBounds(405, 25, 305, 25);
		contentPane.add(SubTitulo);

		// ------------------------------------------------------------------------------------------------
		// ------------------------------------------------------------------------------------------------

		// Settins Menu Panel
		Menu.setBorder(null);
		Menu.setAlignmentX(0.1f);
		Menu.setBackground(new Color(0, 0, 0, 0));
		Menu.setBounds(275, 0, 170, 673);
		contentPane.add(Menu);
		Menu.setLayout(null);
		Menu.setVisible(false);

		// ------------------------------------------------------------------------------------------------
		// ------------------------------------------------------------------------------------------------

		// Componentes Menu
		ImportaB = new JButton("");
		ImportaB.setContentAreaFilled(false);
		ImportaB.setDisabledIcon(
				new ImageIcon(Design.class.getResource("/pt/caseclosed/resources/ImportarSelect3.png")));
		ImportaB.setIcon(new ImageIcon(Design.class.getResource("/pt/caseclosed/resources/Importa\u00E7\u00E3o.png")));
		ImportaB.setRolloverIcon(
				new ImageIcon(Design.class.getResource("/pt/caseclosed/resources/Hover Importa\u00E7\u00E3o.png")));
		ImportaB.setBorderPainted(false);
		ImportaB.setBounds(9, 448, 152, 27);
		Menu.add(ImportaB);
		ImportaB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HideAll();
				ImportaB.setEnabled(false);
				Menu.setVisible(true);
				Importação.setVisible(true);
				SubTitulo.setText("Importação");
			}
		});

		ReclamaB = new JButton("");
		ReclamaB.setContentAreaFilled(false);
		ReclamaB.setBorderPainted(false);
		ReclamaB.setDisabledIcon(
				new ImageIcon(Design.class.getResource("/pt/caseclosed/resources/Reclama\u00E7\u00E3oSelect3.png")));
		ReclamaB.setEnabled(true);
		ReclamaB.setRolloverIcon(
				new ImageIcon(Design.class.getResource("/pt/caseclosed/resources/Hover Reclama\u00E7\u00E3o.png")));
		ReclamaB.setIcon(new ImageIcon(Design.class.getResource("/pt/caseclosed/resources/Reclama\u00E7\u00E3o.png")));
		ReclamaB.setBounds(9, 298, 152, 27);
		Menu.add(ReclamaB);
		ReclamaB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HideAll();
				flagrec = false;
				FillRec();
				LimpaReclamação();
				flagrec = true;
				ReclamaB.setEnabled(false);
				Menu.setVisible(true);
				Reclamação.setVisible(true);
				SubTitulo.setText("Reclamação de Objetos");
			}
		});

		RegistoB = new JButton("");
		RegistoB.setContentAreaFilled(false);
		RegistoB.setDisabledIcon(
				new ImageIcon(Design.class.getResource("/pt/caseclosed/resources/RegistoSelect3.png")));
		RegistoB.setRolloverIcon(new ImageIcon(Design.class.getResource("/pt/caseclosed/resources/Hover Registo.png")));
		RegistoB.setIcon(new ImageIcon(Design.class.getResource("/pt/caseclosed/resources/Registo.png")));
		RegistoB.setBorderPainted(false);
		RegistoB.setBounds(10, 223, 150, 27);
		Menu.add(RegistoB);
		RegistoB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					FillReg();
					LimpaRegisto();

				} catch (IOException e1) {
					e1.printStackTrace();
				}
				HideAll();
				RegistoB.setEnabled(false);
				Menu.setVisible(true);
				Registo.setVisible(true);
				SubTitulo.setText("Registo de Objetos");
			}
		});

		ListaB = new JButton("");
		ListaB.setContentAreaFilled(false);
		ListaB.setRolloverIcon(new ImageIcon(Design.class.getResource("/pt/caseclosed/resources/Hover listagens.png")));
		ListaB.setDisabledIcon(
				new ImageIcon(Design.class.getResource("/pt/caseclosed/resources/ListagensSelect3.png")));
		ListaB.setIcon(new ImageIcon(Design.class.getResource("/pt/caseclosed/resources/Listagens.png")));
		ListaB.setBorderPainted(false);
		ListaB.setBounds(9, 373, 152, 27);
		Menu.add(ListaB);
		ListaB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HideAll();
				flaglist = false;
				FillListagens();
				flaglist = true;
				if (acesso.equalsIgnoreCase(niveis[2]) == false) {
					ListaB.setEnabled(false);
				}
				Menu.setVisible(true);
				mdlList.setRowCount(0);
				Listagens.setVisible(true);
				SubTitulo.setText("Listagens");
			}
		});

		DoaB = new JButton("");
		DoaB.setContentAreaFilled(false);
		DoaB.setRolloverIcon(
				new ImageIcon(Design.class.getResource("/pt/caseclosed/resources/Hover Doa\u00E7\u00E3o.png")));
		DoaB.setDisabledIcon(
				new ImageIcon(Design.class.getResource("/pt/caseclosed/resources/Doa\u00E7\u00F5esSelect3.png")));
		DoaB.setIcon(new ImageIcon(Design.class.getResource("/pt/caseclosed/resources/Doa\u00E7\u00E3o.png")));
		DoaB.setBorderPainted(false);
		DoaB.setBounds(9, 523, 152, 27);
		Menu.add(DoaB);
		DoaB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HideAll();
				DoaB.setEnabled(false);
				Menu.setVisible(true);
				Doações.setVisible(true);
				FillDoaTable();
				FillDoa();

				SubTitulo.setText("Doações");
			}
		});

		ConfigB = new JButton("");
		ConfigB.setContentAreaFilled(false);
		ConfigB.setDisabledIcon(new ImageIcon(Design.class.getResource("/pt/caseclosed/resources/ConfigSelect3.png")));
		ConfigB.setRolloverIcon(
				new ImageIcon(Design.class.getResource("/pt/caseclosed/resources/Hover Configura\u00E7\u00F5es.png")));
		ConfigB.setIcon(
				new ImageIcon(Design.class.getResource("/pt/caseclosed/resources/Configura\u00E7\u00F5es.png")));
		ConfigB.setBorderPainted(false);
		ConfigB.setBounds(9, 598, 152, 27);
		Menu.add(ConfigB);
		ConfigB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flagconfig = false;
				FillConfig();
				CleanConfig();
				flagconfig = true;
				HideAll();
				ConfigB.setEnabled(false);
				Menu.setVisible(true);
				Configs.setVisible(true);
				SubTitulo.setText("Configurações");
			}
		});

		JLabel Logo = new JLabel("");
		Logo.setBounds(21, 48, 127, 127);
		Logo.setIcon(new ImageIcon(Design.class.getResource("/pt/caseclosed/resources/icon 127.png")));
		Logo.setForeground(Color.BLACK);
		Logo.setBackground(Color.RED);
		Menu.add(Logo);

		FundoMenu = new JLabel("");
		FundoMenu.setIcon(new ImageIcon(Design.class.getResource("/pt/caseclosed/resources/BackgroundMenu.png")));
		FundoMenu.setBounds(0, 61, 170, 667);
		Menu.add(FundoMenu);

		// ------------------------------------------------------------------------------------------------

		// Settings Login Panel
		Login = new JPanel();
		Login.setBorder(new EmptyBorder(5, 5, 5, 5));
		Login.setBackground(Color.WHITE);
		Login.setBounds(0, 0, 721, 673);
		contentPane.add(Login);
		Login.setLayout(null);

		JLabel LogoLogin = new JLabel("");
		LogoLogin.setBounds(298, 45, 127, 127);
		LogoLogin.setIcon(new ImageIcon(Design.class.getResource("/pt/caseclosed/resources/icon 127.png")));
		LogoLogin.setForeground(Color.BLACK);
		LogoLogin.setBackground(Color.RED);
		Login.add(LogoLogin);

		JLabel User = new JLabel("Utilizador");
		User.setBounds(215, 206, 76, 16);
		User.setForeground(new Color(100, 149, 237));
		User.setHorizontalAlignment(SwingConstants.RIGHT);
		User.setFont(new Font("Simply Rounded", Font.PLAIN, 14));
		Login.add(User);

		userTXT = new JTextField();
		userTXT.setBounds(303, 203, 116, 22);
		Login.add(userTXT);
		userTXT.setColumns(10);

		JLabel PW = new JLabel("Password");
		PW.setBounds(225, 238, 66, 16);
		PW.setHorizontalAlignment(SwingConstants.RIGHT);
		PW.setFont(new Font("Simply Rounded", Font.PLAIN, 14));
		PW.setForeground(new Color(100, 149, 237));
		Login.add(PW);

		pwTXT = new JPasswordField();
		pwTXT.setBounds(303, 235, 116, 22);
		pwTXT.setColumns(10);
		Login.add(pwTXT);

		JLabel BackInfoLogo = new JLabel("");
		BackInfoLogo.setBounds(198, 174, 326, 115);
		BackInfoLogo.setIcon(new ImageIcon(Design.class.getResource("/pt/caseclosed/resources/Background.png")));
		Login.add(BackInfoLogo);

		ConfirmLogin = new JButton("");
		ConfirmLogin.setBounds(287, 295, 149, 31);
		ConfirmLogin.setContentAreaFilled(false);
		ConfirmLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login(userTXT.getText(), pwTXT.getText());

			}
		});

		ConfirmLogin.setIcon(new ImageIcon(Design.class.getResource("/pt/caseclosed/resources/ConfirmBut.png")));
		Login.add(ConfirmLogin);

		Registo = new JPanel();
		Registo.setBounds(0, 0, 721, 673);
		contentPane.add(Registo);
		Registo.setLayout(null);
		Registo.setBorder(new EmptyBorder(5, 5, 5, 5));
		Registo.setBackground(Color.WHITE);
		Registo.setVisible(false);

		JLabel nomeReg = new JLabel("Nome");
		nomeReg.setForeground(Color.WHITE);
		nomeReg.setFont(new Font("Simply Rounded", Font.PLAIN, 14));
		nomeReg.setBounds(223, 239, 46, 14);
		Registo.add(nomeReg);

		NomeRegtxt = new JTextField();
		NomeRegtxt.setColumns(10);
		NomeRegtxt.setBounds(289, 236, 86, 20);
		NomeRegtxt.setDocument(new JTextFieldLimit(20));
		Registo.add(NomeRegtxt);

		JLabel SalaReg = new JLabel("Sala");
		SalaReg.setForeground(Color.WHITE);
		SalaReg.setFont(new Font("Simply Rounded", Font.PLAIN, 14));
		SalaReg.setBounds(511, 239, 46, 14);
		Registo.add(SalaReg);

		SalaRegBox = new JComboBox<String>();
		SalaRegBox.setFont(new Font("Arial", Font.PLAIN, 9));
		SalaRegBox.setBackground(Color.WHITE);
		SalaRegBox.setBounds(562, 236, 86, 20);
		Registo.add(SalaRegBox);

		EmailRegtxt = new JTextField();
		EmailRegtxt.setColumns(10);
		EmailRegtxt.setBounds(415, 236, 86, 20);
		EmailRegtxt.setDocument(new JTextFieldLimit(20));
		Registo.add(EmailRegtxt);

		JLabel EmailReg = new JLabel("Email");
		EmailReg.setForeground(Color.WHITE);
		EmailReg.setFont(new Font("Simply Rounded", Font.PLAIN, 14));
		EmailReg.setBounds(378, 239, 46, 14);
		Registo.add(EmailReg);

		JLabel TipoReg = new JLabel("Tipo");
		TipoReg.setForeground(Color.WHITE);
		TipoReg.setFont(new Font("Simply Rounded", Font.PLAIN, 14));
		TipoReg.setBounds(223, 266, 46, 14);
		Registo.add(TipoReg);

		JLabel EstadoReg = new JLabel("Estado");
		EstadoReg.setForeground(Color.WHITE);
		EstadoReg.setFont(new Font("Simply Rounded", Font.PLAIN, 14));
		EstadoReg.setBounds(511, 266, 46, 14);
		Registo.add(EstadoReg);

		JLabel CorReg = new JLabel("Cor");
		CorReg.setForeground(Color.WHITE);
		CorReg.setFont(new Font("Simply Rounded", Font.PLAIN, 14));
		CorReg.setBounds(378, 266, 46, 14);
		Registo.add(CorReg);

		CorRegBox = new JComboBox<String>();
		CorRegBox.setBackground(Color.WHITE);
		CorRegBox.setBounds(415, 263, 86, 20);
		Registo.add(CorRegBox);

		EstadoRegBox = new JComboBox<String>();
		EstadoRegBox.setFont(new Font("Arial", Font.PLAIN, 9));
		EstadoRegBox.setBackground(Color.WHITE);
		EstadoRegBox.setBounds(562, 263, 86, 20);

		Registo.add(EstadoRegBox);

		TipoRegBox = new JComboBox<String>();
		TipoRegBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (flagreg == true) {
					try {
						CodigotxtReg.setText(Core_Objetos.GetCodigo(TipoRegBox.getSelectedItem().toString()));
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
		TipoRegBox.setFont(new Font("Arial", Font.PLAIN, 9));
		TipoRegBox.setBackground(Color.WHITE);
		TipoRegBox.setBounds(289, 264, 86, 20);
		Registo.add(TipoRegBox);

		JLabel CodigoReg = new JLabel("Codigo");
		CodigoReg.setForeground(Color.WHITE);
		CodigoReg.setFont(new Font("Simply Rounded", Font.PLAIN, 14));
		CodigoReg.setBounds(223, 293, 46, 14);
		Registo.add(CodigoReg);

		CodigotxtReg = new JTextField();
		CodigotxtReg.setEditable(false);
		CodigotxtReg.setBackground(Color.WHITE);
		CodigotxtReg.setBounds(289, 290, 86, 20);
		Registo.add(CodigotxtReg);
		CodigotxtReg.setColumns(10);

		JLabel DescriReg = new JLabel("Descri\u00E7\u00E3o");
		DescriReg.setForeground(Color.WHITE);
		DescriReg.setFont(new Font("Simply Rounded", Font.PLAIN, 14));
		DescriReg.setBounds(223, 321, 69, 14);
		Registo.add(DescriReg);

		DescriRegtxt = new JTextArea();
		DescriRegtxt.setBounds(289, 321, 237, 59);
		DescriRegtxt.setDocument(new JTextFieldLimit(50));
		Registo.add(DescriRegtxt);

		JLabel BolaReg = new JLabel("");
		BolaReg.setBounds(579, 321, 127, 127);
		Registo.add(BolaReg);
		BolaReg.setIcon(new ImageIcon(Design.class.getResource("/pt/caseclosed/resources/RegistoAqui.png")));
		BolaReg.setForeground(Color.BLACK);
		BolaReg.setBackground(Color.RED);

		JButton ConfirmarBReg = new JButton("");
		ConfirmarBReg.setContentAreaFilled(false);
		ConfirmarBReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					if (NomeRegtxt.getText().equals("") == false && NomeRegtxt.getText().contains("[0-9]") == false
							&& EmailRegtxt.getText().equals("") == false
							&& SalaRegBox.getSelectedItem().toString().equals("") == false
							&& TipoRegBox.getSelectedItem().toString().equals("") == false
							&& EstadoRegBox.getSelectedItem().toString().equals("") == false
							&& CorRegBox.getSelectedItem().toString().equals("") == false
							&& DescriRegtxt.getText().equals("") == false) {
						Core_Objetos.LerRegObj();
						if (JOptionPane.showConfirmDialog(null, "Quer confirmar o registo?", "",
								JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
							Core_Objetos.AddRegAdmin(NomeRegtxt.getText(), EmailRegtxt.getText(),
									SalaRegBox.getSelectedItem().toString(), Core_Objetos.date2(), Core_Objetos.hour(),
									CodigotxtReg.getText(), CorRegBox.getSelectedItem().toString(),
									EstadoRegBox.getSelectedItem().toString(), DescriRegtxt.getText());
							LimpaRegisto();
						}
					} else {
						JOptionPane.showMessageDialog(null,
								"Preencha todos os campos. \nNota : O nome não pode conter números",
								"Campos por preencher/dados incorretos.", JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		});
		ConfirmarBReg.setIcon(new ImageIcon(Design.class.getResource("/pt/caseclosed/resources/ConfirmBut.png")));
		ConfirmarBReg.setBounds(215, 409, 146, 38);
		Registo.add(ConfirmarBReg);

		JLabel BackinfoReg = new JLabel("");
		BackinfoReg.setIcon(new ImageIcon(Design.class.getResource("/pt/caseclosed/resources/Backinfo.png")));
		BackinfoReg.setBounds(215, 219, 449, 177);
		Registo.add(BackinfoReg);

		JLabel FundoReg = new JLabel("");
		FundoReg.setIcon(new ImageIcon(Design.class.getResource("/pt/caseclosed/resources/Background.png")));
		FundoReg.setBounds(32, 87, 601, 567);
		Registo.add(FundoReg);

		// -------------------------------------------------------------------------------
		// -------------------------------------------------------------------------------

		// Settings Reclamação Panel
		Reclamação = new JPanel();
		Reclamação.setBounds(0, 0, 721, 673);
		contentPane.add(Reclamação);
		Reclamação.setVisible(false);
		Reclamação.setLayout(null);
		Reclamação.setBorder(new EmptyBorder(5, 5, 5, 5));
		Reclamação.setBackground(Color.WHITE);

		JLabel TipoObjetoRec = new JLabel("Tipo");
		TipoObjetoRec.setForeground(Color.WHITE);
		TipoObjetoRec.setFont(new Font("Simply Rounded", Font.PLAIN, 14));
		TipoObjetoRec.setBounds(223, 231, 47, 14);
		Reclamação.add(TipoObjetoRec);

		TipoRecBox = new JComboBox<String>();
		TipoRecBox.setBackground(Color.WHITE);
		TipoRecBox.setBounds(257, 228, 86, 20);
		Reclamação.add(TipoRecBox);
		TipoRecBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (flagrec == true) {
					EstadoRecBox.setSelectedIndex(0);
					SalaRecBox.setSelectedIndex(0);
					CorRecBox.setSelectedIndex(0);
					DataRecBox.setSelectedIndex(0);
					LimiteRecBox.setSelectedIndex(0);

					FillListRec();
				}
			}
		});
		table = new JTable(mdlRec);
		table.setBounds(223, 289, 429, 97);
		table.setAutoCreateRowSorter(true);
		table.setRowSorter(sorterReclama);
		table.setDefaultEditor(Object.class, null);
		Reclamação.add(table);

		JScrollPane scrl = new JScrollPane(table);
		scrl.setBorder(null);
		scrl.setBounds(223, 322, 434, 173);
		Reclamação.add(scrl);

		JLabel lblData = new JLabel("Data");
		lblData.setForeground(Color.WHITE);
		lblData.setFont(new Font("Simply Rounded", Font.PLAIN, 14));
		lblData.setBounds(223, 256, 39, 14);
		Reclamação.add(lblData);

		JLabel lblCor = new JLabel("Sala");
		lblCor.setForeground(Color.WHITE);
		lblCor.setFont(new Font("Simply Rounded", Font.PLAIN, 14));
		lblCor.setBounds(351, 231, 39, 14);
		Reclamação.add(lblCor);

		SalaRecBox = new JComboBox<String>();
		SalaRecBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flagrec == true) {
					FilterRec();
				}
			}
		});
		SalaRecBox.setBackground(Color.WHITE);
		SalaRecBox.setBounds(398, 228, 86, 20);
		Reclamação.add(SalaRecBox);

		JLabel lblSala = new JLabel("Limite");
		lblSala.setForeground(Color.WHITE);
		lblSala.setFont(new Font("Simply Rounded", Font.PLAIN, 14));
		lblSala.setBounds(351, 256, 39, 14);
		Reclamação.add(lblSala);

		LimiteRecBox = new JComboBox<String>();
		LimiteRecBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flagrec == true) {
					FilterRec();
				}
			}
		});
		LimiteRecBox.setBackground(Color.WHITE);
		LimiteRecBox.setBounds(398, 253, 86, 20);
		Reclamação.add(LimiteRecBox);

		CorRecBox = new JComboBox<String>();
		CorRecBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flagrec == true) {
					FilterRec();
				}
			}
		});
		CorRecBox.setBackground(Color.WHITE);
		CorRecBox.setBounds(547, 228, 86, 20);
		Reclamação.add(CorRecBox);

		JLabel lblCor_1 = new JLabel("Cor");
		lblCor_1.setForeground(Color.WHITE);
		lblCor_1.setFont(new Font("Simply Rounded", Font.PLAIN, 14));
		lblCor_1.setBounds(496, 231, 39, 14);
		Reclamação.add(lblCor_1);

		DataRecBox = new JComboBox<String>();
		DataRecBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flagrec == true) {
					FilterRec();
				}
			}
		});
		DataRecBox.setBackground(Color.WHITE);
		DataRecBox.setBounds(257, 253, 86, 20);
		Reclamação.add(DataRecBox);

		JLabel lblEstado_1 = new JLabel("Estado");
		lblEstado_1.setForeground(Color.WHITE);
		lblEstado_1.setFont(new Font("Simply Rounded", Font.PLAIN, 14));
		lblEstado_1.setBounds(496, 256, 52, 14);
		Reclamação.add(lblEstado_1);

		EstadoRecBox = new JComboBox<String>();
		EstadoRecBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flagrec == true) {
					FilterRec();
				}
			}
		});
		EstadoRecBox.setBackground(Color.WHITE);
		EstadoRecBox.setBounds(547, 253, 86, 20);
		Reclamação.add(EstadoRecBox);

		JLabel DetalhesRec = new JLabel("Detalhes");
		DetalhesRec.setForeground(Color.WHITE);
		DetalhesRec.setFont(new Font("Simply Rounded", Font.PLAIN, 22));
		DetalhesRec.setBounds(223, 286, 116, 40);
		Reclamação.add(DetalhesRec);

		ConfirmarBRec = new JButton("");
		ConfirmarBRec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Codigo_Registo = table.getValueAt(table.getSelectedRow(), 2).toString();
				String FileName = table.getValueAt(table.getSelectedRow(), 0).toString().substring(3,
						table.getValueAt(table.getSelectedRow(), 0).toString().length()) + ".txt";

				Core_Objetos.RemoveRegObj(Codigo_Registo, FileName);
				mdlRec.removeRow(table.getSelectedRow());

			}
		});
		ConfirmarBRec.setContentAreaFilled(false);
		ConfirmarBRec.setIcon(new ImageIcon(Design.class.getResource("/pt/caseclosed/resources/ConfirmBut.png")));
		ConfirmarBRec.setBounds(215, 533, 146, 38);
		Reclamação.add(ConfirmarBRec);

		JLabel BackInfoRec = new JLabel("");
		BackInfoRec.setIcon(new ImageIcon(Design.class.getResource("/pt/caseclosed/resources/backinfo2large.png")));
		BackInfoRec.setBounds(215, 219, 449, 297);
		Reclamação.add(BackInfoRec);

		JLabel FundoRec = new JLabel("");
		FundoRec.setIcon(new ImageIcon(Design.class.getResource("/pt/caseclosed/resources/Background.png")));
		FundoRec.setBounds(32, 87, 601, 567);
		Reclamação.add(FundoRec);

		// ------------------------------------------------------------------------------------------------------------
		// ------------------------------------------------------------------------------------------------------------

		Listagens = new JPanel();
		Listagens.setBackground(Color.WHITE);
		Listagens.setBounds(0, 0, 721, 673);
		contentPane.add(Listagens);
		Listagens.setLayout(null);
		Listagens.setVisible(false);

		JLabel lblNewLabel = new JLabel("Ficheiro");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Simply Rounded", Font.PLAIN, 14));
		lblNewLabel.setBounds(223, 231, 62, 14);
		Listagens.add(lblNewLabel);

		TableListagens = new JTable(mdlList);
		TableListagens.setBounds(223, 289, 429, 97);
		TableListagens.setAutoCreateRowSorter(true);
		TableListagens.setRowSorter(sorterListagens);
		TableListagens.setDefaultEditor(Object.class, null);
		Listagens.add(TableListagens);

		JScrollPane scroll = new JScrollPane(TableListagens);
		scroll.setBorder(null);
		scroll.setBounds(223, 333, 434, 173);
		Listagens.add(scroll);

		SalaListBox = new JComboBox<String>();
		SalaListBox.setBackground(Color.WHITE);
		SalaListBox.setBorder(null);
		SalaListBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flaglist == true) {
					FilterListagens();
				}
			}
		});
		SalaListBox.setBounds(422, 228, 86, 20);
		Listagens.add(SalaListBox);

		CorListBox = new JComboBox<String>();
		CorListBox.setBackground(Color.WHITE);
		CorListBox.setBorder(null);
		CorListBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flaglist == true) {
					FilterListagens();
				}
			}
		});

		CorListBox.setBounds(565, 228, 86, 20);
		Listagens.add(CorListBox);

		JLabel lblDfinal = new JLabel("Limite");
		lblDfinal.setForeground(Color.WHITE);
		lblDfinal.setFont(new Font("Simply Rounded", Font.PLAIN, 14));
		lblDfinal.setBounds(375, 256, 46, 14);
		Listagens.add(lblDfinal);

		LimiteListBox = new JComboBox<String>();
		LimiteListBox.setBackground(Color.WHITE);
		LimiteListBox.setBorder(null);
		LimiteListBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flaglist == true) {
					FilterListagens();
				}
			}
		});
		LimiteListBox.setBounds(422, 253, 86, 20);
		Listagens.add(LimiteListBox);

		TipoListBox = new JComboBox<String>();
		TipoListBox.setBackground(Color.WHITE);
		TipoListBox.setBorder(null);
		TipoListBox.setBounds(277, 280, 86, 20);
		Listagens.add(TipoListBox);
		TipoListBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (flaglist == true) {
					FilterListagens();
				}
			}
		});

		JLabel lblData_1 = new JLabel("Data");
		lblData_1.setForeground(Color.WHITE);
		lblData_1.setFont(new Font("Simply Rounded", Font.PLAIN, 14));
		lblData_1.setBounds(223, 256, 46, 14);
		Listagens.add(lblData_1);

		DataListBox = new JComboBox<String>();
		DataListBox.setBackground(Color.WHITE);
		DataListBox.setBorder(null);
		DataListBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (flaglist == true) {
					FilterListagens();
				}
			}
		});
		DataListBox.setBounds(277, 253, 86, 20);
		Listagens.add(DataListBox);

		// ------------------------------------------------------------------------------------------------
		// ------------------------------------------------------------------------------------------------

		EstadoListBox = new JComboBox<String>();
		EstadoListBox.setBackground(Color.WHITE);
		EstadoListBox.setBorder(null);
		EstadoListBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flaglist == true) {
					FilterListagens();
				}
			}
		});
		EstadoListBox.setBounds(565, 253, 86, 20);
		Listagens.add(EstadoListBox);

		JLabel label = new JLabel("Detalhes");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Simply Rounded", Font.PLAIN, 22));
		label.setBounds(223, 297, 116, 40);
		Listagens.add(label);

		FicheiroBox = new JComboBox<String>();
		FicheiroBox.setBackground(Color.WHITE);
		FicheiroBox.setBorder(null);
		FicheiroBox.setBounds(277, 228, 86, 20);
		Listagens.add(FicheiroBox);
		FicheiroBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (flaglist == true) {
					if (FicheiroBox.getSelectedItem().toString().equals("") == false) {
						flaglist = false;
						FillBoxListagens();
					}
					flaglist = true;
				}
			}
		});

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setForeground(Color.WHITE);
		lblEstado.setFont(new Font("Simply Rounded", Font.PLAIN, 14));
		lblEstado.setBounds(515, 256, 46, 14);
		Listagens.add(lblEstado);

		JLabel label_17 = new JLabel("Sala");
		label_17.setForeground(Color.WHITE);
		label_17.setFont(new Font("Simply Rounded", Font.PLAIN, 14));
		label_17.setBounds(375, 231, 46, 14);
		Listagens.add(label_17);

		JLabel label_18 = new JLabel("Tipo");
		label_18.setForeground(Color.WHITE);
		label_18.setFont(new Font("Simply Rounded", Font.PLAIN, 14));
		label_18.setBounds(223, 283, 47, 14);
		Listagens.add(label_18);

		JLabel label_20 = new JLabel("Cor");
		label_20.setForeground(Color.WHITE);
		label_20.setFont(new Font("Simply Rounded", Font.PLAIN, 14));
		label_20.setBounds(515, 231, 46, 14);
		Listagens.add(label_20);

		JLabel label_15 = new JLabel("");
		label_15.setBounds(215, 219, 449, 297);
		Listagens.add(label_15);
		label_15.setIcon(new ImageIcon(Design.class.getResource("/pt/caseclosed/resources/backinfo2large.png")));

		JLabel label_14 = new JLabel("");
		label_14.setIcon(new ImageIcon(Design.class.getResource("/pt/caseclosed/resources/Background.png")));
		label_14.setBounds(32, 87, 601, 567);
		Listagens.add(label_14);

		// ------------------------------------------------------------------------------------------------
		// ------------------------------------------------------------------------------------------------

		Configs = new JPanel();
		Configs.setBackground(Color.WHITE);
		Configs.setBounds(0, 0, 721, 673);
		contentPane.add(Configs);
		Configs.setLayout(null);
		Configs.setVisible(false);

		JLabel lblSalas = new JLabel("Salas");
		lblSalas.setForeground(Color.WHITE);
		lblSalas.setFont(new Font("Simply Rounded", Font.PLAIN, 18));
		lblSalas.setBounds(228, 176, 116, 40);
		Configs.add(lblSalas);

		JLabel lblUsers = new JLabel("Users");
		lblUsers.setForeground(Color.WHITE);
		lblUsers.setFont(new Font("Simply Rounded", Font.PLAIN, 18));
		lblUsers.setBounds(228, 239, 116, 26);
		Configs.add(lblUsers);

		JLabel lblObjetos = new JLabel("Objetos");
		lblObjetos.setForeground(Color.WHITE);
		lblObjetos.setFont(new Font("Simply Rounded", Font.PLAIN, 18));
		lblObjetos.setBounds(534, 176, 116, 40);
		Configs.add(lblObjetos);

		JLabel lblUtilizador = new JLabel("Utilizador");
		lblUtilizador.setForeground(Color.WHITE);
		lblUtilizador.setFont(new Font("Simply Rounded", Font.PLAIN, 14));
		lblUtilizador.setBounds(367, 274, 61, 14);
		Configs.add(lblUtilizador);

		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setForeground(Color.WHITE);
		lblTipo.setFont(new Font("Simply Rounded", Font.PLAIN, 14));
		lblTipo.setBounds(534, 214, 46, 14);
		Configs.add(lblTipo);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Simply Rounded", Font.PLAIN, 14));
		lblPassword.setBounds(367, 302, 68, 14);
		Configs.add(lblPassword);

		JLabel lblAcesso = new JLabel("Acesso");
		lblAcesso.setForeground(Color.WHITE);
		lblAcesso.setFont(new Font("Simply Rounded", Font.PLAIN, 14));
		lblAcesso.setBounds(228, 330, 68, 14);
		Configs.add(lblAcesso);

		JLabel lblAdicionar = new JLabel("Adicionar");
		lblAdicionar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdicionar.setForeground(Color.WHITE);
		lblAdicionar.setFont(new Font("Simply Rounded", Font.PLAIN, 22));
		lblAdicionar.setBounds(394, 143, 96, 40);
		Configs.add(lblAdicionar);

		JLabel label_5 = new JLabel("Sala");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Simply Rounded", Font.PLAIN, 14));
		label_5.setBounds(228, 214, 46, 14);
		Configs.add(label_5);

		JLabel lblInst = new JLabel("Nome Inst.");
		lblInst.setForeground(Color.WHITE);
		lblInst.setFont(new Font("Simply Rounded", Font.PLAIN, 14));
		lblInst.setBounds(367, 214, 68, 14);
		Configs.add(lblInst);

		JLabel lblEditarRemover = new JLabel("Editar - Remover");
		lblEditarRemover.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditarRemover.setForeground(Color.WHITE);
		lblEditarRemover.setFont(new Font("Simply Rounded", Font.PLAIN, 22));
		lblEditarRemover.setBounds(344, 343, 196, 40);
		Configs.add(lblEditarRemover);

		TipoAdd = new JTextField();
		TipoAdd.setBorder(null);
		TipoAdd.setColumns(10);
		TipoAdd.setBounds(571, 211, 86, 20);
		TipoAdd.setDocument(new JTextFieldLimit(20));
		Configs.add(TipoAdd);

		SalaAdd = new JTextField();
		SalaAdd.setBorder(null);
		SalaAdd.setColumns(10);
		SalaAdd.setBounds(272, 211, 86, 20);
		SalaAdd.setDocument(new JTextFieldLimit(4));
		Configs.add(SalaAdd);

		UtilizadorAdd = new JTextField();
		UtilizadorAdd.setBorder(null);
		UtilizadorAdd.setColumns(10);
		UtilizadorAdd.setBounds(438, 271, 86, 20);
		Configs.add(UtilizadorAdd);

		PassAdd = new JTextField();
		PassAdd.setBorder(null);
		PassAdd.setColumns(10);
		PassAdd.setBounds(438, 299, 86, 20);
		Configs.add(PassAdd);

		InstAdd = new JTextField();
		InstAdd.setBorder(null);
		InstAdd.setColumns(10);
		InstAdd.setBounds(438, 211, 86, 20);
		InstAdd.setDocument(new JTextFieldLimit(20));
		Configs.add(InstAdd);

		AcessAdd = new JComboBox<String>();
		AcessAdd.setFont(new Font("Arial", Font.PLAIN, 9));
		AcessAdd.setBorder(null);
		AcessAdd.setBackground(Color.WHITE);
		AcessAdd.setBounds(272, 327, 86, 20);
		Configs.add(AcessAdd);

		ConfirmEdit = new JButton("");
		ConfirmEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					//Adiciona Instituição
					if (InstAdd.getText().equals("") == false) {
						Core_Inst.LerInst();
						Core_Inst.CriaIS(Integer.toString(Core_Inst.random()), InstAdd.getText());
					}

					// ------------------------------------------------------------------------------------------------
					// ------------------------------------------------------------------------------------------------
					//Adiciona Sala
					if (SalaAdd.getText().equals("") == false && Character.isLetter(SalaAdd.getText().charAt(0)) == true
							&& Character.isUpperCase(SalaAdd.getText().charAt(0)) == true) {
						Core_Sala.LerSalas();
						Core_Sala.Write_Salas(SalaAdd.getText());
					}
					if (SalaAdd.getText().equals("") == false
							&& (Character.isLetter(SalaAdd.getText().charAt(0)) == false
									|| Character.isUpperCase(SalaAdd.getText().charAt(0)) == false)) {
						JOptionPane.showMessageDialog(null, "Por favor introduza uma Sala valida, exemplo : B106",
								"Adicionar Sala - Erro", JOptionPane.INFORMATION_MESSAGE);
					}

					// ------------------------------------------------------------------------------------------------
					// ------------------------------------------------------------------------------------------------
					//Adiciona Tipo Objeto
					if (TipoAdd.getText().equals("") == false
							&& InstTipo.getSelectedItem().toString().equals("") == false) {
						Core_Objetos.LerTipo();

						Core_Objetos.AddTipo_Objetos(InstTipo.getSelectedItem().toString(), TipoAdd.getText());

					}
					if (TipoAdd.getText().equals("") == true
							&& InstTipo.getSelectedItem().toString().equals("") == false) {
						JOptionPane.showMessageDialog(null,
								"Por favor introduza um tipo de objeto os dados corretamente.",
								"Adicionar Objeto - Erro", JOptionPane.INFORMATION_MESSAGE);
					}
					if (TipoAdd.getText().equals("") == false
							&& InstTipo.getSelectedItem().toString().equals("") == true) {
						JOptionPane.showMessageDialog(null,
								"Por favor selecione uma Instituição para associoar ao objeto.",
								"Adicionar Objeto - Erro", JOptionPane.INFORMATION_MESSAGE);
					}

					// ------------------------------------------------------------------------------------------------
					// ------------------------------------------------------------------------------------------------
					//Adiciona Novo Utilizador
					if (NomeAdd.getText().equals("") == false && EmailAdd.getText().equals("") == false
							&& AcessAdd.getSelectedItem().toString().equals("") == false
							&& UtilizadorAdd.getText().equals("") == false && PassAdd.getText().equals("") == false
							&& PassAdd.getText().length() >= 4
							&& PassAdd.getText().toLowerCase().equals(NomeAdd.getText().toLowerCase()) == false
							&& PassAdd.getText().toLowerCase().equals(UtilizadorAdd.getText().toLowerCase()) == false) {
						Core_User.LerUser();
						Core_User.AddUser(UtilizadorAdd.getText(), PassAdd.getText(),
								AcessAdd.getSelectedItem().toString(), EmailAdd.getText(), NomeAdd.getText());
					}
					if ((NomeAdd.getText().equals("") == false && EmailAdd.getText().equals("") == true
							&& AcessAdd.getSelectedItem().toString().equals("") == true
							&& UtilizadorAdd.getText().equals("") == true && PassAdd.getText().equals("") == true) ||

							(NomeAdd.getText().equals("") == true && EmailAdd.getText().equals("") == false
									&& AcessAdd.getSelectedItem().toString().equals("") == true
									&& UtilizadorAdd.getText().equals("") == true
									&& PassAdd.getText().equals("") == true)
							||

							(NomeAdd.getText().equals("") == true && EmailAdd.getText().equals("") == true
									&& AcessAdd.getSelectedItem().toString().equals("") == false
									&& UtilizadorAdd.getText().equals("") == true
									&& PassAdd.getText().equals("") == true)
							||

							(NomeAdd.getText().equals("") == true && EmailAdd.getText().equals("") == true
									&& AcessAdd.getSelectedItem().toString().equals("") == true
									&& UtilizadorAdd.getText().equals("") == false
									&& PassAdd.getText().equals("") == true)
							||

							(NomeAdd.getText().equals("") == true && EmailAdd.getText().equals("") == true
									&& AcessAdd.getSelectedItem().toString().equals("") == true
									&& UtilizadorAdd.getText().equals("") == true
									&& PassAdd.getText().equals("") == false)
							||

							(PassAdd.getText().length() < 4 && PassAdd.getText().equals("") == false) ||

							(PassAdd.getText().toLowerCase().equals(NomeAdd.getText().toLowerCase()) == true
									&& PassAdd.getText().equals("") == false && NomeAdd.getText().equals("") == false)
							||

							(PassAdd.getText().toLowerCase().equals(UtilizadorAdd.getText().toLowerCase()) == true
									&& PassAdd.getText().equals("") == false
									&& UtilizadorAdd.getText().equals("") == false)) {
						JOptionPane.showMessageDialog(null, "Por favor preencha todos os dados corretamente.\n"
								+ "Exemplo :\n\n" + "Nome : Joao \n\n" + "Email : Joao@caseclosed.pt \n\n"
								+ "Selecione um nivel de acesso \n\n" + "Utilizador : JoaoUser \n\n"
								+ "Password : 1234 \n\n" + "A password deve cumprir os seguintes parametros : \n\n"
								+ "	- Ser maior que 4 caracteres.\n" + "	- Não pode ser igual ao Nome.\n"
								+ "	- Não pode ser igual ao nome de Utilizador.\n"
								+ "	- Pode conter caractéres especias tais como : +-#$@(/",
								"Informação de novo utilizador errada.", JOptionPane.INFORMATION_MESSAGE);
					}
					//Remove Sala
					if (SalaEdit.getSelectedItem().toString().equals("") == false && SalaRemove.isSelected() == true) {
						Core_Sala.RemoveSala(SalaEdit.getSelectedItem().toString());
					}
					//Edita Sala
					if (SalaEdit.getSelectedItem().toString().equals("") == false && SalaRemove.isSelected() == false) {
						
						if (SalaEditTXT.getText().equals("") == false && SalaRemove.isSelected() == false
								&& Character.isLetter(SalaEditTXT.getText().charAt(0)) == true
								&& Character.isUpperCase(SalaEditTXT.getText().charAt(0)) == true
								&& SalaEditTXT.getText().equals(SalaEdit.getSelectedItem().toString()) == false) {
							Core_Sala.RemoveSala(SalaEdit.getSelectedItem().toString());
							Core_Sala.Write_Salas(SalaEditTXT.getText());
						}

						if (SalaEditTXT.getText().equals("") == false && SalaRemove.isSelected() == false
								&& (Character.isLetter(SalaEditTXT.getText().charAt(0)) == false
										|| Character.isUpperCase(SalaEditTXT.getText().charAt(0)) == false
										|| SalaEditTXT.getText()
												.equals(SalaEdit.getSelectedItem().toString()) == true)) {
							JOptionPane.showMessageDialog(null,
									"Por favor introduza uma Sala valida, exemplo : B106\nA sala deve ser diferente da seleção a editar.",
									"Editar Sala - Erro", JOptionPane.INFORMATION_MESSAGE);
						}
					}

					// ------------------------------------------------------------------------------------------------
					// ------------------------------------------------------------------------------------------------

					// Remove Tipo Objeto
					if (TipoEdit.getSelectedItem().toString().equals("") == false && ObjRemove.isSelected() == true) {
						boolean flag = false;
						File dir = new File(".");
						List<File> list = Arrays.asList(dir.listFiles(new FilenameFilter() {
							@Override
							public boolean accept(File dir, String name) {

								return name.matches("[0-9]{2}[-][0-9]{4}(.txt)"); 
							}
						}));
						for (int j = 0; j < list.size(); j++) {

							Core_Objetos.CustomFillList(
									list.get(j).toString().substring(2, list.get(j).toString().length()));

							for (int i = 0; i < Core_Objetos.newObjAdmin.size(); i++) {
								if (Core_Objetos.newObjAdmin.get(i).getCod_to()
										.equals(TipoEdit.getSelectedItem().toString()) == true) {
									flag = true;
								}
							}
						}
						if (flag == true) {
							Core_Objetos.RemoveTipo(TipoEdit.getSelectedItem().toString());
						} else {
							JOptionPane.showMessageDialog(null,
									"Este Objeto ainda tem Registos associados.\nDoe ou Reclame os objetos para poder remover este tipo de Objeto");
						}
					}
					//Edita Tipo Objeto e altera instituições associadas a registos pré feitos
					if (TipoEdit.getSelectedItem().toString().equals("") == false && ObjRemove.isSelected() == false) {
						String Cod =Core_Objetos.GetCodigo( TipoEdit.getSelectedItem().toString());
						Core_Objetos.RemoveTipo(TipoEdit.getSelectedItem().toString());
						Core_Objetos.EditTipo_Objetos(ObjEditTXT.getText(), TipoEdit.getSelectedItem().toString(),Cod);
						Core_Objetos.DOA.delete();
						try {
							CheckDoações();
						} catch (ParseException e) {
							e.printStackTrace();
						}
					}

					// ------------------------------------------------------------------------------------------------
					// ------------------------------------------------------------------------------------------------

					// Remove Instituição
					if (SelectInstEdit.getSelectedItem().toString().equals("") == false
							&& InstRemove.isSelected() == true) {
						if (Core_Inst.ProcuraTipo(SelectInstEdit.getSelectedItem().toString()) == false) {
							Core_Inst.RemoveInst(SelectInstEdit.getSelectedItem().toString());
						} else {
							JOptionPane.showMessageDialog(null,
									"Esta Instituição encontra~se associada a um Objeto, por favor remova esse Objeto");
						}
					}

					// Edita Instituição
					if (SelectInstEdit.getSelectedItem().toString().equals("") == false
							&& InstRemove.isSelected() == false) {
						if (Core_Inst.ProcuraTipo(SelectInstEdit.getSelectedItem().toString()) == false) {
							Core_Inst.RemoveInst(SelectInstEdit.getSelectedItem().toString());
							Core_Inst.CriaIS(Integer.toString(Core_Inst.random()), InstEditTXT.getText());
						} else {
							JOptionPane.showMessageDialog(null,
									"Esta Instituição encontra~se associada a um Objeto, por favor remova esse Objeto");
						}
					}
					/*Faz verificações se todos os 
					 *campos estao devidamente preenchidos
					 *Edita Utilizador
					 */
					if (NomeEdit.getText().equals("") == false && EmailEdit.getText().equals("") == false
							&& AcessEdit.getSelectedItem().toString().equals("") == false
							&& UserEdit.getText().equals("") == false && PassEdit.getText().equals("") == false
							&& PassEdit.getText().length() >= 4
							&& PassEdit.getText().toLowerCase().equals(NomeEdit.getText().toLowerCase()) == false
							&& PassEdit.getText().toLowerCase().equals(UserEdit.getText().toLowerCase()) == false
							&& UserRemove.isSelected() == false) {
						Core_User.RemoveUser(UserEdit.getText());
						Core_User.AddUser(UserEdit.getText(), PassEdit.getText(),
								AcessEdit.getSelectedItem().toString(), EmailEdit.getText(), NomeEdit.getText());
					}
					//Remove Utilizador
					if (NomeEdit.getText().equals("") == false && EmailEdit.getText().equals("") == false
							&& AcessEdit.getSelectedItem().toString().equals("") == false
							&& UserEdit.getText().equals("") == false && PassEdit.getText().equals("") == false
							&& PassEdit.getText().length() >= 4
							&& PassEdit.getText().toLowerCase().equals(NomeEdit.getText().toLowerCase()) == false
							&& PassEdit.getText().toLowerCase().equals(UserEdit.getText().toLowerCase()) == false
							&& UserRemove.isSelected() == true) {
						Core_User.RemoveUser(UserEdit.getText());

					}
					if ((NomeEdit.getText().equals("") == false && EmailEdit.getText().equals("") == true
							&& AcessEdit.getSelectedItem().toString().equals("") == true
							&& UserEdit.getText().equals("") == true && PassEdit.getText().equals("") == true) ||

							(NomeEdit.getText().equals("") == true && EmailEdit.getText().equals("") == false
									&& AcessEdit.getSelectedItem().toString().equals("") == true
									&& UserEdit.getText().equals("") == true && PassEdit.getText().equals("") == true)
							||

							(NomeEdit.getText().equals("") == true && EmailEdit.getText().equals("") == true
									&& AcessEdit.getSelectedItem().toString().equals("") == false
									&& UserEdit.getText().equals("") == true && PassEdit.getText().equals("") == true)
							||

							(NomeEdit.getText().equals("") == true && EmailEdit.getText().equals("") == true
									&& AcessEdit.getSelectedItem().toString().equals("") == true
									&& UserEdit.getText().equals("") == false && PassEdit.getText().equals("") == true)
							||

							(NomeEdit.getText().equals("") == true && EmailEdit.getText().equals("") == true
									&& AcessEdit.getSelectedItem().toString().equals("") == true
									&& UserEdit.getText().equals("") == true && PassEdit.getText().equals("") == false)
							||

							(PassEdit.getText().length() < 4 && PassEdit.getText().equals("") == false) ||

							(PassEdit.getText().toLowerCase().equals(NomeEdit.getText().toLowerCase()) == true
									&& PassEdit.getText().equals("") == false && NomeEdit.getText().equals("") == false)
							||

							(PassEdit.getText().toLowerCase().equals(UserEdit.getText().toLowerCase()) == true
									&& PassEdit.getText().equals("") == false
									&& UserEdit.getText().equals("") == false)) {
						JOptionPane.showMessageDialog(null, "Por favor preencha todos os dados corretamente.\n"
								+ "Exemplo :\n\n" + "Nome : Joao \n\n" + "Email : Joao@caseclosed.pt \n\n"
								+ "Selecione um nivel de acesso \n\n" + "Utilizador : JoaoUser \n\n"
								+ "Password : 1234 \n\n" + "A password deve cumprir os seguintes parametros : \n\n"
								+ "	- Ser maior que 4 caracteres.\n" + "	- Não pode ser igual ao Nome.\n"
								+ "	- Não pode ser igual ao nome de Utilizador.\n"
								+ "	- Pode conter caractéres especias tais como : +-#$@(/",
								"Por favor edite os campos de utilizador corretamente.",
								JOptionPane.INFORMATION_MESSAGE);
					}
					flagconfig = false;
					FillConfig();
					flagconfig = true;
					CleanConfig();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		ConfirmEdit.setContentAreaFilled(false);
		ConfirmEdit.setIcon(new ImageIcon(Design.class.getResource("/pt/caseclosed/resources/smallConfirm2.png")));
		ConfirmEdit.setBounds(218, 610, 121, 26);
		Configs.add(ConfirmEdit);

		EmailAdd = new JTextField();
		EmailAdd.setBorder(null);
		EmailAdd.setColumns(10);
		EmailAdd.setBounds(272, 299, 86, 20);
		Configs.add(EmailAdd);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Simply Rounded", Font.PLAIN, 14));
		lblEmail.setBounds(228, 302, 61, 14);
		Configs.add(lblEmail);

		NomeAdd = new JTextField();
		NomeAdd.setBorder(null);
		NomeAdd.setColumns(10);
		NomeAdd.setBounds(272, 271, 86, 20);
		Configs.add(NomeAdd);

		JLabel label_2 = new JLabel("Salas");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Simply Rounded", Font.PLAIN, 18));
		label_2.setBounds(228, 380, 116, 40);
		Configs.add(label_2);

		JLabel label_3 = new JLabel("Sala");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Simply Rounded", Font.PLAIN, 14));
		label_3.setBounds(228, 418, 46, 14);
		Configs.add(label_3);

		JLabel label_4 = new JLabel("Users");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Simply Rounded", Font.PLAIN, 18));
		label_4.setBounds(228, 485, 61, 26);
		Configs.add(label_4);

		JLabel label_6 = new JLabel("Nome");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Simply Rounded", Font.PLAIN, 14));
		label_6.setBounds(228, 545, 68, 14);
		Configs.add(label_6);

		JLabel label_7 = new JLabel("Email");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Simply Rounded", Font.PLAIN, 14));
		label_7.setBounds(228, 573, 61, 14);
		Configs.add(label_7);

		JLabel label_8 = new JLabel("Acesso");
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Simply Rounded", Font.PLAIN, 14));
		label_8.setBounds(367, 573, 68, 14);
		Configs.add(label_8);

		AcessEdit = new JComboBox<String>();
		AcessEdit.setFont(new Font("Arial", Font.PLAIN, 9));
		AcessEdit.setBorder(null);
		AcessEdit.setBackground(Color.WHITE);
		AcessEdit.setBounds(438, 570, 86, 20);
		Configs.add(AcessEdit);

		EmailEdit = new JTextField();
		EmailEdit.setColumns(10);
		EmailEdit.setBorder(null);
		EmailEdit.setBounds(272, 570, 86, 20);
		Configs.add(EmailEdit);

		NomeEdit = new JTextField();
		NomeEdit.setColumns(10);
		NomeEdit.setBorder(null);
		NomeEdit.setBounds(272, 542, 86, 20);
		Configs.add(NomeEdit);

		JLabel label_9 = new JLabel("Utilizador");
		label_9.setForeground(Color.WHITE);
		label_9.setFont(new Font("Simply Rounded", Font.PLAIN, 14));
		label_9.setBounds(367, 520, 61, 14);
		Configs.add(label_9);

		JLabel label_10 = new JLabel("Password");
		label_10.setForeground(Color.WHITE);
		label_10.setFont(new Font("Simply Rounded", Font.PLAIN, 14));
		label_10.setBounds(367, 548, 68, 14);
		Configs.add(label_10);

		UserEdit = new JTextField();
		UserEdit.setEditable(false);
		UserEdit.setColumns(10);
		UserEdit.setBorder(null);
		UserEdit.setBounds(438, 517, 86, 20);
		Configs.add(UserEdit);

		PassEdit = new JTextField();
		PassEdit.setColumns(10);
		PassEdit.setBorder(null);
		PassEdit.setBounds(438, 545, 86, 20);
		Configs.add(PassEdit);

		SelectInstEdit = new JComboBox<String>();
		SelectInstEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flagconfig == true) {
					if (SelectInstEdit.getSelectedItem().toString().equals("") == false) {
						InstEditTXT.setText(SelectInstEdit.getSelectedItem().toString());
					}
				}
			}
		});
		SelectInstEdit.setFont(new Font("Arial", Font.PLAIN, 9));
		SelectInstEdit.setBorder(null);
		SelectInstEdit.setBackground(Color.WHITE);
		SelectInstEdit.setBounds(438, 415, 86, 20);
		Configs.add(SelectInstEdit);

		JLabel lblSelec = new JLabel("Selec.");
		lblSelec.setForeground(Color.WHITE);
		lblSelec.setFont(new Font("Simply Rounded", Font.PLAIN, 14));
		lblSelec.setBounds(228, 518, 68, 14);
		Configs.add(lblSelec);

		JLabel lblInst_1 = new JLabel("Inst.");
		lblInst_1.setForeground(Color.WHITE);
		lblInst_1.setFont(new Font("Simply Rounded", Font.PLAIN, 14));
		lblInst_1.setBounds(534, 245, 68, 14);
		Configs.add(lblInst_1);

		InstTipo = new JComboBox<String>();
		InstTipo.setFont(new Font("Arial", Font.PLAIN, 9));
		InstTipo.setBorder(null);
		InstTipo.setBackground(Color.WHITE);
		InstTipo.setBounds(571, 242, 86, 20);
		Configs.add(InstTipo);

		SelectUser = new JComboBox<String>();
		SelectUser.setFont(new Font("Arial", Font.PLAIN, 9));
		SelectUser.setBorder(null);
		SelectUser.setBackground(Color.WHITE);
		SelectUser.setBounds(272, 515, 86, 20);
		Configs.add(SelectUser);
		SelectUser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (flagconfig == true) {
					if (SelectUser.getSelectedItem().equals("") == false) {
						Core_User.LerUser();
						NomeEdit.setText(Core_User.user.get(SelectUser.getSelectedIndex() - 1).getNome());
						EmailEdit.setText(Core_User.user.get(SelectUser.getSelectedIndex() - 1).getEmail());
						UserEdit.setText(Core_User.user.get(SelectUser.getSelectedIndex() - 1).getUsername());
						PassEdit.setText(Core_User.user.get(SelectUser.getSelectedIndex() - 1).getPassword());
						AcessEdit.setSelectedItem(Core_User.user.get(SelectUser.getSelectedIndex() - 1).getAcesso());
					}
				}
			}
		});

		JLabel label_11 = new JLabel("Tipo");
		label_11.setForeground(Color.WHITE);
		label_11.setFont(new Font("Simply Rounded", Font.PLAIN, 14));
		label_11.setBounds(534, 418, 46, 14);
		Configs.add(label_11);

		JLabel label_12 = new JLabel("Objetos");
		label_12.setForeground(Color.WHITE);
		label_12.setFont(new Font("Simply Rounded", Font.PLAIN, 18));
		label_12.setBounds(534, 380, 116, 40);
		Configs.add(label_12);

		JLabel label_13 = new JLabel("Institui\u00E7\u00F5es");
		label_13.setForeground(Color.WHITE);
		label_13.setFont(new Font("Simply Rounded", Font.PLAIN, 18));
		label_13.setBounds(367, 388, 116, 25);
		Configs.add(label_13);

		JLabel lblNome = new JLabel("Nome Inst.");
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Simply Rounded", Font.PLAIN, 14));
		lblNome.setBounds(367, 418, 68, 14);
		Configs.add(lblNome);

		SalaEdit = new JComboBox<String>();
		SalaEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (flagconfig == true) {
					if (SalaEdit.getSelectedItem().toString().equals("") == false) {
						SalaEditTXT.setText("");
						SalaEditTXT.setText(SalaEdit.getSelectedItem().toString());
					}
				}
			}
		});
		SalaEdit.setFont(new Font("Arial", Font.PLAIN, 9));
		SalaEdit.setBorder(null);
		SalaEdit.setBackground(Color.WHITE);
		SalaEdit.setBounds(272, 415, 86, 20);
		Configs.add(SalaEdit);

		TipoEdit = new JComboBox<String>();
		TipoEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flagconfig == true) {
					if (TipoEdit.getSelectedItem().toString().equals("") == false) {
						ObjEditTXT.setText("");
						try {
							ObjEditTXT.setText(Core_Objetos.GetInst(TipoEdit.getSelectedItem().toString()));
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});
		TipoEdit.setFont(new Font("Arial", Font.PLAIN, 9));
		TipoEdit.setBorder(null);
		TipoEdit.setBackground(Color.WHITE);
		TipoEdit.setBounds(571, 415, 86, 20);
		Configs.add(TipoEdit);

		UserRemove = new JRadioButton("Remover");
		UserRemove.setForeground(Color.WHITE);
		UserRemove.setContentAreaFilled(false);
		UserRemove.setBorder(null);
		UserRemove.setBackground(new Color(240, 240, 240));
		UserRemove.setFont(new Font("Simply Rounded", Font.PLAIN, 14));
		UserRemove.setBounds(534, 568, 127, 25);
		Configs.add(UserRemove);

		SalaEditTXT = new JTextField();
		SalaEditTXT.setBorder(null);
		SalaEditTXT.setBounds(272, 440, 86, 22);
		SalaEditTXT.setDocument(new JTextFieldLimit(4));
		SalaEditTXT.setColumns(10);
		Configs.add(SalaEditTXT);

		SalaRemove = new JRadioButton("Remover");
		SalaRemove.setForeground(Color.WHITE);
		SalaRemove.setFont(new Font("Simply Rounded", Font.PLAIN, 14));
		SalaRemove.setContentAreaFilled(false);
		SalaRemove.setBorder(null);
		SalaRemove.setBackground(SystemColor.menu);
		SalaRemove.setBounds(272, 464, 86, 25);
		Configs.add(SalaRemove);

		InstEditTXT = new JTextField();
		InstEditTXT.setBorder(null);
		InstEditTXT.setColumns(10);
		InstEditTXT.setDocument(new JTextFieldLimit(20));
		InstEditTXT.setBounds(438, 440, 86, 22);
		Configs.add(InstEditTXT);

		ObjEditTXT = new JTextField();
		ObjEditTXT.setEditable(false);
		ObjEditTXT.setColumns(10);
		ObjEditTXT.setDocument(new JTextFieldLimit(20));
		ObjEditTXT.setBounds(571, 440, 86, 22);
		Configs.add(ObjEditTXT);

		ObjRemove = new JRadioButton("Remover");
		ObjRemove.setForeground(Color.WHITE);
		ObjRemove.setFont(new Font("Simply Rounded", Font.PLAIN, 14));
		ObjRemove.setContentAreaFilled(false);
		ObjRemove.setBorder(null);
		ObjRemove.setBackground(SystemColor.menu);
		ObjRemove.setBounds(571, 487, 86, 25);
		Configs.add(ObjRemove);

		InstTipoEdit = new JComboBox<String>();
		InstTipoEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flagconfig == true) {
					if (InstTipoEdit.getSelectedItem().toString().equals("") == false
							&& TipoEdit.getSelectedItem().toString().equals("") == false) {
						ObjEditTXT.setText("");
						ObjEditTXT.setText(InstTipoEdit.getSelectedItem().toString());
					}
				}
			}
		});
		InstTipoEdit.setFont(new Font("Arial", Font.PLAIN, 9));
		InstTipoEdit.setBorder(null);
		InstTipoEdit.setBackground(Color.WHITE);
		InstTipoEdit.setBounds(571, 468, 86, 20);
		Configs.add(InstTipoEdit);

		InstRemove = new JRadioButton("Remover");
		InstRemove.setForeground(Color.WHITE);
		InstRemove.setFont(new Font("Simply Rounded", Font.PLAIN, 14));
		InstRemove.setContentAreaFilled(false);
		InstRemove.setBorder(null);
		InstRemove.setBackground(SystemColor.menu);
		InstRemove.setBounds(438, 464, 86, 25);
		Configs.add(InstRemove);

		JLabel lblNomeadd = new JLabel("Nome");
		lblNomeadd.setForeground(Color.WHITE);
		lblNomeadd.setFont(new Font("Simply Rounded", Font.PLAIN, 14));
		lblNomeadd.setBounds(228, 274, 68, 14);
		Configs.add(lblNomeadd);

		JLabel label_1 = new JLabel("Institui\u00E7\u00F5es");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Simply Rounded", Font.PLAIN, 18));
		label_1.setBounds(367, 184, 116, 25);
		Configs.add(label_1);

		JLabel BackInfoConfig = new JLabel("");
		BackInfoConfig.setIcon(new ImageIcon(Design.class.getResource("/pt/caseclosed/resources/backinfo2large.png")));
		BackInfoConfig.setBounds(218, 143, 449, 458);
		Configs.add(BackInfoConfig);

		JLabel BackConfig = new JLabel("");
		BackConfig.setIcon(new ImageIcon(Design.class.getResource("/pt/caseclosed/resources/Background.png")));
		BackConfig.setBounds(32, 87, 601, 567);
		Configs.add(BackConfig);

		Doações = new JPanel();
		Doações.setBackground(Color.WHITE);
		Doações.setBounds(0, 0, 721, 667);
		Doações.setVisible(false);
		contentPane.add(Doações);
		Doações.setLayout(null);

		InstDoaBox = new JComboBox<String>();
		InstDoaBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (flagdoa == true) {
					FilterDoa();
				}
			}
		});
		InstDoaBox.setBackground(Color.WHITE);
		InstDoaBox.setBounds(295, 230, 86, 20);
		Doações.add(InstDoaBox);

		JLabel lblInstituio = new JLabel("Institui\u00E7\u00E3o");
		lblInstituio.setForeground(Color.WHITE);
		lblInstituio.setFont(new Font("Simply Rounded", Font.PLAIN, 14));
		lblInstituio.setBounds(224, 233, 71, 14);
		Doações.add(lblInstituio);

		JButton ConfirmDoa = new JButton("");
		ConfirmDoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (TableDoa.getSelectedRow() > -1) {
					String Codigo_Registo = TableDoa.getValueAt(TableDoa.getSelectedRow(), 5).toString();
					String FileInst = TableDoa.getValueAt(TableDoa.getSelectedRow(), 6).toString() + ".txt";
					String FileData = TableDoa.getValueAt(TableDoa.getSelectedRow(), 0).toString().substring(3,
							TableDoa.getValueAt(TableDoa.getSelectedRow(), 0).toString().length()) + ".txt";
					Core_Objetos.AdicionaDoa(Codigo_Registo, "Doações.txt", FileInst);
					Core_Objetos.RemoveRegObj(Codigo_Registo, "Doações.txt");
					Core_Objetos.RemoveRegObj(Codigo_Registo, FileData); 
					mdlDoa.removeRow(TableDoa.getSelectedRow());
				}
			}
		});
		ConfirmDoa.setIcon(new ImageIcon(Design.class.getResource("/pt/caseclosed/resources/ConfirmBut.png")));
		ConfirmDoa.setContentAreaFilled(false);
		ConfirmDoa.setBounds(215, 534, 146, 38);
		Doações.add(ConfirmDoa);

		TableDoa = new JTable(mdlDoa);
		TableDoa.setBounds(224, 304, 428, 201);
		TableDoa.setAutoCreateRowSorter(true);
		TableDoa.setDefaultEditor(Object.class, null);
		TableDoa.setRowSorter(sorterDoa);
		Doações.add(TableDoa);

		JScrollPane scrlDoa = new JScrollPane(TableDoa);
		scrlDoa.setBorder(null);
		scrlDoa.setBounds(224, 304, 428, 201);
		Doações.add(scrlDoa);

		JLabel label_21 = new JLabel("Detalhes");
		label_21.setForeground(Color.WHITE);
		label_21.setFont(new Font("Simply Rounded", Font.PLAIN, 22));
		label_21.setBounds(224, 263, 116, 40);
		Doações.add(label_21);

		JLabel label_19 = new JLabel("");
		label_19.setIcon(new ImageIcon(Design.class.getResource("/pt/caseclosed/resources/backinfo2large.png")));
		label_19.setBounds(215, 219, 449, 297);
		Doações.add(label_19);

		JLabel label_22 = new JLabel("");
		label_22.setIcon(new ImageIcon(Design.class.getResource("/pt/caseclosed/resources/Background.png")));
		label_22.setBounds(32, 87, 601, 567);
		Doações.add(label_22);

		Importação = new JPanel();
		Importação.setBackground(Color.WHITE);
		Importação.setBounds(0, 0, 721, 673);
		contentPane.add(Importação);
		Importação.setLayout(null);
		Importação.setVisible(false);

		TableImport = new JTable(mdlImport);
		TableImport.setBounds(223, 253, 429, 133);
		TableImport.setAutoCreateRowSorter(true);
		TableImport.setDefaultEditor(Object.class, null);
		Importação.add(TableImport);

		JScrollPane scrlImport = new JScrollPane(TableImport);
		scrlImport.setBorder(null);
		scrlImport.setBounds(224, 304, 428, 201);
		Importação.add(scrlImport);

		JButton ImportButton = new JButton("");
		ImportButton.setIcon(new ImageIcon(Design.class.getResource("/pt/caseclosed/resources/ImportarBut.png")));
		ImportButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jfc = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Ficheiros de Texto", "txt", "text");
				jfc.setFileFilter(filter);
				jfc.showDialog(null, "Confirm");
				jfc.setVisible(true);
				filename = jfc.getSelectedFile();

				mdlImport.setColumnCount(0);
				mdlImport.addColumn("Data");
				mdlImport.addColumn("Tipo");
				mdlImport.addColumn("Cor");
				mdlImport.addColumn("Sala");
				mdlImport.addColumn("Estado");
				mdlImport.addColumn("Descri.");
				mdlImport.setRowCount(0);

				Core_Objetos.LerRegOnline(filename);
				PathFileTXT.setText(filename.toString());

				for (int i = 0; i < Core_Objetos.newObjSeg.size(); i++) {
					mdlImport.addRow(new Object[] { Core_Objetos.newObjSeg.get(i).getData().toString(),
							Core_Objetos.newObjSeg.get(i).getCod_to().toString(),
							Core_Objetos.newObjSeg.get(i).getCor().toString(),
							Core_Objetos.newObjSeg.get(i).getSala().toString(),
							Core_Objetos.newObjSeg.get(i).getEstado().toString(),
							Core_Objetos.newObjSeg.get(i).getDescrição().toString(), });
				}
			}
		});

		JLabel label_16 = new JLabel("Detalhes");
		label_16.setForeground(Color.WHITE);
		label_16.setFont(new Font("Simply Rounded", Font.PLAIN, 22));
		label_16.setBounds(224, 263, 116, 40);
		Importação.add(label_16);
		ImportButton.setBounds(224, 226, 80, 29);
		Importação.add(ImportButton);

		PathFileTXT = new JTextField();
		PathFileTXT.setBorder(null);
		PathFileTXT.setEditable(false);
		PathFileTXT.setBounds(311, 229, 341, 22);
		Importação.add(PathFileTXT);
		PathFileTXT.setColumns(10);

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (mdlImport.getRowCount() > 0) {
					if (JOptionPane.showConfirmDialog(null, "Quer confirmar o registo?", "",
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						for (int i = 0; i < Core_Objetos.newObjSeg.size(); i++) {
							try {
								
								Core_Objetos.AddRegAdmin(Core_Objetos.newObjSeg.get(i).getNomereg().toString(),
										Core_Objetos.newObjSeg.get(i).getMailreg().toString(),
										Core_Objetos.newObjSeg.get(i).getSala().toString(),
										Core_Objetos.newObjSeg.get(i).getData().toString(),
										Core_Objetos.newObjSeg.get(i).getHora().toString().substring(0, 5),
										Core_Objetos.newObjSeg.get(i).getCod_to().toString(),
										Core_Objetos.newObjSeg.get(i).getCor().toString(),
										Core_Objetos.newObjSeg.get(i).getEstado().toString(),
										Core_Objetos.newObjSeg.get(i).getDescrição().toString());

							} catch (IOException e) {
								e.printStackTrace();
							}
							mdlImport.setRowCount(0);
							PathFileTXT.setText("");
						}
					}
				}
			}
		});
		button.setIcon(new ImageIcon(Design.class.getResource("/pt/caseclosed/resources/ConfirmBut.png")));
		button.setContentAreaFilled(false);
		button.setBounds(218, 530, 146, 38);
		Importação.add(button);

		JLabel BackInfoImport = new JLabel("");
		BackInfoImport.setIcon(new ImageIcon(Design.class.getResource("/pt/caseclosed/resources/backinfo2large.png")));
		BackInfoImport.setBounds(215, 219, 449, 297);
		Importação.add(BackInfoImport);

		JLabel BackImport = new JLabel("");
		BackImport.setIcon(new ImageIcon(Design.class.getResource("/pt/caseclosed/resources/Background.png")));
		BackImport.setBounds(32, 87, 601, 567);
		Importação.add(BackImport);
	}
}
