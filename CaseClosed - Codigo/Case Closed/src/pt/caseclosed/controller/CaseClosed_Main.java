package pt.caseclosed.controller;

import java.awt.EventQueue;
import pt.caseclosed.view.Design;

public class CaseClosed_Main {
	/**
	 * Verifica Objetos eligiveis para Doação Verifica ficheiro de Utilizadores
	 * Caso nao exista , é criado um com Login de Admin Arranca o programa
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Design.CheckDoações();
					Core_User.LerUser();
					Design frame = new Design();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
