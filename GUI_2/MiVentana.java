package GUI_2;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Dimension;

public class MiVentana extends JFrame
{
	public MiVentana()
	{
		super();
		this.init();
	}

	public MiVentana(String title)
	{
		super(title);
		this.init();
	}

	private void init()
	{
		this.setSize(300, 150);
		this.setLocation(0, 0); //La posició on s'inicia la finestra
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(300, 150));
		this.setMaximumSize(new Dimension(300, 150));
		//this.pack();//Ajusta el tamany al contingut de la finestra
		this.setResizable(false); //fem que no es pugui redimensionar
		this.setIconImage(new ImageIcon("C:/Users/Lenovo/OneDrive/Documents/PAOO/GUI_2/perri_el_hornitorrinco.png").getImage());
		this.addComponents();
		
	}

	private void addComponents()
	{
		
	}
}

