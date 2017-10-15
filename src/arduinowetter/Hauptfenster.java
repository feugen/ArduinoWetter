package arduinowetter;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	
	private MenuItem trayItemSchliessen = null;
	private MenuItem trayitemAction = null;
	private TrayIcon trayIcon = null;
	

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
		
		//Systemtray
		
		if(!SystemTray.isSupported()) {
			System.out.println("Achtung, Systemtray wird auf diesem System nicht unterstützt");
		}else {
			//Systemtray holen
			SystemTray systemTray = SystemTray.getSystemTray();
			Image bild = Toolkit.getDefaultToolkit().getImage("gruen.png");
			
			//Popup Menü erstellen
			PopupMenu trayPopupMenu = new PopupMenu();
			
			//1. Item erstellen und hinzufügen
			trayitemAction = new MenuItem("Über");
			trayPopupMenu.add(trayitemAction);
			trayitemAction.addActionListener(new ListenerMain());
			
			//2. Item erstellen
		    trayItemSchliessen = new MenuItem("Schließen");
		    trayItemSchliessen.addActionListener(new ListenerMain()); 
		    trayPopupMenu.add(trayItemSchliessen);
		    trayItemSchliessen.addActionListener(new ListenerMain());
		    
		    //TrayIcon aufsetzen
		    trayIcon = new TrayIcon(bild, "SystemTray Demo", trayPopupMenu);
		    //Auf Standardgröße je nach Betriebssystem setzen
		    trayIcon.setImageAutoSize(true);
		    trayIcon.addMouseListener(new ListenerMain());
		    
		    try{
		        systemTray.add(trayIcon);
		    }catch(AWTException awtException){
		        awtException.printStackTrace();
		    }
		}

		fenster = new JFrame("ArduinoWetter - super-physik.de");
		fenster.setBounds(400, 400, 1280, 720);
		fenster.setMinimumSize(new Dimension(800, 480));
		fenster.setLocationRelativeTo(null);
		fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenster.setResizable(true);
		fenster.setVisible(true);
		
		//Tab Leiste und Tabs erzeugen
		JTabbedPane tabLeiste = new JTabbedPane();
		JPanel tab1 = new JPanel();
		JPanel tab2 = new JPanel();
		JPanel tab3 = new JPanel();
		tabLeiste.addTab("Arduino", tab1);
		tabLeiste.addTab("Extern", tab2);
		tabLeiste.addTab("Übungen", tab3);
		
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
	
	private class ListenerMain implements MouseListener, ActionListener {

		@Override
		public void mouseClicked(MouseEvent arg0) {
			if (trayIcon != null && arg0.getSource() == trayIcon) {
				if (fenster.isVisible()) {
					fenster.setVisible(false);
				}else {
					fenster.setVisible(true);
				}
			}
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

		@Override
		public void actionPerformed(ActionEvent e) {
			if (trayItemSchliessen != null && e.getSource() == trayItemSchliessen) {
				System.exit(0);
			}
			if (trayitemAction != null && e.getSource() == trayitemAction) {
				new FensterUeber();
			}
		}
	}
}
