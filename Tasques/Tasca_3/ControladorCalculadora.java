package Tasques.Tasca_3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorCalculadora
{
	private IVistaCalculadora vista;
	private IModeloCalculadora modelo;
	private boolean escrivint;
	private boolean decimal;

	public ControladorCalculadora(IVistaCalculadora v, IModeloCalculadora m)
	{
		this.vista = v;
		this.modelo = m;
		this.escrivint = false;
		vista.addOyenteTeclaMas(new ActionListener() {
			public void actionPerformed(ActionEvent event)
			{
				teclaMasPulsada();
			}
		});
		vista.addOyenteTeclaMenos(new ActionListener() {
			public void actionPerformed(ActionEvent event)
			{
				teclaMenosPulsada();
			}
		});
		vista.addOyenteTeclaPor(new ActionListener() {
			public void actionPerformed(ActionEvent event)
			{
				teclaPorPulsada();
			}
		});
		vista.addOyenteTeclaDiv(new ActionListener() {
			public void actionPerformed(ActionEvent event)
			{
				teclaDivPulsada();
			}
		});
		vista.addOyenteTeclaIgual(new ActionListener() {
			public void actionPerformed(ActionEvent event)
			{
				teclaIgualPulsada();
			}
		});
		vista.addOyenteTeclaClear(new ActionListener(){
			public void actionPerformed(ActionEvent event)
			{
				teclaClearPulsada();
			}
		});

		for (int i = 0; i < 10; i++)
		{
			final int valor = i;
			vista.addOyenteTeclaDigito(i, new ActionListener() {
				public void actionPerformed(ActionEvent event)
				{
					teclaDigitoPulsada("" + valor);
				}
			});
		}
		
		vista.addOyenteTeclaDecimal(new ActionListener() {
			public void actionPerformed(ActionEvent event)
			{
				teclaDecimalPulsada();
			}
		});
	}

	protected void teclaMasPulsada()
	{
		IOperadorBinario operador = new Suma();
		String disp = this.vista.getDisplay();
		double operando = Double.parseDouble(disp);

		if (this.escrivint)
			this.modelo.nuevoOperando(operando);
		this.modelo.nuevaOperacion(operador);
		this.escrivint = false;
		this.decimal = false;
	}

	protected void teclaMenosPulsada()
	{
		IOperadorBinario operador = new Resta();
		String disp = this.vista.getDisplay();
		double operando = Double.parseDouble(disp);

		if (this.escrivint)
			this.modelo.nuevoOperando(operando);
		this.modelo.nuevaOperacion(operador);
		this.escrivint = false;
		this.decimal = false;
	}

	protected void teclaPorPulsada()
	{
		IOperadorBinario operador = new Multiplicacion();
		String disp = this.vista.getDisplay();
		double operando = Double.parseDouble(disp);

		if (this.escrivint)
			this.modelo.nuevoOperando(operando);
		this.modelo.nuevaOperacion(operador);
		this.escrivint = false;
		this.decimal = false;
	}

	protected void teclaDivPulsada()
	{
		IOperadorBinario operador = new Division();
		String disp = this.vista.getDisplay();
		double operando = Double.parseDouble(disp);

		if (this.escrivint)
			this.modelo.nuevoOperando(operando);
		this.modelo.nuevaOperacion(operador);
		this.escrivint = false;
		this.decimal = false;
	}

	protected void teclaIgualPulsada()
	{
		String disp = this.vista.getDisplay();
		double operando = Double.parseDouble(disp);
		double result;

		this.modelo.nuevoOperando(operando);
		result = this.modelo.getResultado();
		this.vista.setDisplay("" + result);
		this.decimal = false;
		this.escrivint = false;
	}

	protected void teclaClearPulsada()
	{
		this.modelo.clear();
		this.decimal = false;
		this.modelo.nuevaOperacion(null);
		this.vista.setDisplay("0");
		this.escrivint = false;
	}

	protected void teclaDigitoPulsada(String digito)
	{
		String displayActual = this.vista.getDisplay();
		if (displayActual.equals("0") || this.escrivint == false)
		{
			this.vista.setDisplay(digito);
			this.escrivint = true;
		}
		else if (this.escrivint)
			this.vista.setDisplay(displayActual + digito);
	}

	protected void teclaDecimalPulsada()
	{
		if (!this.decimal && this.escrivint)
		{
			this.vista.setDisplay(this.vista.getDisplay() + ".");
			this.decimal = true;
		}
		else if (!this.decimal && !this.escrivint)
		{
			this.vista.setDisplay("0.");
			this.decimal = false;
			this.escrivint = true;
		}
	}

	public void setVisible(boolean v)
	{
		this.vista.setVisible(v);
	}
}
