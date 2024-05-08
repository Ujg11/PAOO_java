import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.Color;
import java.awt.Component;

public class MiVentana extends JFrame {
	private JPanel panelPrincipal;
	private JMenuItem miAcercaDe,miSalir,miIconificar,miZoom,miNormal;
	private JMenuItem miCyan,miOrange,miGreen,miMagenta,miYellow;
	private JRadioButtonMenuItem rbMenuItem1,rbMenuItem2;
	private JCheckBoxMenuItem cbMenuItem1,cbMenuItem2;
	private JMenuItem jpMenuItem1;
	private JMenuItem jpMenuItem2;
	
	public MiVentana() {
        super();
        this.init();
    }
	
    public MiVentana(String title) {
        super(title);
        this.init();
    }
    
    private void init() {
        this.setLocation(1000,500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setIconImage(new ImageIcon("upc-icon.png").getImage());
        this.addComponentsPanelContenido();
        this.setJMenuBar(crearMenuBar());
        this.crearPopupMenu();
        this.pack();
    }
    
	private void addComponentsPanelContenido() {
	    JPanel panelContenido = new JPanel(new BorderLayout());
		panelContenido.setPreferredSize(new Dimension(475,300));
		panelContenido.add(crearPanelPrincipal(),BorderLayout.CENTER);
		this.setContentPane(panelContenido);
    }
	
    private JPanel crearPanelPrincipal() {
    	panelPrincipal = new JPanel(new CardLayout());
	    JPanel p1=new JPanel(),p2=new JPanel(),p3=new JPanel(),p4=new JPanel(),p5=new JPanel();
	    p1.setBackground(Color.CYAN);
	    p2.setBackground(Color.ORANGE);
	    p3.setBackground(Color.GREEN);
	    p4.setBackground(Color.MAGENTA);
	    p5.setBackground(Color.YELLOW);
	    panelPrincipal.add(p1,"pCyan"); 
	    panelPrincipal.add(p2,"pOrange");
	    panelPrincipal.add(p3,"pGreen");
	    panelPrincipal.add(p4,"pMagenta");
	    panelPrincipal.add(p5,"pYellow");
	    return panelPrincipal;
    }
    
	protected void showCard(String card) {
		((CardLayout) panelPrincipal.getLayout()).show(panelPrincipal, card);		
	}

    private JMenuBar crearMenuBar() {
    	JMenuBar menuBar = new JMenuBar();
   	    menuBar.add(crearMenuAplicacion());
      	menuBar.add(crearMenuVentana());
      	menuBar.add(crearMenuConfiguracion());
      	addOyentesItemsMenuVentana();
        return menuBar;	
	}
    
	private JMenu crearMenuAplicacion() {
    	JMenu menu = new JMenu("MiVentana");
    	menu.setMnemonic(KeyEvent.VK_M);

    	miAcercaDe = new JMenuItem("Acerca de MiVentana",new ImageIcon("upc-menu-icon.png"));
    	miAcercaDe.setMnemonic(KeyEvent.VK_A);
   	
        miSalir = new JMenuItem("Salir",KeyEvent.VK_S);
		miSalir.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_S, ActionEvent.ALT_MASK));

