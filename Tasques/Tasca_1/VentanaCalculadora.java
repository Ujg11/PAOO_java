import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
//import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaCalculadora extends JFrame
{
	private JTextField display;
	private JButton teclaClear;
	private JButton[] taulaBotons;
	private JButton punt;
	private JButton teclaIgual;
	private JButton teclaSumar;
	private JButton teclaRestar;
	private JButton teclaMultiplicar;
	private JButton teclaDividir;

	
	public VentanaCalculadora()
	{
		super();
		init();
	}

	private void init()
	{
		JPanel panelContingut = new JPanel(new BorderLayout());

		panelContingut.add(crearPanelDisplay(), BorderLayout.NORTH);
		panelContingut.add(crearPanelClear(), BorderLayout.CENTER);
		panelContingut.add(crearPanelTeclas(), BorderLayout.SOUTH);
		
		this.setSize(230, 240);
		this.setTitle("Calculadora");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocation(500, 350);
		this.setResizable(false);
		
		this.setContentPane(panelContingut);
	}

	private JPanel crearPanelDisplay()
	{
		JPanel panel = new JPanel();

		this.display = new JTextField("0", 10);
		this.display.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1, true));
		this.display.setBackground(Color.WHITE);
		this.display.setFont(new Font("Arial", Font.BOLD, 25));
		this.display.setHorizontalAlignment(JTextField.RIGHT);
		this.display.setEditable(false);
		panel.add(display);
		return (panel);
	}

	private JPanel crearPanelClear()
	{
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

		this.teclaClear = new JButton("C");
		this.teclaClear.setBackground(Color.RED);
		this.teclaClear.setForeground(Color.WHITE);

		panel.add(teclaClear);
		return (panel);
	}

	private JPanel crearPanelTeclas()
	{
		JPanel panel = new JPanel(new GridLayout(4, 4, 5, 5));
		this.taulaBotons = new JButton[10]; //0 al 9
		String nums[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

		panel.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
		taulaBotons[7] = new JButton(nums[7]);
		panel.add(taulaBotons[7]);
		taulaBotons[8] = new JButton(nums[8]);
		panel.add(taulaBotons[8]);
		taulaBotons[9] = new JButton(nums[9]);
		panel.add(taulaBotons[9]);

		this.teclaDividir = new JButton("/");
		panel.add(this.teclaDividir);

		taulaBotons[4] = new JButton(nums[4]);
		panel.add(taulaBotons[4]);
		taulaBotons[5] = new JButton(nums[5]);
		panel.add(taulaBotons[5]);
		taulaBotons[6] = new JButton(nums[6]);
		panel.add(taulaBotons[6]);

		this.teclaMultiplicar = new JButton("*");
		panel.add(teclaMultiplicar);

		taulaBotons[1] = new JButton(nums[1]);
		panel.add(taulaBotons[1]);
		taulaBotons[2] = new JButton(nums[2]);
		panel.add(taulaBotons[2]);
		taulaBotons[3] = new JButton(nums[3]);
		panel.add(taulaBotons[3]);

		this.teclaRestar = new JButton("-");
		panel.add(teclaRestar);

		taulaBotons[0] = new JButton(nums[0]);
		panel.add(taulaBotons[0]);

		this.punt = new JButton(".");
		panel.add(this.punt);
		this.teclaIgual = new JButton("=");
		panel.add(teclaIgual);
		this.teclaSumar = new JButton("+");
		panel.add(this.teclaSumar);
		
		return (panel);
	}
}
