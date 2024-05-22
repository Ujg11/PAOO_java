package Tasca_6.ex2;

public class Test
{
	public static void main(String[] args)
	{
		Contacte c = new Contacte("Anthony");

		Iterable<String> telefons = c.getTelefons();
		for (String t: telefons)
			System.out.println(t);
		System.out.println(c.afegirTelefon("62346455433"));
		System.out.println(c.afegirTelefon("66543234569"));
		Iterable<String> telefons_plens = c.getTelefons();
		for (String t: telefons_plens)
			System.out.println(t);
	}
}
