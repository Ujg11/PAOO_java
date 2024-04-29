package Tasques.Tasca_3;

public class Calculadora implements IModeloCalculadora
{
	private double resultadoActual;
	IOperadorBinario operacionPendiente;

	public Calculadora()
	{
		this.resultadoActual = 0;
		this.operacionPendiente = null;
	}

	public void clear()
	{
		this.resultadoActual = 0;
		this.operacionPendiente = null;
	}

	public double getResultado()
	{
		return (this.resultadoActual);
	}

	public void nuevaOperacion(IOperadorBinario operacion)
	{
		this.operacionPendiente = operacion;
	}

	public void nuevoOperando(double operando)
	{
		if (this.operacionPendiente != null)
		{
			this.resultadoActual = this.operacionPendiente.ejecutar(resultadoActual, operando);
		}
		else
			this.resultadoActual = operando;
		this.operacionPendiente = null;
	}

	public boolean isOperacion()
	{
		if (this.operacionPendiente != null)
			return (true);
		return (false);
	}

}
