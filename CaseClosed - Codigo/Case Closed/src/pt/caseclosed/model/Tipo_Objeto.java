package pt.caseclosed.model;

public class Tipo_Objeto {
	private String AddCod_to,objeto,Inst;
	
	public Tipo_Objeto(String AddCod_to,String objeto,String Inst)
	{
		this.AddCod_to = AddCod_to;
		this.objeto = objeto;
		this.Inst=Inst;
	}
	public Tipo_Objeto()
	{}

	public String getInst() {
		return Inst;
	}

	public void setInst(String inst) {
		Inst = inst;
	}
	
	public String getAddCod_to() {
		return AddCod_to;
	}

	public void setAddCod_to(String addCod_to) {
		AddCod_to = addCod_to;
	}
	
	public String getObjeto() {
		return objeto;
	}

	public void setObjeto(String objeto) {
		this.objeto = objeto;
	}
	
	@Override
	public String toString()
	{
		return objeto;
	}

}
