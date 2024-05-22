public class ProducteIVASuperreduit extends Producte
{
	private static double IVA = 0.04;

	ProducteIVASuperreduit(String codi, String d, double p)
	{
		super(codi, d, p);
	}

	public double consultarPreuAmbIVA()
	{
		return (this.getPreuSenseIVA() * (1 + IVA));
	}

	public double consultarIVA()
	{
		return (IVA * 100);
	}

	protected Object clone()
	{
		return (new ProducteIVASuperreduit(this.getCodi(), this.getDescripcio(), this.getPreuSenseIVA()));
	}

	public static double getIVA() {
		return IVA;
	}

	public static void setIVA(double iVA) {
		IVA = iVA;
	}
}
