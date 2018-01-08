package pt.caseclosed.model;
public class Sala {
	private String Salas;
	
	public Sala(String salas)
	{
		this.Salas=salas;
	}
	public String getSalas() {
		return Salas;
	}
	public void setSalas(String salas) {
		Salas = salas;
	}
	
	@Override
	public String toString()
	{
		return Salas;
	}
}
