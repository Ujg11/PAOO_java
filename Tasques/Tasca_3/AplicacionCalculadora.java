package Tasques.Tasca_3;

import javax.swing.SwingUtilities;

public class AplicacionCalculadora
{
	public static void main(String[] args)
	{
		IVistaCalculadora vista = new VentanaCalculadora();
		IModeloCalculadora modelo = new Calculadora();

		ControladorCalculadora controlador = new ControladorCalculadora(vista, modelo);

		SwingUtilities.invokeLater(
			new Runnable()
			{
				public void run()
				{
					controlador.setVisible(true);
				}
			}
		);
	}	
}
