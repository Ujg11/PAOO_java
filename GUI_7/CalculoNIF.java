package GUI_7;

public class CalculoNIF implements ModeloCalculoNIF
{
	private final static String[] letras = {"T", "R", "W", "A", "G", "M", "Y"};

	public String calcularNIF(String numeroDNI)
	{
		int num;

		if (numeroDNI.length() != 8)
			return (null);
		try {
			num = Integer.parseInt(numeroDNI);
		} catch (NumberFormatException e) {
			return (null);
		}
		return (numeroDNI + letras[num%7]);
	}
}
