import java.nio.file.ProviderNotFoundException;

import javax.swing.SwingUtilities;

public class AplicacioCentreLudic
{
	public static void main(String[] args) {
		FinestraCentreLudic finestra = new FinestraCentreLudic();

		SwingUtilities.invokeLater(
			new Runnable()
			{
				public void run()
				{
					finestra.setVisible(true);
				}
			}
		);
	}
	
}
