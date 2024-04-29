package GUI_7;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorCalculoNIF
{
	private VistaCalculoNIF vista;
	private ModeloCalculoNIF modelo;

	public ControladorCalculoNIF(VistaCalculoNIF vista, ModeloCalculoNIF modelo)
	{
		this.vista = vista;
		this.modelo = modelo;
		this.vista.addOyenteCalcular(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				calcularNIF();
			}
		});
		this.vista.addOyenteResetear(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				reset();
			}
		});
	}

	protected void calcularNIF()
	{
		String dni = this.vista.getDNI();
		String nif = this.modelo.calcularNIF(dni);
		if (nif == null)
			this.vista.setNIF("Formato DNI incorrecto");
		else
			this.vista.setNIF(nif);
	}

	protected void reset()
	{
		this.vista.resetearFormulario();
	}
}
