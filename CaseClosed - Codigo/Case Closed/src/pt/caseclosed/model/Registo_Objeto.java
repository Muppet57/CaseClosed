package pt.caseclosed.model;

public class Registo_Objeto {
	private String codregisto,nomereg,mailreg,sala,data,hora,cod_to,cor,estado,descrição,inst;


	//Utilizado para guardar Objetos de Registo Objetos
	public Registo_Objeto(String codregisto, String nomereg, String mailreg, String sala, String data, String hora,
			String cod_to,String cor, String estado, String descrição) {
		this.codregisto=codregisto;
		this.nomereg = nomereg;
		this.mailreg = mailreg;
		this.sala = sala;
		this.data = data;
		this.hora = hora;
		this.cod_to = cod_to;
		this.cor = cor;
		this.estado = estado;
		this.descrição = descrição;
	}
	//Utilizado para guardar objetos de Doação
	public Registo_Objeto(String codregisto, String nomereg, String mailreg, String sala, String data, String hora,
			String cod_to,String cor, String estado, String descrição,String inst) {
		this.codregisto=codregisto;
		this.nomereg = nomereg;
		this.mailreg = mailreg;
		this.sala = sala;
		this.data = data;
		this.hora = hora;
		this.cod_to = cod_to;
		this.cor = cor;
		this.estado = estado;
		this.descrição = descrição;
		this.inst=inst;
	}
	//Utilizado para guardar objetos de Importação
	public Registo_Objeto(String Data, String Hora, String Nome, String Email, String Sala, String Tipo, 
			String Cor, String estado, String descrição) {
		this.data = Data;
		this.hora = Hora;
		this.nomereg = Nome;
		this.mailreg = Email;
		this.sala = Sala;
		this.cod_to = Tipo;
		this.cor = Cor;
		this.estado = estado;
		this.descrição = descrição;
	}
	
	public String getInst() {
		return inst;
	}

	public void setInst(String inst) {
		this.inst = inst;
	}
	
	public String getCodregisto() {
		return codregisto;
	}

	public void setCodregisto(String codregisto) {
		this.codregisto = codregisto;
	}

	public String getNomereg() {
		return nomereg;
	}

	public void setNomereg(String nomereg) {
		this.nomereg = nomereg;
	}

	public String getMailreg() {
		return mailreg;
	}

	public void setMailreg(String mailreg) {
		this.mailreg = mailreg;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
	
	public String getCod_to() {
		return cod_to;
	}

	public void setCod_to(String cod_to) {
		this.cod_to = cod_to;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDescrição() {
		return descrição;
	}

	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}
}