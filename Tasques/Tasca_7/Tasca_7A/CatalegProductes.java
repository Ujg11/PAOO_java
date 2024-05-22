import java.util.HashMap;
import java.util.Map;

public class CatalegProductes implements IModelCatalegProducte
{
	private Map<String, Producte>	cataleg;
	//private int			numProductes;

	CatalegProductes(Producte[] productes)
	{
		this.cataleg = new HashMap<>();
		if (productes != null)
		{
			for (Producte p: productes)
			{
				if (p != null)
					this.cataleg.put(p.getCodi(), p);
			}
		}
	}

	public Iterable<Producte> getCataleg()
	{
		return cataleg.values();
	}

	public int getNumProductes()
	{
		return (cataleg.size());
	}

	public Producte consultarProducte(String codi)
	{
		return (cataleg.get(codi));
	}

	boolean afegirProducte(Producte producte)
	{
		Producte p = cataleg.get(producte.getCodi());

		if (p != null)
			return (false);
		cataleg.put(producte.getCodi(), producte);
		return (true);
	}

	boolean eliminarProducte(String codi)
	{
		Producte p = cataleg.remove(codi);
		
		if (p != null)
			return (true);
		return (false);
	}

	boolean modificarPreuBrut(String codi, Double preu)
	{
		Producte p = cataleg.get(codi);

		if (p != null)
		{
			p.setPreuSenseIVA(preu);
			return (true);
		}
		return (false);
	}
}
