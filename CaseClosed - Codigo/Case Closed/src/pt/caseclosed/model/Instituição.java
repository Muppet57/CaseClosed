package pt.caseclosed.model;
public class Instituição {
	private String Codigo_IS;
	private String nome_IS;
	
	public Instituição(String Codigo_IS,String nome_IS){
		this.Codigo_IS=Codigo_IS;
		this.nome_IS=nome_IS;
	}

	public String getCodigo_IS() {
		return Codigo_IS;
	}
	public void setCodigo_IS(String codigo_IS) {
		Codigo_IS = codigo_IS;
	}
	public String getNome_IS() {
		return nome_IS;
	}
	public void setNome_IS(String nome_IS) {
		this.nome_IS = nome_IS;
	}
	
	@Override
	public String toString()
	{
		return nome_IS;
	}
}
