package GUI_7;
import javax.swing.SwingUtilities;

public class AppCalculo
{
	public static void main(String[] args)
	{
		//Vista vista = new ImpVista();
		//Modelo modelo = new ImpModelo();
		//Controlador controlador = new ImpControlador();

		VistaCalculoNIF vista = new VentanaCalculaNIF();
		ModeloCalculoNIF modelo = new CalculoNIF();
		ControladorCalculoNIF controlador =  new ControladorCalculoNIF(vista, modelo);

		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				vista.setVisible(true);
			}
		});
	}
}
