import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FinestraCataleg extends JFrame implements IVistaCatalegProductes
{
	private JTextField	codi;
	private JTextField	infoCodi;
	private JTextField	infoDescripcio;
	private JTextField	infoPreuSenseIva;
	private JTextField	infoPreuAmbIva;

	private JButton		botoBuscar;
	private JButton		botoBorrar;

	public FinestraCataleg()
	{
		super();
		init();
	}

	private void init()
	{
		this.setTitle("Catàleg de Productes");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(420, 380);
		this.setLocation(500, 350);
		this.setResizable(false);

		JPanel panelContingut = new JPanel();
		panelContingut.setLayout(new BoxLayout(panelContingut, BoxLayout.Y_AXIS));
		JPanel panelDeConsulta = crearPanelConsulta();
		JPanel infoProducte = crearPanelInfoProducte();
		JPanel botonsBuscarClear = crearBotons();

		panelContingut.add(Box.createVerticalStrut(20));
		panelContingut.add(panelDeConsulta);
		panelContingut.add(Box.createVerticalStrut(20));
		panelContingut.add(infoProducte);
		panelContingut.add(Box.createVerticalStrut(20));
		panelContingut.add(botonsBuscarClear);
		panelContingut.add(Box.createVerticalStrut(20));

		this.setContentPane(panelContingut);
	}

	private JPanel crearPanelConsulta()
	{
		JPanel panelConsulta = new JPanel();
		panelConsulta.setLayout(new BoxLayout(panelConsulta, BoxLayout.X_AXIS));
		
		panelConsulta.add(Box.createHorizontalStrut(20));
		panelConsulta.add(new JLabel("Codi del Producte:"));
		panelConsulta.add(Box.createHorizontalStrut(20));
		this.codi = new JTextField("Introduir Codi", 20);
		panelConsulta.add(this.codi);
		panelConsulta.add(Box.createHorizontalStrut(20));

		return (panelConsulta);
	}

	private JPanel crearPanelInfoProducte()
	{
		JPanel infoProducte = new JPanel();
		infoProducte.setLayout(new BoxLayout(infoProducte, BoxLayout.Y_AXIS));
		infoProducte.setBorder(BorderFactory.createTitledBorder("Informació del Producte"));
		infoProducte.add(Box.createVerticalStrut(20));

		JPanel panelCodi = new JPanel();
		panelCodi.setLayout(new BoxLayout(panelCodi, BoxLayout.X_AXIS));
		panelCodi.add(Box.createHorizontalStrut(20));
		panelCodi.add(new JLabel("Codi:"));
		panelCodi.add(Box.createHorizontalStrut(80));
		this.infoCodi = new JTextField("", 15);
		this.infoCodi.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1, true));
		this.infoCodi.setBackground(Color.WHITE);
		this.infoCodi.setHorizontalAlignment(JTextField.LEFT);
		this.infoCodi.setFont(new Font("Arial", Font.BOLD, 15));
		this.infoCodi.setEditable(false);
		panelCodi.add(this.infoCodi);
		panelCodi.add(Box.createHorizontalStrut(20));
		infoProducte.add(panelCodi);

		infoProducte.add(Box.createVerticalStrut(15));

		JPanel panelDescripcio = new JPanel();
		panelDescripcio.setLayout(new BoxLayout(panelDescripcio, BoxLayout.X_AXIS));
		panelDescripcio.add(Box.createHorizontalStrut(20));
		panelDescripcio.add(new JLabel("Descripcio:"));
		panelDescripcio.add(Box.createHorizontalStrut(45));
		this.infoDescripcio = new JTextField("", 15);
		this.infoDescripcio.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1, true));
		this.infoDescripcio.setBackground(Color.WHITE);
		this.infoDescripcio.setHorizontalAlignment(JTextField.LEFT);
		this.infoDescripcio.setFont(new Font("Arial", Font.BOLD, 15));
		this.infoDescripcio.setEditable(false);
		panelDescripcio.add(this.infoDescripcio);
		panelDescripcio.add(Box.createHorizontalStrut(20));
		infoProducte.add(panelDescripcio);

		infoProducte.add(Box.createVerticalStrut(15));

		JPanel panelPreuSenseIva = new JPanel();
		panelPreuSenseIva.setLayout(new BoxLayout(panelPreuSenseIva, BoxLayout.X_AXIS));
		panelPreuSenseIva.add(Box.createHorizontalStrut(20));
		panelPreuSenseIva.add(new JLabel("Preu sense IVA:"));
		panelPreuSenseIva.add(Box.createHorizontalStrut(20));
		this.infoPreuSenseIva = new JTextField("", 15);
		this.infoPreuSenseIva.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1, true));
		this.infoPreuSenseIva.setBackground(Color.WHITE);
		this.infoPreuSenseIva.setHorizontalAlignment(JTextField.LEFT);
		this.infoPreuSenseIva.setFont(new Font("Arial", Font.BOLD, 15));
		this.infoPreuSenseIva.setEditable(false);
		panelPreuSenseIva.add(this.infoPreuSenseIva);
		panelPreuSenseIva.add(Box.createHorizontalStrut(20));
		infoProducte.add(panelPreuSenseIva);

		infoProducte.add(Box.createVerticalStrut(15));

		JPanel panelPreuAmbIva = new JPanel();
		panelPreuAmbIva.setLayout(new BoxLayout(panelPreuAmbIva, BoxLayout.X_AXIS));
		panelPreuAmbIva.add(Box.createHorizontalStrut(20));
		panelPreuAmbIva.add(new JLabel("Preu amb IVA:"));
		panelPreuAmbIva.add(Box.createHorizontalStrut(30));
		this.infoPreuAmbIva = new JTextField("", 15);
		this.infoPreuAmbIva.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1, true));
		this.infoPreuAmbIva.setBackground(Color.WHITE);
		this.infoPreuAmbIva.setHorizontalAlignment(JTextField.LEFT);
		this.infoPreuAmbIva.setFont(new Font("Arial", Font.BOLD, 15));
		this.infoPreuAmbIva.setEditable(false);
		panelPreuAmbIva.add(this.infoPreuAmbIva);
		panelPreuAmbIva.add(Box.createHorizontalStrut(20));
		infoProducte.add(panelPreuAmbIva);

		return (infoProducte);
	}

	private JPanel crearBotons()
	{
		JPanel panelBotons = new JPanel(new FlowLayout(FlowLayout.CENTER));
		this.botoBuscar = new JButton("Buscar");
		this.botoBorrar = new JButton("Borrar");

		panelBotons.add(this.botoBuscar);
		panelBotons.add(this.botoBorrar);

		return (panelBotons);
	}

	public String	getCodi()
	{
		return (this.codi.getText());
	}

	public void		mostrarProducte(Producte p)
	{
		this.infoCodi.setText(p.getCodi());
		this.infoDescripcio.setText(p.getDescripcio());
		this.infoPreuSenseIva.setText(p.getPreuSenseIVA() + "€");
		this.infoPreuAmbIva.setText(p.consultarPreuAmbIVA() + "€");
	}

	public void		ferClear()
	{
		this.codi.setText("Introduir Codi");
		this.infoCodi.setText("");
		this.infoDescripcio.setText("");
		this.infoPreuSenseIva.setText("");
		this.infoPreuAmbIva.setText("");
	}

	public void		mostrarMissatgeError(String missatge)
	{
		JOptionPane.showMessageDialog(this, missatge, "Error!", JOptionPane.ERROR_MESSAGE);
	}

	public void		addListenerConsultar(ActionListener l)
	{
		this.botoBuscar.addActionListener(l);
	}

	public void		addListenerClear(ActionListener l)
	{
		this.botoBorrar.addActionListener(l);
	}
}
