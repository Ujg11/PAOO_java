import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.toedter.calendar.JDateChooser;

//JCalendar ->web: toedter.com
// 1- ens baixem la llibreria (un zip)
// 2- carpeta lib
// 3- afegirla i buscar com afegirla (eclipse: build path)

//crear: private JDataChooser dataChooser;
//		dataChooser = new JDataChooser("dd/MM/yyyy", "##/##/##", '_');
//ara l'afegiriem on volguessim
//per consultar la data: dataChooser.getDate();

public class FinestraCentreLudic extends JFrame
{
	//Panell Principal
	private JPanel		panelPrincipal;
	private JMenuItem	iniciApp;
	private JMenuItem	crearNovaActivitat;
	private JMenuItem	consultarLlistaActivitats;
	//private JMenuItem	consultarModificarActivitat;

	//Panel inici
	private JPanel		panelInici;

	//Panell Crear Activitat:
	private JPanel		panelCrearActivitat;
		private JComboBox	tipusActivitat; //escullim qui tipus d'activitat i activem els card layouts

		//Panell Activitat Concreta
		private JPanel	panelActivitatConcreta;
			//Podem tenir un altre Card Layout depenent de la activitat

			//Panell Inicial
			private JPanel	panelInicialCrearActivitat;

			//Activitat Cultural
			private JPanel	panelActivitatCultural;
				private JTextField		nomActivitatC, descripcioActivitatC, numMaximParticipantsC, adresaActivitatC,
										poblacioActivitatC, preuActivitatC;
				private JDateChooser	dataActivitatCultural;
				private JTextField		horaIniciACultural;
				private JButton			botoInserirNovaActivitatC;

			//Activitat Esportiva
			private JPanel	panelActivitatEsportiva;
				private JTextField		nomActivitatE, descripcioActivitatE, numMaximParticipantsE, adresaActivitatE,
										poblacioActivitatE;
				private JCheckBox		dilluns, dimarts, dimecres, dijous, divendres, dissabte;
				private JDateChooser	dataIniciEsportiva;
				private JDateChooser	dataFiEsportiva;
				private JTextField		horaIniciEsportiva;
				private JTextField		horaFiEsportiva;
				private JButton			botoInserirNovaActivitatE;

			//Activitat Formativa
			private JPanel	panelActivitatFormativa;
				private JTextField		nomActivitatF, descripcioActivitatF, numMaximParticipantsF, adresaActivitatF,
										poblacioActivitatF, duracioActivitatF;
				private JDateChooser	dataLimitInscripcioF;
				private JDateChooser	dataActivitatFormativa;
				private JTextField		horaIniciActivitatF;
				private JButton			botoInserirNovaActivitatF;
	
	//Panell Llista Activitats:
	private JPanel panelLlistaActivitats;

		//Panel de les opcions
		private JPanel panelOpcions;
			//Filtres possibles
			private JComboBox	admetInscripcions;
			private JComboBox	tipusActivitatFiltre;
			private	JTextField	poblacioFiltre;
			//Farem un quadre de text amb la llista de les activitats i que sera un JScrollPane
			private JTextArea	llistaActivitats;
			private JTextField	activitatAModificar; //La activitat seleccionada

			private JButton		consultarActivitat;
			private JButton		eliminarActivitat;
			private JComboBox	gestioActivitat; //Inscriure Persona, Cancelar inscripcio, Consultar Inscripcions
			private JButton		gestionarActivitatBoto;
		
		//Panell de Consultar Activitat
		private JPanel	panelConsultarActivitat;
		private JButton	tornarDeConsultaAOpcions;

		//Panell de Gestionar Activitat
		private JPanel	panelGestionarActivitat;
		private	JButton tornarDeGestioAOpcions;
			//S'ha de poder: inscriure, cancelar una inscripcio, consultar les inscripcions
		

		public FinestraCentreLudic()
		{
			super();
			this.init();
		}

		private	void init()
		{
			this.setLocation(700, 200);
			this.setTitle("Activitats Centre Lúdic");
			this.setSize(new Dimension(700, 600));
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.addComponentsPanelContenido();
			this.setJMenuBar(crearMenuBar());
			//this.pack();
		}

