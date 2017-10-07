package arduinowetter;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Hauptfenster {
	
	private JFrame fenster;
	private JMenuItem mnexit, mneinst, mnueber;
	
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	private JPanel panel4 = new JPanel();
	

	/**
	 * Konstruktor
	 */
	public Hauptfenster() {
		initialisierung();
	}
	
	
	/**
	 * Initialisierung
	 */
	private void initialisierung() {
		fenster = new JFrame("ArduinoWetter - super-physik.de");
		fenster.setBounds(400, 400, 1280, 720);
		fenster.setLocationRelativeTo(null);
		fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenster.setResizable(false);
		fenster.setVisible(true);
		
		//Tab Leiste und Tabs erzeugen
		JTabbedPane tabLeiste = new JTabbedPane();
		JPanel tab1 = new JPanel();
		JPanel tab2 = new JPanel();
		tabLeiste.addTab("Tab1", tab1);
		tabLeiste.addTab("Tab2", tab2);
		
		//Tab1 Layout und Elemente
		tab1.setLayout(new GridLayout(2, 2));
		tab1.add(panel1);
		tab1.add(panel2);
		tab1.add(panel3);
		tab1.add(panel4);
		panel1.setBackground(new Color(155, 155, 130));
		
		//Tab2 Layout und Elemente
		tab2.add(new JButton("Button des zweiten Tabs"));
		
		fenster.add(tabLeiste);
		
		
		//Menüleiste
		JMenuBar menuBar = new JMenuBar();
		fenster.setJMenuBar(menuBar);
		
		//Menü - Datei
		JMenu mnDatei = new JMenu("Datei");
		menuBar.add(mnDatei);
		
		//Menüeinträge - Datei - Schließen
		mnexit = new JMenuItem("Schließen");
		mnDatei.add(mnexit);
		mnexit.addMouseListener(new ListenerMain());
		
		//Menü - Extras
		JMenu mnExtras = new JMenu("Extras");
		menuBar.add(mnExtras);
		
		//Menüeinträge - Extras - Einstellungen
		mneinst = new JMenuItem("Einstellungen");
		mnExtras.add(mneinst);
		mneinst.addMouseListener(new ListenerMain());
		
		//Menü - Hilfe
		JMenu mnHilfe = new JMenu("Hilfe");
		menuBar.add(mnHilfe);
		
		//Menüeinträge - Hilfe - Über
		mnueber = new JMenuItem("Über");
		mnHilfe.add(mnueber);
		mnueber.addMouseListener(new ListenerMain());
		
	}
	
	
	private class ListenerMain implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent arg0) {
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			
			//Programm Schließen
			if (arg0.getSource() == mnexit) {
				System.exit(0);
			}
			//Einstellungen aufrufen
			else if (arg0.getSource() == mneinst) {
				new FensterEinstellungen();
			}
			//Über Fenster aufrufen
			else if (arg0.getSource() == mnueber) {
				new FensterUeber();
			}
			
		}

	}

}
