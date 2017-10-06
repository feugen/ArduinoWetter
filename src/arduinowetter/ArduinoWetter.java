package arduinowetter;

import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class ArduinoWetter {
	
	public static final String VERSIONSNUMMER = "0.1";

	private JFrame frame;
	//MenuItemMap, dient dazu um Items eine Nummer zuzuweisen, über welche festgestellt wird, welcher Knopf betätigt wurde.
	//Zuweisung erfolgt in der Methode initialisierung.
	private static Map<JMenuItem, Integer> menuMap = new HashMap<JMenuItem, Integer>(10);

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
		initialisierung();
	}

	/**
	 * Initialisierung.
	 */
	private void initialisierung() {
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
		menuMap.put(mnexit, 0);
		
		//Menü - Extras
		JMenu mnExtras = new JMenu("Extras");
		menuBar.add(mnExtras);
		
		//Menüeinträge - Extras - Einstellungen
		JMenuItem mneinst = new JMenuItem("Einstellungen");
		mnExtras.add(mneinst);
		mneinst.addMouseListener(new ListenerMain());
		menuMap.put(mneinst, 1);
		
		//Menü - Hilfe
		JMenu mnHilfe = new JMenu("Hilfe");
		menuBar.add(mnHilfe);
		
		//Menüeinträge - Hilfe - Über
		JMenuItem mntmber = new JMenuItem("Über");
		mnHilfe.add(mntmber);
		mntmber.addMouseListener(new ListenerMain());
		menuMap.put(mntmber, 2);
		
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
			
			JMenuItem quelle = (JMenuItem)arg0.getSource();
			int itemIndex = menuMap.get(quelle);
			
			//Programm Schließen
			if (itemIndex == 0) {
				System.exit(0);
			}
			//Einstellungen aufrufen
			else if (itemIndex == 1) {
				new FensterEinstellungen();
			}
			//Über Fenster aufrufen
			else if (itemIndex == 2) {
				new FensterUeber();
			}
			
		}

	}

}
