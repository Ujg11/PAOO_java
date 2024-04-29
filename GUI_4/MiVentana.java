package GUI_4;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
//import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;
//import javax.swing.plaf.DimensionUIResource;

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
		components_exemple();
	}

	private void addComponents()
	{
		//JPanel panelContenido = new JPanel();
		//GridLayout:
		//JPanel panelContenido = new JPanel(new GridLayout(3,3));
		//BorderLayout:
		//JPanel panelContenido = new JPanel(new BorderLayout());
		//FlowLayout:
		//JPanel panelContenido = new JPanel(new FlowLayout(FlowLayout.LEFT, 80, 30));
		//BoxLayput:
		//panelContenido.setLayout(new BoxLayout(panelContenido, BoxLayout.Y_AXIS));
		//CardLayout:
		JPanel panelContenido = new JPanel(new CardLayout());

		panelContenido.setPreferredSize(new Dimension(475, 300));
		//panelContenido.setBackground(new Color(93999));
		//panelContenido.setBorder(BorderFactory.createTitledBorder("Panel de contenido"));

		JPanel p1 = new JPanel(), p2 = new JPanel(), p3 = new JPanel(),
				p4 = new JPanel(), p5 = new JPanel(); //p6 = new JPanel();

		p1.setBackground(Color.CYAN);
		//p1.setPreferredSize(new Dimension(100, 40));
		//p1.setMaximumSize(new Dimension(30, 50));

		p2.setBackground(Color.ORANGE);
		//p2.setPreferredSize(new DimensionUIResource(110, 40));
		//p2.setMaximumSize(new Dimension(30, 50));

		p3.setBackground(Color.GREEN);
		//p3.setPreferredSize(new DimensionUIResource(90, 40));
		//p3.setMaximumSize(new Dimension(20, 30));

		p4.setBackground(Color.MAGENTA);
		//p4.setPreferredSize(new DimensionUIResource(100, 60));
		//p4.setMaximumSize(new Dimension(60, 50));

		p5.setBackground(Color.YELLOW);
		//p5.setPreferredSize(new DimensionUIResource(80, 80));
		//p5.setMaximumSize(new Dimension(30, 30));

		//p6.setBackground(Color.RED);
		//p6.setPreferredSize(new DimensionUIResource(100, 40));

		//panelContenido.add(p1, BorderLayout.NORTH);
		//panelContenido.add(p2, BorderLayout.SOUTH);
		//panelContenido.add(p3, BorderLayout.EAST);
		//panelContenido.add(p4, BorderLayout.WEST);
		//panelContenido.add(p5, BorderLayout.CENTER);

		//panelContenido.add(p1);
		//panelContenido.add(p2);
		//panelContenido.add(Box.createVerticalStrut(20));//posem un espai
		//panelContenido.add(p3);
		//panelContenido.add(p4);
		//panelContenido.add(Box.createGlue()); //posem un espai
		//panelContenido.add(p5);

		panelContenido.add(p1);
		panelContenido.add(p2);
		panelContenido.add(p3, "pGreen");
		panelContenido.add(p4);
		panelContenido.add(p5);
		
		this.setContentPane(panelContenido);
		((CardLayout)panelContenido.getLayout()).show(panelContenido, "pGreen");
		//this.setContentPane(new JScrollPane(panelContenido));
	}

	//Exemple: Crear 2 panells, un superior i un altre inferior. El superior tindra 4 subpanells en una matriu 2x2
	//i un borde amb un titol.
	//El panell d'abaix no tindra mes subpanells i es podra fer scroll
	private void components_exemple()
	{
		JPanel panelContenido = new JPanel(new BorderLayout());
		JPanel panelNorte =  new JPanel(new GridLayout(2, 2, 10, 5));
		JPanel p1 = new JPanel(), p2 = new JPanel(), p3 = new JPanel(), p4 = new JPanel();

		panelContenido.setPreferredSize(new Dimension(475, 300));
		panelNorte.setBorder(BorderFactory.createTitledBorder("Data Area"));
		p1.setBackground(Color.CYAN);
		p1.setPreferredSize(new Dimension(100, 30));
		p2.setBackground(Color.ORANGE);
		p2.setPreferredSize(new Dimension(100, 30));
		p3.setBackground(Color.GREEN);
		p3.setPreferredSize(new Dimension(100, 30));
		p4.setBackground(Color.MAGENTA);
		p4.setPreferredSize(new Dimension(100, 30));
		panelNorte.add(p1);
		panelNorte.add(p2);
		panelNorte.add(p3);
		panelNorte.add(p4);
		panelContenido.add(panelNorte, BorderLayout.NORTH);

		JPanel p5 = new JPanel();
		p5.setBackground(Color.YELLOW);
		p5.setPreferredSize(new Dimension(800, 400));
		//p5.setMaximumSize(new Dimension(200, 100));
		JScrollPane panelSur = new JScrollPane(p5);
		panelSur.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		panelContenido.add(panelSur, BorderLayout.SOUTH);

		this.setContentPane(panelContenido);
	}
}
