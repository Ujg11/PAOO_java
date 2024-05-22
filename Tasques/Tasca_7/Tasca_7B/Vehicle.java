package Tasca_7.Tasca_7B;

import java.util.HashMap;
import java.util.Map;

public class Vehicle
{
	private String matricula;
	private Map<Long, Multa> multes;

	Vehicle(String mat)
	{
		this.matricula = mat;
		this.multes = new HashMap<>();
	}

	public String getMatricula()
	{
		return (this.matricula);
	}

	

	public Multa trobarMulta(long numDenuncia)
	{
		return (multes.get(numDenuncia));
	}

	public boolean afegirMulta(Multa m)
	{
		if (this.multes.containsKey(m.getNumDenuncia()))
			return (false);
		multes.put(m.getNumDenuncia(), m);
		return (true);
	}

	public boolean multesPendentsPagament()
	{
		for (Multa m : multes.values())
		{
			if (m.multaPendent())
				return (true);
		}
		return (false);
	}

	public Multa eliminarMulta(long numDenuncia)
	{
		return (this.multes.remove(numDenuncia));
	}

	public Iterable<Multa> getMultes() {
		return multes.values();
	}

}
