import javax.swing.SwingUtilities;

public class AplicacioCataleg
{
	public static void main(String[] args)
	{
		ProducteIVAGeneral	p1 = new ProducteIVAGeneral("10", "Sorra", 12);
		ProducteIVAReduit	p2 = new ProducteIVAReduit("20", "Grava", 20);
		ProducteIVASuperreduit	p3 = new ProducteIVASuperreduit("30", "Pedra", 25);

		Producte[] productes = new Producte[3];
		productes[0] = p1;
		productes[1] = p2;
		productes[2] = p3;

		IVistaCatalegProductes	vista = new FinestraCataleg();
		IModelCatalegProducte	model = new CatalegProductes(productes);
		ControladorCataleg		controlador = new ControladorCataleg(vista, model);

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
  
