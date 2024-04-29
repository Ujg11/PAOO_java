import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
//mport java.awt.Font;
//import java.awt.GridBagLayout;

public class VentanaReservas extends JFrame
{
	private JButton botonReiniciar;
	private JButton botonEnviar;
	private JButton botonCancelar;

	private JTextField nom;
	private JRadioButton femenino;
	private JRadioButton masculino;
	private JRadioButton otro;
	private JTextArea  direccion;
	private JTextField telefon;
	private JTextField mail;

	private JTextField numPersonas;
	@SuppressWarnings("rawtypes")
	private JComboBox  categoriaHabitacion;
	private JTextField entrada;
	private JTextField salida;
	private JCheckBox  desayuno;
	private JCheckBox  almuerzo;
	private JCheckBox  cena;

	public VentanaReservas()
	{
		super();
		init();
	}	

	private void init()
	{
		this.setTitle("Reservas");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(420, 550);
		this.setLocation(500, 350);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		JPanel panelContingut = new JPanel();
		panelContingut.setLayout(new BoxLayout(panelContingut, BoxLayout.Y_AXIS));
		JPanel panelDatosPersonales = crearDatosPersonales();
		JPanel panelDetallesReserva = crearDetallesReserva();
		JPanel panelBotonesFinalizar = crearBotonesFinalizar();

		panelContingut.add(Box.createVerticalStrut(25));

		JPanel aux1 = new JPanel();
		aux1.setLayout(new BoxLayout(aux1, BoxLayout.X_AXIS));
		aux1.add(Box.createHorizontalStrut(20));
		aux1.add(panelDatosPersonales);
		panelContingut.add(aux1);
		panelContingut.add(Box.createVerticalStrut(25));

		JPanel aux2 = new JPanel();
		aux2.setLayout(new BoxLayout(aux2, BoxLayout.X_AXIS));
		aux2.add(Box.createHorizontalStrut(20));
		aux2.add(panelDetallesReserva);
		panelContingut.add(aux2);
		panelContingut.add(Box.createVerticalStrut(25));
	
		panelContingut.add(panelBotonesFinalizar);
		panelContingut.add(Box.createVerticalStrut(25));

		this.setContentPane(panelContingut);
	}

	private JPanel crearDatosPersonales()
	{
		JPanel datosPersonales = new JPanel();
		datosPersonales.setLayout(new BoxLayout(datosPersonales, BoxLayout.Y_AXIS));
		datosPersonales.setBorder(BorderFactory.createTitledBorder("Datos Personales"));
		//datosPersonales.setMaximumSize(new Dimension(30, 30));
		
		JPanel lineaNom = new JPanel();
		lineaNom.setLayout(new BoxLayout(lineaNom, BoxLayout.X_AXIS));
		lineaNom.add(Box.createHorizontalStrut(20));
		lineaNom.add(new JLabel("Nombre"));
		lineaNom.add(Box.createHorizontalStrut(15));
		this.nom = new JTextField("Nombre", 25);
		lineaNom.add(this.nom);
		JPanel aux1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		aux1.add(lineaNom);

		JPanel lineaGenere = new JPanel();
		lineaGenere.setLayout(new BoxLayout(lineaGenere, BoxLayout.X_AXIS));
		lineaGenere.add(Box.createHorizontalStrut(20));
		lineaGenere.add(new JLabel("Genero"));
		lineaGenere.add(Box.createHorizontalStrut(15));
		this.femenino = new JRadioButton("Femenino", true);
		lineaGenere.add(femenino);
		lineaGenere.add(Box.createHorizontalStrut(20));
		this.masculino = new JRadioButton("Masculino");
		lineaGenere.add(masculino);
		lineaGenere.add(Box.createHorizontalStrut(20));
		this.otro = new JRadioButton("Otro");
		lineaGenere.add(otro);
		JPanel aux2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		aux2.add(lineaGenere);
		

		JPanel lineaDireccio = new JPanel();
		lineaDireccio.setLayout(new BoxLayout(lineaDireccio, BoxLayout.X_AXIS));
		lineaDireccio.add(Box.createHorizontalStrut(20));
		lineaDireccio.add(new JLabel("Direccion"));
		lineaDireccio.add(Box.createHorizontalStrut(10));
		this.direccion = new JTextArea("Direccion");
		this.direccion.setPreferredSize(new Dimension(250, 80));
		this.direccion.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		lineaDireccio.add(this.direccion);
		JPanel aux3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		aux3.add(lineaDireccio);

		JPanel lineaTelefon = new JPanel();
		lineaTelefon.setLayout(new BoxLayout(lineaTelefon, BoxLayout.X_AXIS));
		lineaTelefon.add(Box.createHorizontalStrut(20));
		lineaTelefon.add(new JLabel("Telefono"));
		lineaTelefon.add(Box.createHorizontalStrut(13));
		this.telefon = new JTextField("666666666");
		this.telefon.setColumns(25);
		lineaTelefon.add(this.telefon);
		JPanel aux4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		aux4.add(lineaTelefon);
		
		JPanel lineaEmail = new JPanel();
		lineaEmail.setLayout(new BoxLayout(lineaEmail, BoxLayout.X_AXIS));
		lineaEmail.add(Box.createHorizontalStrut(20));
		lineaEmail.add(new JLabel("Email"));
		lineaEmail.add(Box.createHorizontalStrut(34));
		this.mail = new JTextField("nombre@gmail.com");
		this.mail.setColumns(25);
		lineaEmail.add(this.mail);
		JPanel aux5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		aux5.add(lineaEmail);


		datosPersonales.add(aux1);
		datosPersonales.add(aux2);
		datosPersonales.add(aux3);
		datosPersonales.add(aux4);
		datosPersonales.add(aux5);
		return (datosPersonales);		
	}

