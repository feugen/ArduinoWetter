package arduinowetter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class FensterEinstellungen {
	
	private JFrame fenster;
	private JPanel leiste;
	private JPanel ansicht;
	private JPanel knoepfe;
	
	private JButton uebernehmen;
	private JButton abbrechen;
	
	private JList<String> liste;
	String[] menuliste = {"Datenquelle", "Sonstiges"};
	
	public FensterEinstellungen() {
		initialisierung();
	}
	
	private void initialisierung() {
		
		fenster = new JFrame();
		fenster.setBounds(100, 100, 800, 480);
		fenster.setLocationRelativeTo(null);
		fenster.setAlwaysOnTop(true);
		fenster.setTitle("ArduinoWetter - super-physik.de");
		fenster.setLayout(null);
		fenster.setResizable(false);
		fenster.setVisible(true);
		
		leiste = new JPanel(new BorderLayout());
		ansicht = new JPanel();
		knoepfe = new JPanel(null);
		
		//Setze die JPanel Elemente
		leiste.setBounds(0, 0, 160, 445);
		ansicht.setBounds(165, 0, 625, 380);
		ansicht.setBackground(Color.lightGray);;
		knoepfe.setBounds(165, 385, 625, 60);
		
		//Weise die Menüliste dem Listenhalter zu
		liste = new JList<String>(menuliste);
		liste.setFont(liste.getFont().deriveFont(17.0f));
		
		//Setze die einzelnen Knöpfe
		uebernehmen = new JButton("Übernehmen");
		uebernehmen.setBounds(475, 15, 140, 25);
		uebernehmen.addMouseListener(new ListenerEinstellungen());
		abbrechen = new JButton("Abbrechen");
		abbrechen.setBounds(325, 15, 140, 25);
		abbrechen.addMouseListener(new ListenerEinstellungen());
		
		//Platzieren Platzhalter auf dem Haupt Menüfenster
		fenster.add(leiste);
		fenster.add(ansicht);
		fenster.add(knoepfe);
		
		//Platziere Leisteneinträge
		leiste.add(new JScrollPane(liste));
		
		//Platziere Knöpfe auf Knopfhalter
		knoepfe.add(abbrechen);
		knoepfe.add(uebernehmen);

	}
	
	private class ListenerEinstellungen implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			if(abbrechen == e.getSource()) {
				//Schließe das Fenster wenn auf Abbrechen geklickt
				fenster.setVisible(false);
			}
			if(uebernehmen == e.getSource()) {
				// TODO Die Auswahl irgendwo speichern und danach schließen.
				//Schließe das Fenster wenn auf Abbrechen geklickt
				fenster.setVisible(false);
			}
			
		}
		
	}

}
