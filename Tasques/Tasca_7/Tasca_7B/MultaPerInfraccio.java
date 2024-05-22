package Tasca_7.Tasca_7B;

import java.time.LocalDateTime;

public class MultaPerInfraccio extends MultaCirculacio
{
	private String dniConductor;

	MultaPerInfraccio(int num, LocalDateTime diaHora, String lloc, String mat, String cod, String d, double imp, String dni)
	{
		super(num, diaHora, lloc, mat, cod, d, imp);
		this.dniConductor = dni;
	}

	public int puntsPerduts()
	{
		String	cod = this.getCodiInfraccio();
		int		i = 0;

		while (i < cod.length())
		{
			if (cod.charAt(i) == '-')
				return (cod.charAt(i + 1) - '0');
			i++;
		}
		return (0);
	}

	public String toString()
	{
		String s = super.toString();

		s += "\nDNI del conductor: " + this.dniConductor;
		s += "\nPunts retirats: " + puntsPerduts();
		return (s);
	}

	public String getDniConductor() {
		return dniConductor;
	}

	public void setDniConductor(String dniConductor) {
		this.dniConductor = dniConductor;
	}

}
