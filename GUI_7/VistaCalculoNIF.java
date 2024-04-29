package GUI_7;

import java.awt.event.ActionListener;

public interface VistaCalculoNIF
{
	public void setVisible(boolean v);
	public String getDNI();
	public void setNIF(String nif);
	public void resetearFormulario();
	public void addOyenteCalcular(ActionListener l);
	public void addOyenteResetear(ActionListener l);
}
