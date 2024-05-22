package Tasca_7.Tasca_7B;

import java.time.LocalDateTime;

public abstract class MultaCirculacio extends Multa
{
	MultaCirculacio(int num, LocalDateTime diaHora, String lloc, String mat, String cod, String d, double imp)
	{
		super(num, diaHora, lloc, mat, cod, d, imp);
	}

	public abstract int puntsPerduts();
}
