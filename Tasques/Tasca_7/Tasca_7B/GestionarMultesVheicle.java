package Tasca_7.Tasca_7B;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestionarMultesVheicle
{
	private Map<String, Vehicle> vehicles;

	public GestionarMultesVheicle()
	{
		this.vehicles = new HashMap<>();
	}

	public boolean donarAltaMulta(Multa m, String matricula)
	{
		Vehicle v = this.vehicles.get(matricula);

		if (v == null)
		{
			v = new Vehicle(matricula);
			this.vehicles.put(matricula, v);
		}
		return (v.afegirMulta(m));
	}

	public boolean donarBaixaVehicle(String matricula)
	{
		Vehicle v = this.vehicles.get(matricula);

		if (v == null)
			return (false);
		if (v.multesPendentsPagament())
			return (false);
		this.vehicles.remove(matricula);
		return (true);
	}

	public boolean anularMulta(String matricula, long numDenuncia)
	{
		Vehicle	v = this.vehicles.get(matricula);
		Multa	m;

		if (v == null)
			return (false);
		m = v.trobarMulta(numDenuncia);
		if (m != null && m.multaPendent())
		{
			m.setEstatAnulada();
			return (true);
		}
		return (false);
	}

	public Multa consultarMultaVehicle(String matricula, long numDenuncia)
	{
		Vehicle	v = this.vehicles.get(matricula);
		Multa	m;

		if (v == null)
			return (null);
		m = v.trobarMulta(numDenuncia);
		if (m == null)
			return (null);
		return (m);
	}

	public boolean pagarMulta(String matricula, long numDenuncia)
	{
		Vehicle	v = this.vehicles.get(matricula);
		Multa	m;

		if (v == null)
			return (false);
		m = v.trobarMulta(numDenuncia);
		if (m != null && m.multaPendent())
		{
			m.setEstatPagada();
			return (true);
		}
		return (false);
	}

	public Iterable<Multa> getMultesAmbPerduaDePunts()
	{
		List<Multa> multesPerduaPunts = new ArrayList<>();

		for (Vehicle v : this.vehicles.values())
		{
			for (Multa m: v.getMultes())
			{
				if (m.puntsPerduts() > 0)
					multesPerduaPunts.add(m);
			}
		}
		return (multesPerduaPunts);
	}

	public Iterable<Multa> getMultesPendentsDePagament(String matricula)
	{
		List<Multa> multesPendents = new ArrayList<>();
		Vehicle		v = this.vehicles.get(matricula);

		if (v == null)
			return (null);
		for (Multa m: v.getMultes())
		{
			if (m.multaPendent())
				multesPendents.add(m);
		}
		return (multesPendents);
	}

}
