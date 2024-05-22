import java.awt.event.ActionListener;

public interface IVistaCatalegProductes
{
	public String	getCodi();
	public void		mostrarProducte(Producte p);
	public void		ferClear();
	public void		mostrarMissatgeError(String missatge);
	public void		addListenerConsultar(ActionListener l);
	public void		addListenerClear(ActionListener l);
	public void		setVisible(boolean v);
}
