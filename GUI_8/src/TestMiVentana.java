import javax.swing.SwingUtilities;

public class TestMiVentana {

	public static void main(String[] args) {
		MiVentana ventana = new MiVentana("Mi Ventana");
		SwingUtilities.invokeLater(new Runnable() {			
			@Override
			public void run() {
				ventana.setVisible(true);			
			}
		});
	}
}
