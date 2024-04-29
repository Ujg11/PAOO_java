package GUI_5;
import java.awt.BorderLayout;
import java.awt.Dimension;
//import java.awt.FlowLayout;
//import javax.swing.Action;


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
	}

	private void addComponents()
	{
		JPanel panelContenido = new JPanel();
		panelContenido.setLayout(new BoxLayout(panelContenido, BoxLayout.Y_AXIS));
		panelContenido.setPreferredSize(new Dimension(475, 300));

		//JTextField:
		//JTextField jTF1 = new JTextField();
		//JTextField jTF2 = new JTextField("Texto Inicial");
		//JTextField jTF3 = new JTextField(20);
		//JTextField jTF4 = new JTextField("Texto inicial 2 cols", 2);

		//jTF1.setMaximumSize(jTF1.getPreferredSize());
		//jTF2.setMaximumSize(jTF2.getPreferredSize());
		//jTF3.setMaximumSize(jTF3.getPreferredSize());
		//jTF4.setMaximumSize(jTF4.getPreferredSize());

		//panelContenido.add(jTF1);
		//panelContenido.add(Box.createVerticalStrut(20));
		//panelContenido.add(jTF2);
		//panelContenido.add(Box.createVerticalStrut(20));
		//panelContenido.add(jTF3);
		//panelContenido.add(Box.createVerticalStrut(20));
		//panelContenido.add(jTF4);
		//panelContenido.add(Box.createVerticalStrut(20));

		//Per evitar que es redimensioni:
		// 1:
		// JTextField jTF1 = new JTextField();
		// JPanel paux1 = new JPanel();
		// paux1.add(jTF1);
		// panelContenido.add(paux1);
		//(EN AQUEST CAS ES REDIMENSIONA EL PANELL AUXILIAR)
		//2:
		// JTextField jTF1 = new JTextField();
		// jTF1.setMaximumSize(jTF1.getPreferredSize());
		// panelContenido.add(jTF1);


		//JTextArea:
		//JTextArea jta1 = new JTextArea();
		//JTextArea jta2 = new JTextArea("Texto\nInicial");
		//JTextArea jta3 = new JTextArea(5, 30);
		//JTextArea jta4 = new JTextArea("Texto 2 filas y 2 columnas", 2, 2);
		//
		//jta1.setMaximumSize(jta1.getPreferredSize());
		//jta2.setMaximumSize(jta2.getPreferredSize());
		//jta3.setMaximumSize(jta3.getPreferredSize());
		//jta4.setMaximumSize(jta4.getPreferredSize());
//
		//panelContenido.add(jta1);
		//panelContenido.add(Box.createVerticalStrut(20));
		//panelContenido.add(jta2);
		//panelContenido.add(Box.createVerticalStrut(20));
		//panelContenido.add(jta3);
		//panelContenido.add(Box.createVerticalStrut(20));
		//panelContenido.add(jta4);

		//JButton:
		//JPanel panelNorte = new JPanel();
		//ImageIcon exitIcon = new ImageIcon("perri_el_hornitorrinco.png");

		//JButton jb1 = new JButton();
		//JButton jb2 = new JButton("Solo exto");
		//JButton jb3 = new JButton(exitIcon);
		//Button jb4 = new JButton("Texto e imagen", exitIcon);
		//panelNorte.add(jb1);
		//panelNorte.add(jb2);
		//panelNorte.add(jb3);
		//panelNorte.add(jb4);
		//panelContenido.add(panelNorte, BorderLayout.NORTH);

		JPanel panelContenido2 = new JPanel(new BorderLayout());
		JPanel panelSur = new JPanel();
		String[] items = {"Item 1", "Item 2", "Item 3", "Item 4"};
		
		panelContenido2.setPreferredSize(new Dimension(475, 300));
		JComboBox jC1 = new JComboBox<>(items);
		JComboBox jC2 = new JComboBox<>(items);
		JComboBox jC3 = new JComboBox<>(items);
		jC3.setEditable(true);
		panelSur.add(jC1);
		panelSur.add(jC2);
		panelSur.add(jC3);

		panelContenido2.add(panelSur, BorderLayout.NORTH);

		this.setContentPane(panelContenido2);
	}

}
