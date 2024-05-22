import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorCataleg
{
	private IVistaCatalegProductes	vista;
	private IModelCatalegProducte	model;

	public ControladorCataleg(IVistaCatalegProductes v, IModelCatalegProducte m)
	{
		this.vista = v;
		this.model = m;
		vista.addListenerConsultar(new ActionListener() {
			public void actionPerformed(ActionEvent event)
			{
				teclaBuscarPulsada();
			}
		});
		vista.addListenerClear(new ActionListener() {
			public void actionPerformed(ActionEvent event)
			{
				teclaClearPulsada();
			}
		});
	}

	protected void teclaClearPulsada()
	{
		vista.ferClear();
	}

	protected void teclaBuscarPulsada()
	{
		String s = vista.getCodi();
		if (s.equals("Introduir Codi"))
			vista.mostrarMissatgeError("Introdueix un Codi Vàlid");
		else if (model.consultarProducte(s) != null)
			vista.mostrarProducte(model.consultarProducte(s));
		else
			vista.mostrarMissatgeError("No s'ha trobat el Producte, comprova que el codi sigui correcte i que el catàleg estigui ple");
	}

	public void setVisible(boolean v)
	{
		this.vista.setVisible(v);
	}
}
