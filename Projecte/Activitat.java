
public abstract class Activitat
{
	private String nom;
	private String descripcio;
	private int maximParticipants;
	private int personesInscrites;
	private String adresa;
	private String poblacio;
	protected Persona[] inscrits;

	public Activitat(String nom, String descripcio, int maximParticipants, int personesInscrites, String adresa, String poblacio)
	{
		this.nom = nom;
		this.descripcio = descripcio;
		this.maximParticipants = maximParticipants;
		this.personesInscrites = personesInscrites;
		this.adresa = adresa;
		this.poblacio = poblacio;
		inscrits = new Persona[maximParticipants];
		for (int i = 0; i < inscrits.length; i++)
			inscrits[i] = null;
	}

	public boolean llocPerInscripcio()
	{
		if (personesInscrites < maximParticipants)
			return (true);
		else
			return (false);
	}

	/*public boolean ferInscripcio(String dni, String tel)
	{
		Persona p = new Persona(dni, tel);
	
		if (llocPerInscripcio())
		{
			for (int i = 0; i < this.personesInscrites - 1; i++)
			{
				if (inscrits[i].getDNI().equals(p.getDNI()))
					return (false);
			}
			inscrits[this.personesInscrites] = p;
			this.personesInscrites++;
			return (true);
		}
		return (false);
	}*/

	public abstract boolean ferInscripcio(Persona p);
	/*{
		if (llocPerInscripcio())
		{
			for (int i = 0; i < this.personesInscrites - 1; i++)
			{
				if (inscrits[i].getDNI().equals(p.getDNI()))
					return (false);
			}
			inscrits[this.personesInscrites] = p;
			this.personesInscrites++;
			return (true);
		}
		return (false);
	}*/

	public boolean donarDeBaixa(String dni)
	{
		int i = 0;
		boolean flag = false;

		for (i = 0; i < this.personesInscrites - 1; i++)
		{
			if (inscrits[i].getDNI().equals(dni))
			{
				flag = true;
				break ;
			}	
		}
		if (flag)
		{
			for (int j = i; j < this.personesInscrites - 2; j++)
			{
				inscrits[j] = inscrits[j + 1];
			}
			inscrits[personesInscrites - 1] = null;
			this.personesInscrites--;
			return (true);
		}
		return (false);
	}
 
	/*public Persona[] consultarPersonesInscrites()
	{
		Persona[] p = new Persona[this.inscrits.length];

		for (int i = 0; i < this.inscrits.length; i++)
		{
			p[i] = new Persona(this.inscrits[i]);
		}
		return (p);
	}*/

	public Persona consultarPersonaInscrita(int iterador)
	{
		if (iterador >= 0 && iterador <= this.personesInscrites - 1)
			return (this.inscrits[iterador]);
		return (null);
	}

	public void consultarInscrits()
	{
		for (int i = 0; i < this.personesInscrites; i++)
		{
			System.out.println(consultarPersonaInscrita(i));
		}
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescripcio() {
		return descripcio;
	}

	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}

	public int getMaximParticipants() {
		return maximParticipants;
	}

	public void setMaximParticipants(int maximParticipants) {
		this.maximParticipants = maximParticipants;
	}

	public int getPersonesInscrites() {
		return personesInscrites;
	}

	public void setPersonesInscrites(int personesInscrites) {
		this.personesInscrites = personesInscrites;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getPoblacio() {
		return poblacio;
	}

	public void setPoblacio(String poblacio) {
		this.poblacio = poblacio;
	}	
}