		menu.add(miAcercaDe);
        menu.add(miSalir);
     	return menu;
 	}
	
	private JMenu crearMenuVentana() {
    	JMenu menu = new JMenu("Ventana", true);
    	menu.setMnemonic(KeyEvent.VK_V);
    	miIconificar = new JMenuItem("Iconificar", KeyEvent.VK_I);
    	miIconificar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.ALT_MASK));
    	miZoom = new JMenuItem("Zoom", KeyEvent.VK_Z);
    	miZoom.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.ALT_MASK));
     	miNormal = new JMenuItem("Normal", KeyEvent.VK_N);
    	miNormal.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.ALT_MASK));
    	menu.add(miIconificar);
    	menu.add(miZoom);
    	menu.add(miNormal);
		menu.addSeparator();
		menu.add(crearSubMenuVista());
		return menu;
	}
	
	private JMenu crearMenuConfiguracion() {
		JMenu menu = new JMenu("Configuracion");
		menu.setMnemonic(KeyEvent.VK_C);

		rbMenuItem1 = new JRadioButtonMenuItem("Exclusivo 1",true);
		rbMenuItem1.setMnemonic(KeyEvent.VK_E);
		
		rbMenuItem2 = new JRadioButtonMenuItem("Exclusivo 2");
		rbMenuItem2.setMnemonic(KeyEvent.VK_X);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rbMenuItem1);
		group.add(rbMenuItem2);
		menu.add(rbMenuItem1);
		menu.add(rbMenuItem2);

		//grup de check box menu items
		menu.addSeparator();
		cbMenuItem1 = new JCheckBoxMenuItem("Opcion B");
		cbMenuItem1.setMnemonic(KeyEvent.VK_B);
		
		cbMenuItem2 = new JCheckBoxMenuItem("Opcion F");
		cbMenuItem2.setMnemonic(KeyEvent.VK_F);
		menu.add(cbMenuItem1);
		menu.add(cbMenuItem2);
		
		return menu;
	}
	
	private JMenu crearSubMenuVista() {
		JMenu submenu = new JMenu("Mostrar Vista");
		submenu.setMnemonic(KeyEvent.VK_V);
		
		miCyan = new JMenuItem("Cyan",KeyEvent.VK_C);		
		miCyan.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_C, ActionEvent.ALT_MASK));
		
		miOrange = new JMenuItem("Orange",KeyEvent.VK_O);		
		miOrange.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_O, ActionEvent.ALT_MASK));

		miGreen = new JMenuItem("Green",KeyEvent.VK_G);		
		miGreen.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_G, ActionEvent.ALT_MASK));

		miMagenta = new JMenuItem("Magenta",KeyEvent.VK_M);		
		miMagenta.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_M, ActionEvent.ALT_MASK));

		miYellow = new JMenuItem("Yellow",KeyEvent.VK_Y);		
		miYellow.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_Y, ActionEvent.ALT_MASK));

		submenu.add(miCyan);
		submenu.add(miOrange);
		submenu.add(miGreen);
		submenu.add(miMagenta);
		submenu.add(miYellow);
		return submenu;
	}
	
    private void addOyentesItemsMenuVentana() {
    	miIconificar.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				minimizar();
			}
		});
       	miZoom.addActionListener(new ActionListener() {		
			@Override
   			public void actionPerformed(ActionEvent e) {
    				maximizar();
    			}
    		});
    	miNormal.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				normal();
			}
		});
		miCyan.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				showCard("pCyan");
			}
		});
		miOrange.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				showCard("pOrange");				
			}
		});   	
		miGreen.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				showCard("pGreen");				
			}
		});
		miMagenta.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				showCard("pMagenta");				
			}
		});
		miYellow.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				showCard("pYellow");				
			}
		});  	
    }
    
	protected void normal() {
		this.setExtendedState(JFrame.NORMAL);
	}
	
	protected void minimizar() {
		this.setExtendedState(JFrame.ICONIFIED);
	}
	
	protected void maximizar() {
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
	
	private void crearPopupMenu() {
		JPopupMenu jpMenu = new JPopupMenu("Mostrar Vista");
		jpMenuItem1 = new JMenuItem("IM 1");
		jpMenuItem2 = new JMenuItem("IM 2");
		jpMenu.add(jpMenuItem1);
		jpMenu.add(jpMenuItem2);
		this.panelPrincipal.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				quizasMostrar(e);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				quizasMostrar(e);
			}
			private void quizasMostrar(MouseEvent e) {
				if(e.isPopupTrigger()) {
					jpMenu.show(e.getComponent(), e.getX(), e.getY());
				}
			}
		});
	}
}
