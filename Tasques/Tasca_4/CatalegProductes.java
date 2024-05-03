public class CatalegProductes implements IModelCatalegProducte
{
	private Producte[]	cataleg;
	private int			numProductes;

	CatalegProductes(Producte[] productes)
	{
		if (productes != null)
			this.numProductes = productes.length;
		else
			this.numProductes = 0;
		this.cataleg = productes;
	}

	public Producte[] getCataleg() {
		return cataleg;
	}

	public int getNumProductes() {
		return numProductes;
	}

	public Producte consultarProducte(String codi)
	{
		if (numProductes == 0)
			return (null);
		for (int i = 0; i < numProductes; i++)
		{
			if (cataleg[i] != null && cataleg[i].getCodi().equals(codi))
				return ((Producte)(cataleg[i].clone()));
		}
		return (null);
	}
}
