package arduinowetter;

import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class ArduinoWetter {
	
	public static final String VERSIONSNUMMER = "0.1";

	private JFrame frame;

	/**
	 * Software starten.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArduinoWetter window = new ArduinoWetter();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Konstructor lässt die Initialisierung laufen
	 */
	public ArduinoWetter() {
		initialize();
	}

	/**
	 * Initialisierung.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(400, 400, 1280, 720);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("ArduinoWetter - super-physik.de");
		frame.setResizable(false);
		
		//Menüleiste
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		//Menü - Datei
		JMenu mnDatei = new JMenu("Datei");
		menuBar.add(mnDatei);
		
		//Menüeinträge - Datei - Schließen
		JMenuItem mnexit = new JMenuItem("Schließen");
		mnDatei.add(mnexit);
		mnexit.addMouseListener(new ListenerMain());
		
		//Menü - Extras
		JMenu mnExtras = new JMenu("Extras");
		menuBar.add(mnExtras);
		
		//Menüeinträge - Extras - Einstellungen
		JMenuItem mneinst = new JMenuItem("Einstellungen");
		mnExtras.add(mneinst);
		mneinst.addMouseListener(new ListenerMain());
		
		//Menü - Hilfe
		JMenu mnHilfe = new JMenu("Hilfe");
		menuBar.add(mnHilfe);
		
		//Menüeinträge - Hilfe - Über
		JMenuItem mntmber = new JMenuItem("Über");
		mnHilfe.add(mntmber);
		mntmber.addMouseListener(new ListenerMain());
		
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
			
			Object quelle = arg0.getSource();
			// Todo schlechte Lösungen, wenn Buttonbeschriftung sich ändert wird es nicht mehr funktionieren.
			// Objektname wäre besser.
			String ButtonText = ((JMenuItem)quelle).getText();
			//Über Fenster aufrufen
			if (ButtonText.equals("Über")) {
				new FensterUeber();
			}
			//Programm Schließen
			else if (ButtonText.equals("Schließen")) {
				System.exit(0);
			}
			else if (ButtonText.equals("Einstellungen")) {
				new FensterEinstellungen();
			}
			
		}

	}

}