		private void addComponentsPanelContenido()
		{
			JPanel panelContenido = new JPanel(new BorderLayout());

			panelContenido.setPreferredSize(new Dimension(475, 300));
			panelContenido.add(crearPanelPrincipal(), BorderLayout.CENTER);
			this.setContentPane(panelContenido);
		}

		private JPanel crearPanelPrincipal()
		{
			this.panelPrincipal = new JPanel(new CardLayout());
			
			this.panelPrincipal.add(crearPanelInici(), "Inici");
			this.panelPrincipal.add(crearPanelCrearActivitat(), "PanelCrearActivitat");
			this.panelPrincipal.add(crearPanelLlistarActivitats(), "PanelLlistaActivitats");
			return (this.panelPrincipal);
		}

		//"Inici", "PanelCrearActivitat" i "PanelLlistaActivitats"
		protected void showCardPanelPrincipal(String card)
		{
			((CardLayout) this.panelPrincipal.getLayout()).show(panelPrincipal, card);
		}

		private JPanel crearPanelInici()
		{
			this.panelInici = new JPanel();
			this.panelInici.setLayout(new BoxLayout(panelInici, BoxLayout.Y_AXIS));

			this.panelInici.add(new JLabel("    Benvinguts al nostre Centre Ludic on podras trobar moltes activitats!"));
			return (panelInici);
		}

		private JMenuBar crearMenuBar()
		{
			JMenuBar menuBar = new JMenuBar();

			menuBar.add(crearMenuAplicacion());
			addOyentesItemsMenuVentanaPrincipal();
			return (menuBar);
		}

		private JMenu crearMenuAplicacion()
		{
			JMenu	menu = new JMenu("Opcions");
			menu.setMnemonic(KeyEvent.VK_M);

			this.iniciApp = new JMenuItem("Inici", KeyEvent.VK_SPACE);
			this.crearNovaActivitat = new JMenuItem("Crear nova activitat", KeyEvent.VK_0);
			this.consultarLlistaActivitats = new JMenuItem("Consultar Llista de les Activitats", KeyEvent.VK_1);

			menu.add(this.iniciApp);
			menu.add(this.crearNovaActivitat);
			menu.add(this.consultarLlistaActivitats);
			return (menu);
		}

