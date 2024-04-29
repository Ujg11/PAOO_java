package GUI_3;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;

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
		this.setSize(500, 400);
		this.setLocation(500, 350); //La posició on s'inicia la finestra
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//this.pack();//Ajusta el tamany al contingut de la finestra
		//this.setResizable(false); //fem que no es pugui redimensionar
		this.setIconImage(new ImageIcon("C:/Users/Lenovo/OneDrive/Documents/PAOO/GUI_2/perri_el_hornitorrinco.png").getImage());
		this.addComponents();
	}

	private void addComponents()
	{
		JPanel panelContenido = new JPanel();
		
		panelContenido.setPreferredSize(new Dimension(100, 100));
		panelContenido.setBackground(new Color(93999));
		panelContenido.setBorder(BorderFactory.createTitledBorder("Panel de contenido"));

		//Afegim les components
		JPanel p1 = new JPanel();
		p1.setBackground(Color.CYAN);
		p1.setPreferredSize(new DimensionUIResource(300, 200));

		JPanel p2 = new JPanel();
		p2.setBackground(Color.ORANGE);
		p2.setPreferredSize(new DimensionUIResource(80, 100));

		JPanel p3 = new JPanel();
		p3.setBackground(Color.GREEN);
		p3.setPreferredSize(new DimensionUIResource(100, 150));
		
		//els afegim
		panelContenido.add(p1);
		panelContenido.add(p2);
		panelContenido.add(p3);

		//this.setContentPane(panelContenido);
		this.setContentPane(new JScrollPane(panelContenido));
	}
}