	private JPanel crearDetallesReserva()
	{
		JPanel detallesReserva = new JPanel();
		detallesReserva.setLayout(new BoxLayout(detallesReserva, BoxLayout.Y_AXIS));
		detallesReserva.setBorder(BorderFactory.createTitledBorder("Detalles Reserva"));
		//detallesReserva.setMaximumSize(new Dimension(200, 150));

		JPanel lineaNumPersones = new JPanel();
		lineaNumPersones.setLayout(new BoxLayout(lineaNumPersones, BoxLayout.X_AXIS));
		lineaNumPersones.add(Box.createHorizontalStrut(20));
		lineaNumPersones.add(new JLabel("Numero de personas"));
		lineaNumPersones.add(Box.createHorizontalStrut(15));
		this.numPersonas = new JTextField("2", 5);
		lineaNumPersones.add(this.numPersonas);
		JPanel aux1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		aux1.add(lineaNumPersones);
		
		JPanel lineaCategoriaHab = new JPanel();
		String[] tipus = {"Suit", "Basica Doble", "Basica Individual"};
		lineaCategoriaHab.setLayout(new BoxLayout(lineaCategoriaHab, BoxLayout.X_AXIS));
		lineaCategoriaHab.add(Box.createHorizontalStrut(20));
		lineaCategoriaHab.add(new JLabel("Categoria Habitacion"));
		lineaCategoriaHab.add(Box.createHorizontalStrut(15));
		this.categoriaHabitacion = new JComboBox<String>(tipus);
		lineaCategoriaHab.add(this.categoriaHabitacion);
		JPanel aux2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		aux2.add(lineaCategoriaHab);

		JPanel lineaEntradaSortida = new JPanel();
		lineaEntradaSortida.setLayout(new BoxLayout(lineaEntradaSortida, BoxLayout.X_AXIS));
		lineaEntradaSortida.add(Box.createHorizontalStrut(20));
		lineaEntradaSortida.add(new JLabel("Entrada"));
		lineaEntradaSortida.add(Box.createHorizontalStrut(15));
		this.entrada = new JTextField("1/8/2020", 10);
		lineaEntradaSortida.add(this.entrada);
		lineaEntradaSortida.add(Box.createHorizontalStrut(15));
		lineaEntradaSortida.add(new JLabel("Salida"));
		lineaEntradaSortida.add(Box.createHorizontalStrut(15));
		this.salida = new JTextField("1/9/2020", 10);
		lineaEntradaSortida.add(this.salida);
		JPanel aux3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		aux3.add(lineaEntradaSortida);

		JPanel lineaComidas = new JPanel();
		lineaComidas.setLayout(new BoxLayout(lineaComidas, BoxLayout.X_AXIS));
		lineaComidas.add(Box.createHorizontalStrut(20));
		lineaComidas.add(new JLabel("Comidas"));
		lineaComidas.add(Box.createHorizontalStrut(15));
		this.desayuno = new JCheckBox("Desayuno", true);
		lineaComidas.add(this.desayuno);
		lineaComidas.add(Box.createHorizontalStrut(20));
		this.almuerzo = new JCheckBox("Almuerzo", true);
		lineaComidas.add(this.almuerzo);
		lineaComidas.add(Box.createHorizontalStrut(20));
		this.cena = new JCheckBox("Cena", true);
		lineaComidas.add(this.cena);
		JPanel aux4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		aux4.add(lineaComidas);

		detallesReserva.add(aux1);
		detallesReserva.add(aux2);
		detallesReserva.add(aux3);
		detallesReserva.add(aux4);
		return (detallesReserva);
	}

	private JPanel crearBotonesFinalizar()
	{
		JPanel panelSur = new JPanel(new FlowLayout(FlowLayout.CENTER));
		this.botonReiniciar = new JButton("Reiniciar");
		this.botonEnviar = new JButton("Enviar");
		this.botonCancelar = new JButton("Cancelar");

		panelSur.add(this.botonReiniciar);
		panelSur.add(this.botonEnviar);
		panelSur.add(this.botonCancelar);

		return (panelSur);
	}
}