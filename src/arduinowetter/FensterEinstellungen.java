package arduinowetter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class FensterEinstellungen {
	
	private JFrame fenster;
	private JPanel leiste;
	private JPanel ansicht;
	private JPanel knoepfe;
	
	private JButton uebernehmen;
	private JButton abbrechen;
	
	private JList liste;
	private final String[] menuliste = {"Datenquelle", "Sonstiges"};
	
	private JInternalFrame ansichtDatenquelle = null;
	private JInternalFrame ansichtSonstiges = null;
	
	public FensterEinstellungen() {
		initialisierung();
	}
	
	private void initialisierung() {
		
		fenster = new JFrame();
		fenster.setBounds(100, 100, 800, 480);
		fenster.setLocationRelativeTo(null);
		fenster.setAlwaysOnTop(true);
		fenster.setTitle("ArduinoWetter - super-physik.de");
		fenster.getContentPane().setLayout(null);
		fenster.setResizable(false);
		fenster.setVisible(true);
		
		leiste = new JPanel(new BorderLayout());
		ansicht = new JPanel(new BorderLayout(0, 0));
		knoepfe = new JPanel(null);
		
		//Setze die JPanel Elemente
		leiste.setBounds(0, 0, 160, 445);
		ansicht.setBounds(165, 0, 625, 380);
		ansicht.setBackground(Color.lightGray);;
		knoepfe.setBounds(165, 385, 625, 60);
		
		//Weise die Menüliste dem Listenhalter zu
		liste = new JList(menuliste);
		liste.setFont(liste.getFont().deriveFont(17.0f));
		liste.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		liste.addListSelectionListener(new ListenerEinstellungen());
		
		//Setze die einzelnen Knöpfe
		uebernehmen = new JButton("Übernehmen");
		uebernehmen.setBounds(475, 15, 140, 25);
		uebernehmen.addMouseListener(new ListenerEinstellungen());
		abbrechen = new JButton("Abbrechen");
		abbrechen.setBounds(325, 15, 140, 25);
		abbrechen.addMouseListener(new ListenerEinstellungen());
		
		//Platzieren Platzhalter auf dem Haupt Menüfenster
		fenster.getContentPane().add(leiste);
		fenster.getContentPane().add(ansicht);
		fenster.getContentPane().add(knoepfe);
		
		//Platziere Leisteneinträge auf Leiste
		JScrollPane scrollPane = new JScrollPane(liste);
		leiste.add(scrollPane);
		
		//Platziere Knöpfe auf Knopfhalter
		knoepfe.add(abbrechen);
		knoepfe.add(uebernehmen);
		
		//Platziere InternalFrame auf Ansicht
		ansichtDatenquelle = new JInternalFrame("Datenquelle");
		ansichtDatenquelle.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		ansicht.add(ansichtDatenquelle, BorderLayout.CENTER);
		ansichtDatenquelle.setVisible(true);
		
		
		//Wenn Sonstiges ausgewählt, so soll ein anderes JInternalFrame angezeigt werden.
		//Erzeuge ihn hier und schalte um mit Listener je nach Auswahl.
		ansichtSonstiges = new JInternalFrame("Sonstiges");
		ansichtSonstiges.setBorder(new LineBorder(new Color(0 ,0 ,0), 1, true));
		ansichtSonstiges.setVisible(false);
		
		//Platziere Ansichteinträge

	}
	
	private class ListenerEinstellungen implements MouseListener, ListSelectionListener{

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

		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (liste == e.getSource()) {
				if (e.getValueIsAdjusting()) {
					if (liste.getSelectedIndex() == 0) {
						ansichtSonstiges.setVisible(false);
						ansicht.remove(ansichtSonstiges);
						ansichtDatenquelle.setVisible(true);
					}
					else if (liste.getSelectedIndex() == 1) {
						ansichtDatenquelle.setVisible(false);
						ansicht.add(ansichtSonstiges, BorderLayout.CENTER);
						ansichtSonstiges.setVisible(true);
					}
				}
			}
		}
	}
}
