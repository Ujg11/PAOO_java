public abstract class Producte
{
	private	String	codi;
	private	String	descripcio;
	private	double	preuSenseIVA;

	public Producte(String codi, String d, double p)
	{
		this.codi = codi;
		this.descripcio = d;
		this.preuSenseIVA = p;
	}

	public Producte(Producte p)
	{
		this.codi = p.getCodi();
		this.descripcio = p.getDescripcio();
		this.preuSenseIVA = p.getPreuSenseIVA();
	}

	protected abstract Object clone();

	public abstract double consultarPreuAmbIVA();

	public abstract double consultarIVA();

	public String  getCodi() {
		return codi;
	}

	public void setCodi(String  codi) {
		this.codi = codi;
	}

	public String getDescripcio() {
		return descripcio;
	}

	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}

	public double getPreuSenseIVA() {
		return preuSenseIVA;
	}

	public void setPreuSenseIVA(double preuSenseIVA) {
		this.preuSenseIVA = preuSenseIVA;
	}

	
}
