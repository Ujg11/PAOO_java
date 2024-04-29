package GUI_7;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class VentanaCalculaNIF extends JFrame implements VistaCalculoNIF
{
	private JTextField tfDNI, tfNIF;
	private JButton bCalcular, bResetear;

	VentanaCalculaNIF()
	{
		super("Calculo NIF");
		this.init();
	}

	private void init()
	{
		this.setSize(500, 400);
		this.setLocation(475, 300); //La posició on s'inicia la finestra
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.addComponentsPanelContenido();
	}

	private void addComponentsPanelContenido() {
		JPanel panelContenido = new JPanel(new BorderLayout());
		panelContenido.add(BorderLayout.CENTER, crearPanelForm());
		panelContenido.add(BorderLayout.SOUTH, crearPanelBotones());
		JPanel paux = new JPanel();
		paux.add(panelContenido);
		this.setContentPane(new JScrollPane(paux));
	}

	private JPanel crearPanelBotones() {
		JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
		bCalcular = new JButton("Calcular");
		bResetear = new JButton("Resetear");
		panelBotones.add(bCalcular);
		panelBotones.add(bResetear);
		return panelBotones;
	}

	private JPanel crearPanelForm() {
		JPanel panelForm = new JPanel();
		panelForm.setLayout(new BoxLayout(panelForm, BoxLayout.Y_AXIS));
		panelForm.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		panelForm.add(crearPanelFormDNI());
		panelForm.add(Box.createVerticalStrut(10));
		panelForm.add(crearPanelFormNIF());
		panelForm.add(Box.createGlue());
		return panelForm;
	}

	private JPanel crearPanelFormDNI() {
		JPanel panelDNI = new JPanel();
		panelDNI.setLayout(new BoxLayout(panelDNI, BoxLayout.X_AXIS));
		tfDNI = new JTextField(10);
		tfDNI.setPreferredSize(tfDNI.getSize());
		panelDNI.add(new JLabel("DNI:"));
		panelDNI.add(Box.createHorizontalStrut(5));
		panelDNI.add(tfDNI);
		panelDNI.add(Box.createGlue());
		return panelDNI;
	}

	private JPanel crearPanelFormNIF() {
		JPanel panelNIF = new JPanel();
		panelNIF.setLayout(new BoxLayout(panelNIF, BoxLayout.X_AXIS));
		tfNIF = new JTextField(10);
		tfNIF.setPreferredSize(tfNIF.getSize());
		tfNIF.setEditable(false);
		panelNIF.add(new JLabel("NIF:"));
		panelNIF.add(Box.createHorizontalStrut(5));
		panelNIF.add(tfNIF);
		panelNIF.add(Box.createGlue());
		return panelNIF;
	}

	public void setNIF(String nif) {
		this.tfNIF.setText(nif);
	}

	public String getDNI() {
		return tfDNI.getText();
	}

	public void resetearFormulario() {
		tfDNI.setText("");
		tfNIF.setText("");
	}

	public void addOyenteCalcular(ActionListener l) {
		bCalcular.addActionListener(l);
	}

	public void addOyenteResetear(ActionListener l) {
		bResetear.addActionListener(l);
	}

}




