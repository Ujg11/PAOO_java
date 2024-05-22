package Tasca_3;

public interface IModeloCalculadora
{
	public void clear();
	public double getResultado();
	public void nuevaOperacion(IOperadorBinario operacion);
	public void nuevoOperando(double operando);
}
