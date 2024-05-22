package Tasca_6.ex1;

public class Test
{
	public static void main(String[] args)
	{
		Alumne a1 = new Alumne("456765432Z", "Paco");
		
		System.out.println("Mitjana al iniciar: " + a1.calcularMitjana());
		a1.afegirNota(9);
		a1.afegirNota(5);
		a1.afegirNota(7);
		a1.afegirNota(1);
		System.out.println("Mitjana 9, 5, 7, 1: " + a1.calcularMitjana());
		Iterable<Double> col = a1.getNotes();
		System.out.println("Llista de les notes:");
		for (double n: col)
		{
			System.out.println(n);
		}
	}
}
