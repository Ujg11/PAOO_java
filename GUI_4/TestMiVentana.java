package GUI_4;

import javax.swing.SwingUtilities;

public class TestMiVentana {
	public static void main(String[] args)
	{
		MiVentana ventana = new MiVentana("Primera Finestra (GUI 1)");

		SwingUtilities.invokeLater(
		new Runnable()
		{
			public void run()
			{
				ventana.setVisible(true);
			}
		});
	}
}
