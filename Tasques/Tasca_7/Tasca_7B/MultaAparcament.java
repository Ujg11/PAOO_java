package Tasca_7.Tasca_7B;

import java.time.LocalDateTime;

public class MultaAparcament extends Multa
{
	private boolean	retiratPerLaGrua;

	MultaAparcament(int num, LocalDateTime diaHora, String lloc, String mat, String cod, String d, double imp, boolean grua)
	{
		super(num, diaHora, lloc, mat, cod, d, imp);
		this.retiratPerLaGrua = grua;
	}

	public int puntsPerduts()
	{
		return (0);
	}

	public String toString()
	{
		String s = super.toString();

		s += "Ha estat retirat per la grua? ";
		if (retiratPerLaGrua)
			s += "Si";
		else
			s += "No";
		s += "\nPunts retirats: 0";
		return (s);
	}

	public boolean isRetiratPerLaGrua() {
		return retiratPerLaGrua;
	}

	public void setRetiratPerLaGrua(boolean retiratPerLaGrua) {
		this.retiratPerLaGrua = retiratPerLaGrua;
	}
}
