package arduinowetter;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
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
		mnexit.addMouseListener(new ListenerUeber());
		
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
		mnHilfe.add(mntmber);
		mntmber.addMouseListener(new ListenerUeber());
		
	}
	
	
	private class ListenerUeber implements MouseListener {

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
			// Todo schlechte Lösungen, wenn Buttonbeschriftung sich ändert wird es nicht mehr funktionieren. Objektname wäre besser.
			String ButtonText = ((JMenuItem)quelle).getText();
			//Über Fenster aufrufen
			if (ButtonText.equals("Über")) {
				new FensterUeber();
			}
			//Programm Schließen
			if (ButtonText.equals("Schließen")) {
				System.exit(0);
			}
			
		}

	}

}
