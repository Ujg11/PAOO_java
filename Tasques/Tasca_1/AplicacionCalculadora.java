import javax.swing.SwingUtilities;

public class AplicacionCalculadora
{
	public static void main(String[] args)
	{
		VentanaCalculadora finestra = new VentanaCalculadora();

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
