package GUI_6;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
//import java.awt.FlowLayout;
//import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
//import javax.swing.plaf.DimensionUIResource;

public class MiVentana extends JFrame
{
	//private static final String CardLayout = null;
	private JPanel panelPrincipal;
	private JButton bCyan, bGreen, bOrange, bMagenta, bYellow;

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
		addComponents();
	}

	private void addComponents()
	{
		JPanel panelContenido = new JPanel(new BorderLayout());
		panelContenido.setPreferredSize(new Dimension(475, 300));
		panelContenido.add(crearPanelPrincipal(), BorderLayout.CENTER);
		panelContenido.add(crearPanelBotones(), BorderLayout.SOUTH);
		this.setContentPane(panelContenido);
	}

	private JPanel crearPanelPrincipal()
	{
		panelPrincipal = new JPanel(new CardLayout());
		JPanel p1 = new JPanel(), p2 = new JPanel(), p3 = new JPanel(), p4 = new JPanel(), p5 = new JPanel();

		p1.setBackground(Color.CYAN);
		p2.setBackground(Color.ORANGE);
		p3.setBackground(Color.GREEN);
		p4.setBackground(Color.MAGENTA);
		p5.setBackground(Color.YELLOW);
		panelPrincipal.add(p1, "Cyan");
		panelPrincipal.add(p2, "Orange");
		panelPrincipal.add(p3, "Green");
		panelPrincipal.add(p4, "Magenta");
		panelPrincipal.add(p5, "Yellow");

		return (panelPrincipal);
	}

	private JPanel crearPanelBotones()
	{
		JPanel panelBotones = new JPanel();

		this.bCyan = new JButton("Cyan");
		this.bGreen = new JButton("Green");
		this.bOrange = new JButton("Orange");
		this.bMagenta = new JButton("Magenta");
		this.bYellow = new JButton("Yellow");
		panelBotones.add(this.bCyan);
		panelBotones.add(this.bGreen);
		panelBotones.add(this.bOrange);
		panelBotones.add(this.bMagenta);
		panelBotones.add(this.bYellow);
		addOyentesBotones();
		return (panelBotones);
	}

	private void addOyentesBotones()
	{
		this.bCyan.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				showCard("Cyan");
			}
		});
		this.bOrange.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				showCard("Orange");
			}
		});
		this.bGreen.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				showCard("Green");
			}
		});
		this.bMagenta.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				showCard("Magenta");
			}
		});
		this.bYellow.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				showCard("Yellow");
			}
		});
	}

	protected void showCard(String card)
	{
		//Retorna el Layout del panell principal castejant-lo a CardLayout i utilitza el metode show
		((CardLayout) panelPrincipal.getLayout()).show(panelPrincipal, card);
	}
}