		private void addOyentesItemsMenuVentanaPrincipal()
		{
			this.iniciApp.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					showCardPanelPrincipal("Inici");
				}
			});
			this.crearNovaActivitat.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					showCardPanelPrincipal("PanelCrearActivitat");
				}
			});
			this.consultarLlistaActivitats.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					showCardPanelPrincipal("PanelLlistaActivitats");
				}
			});
		}

		//Panel per crear les activitats on primer hi haura un JComboBox per escullir el tipus d'activitat
		//i despres apareixeran cardLayouts segons el tipus
		private JPanel crearPanelCrearActivitat()
		{
			this.panelCrearActivitat = new JPanel(new BorderLayout());

			JPanel panelSuperior = new JPanel();
			String tipus[] = {"Tipus", "Activitat Esportiva", "Activitat Formativa", "Activitat Cultural"};
			panelSuperior.setLayout(new BoxLayout(panelSuperior, BoxLayout.X_AXIS));
			panelSuperior.add(Box.createHorizontalStrut(20));
			panelSuperior.add(new JLabel("Escull el tipus d'activitat i ompli els buits"));
			panelSuperior.add(Box.createHorizontalStrut(10));
			this.tipusActivitat = new JComboBox<String>(tipus);
			panelSuperior.add(this.tipusActivitat);
			panelSuperior.add(Box.createHorizontalStrut(150));
			this.panelCrearActivitat.add(panelSuperior, BorderLayout.NORTH);

			this.panelActivitatConcreta = new JPanel(new CardLayout());
			this.panelInicialCrearActivitat = new JPanel();

			this.panelActivitatConcreta.add(this.panelInicialCrearActivitat, "Tipus");
			this.panelActivitatConcreta.add(crearPanelActivitatEsportiva(), "Activitat Esportiva");
			this.panelActivitatConcreta.add(crearPanelActivitatCultural(), "Activitat Cultural");
			this.panelActivitatConcreta.add(crearPanelActivitatFormativa(), "Activitat Formativa");
			this.panelCrearActivitat.add(this.panelActivitatConcreta, BorderLayout.CENTER);

			addOyentesItemsPanelCrearActivitat();
			
			return (this.panelCrearActivitat);
		}

		private void addOyentesItemsPanelCrearActivitat()
		{
			this.tipusActivitat.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					String s = (String) tipusActivitat.getSelectedItem();
					System.out.println(s);
					showCardActivitatConcreta(s);
				}
			});
		}

		//Panells: "ActivitatEsportiva", "ActivitatCultural", "ActivitatFormativa"
		protected void showCardActivitatConcreta(String card)
		{
			((CardLayout) this.panelActivitatConcreta.getLayout()).show(panelActivitatConcreta, card);
		}
		//((CardLayout) this.panelActivitatConcreta.getLayout()).next();

		private JPanel crearPanelActivitatEsportiva()
		{
			this.panelActivitatEsportiva = new JPanel();
			this.panelActivitatEsportiva.setLayout(new BoxLayout(this.panelActivitatEsportiva, BoxLayout.Y_AXIS));
			this.panelActivitatEsportiva.setBorder(BorderFactory.createTitledBorder("Creacio activitat esportiva"));
			this.panelActivitatEsportiva.add(Box.createVerticalStrut(20));

			JPanel linea1 = new JPanel();
			linea1.setLayout(new BoxLayout(linea1, BoxLayout.X_AXIS));
			linea1.add(Box.createHorizontalStrut(20));
			linea1.add(new JLabel("Nom de l'activitat:"));
			linea1.add(Box.createHorizontalStrut(10));
			this.nomActivitatE = new JTextField("Nom");
			linea1.add(this.nomActivitatE);
			linea1.add(Box.createHorizontalStrut(20));
			linea1.add(new JLabel("Descripció de l'activitat:"));
			linea1.add(Box.createHorizontalStrut(10));
			this.descripcioActivitatE = new JTextField("Descripcio");
			linea1.add(this.descripcioActivitatE);
			linea1.add(Box.createHorizontalStrut(20));
			this.panelActivitatEsportiva.add(linea1);
			this.panelActivitatEsportiva.add(Box.createVerticalStrut(20));

			JPanel linea2 = new JPanel();
			linea2.setLayout(new BoxLayout(linea2, BoxLayout.X_AXIS));
			linea2.add(Box.createHorizontalStrut(20));
			linea2.add(new JLabel("Numero Maxim de Participants"));
			linea2.add(Box.createHorizontalStrut(10));
			this.numMaximParticipantsE = new JTextField("ex: 10");
			linea2.add(this.numMaximParticipantsE);
			linea2.add(Box.createHorizontalStrut(20));
			linea2.add(new JLabel("Adreça on es realitza l'activitat"));
			linea2.add(Box.createHorizontalStrut(10));
			this.adresaActivitatE = new JTextField("Adreça");
			linea2.add(this.adresaActivitatE);
			linea2.add(Box.createHorizontalStrut(20));
			this.panelActivitatEsportiva.add(linea2);
			this.panelActivitatEsportiva.add(Box.createVerticalStrut(20));

			JPanel linea2_1 = new JPanel();
			linea2_1.setLayout(new BoxLayout(linea2_1, BoxLayout.X_AXIS));
			linea2_1.add(Box.createHorizontalStrut(20));
			linea2_1.add(new JLabel("Població on es realitzarà la activitat"));
			linea2_1.add(Box.createHorizontalStrut(15));
			this.poblacioActivitatE = new JTextField("Població");
			linea2_1.add(this.poblacioActivitatE);
			linea2_1.add(Box.createHorizontalStrut(280));
			this.panelActivitatEsportiva.add(linea2_1);
			this.panelActivitatEsportiva.add(Box.createVerticalStrut(20));

			JPanel linea3 = new JPanel();
			linea3.setLayout(new BoxLayout(linea3, BoxLayout.X_AXIS));
			linea3.add(Box.createHorizontalStrut(20));
			linea3.add(new JLabel("Escull els dies de la setmana que es realitzarà l'activitat (diumenge tancat)"));
			linea3.add(Box.createHorizontalStrut(20));
			this.panelActivitatEsportiva.add(linea3);
			this.panelActivitatEsportiva.add(Box.createVerticalStrut(10));

			JPanel linea4 = new JPanel();
			linea4.setLayout(new BoxLayout(linea4, BoxLayout.X_AXIS));
			linea4.add(Box.createHorizontalStrut(20));
			this.dilluns = new JCheckBox("Dilluns");
			linea4.add(this.dilluns);
			linea4.add(Box.createHorizontalStrut(15));
			this.dimarts = new JCheckBox("Dimarts");
			linea4.add(this.dimarts);
			linea4.add(Box.createHorizontalStrut(15));
			this.dimecres = new JCheckBox("Dimecres");
			linea4.add(this.dimecres);
			linea4.add(Box.createHorizontalStrut(15));
			this.dijous = new JCheckBox("Dijous");
			linea4.add(this.dijous);
			linea4.add(Box.createHorizontalStrut(15));
			this.divendres = new JCheckBox("Divendres");
			linea4.add(this.divendres);
			linea4.add(Box.createHorizontalStrut(15));
			this.dissabte = new JCheckBox("Dissabte");
			linea4.add(this.dissabte);
			linea4.add(Box.createHorizontalStrut(15));
			this.panelActivitatEsportiva.add(linea4);
			this.panelActivitatEsportiva.add(Box.createVerticalStrut(20));

			JPanel linea5 = new JPanel();
			linea5.setLayout(new BoxLayout(linea5, BoxLayout.X_AXIS));
			linea5.add(Box.createHorizontalStrut(20));
			linea5.add(new JLabel("Data d'inici de l'activitat"));
			linea5.add(Box.createHorizontalStrut(20));
			this.dataIniciEsportiva = new JDateChooser("dd/MM/yyyy", "##/##/##", '_');
			linea5.add(this.dataIniciEsportiva);
			linea5.add(Box.createHorizontalStrut(40));
			linea5.add(new JLabel("Data de fi de l'activitat"));
			linea5.add(Box.createHorizontalStrut(20));
			this.dataFiEsportiva = new JDateChooser("dd/MM/yyyy", "##/##/##", '_');
			linea5.add(this.dataFiEsportiva);
			linea5.add(Box.createHorizontalStrut(140));
			this.panelActivitatEsportiva.add(linea5);
			this.panelActivitatEsportiva.add(Box.createVerticalStrut(20));

			JPanel linea6 = new JPanel();
			linea6.setLayout(new BoxLayout(linea6, BoxLayout.X_AXIS));
			linea6.add(Box.createHorizontalStrut(20));
			linea6.add(new JLabel("Hora d'inici de l'activitat"));
			linea6.add(Box.createHorizontalStrut(15));
			this.horaIniciEsportiva = new JTextField("XX:XX");
			linea6.add(this.horaIniciEsportiva);
			linea6.add(Box.createHorizontalStrut(30));
			linea6.add(new JLabel("Hora de fi de l'activitat"));
			linea6.add(Box.createHorizontalStrut(15));
			this.horaFiEsportiva = new JTextField("XX:XX");
			linea6.add(this.horaFiEsportiva);
			linea6.add(Box.createHorizontalStrut(140));
			this.panelActivitatEsportiva.add(linea6);
			this.panelActivitatEsportiva.add(Box.createVerticalStrut(20));

			this.botoInserirNovaActivitatE = new JButton("Inserir Activitat");
			this.panelActivitatEsportiva.add(this.botoInserirNovaActivitatE);

			this.panelActivitatEsportiva.add(Box.createVerticalStrut(280));
			return (this.panelActivitatEsportiva);
		}

		private JPanel crearPanelActivitatCultural()
		{
			this.panelActivitatCultural = new JPanel();
			this.panelActivitatCultural.setLayout(new BoxLayout(this.panelActivitatCultural, BoxLayout.Y_AXIS));
			this.panelActivitatCultural.setBorder(BorderFactory.createTitledBorder("Creacio activitat cultural"));
			this.panelActivitatCultural.add(Box.createVerticalStrut(20));

			JPanel linea1 = new JPanel();
			linea1.setLayout(new BoxLayout(linea1, BoxLayout.X_AXIS));
			linea1.add(Box.createHorizontalStrut(20));
			linea1.add(new JLabel("Nom de l'activitat:"));
			linea1.add(Box.createHorizontalStrut(10));
			this.nomActivitatC = new JTextField("Nom");
			linea1.add(this.nomActivitatC);
			linea1.add(Box.createHorizontalStrut(20));
			linea1.add(new JLabel("Descripció de l'activitat:"));
			linea1.add(Box.createHorizontalStrut(10));
			this.descripcioActivitatC = new JTextField("Descripcio");
			linea1.add(this.descripcioActivitatC);
			linea1.add(Box.createHorizontalStrut(20));
			this.panelActivitatCultural.add(linea1);
			this.panelActivitatCultural.add(Box.createVerticalStrut(20));

			JPanel linea2 = new JPanel();
			linea2.setLayout(new BoxLayout(linea2, BoxLayout.X_AXIS));
			linea2.add(Box.createHorizontalStrut(20));
			linea2.add(new JLabel("Numero Maxim de Participants"));
			linea2.add(Box.createHorizontalStrut(10));
			this.numMaximParticipantsC = new JTextField("ex: 10");
			linea2.add(this.numMaximParticipantsC);
			linea2.add(Box.createHorizontalStrut(20));
			linea2.add(new JLabel("Adreça on es realitza l'activitat"));
			linea2.add(Box.createHorizontalStrut(10));
			this.adresaActivitatC = new JTextField("Adreça");
			linea2.add(this.adresaActivitatC);
			linea2.add(Box.createHorizontalStrut(20));
			this.panelActivitatCultural.add(linea2);
			this.panelActivitatCultural.add(Box.createVerticalStrut(20));

			JPanel linea3 = new JPanel();
			linea3.setLayout(new BoxLayout(linea3, BoxLayout.X_AXIS));
			linea3.add(Box.createHorizontalStrut(20));
			linea3.add(new JLabel("Població on es realitzarà la activitat"));
			linea3.add(Box.createHorizontalStrut(15));
			this.poblacioActivitatC = new JTextField("Població");
			linea3.add(this.poblacioActivitatC);
			linea3.add(Box.createHorizontalStrut(20));
			linea3.add(new JLabel("Preu de l'activitat"));
			linea3.add(Box.createHorizontalStrut(15));
			this.preuActivitatC = new JTextField("€");
			linea3.add(this.preuActivitatC);
			linea3.add(Box.createHorizontalStrut(60));
			this.panelActivitatCultural.add(linea3);
			this.panelActivitatCultural.add(Box.createVerticalStrut(20));

			JPanel linea4 = new JPanel();
			linea4.setLayout(new BoxLayout(linea4, BoxLayout.X_AXIS));
			linea4.add(Box.createHorizontalStrut(20));
			linea4.add(new JLabel("Dia de l'activitat"));
			linea4.add(Box.createHorizontalStrut(15));
			this.dataActivitatCultural = new JDateChooser("dd/MM/yyyy", "##/##/##", '_');
			linea4.add(this.dataActivitatCultural);
			linea4.add(Box.createHorizontalStrut(60));
			linea4.add(new JLabel("Hora d'inici de l'activitat"));
			linea4.add(Box.createHorizontalStrut(15));
			this.horaIniciACultural = new JTextField("XX:XX");
			linea4.add(this.horaIniciACultural);
			linea4.add(Box.createHorizontalStrut(70));
			this.panelActivitatCultural.add(linea4);
			this.panelActivitatCultural.add(Box.createVerticalStrut(20));

			this.botoInserirNovaActivitatC = new JButton("Inserir Activitat");
			this.panelActivitatCultural.add(this.botoInserirNovaActivitatC);

			this.panelActivitatCultural.add(Box.createVerticalStrut(330));
			return (this.panelActivitatCultural);
		}

		private JPanel crearPanelActivitatFormativa()
		{
			this.panelActivitatFormativa = new JPanel();

			this.panelActivitatFormativa.setLayout(new BoxLayout(this.panelActivitatFormativa, BoxLayout.Y_AXIS));
			this.panelActivitatFormativa.setBorder(BorderFactory.createTitledBorder("Creacio activitat formativa"));
			this.panelActivitatFormativa.add(Box.createVerticalStrut(20));

			JPanel linea1 = new JPanel();
			linea1.setLayout(new BoxLayout(linea1, BoxLayout.X_AXIS));
			linea1.add(Box.createHorizontalStrut(20));
			linea1.add(new JLabel("Nom de l'activitat:"));
			linea1.add(Box.createHorizontalStrut(10));
			this.nomActivitatF = new JTextField("Nom");
			linea1.add(this.nomActivitatF);
			linea1.add(Box.createHorizontalStrut(20));
			linea1.add(new JLabel("Descripció de l'activitat:"));
			linea1.add(Box.createHorizontalStrut(10));
			this.descripcioActivitatF = new JTextField("Descripcio");
			linea1.add(this.descripcioActivitatF);
			linea1.add(Box.createHorizontalStrut(20));
			this.panelActivitatFormativa.add(linea1);
			this.panelActivitatFormativa.add(Box.createVerticalStrut(20));

			JPanel linea2 = new JPanel();
			linea2.setLayout(new BoxLayout(linea2, BoxLayout.X_AXIS));
			linea2.add(Box.createHorizontalStrut(20));
			linea2.add(new JLabel("Numero Maxim de Participants"));
			linea2.add(Box.createHorizontalStrut(10));
			this.numMaximParticipantsF = new JTextField("ex: 10");
			linea2.add(this.numMaximParticipantsF);
			linea2.add(Box.createHorizontalStrut(20));
			linea2.add(new JLabel("Adreça on es realitza l'activitat"));
			linea2.add(Box.createHorizontalStrut(10));
			this.adresaActivitatF = new JTextField("Adreça");
			linea2.add(this.adresaActivitatF);
			linea2.add(Box.createHorizontalStrut(20));
			this.panelActivitatFormativa.add(linea2);
			this.panelActivitatFormativa.add(Box.createVerticalStrut(20));

			JPanel linea3 = new JPanel();
			linea3.setLayout(new BoxLayout(linea3, BoxLayout.X_AXIS));
			linea3.add(Box.createHorizontalStrut(20));
			linea3.add(new JLabel("Població on es realitzarà la activitat"));
			linea3.add(Box.createHorizontalStrut(10));
			this.poblacioActivitatF = new JTextField("Població");
			linea3.add(this.poblacioActivitatF);
			linea3.add(Box.createHorizontalStrut(15));
			linea3.add(new JLabel("Duració de l'activitat (h)"));
			linea3.add(Box.createHorizontalStrut(15));
			this.duracioActivitatF = new JTextField("Duració");
			linea3.add(this.duracioActivitatF);
			linea3.add(Box.createHorizontalStrut(15));
			linea3.add(new JLabel("Hora d'inici"));
			linea3.add(Box.createHorizontalStrut(10));
			this.horaIniciActivitatF = new JTextField("XX:XX");
			linea3.add(this.horaIniciActivitatF);
			linea3.add(Box.createHorizontalStrut(20));
			this.panelActivitatFormativa.add(linea3);
			this.panelActivitatFormativa.add(Box.createVerticalStrut(20));

			JPanel linea4 = new JPanel();
			linea4.setLayout((new BoxLayout(linea4, BoxLayout.X_AXIS)));
			linea4.add(Box.createHorizontalStrut(20));
			linea4.add(new JLabel("Data límit d'inscripció"));
			linea4.add(Box.createHorizontalStrut(15));
			this.dataLimitInscripcioF = new JDateChooser("dd/MM/yyyy", "##/##/##", '_');
			linea4.add(this.dataLimitInscripcioF);
			linea4.add(Box.createHorizontalStrut(50));
			linea4.add(new JLabel("Data de la Activitat"));
			linea4.add(Box.createHorizontalStrut(15));
			this.dataActivitatFormativa = new JDateChooser("dd/MM/yyyy", "##/##/##", '_');
			linea4.add(this.dataActivitatFormativa);
			linea4.add(Box.createHorizontalStrut(90));
			this.panelActivitatFormativa.add(linea4);
			this.panelActivitatFormativa.add(Box.createVerticalStrut(20));

			this.botoInserirNovaActivitatF = new JButton("Inserir Activitat");
			this.panelActivitatFormativa.add(this.botoInserirNovaActivitatF);


			this.panelActivitatFormativa.add(Box.createVerticalStrut(300));
			return (this.panelActivitatFormativa);
		}

		private JPanel crearPanelLlistarActivitats()
		{
			this.panelLlistaActivitats = new JPanel(new CardLayout());

			this.panelLlistaActivitats.add(crearPanelOpcions(), "Opcions");
			this.panelLlistaActivitats.add(crearPanelConsultarActivitat(), "ConsultarActivitat");
			this.panelLlistaActivitats.add(crearPanelGestionarActivitat(), "GestionarActivitat");
			addOyentesItemsPanelLlistarActivitats();
			return (this.panelLlistaActivitats);
		}

		protected void showCardPanelLlistarActivitats(String card)
		{
			((CardLayout) this.panelLlistaActivitats.getLayout()).show(panelLlistaActivitats, card);
		}

		private JPanel crearPanelOpcions()
		{
			this.panelOpcions = new JPanel();
			this.panelOpcions.setLayout(new BoxLayout(this.panelOpcions, BoxLayout.Y_AXIS));
			this.panelOpcions.add(Box.createVerticalStrut(20));

			JPanel linea0 = new JPanel();
			linea0.setLayout(new BoxLayout(linea0, BoxLayout.X_AXIS));
			String[] opcions = {"Indiferent", "Sí", "No"};
			String[] tipus = {"Indiferent", "Esportiva", "Cultural", "Formació"};
			linea0.add(Box.createHorizontalStrut(20));
			linea0.add(new JLabel("Filtres:"));
			linea0.add(Box.createHorizontalStrut(15));
			linea0.add(new JLabel("Admet inscripcions"));
			linea0.add(Box.createHorizontalStrut(10));
			this.admetInscripcions = new JComboBox<String>(opcions);
			linea0.add(this.admetInscripcions);
			linea0.add(Box.createHorizontalStrut(15));
			linea0.add(new JLabel("Tipus d'activitat"));
			linea0.add(Box.createHorizontalStrut(10));
			this.tipusActivitatFiltre = new JComboBox<String>(tipus);
			linea0.add(this.tipusActivitatFiltre);
			linea0.add(Box.createHorizontalStrut(15));
			linea0.add(new JLabel("Població"));
			linea0.add(Box.createHorizontalStrut(10));
			this.poblacioFiltre = new JTextField();
			linea0.add(this.poblacioFiltre);
			linea0.add(Box.createHorizontalStrut(20));
			this.panelOpcions.add(linea0);
			this.panelOpcions.add(Box.createVerticalStrut(20));


			JPanel linea1 = new JPanel();
			linea1.setLayout(new BoxLayout(linea1, BoxLayout.X_AXIS));
			linea1.add(Box.createHorizontalStrut(20));
			linea1.add(new JLabel("Llista de les activitats actuals del centre:"));
			linea1.add(Box.createHorizontalStrut(20));
			this.llistaActivitats = new JTextArea("Llista d'activitats", 10, 30);
			this.llistaActivitats.setFont(new Font("Arial", Font.PLAIN, 12));
			this.llistaActivitats.setWrapStyleWord(true);
			this.llistaActivitats.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
			JScrollPane s = new JScrollPane(this.llistaActivitats);
			s.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			linea1.add(s);
			linea1.add(Box.createHorizontalStrut(20));
			this.panelOpcions.add(linea1);
			this.panelOpcions.add(Box.createVerticalStrut(20));

			JPanel linea2 = new JPanel();
			linea2.setLayout(new BoxLayout(linea2, BoxLayout.X_AXIS));
			linea2.add(Box.createHorizontalStrut(20));
			linea2.add(new JLabel("Activitat escollida a tractar:"));
			linea2.add(Box.createHorizontalStrut(15));
			this.activitatAModificar = new JTextField("Nom de l'activitat");
			linea2.add(this.activitatAModificar);
			linea2.add(Box.createHorizontalStrut(187));
			this.panelOpcions.add(linea2);
			this.panelOpcions.add(Box.createVerticalStrut(20));

			JPanel linea3 = new JPanel();
			linea3.setLayout(new BoxLayout(linea3, BoxLayout.X_AXIS));
			linea3.add(Box.createHorizontalStrut(50));
			this.consultarActivitat = new JButton("Consultar Activitat");
			linea3.add(this.consultarActivitat);
			linea3.add(Box.createHorizontalStrut(30));
			this.eliminarActivitat = new JButton("Eliminar Activitat");
			linea3.add(this.eliminarActivitat);
			linea3.add(Box.createHorizontalStrut(50));
			this.panelOpcions.add(linea3);
			this.panelOpcions.add(Box.createVerticalStrut(20));

			JPanel linea4 = new JPanel();
			linea4.setLayout(new BoxLayout(linea4, BoxLayout.X_AXIS));
			String gestions[] = {"Opcions", "Inscriure una persona", "Cancel·lar una inscripció", "Consultar les Inscripcions"};
			linea4.add(Box.createHorizontalStrut(20));
			linea4.add(new JLabel("Escull una gestió:"));
			linea4.add(Box.createHorizontalStrut(15));
			this.gestioActivitat = new JComboBox<String>(gestions);
			linea4.add(this.gestioActivitat);
			linea4.add(Box.createHorizontalStrut(20));
			this.gestionarActivitatBoto = new JButton("Gestionar");
			linea4.add(this.gestionarActivitatBoto);
			linea4.add(Box.createHorizontalStrut(20));
			this.panelOpcions.add(linea4);
			this.panelOpcions.add(Box.createVerticalStrut(200));

			return (this.panelOpcions);
		}
	
		private JPanel crearPanelConsultarActivitat()
		{
			this.panelConsultarActivitat = new JPanel();
			this.panelConsultarActivitat.add(new JLabel("Panel de consulta"));

			this.tornarDeConsultaAOpcions = new JButton("Tornar Enrere");
			this.panelConsultarActivitat.add(this.tornarDeConsultaAOpcions);

			return (this.panelConsultarActivitat);
		}

		private JPanel crearPanelGestionarActivitat()
		{
			this.panelGestionarActivitat = new JPanel();
			this.panelGestionarActivitat.add(new JLabel("Panel de gestió"));

			this.tornarDeGestioAOpcions = new JButton("Tornar Enrere");
			this.panelGestionarActivitat.add(this.tornarDeGestioAOpcions);

			return (this.panelGestionarActivitat);
		}

		private void addOyentesItemsPanelLlistarActivitats()
		{
			this.consultarActivitat.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					String s = activitatAModificar.getText();
					//Mirar si existeix la activitat en concret
					showCardPanelLlistarActivitats("ConsultarActivitat");
				}
			});
			this.gestionarActivitatBoto.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					String s = activitatAModificar.getText();
					//Mirar si existeix la activitat en concret
					showCardPanelLlistarActivitats("GestionarActivitat");
				}
			});
			this.eliminarActivitat.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					String s = activitatAModificar.getText();
					//funcio per eliminar la activitat
				}
			});
			this.tornarDeConsultaAOpcions.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					showCardPanelLlistarActivitats("Opcions");
				}
			});
			this.tornarDeGestioAOpcions.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					showCardPanelLlistarActivitats("Opcions");
				}
			});
		}
}
