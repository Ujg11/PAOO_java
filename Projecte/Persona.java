
public class Persona
{
	private String DNI;
	private String telefon;

	public Persona(String dNI, String telefon)
	{
		DNI = dNI;
		this.telefon = telefon;
	}
	
	public Persona(Persona p)
	{
		this.DNI = p.getDNI();
		this.telefon = p.getTelefon();
	}

	public String getDNI()
	{
		return DNI;
	}

	public void setDNI(String dNI)
	{
		DNI = dNI;
	}

	public String getTelefon()
	{
		return telefon;
	}

	public void setTelefon(String telefon)
	{
		this.telefon = telefon;
	}

	public String toString()
	{
		return "Persona: DNI=" + DNI + ", Telefon=" + telefon;
	}
	
	

}
