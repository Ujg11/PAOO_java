import javax.swing.JFrame;

public class MiVentana extends JFrame
{
	public MiVentana(String title)
	{
		super(title);
		this.init();
	}

	private void init()
	{
		this.setSize(475, 320);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.addComponents();
	}

	private void addComponents()
	{

	}
}