import javax.swing.SwingUtilities;

public class AplicacionReservas
{
	public static void main(String[] args)
	{
		VentanaReservas finestra = new VentanaReservas();
		
		SwingUtilities.invokeLater(
			new Runnable() {
				public void run()
				{
					finestra.setVisible(true);
				}
			}
		);
	}
}
