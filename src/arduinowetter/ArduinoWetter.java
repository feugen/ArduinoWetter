package arduinowetter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class ArduinoWetter {

	private JFrame frame;

	/**
	 * Launch the application.
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
	 * Constructor lässt die Initialisierung laufen
	 */
	public ArduinoWetter() {
		initialize();
	}

	/**
	 * Initialisierung.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(400, 400, 800, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("ArduinoWetter - super-physik.de");
		
		//Menüleiste
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		//Menü - Datei
		JMenu mnDatei = new JMenu("Datei");
		menuBar.add(mnDatei);
		
		//Menüeinträge - Datei - Schließen
		JMenuItem mnexit = new JMenuItem("Schließen");
		mnDatei.add(mnexit);
		
		//Menü - Extras
		JMenu mnExtras = new JMenu("Extras");
		menuBar.add(mnExtras);
		
		//Menüeinträge - Extras - Einstellungen
		JMenuItem mneinst = new JMenuItem("Einstellungen");
		mnExtras.add(mneinst);
		
		//Menü - Hilfe
		JMenu mnHilfe = new JMenu("Hilfe");
		menuBar.add(mnHilfe);
		
		//Menüeinträge - Hilfe - Über
		JMenuItem mntmber = new JMenuItem("Über");
		mnHilfe.add(mntmber);;
		
	}

}
