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
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FensterEinstellungen {
	
	private static JFrame fenster;
	private static JPanel leiste;
	private static JPanel ansicht;
	private static JPanel knoepfe;
	
	private static JButton uebernehmen;
	private static JButton abbrechen;
	
	private static JList liste;
	private final String[] menuliste = {"Datenquelle", "Sonstiges"};
	
	private static JInternalFrame ansichtDatenquelle = null;
	private static JInternalFrame ansichtSonstiges = null;
	
	private static JComboBox comboBox_extern = null;
	private static JComboBox comboBox_baudrate = null;
	private static JComboBox comboBox_verbindung = null;
	
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
		knoepfe.setBounds(165, 385, 625, 60);
		
		//Weise die Menüliste dem Listenhalter zu
		liste = new JList(menuliste);
		liste.setFont(liste.getFont().deriveFont(17.0f));
		liste.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		liste.addListSelectionListener(new ListenerEinstellungen());
		
		//Setze die einzelnen Knöpfe
		uebernehmen = new JButton("Übernehmen");
		uebernehmen.setBounds(492, 15, 123, 25);
		uebernehmen.addMouseListener(new ListenerEinstellungen());
		abbrechen = new JButton("Abbrechen");
		abbrechen.setBounds(357, 15, 123, 25);
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
		ansichtDatenquelle.getContentPane().setLayout(null);
		
		
		JLabel lblSerielleVerbindung = new JLabel("Serielle Verbindung");
		lblSerielleVerbindung.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSerielleVerbindung.setBounds(209, 18, 171, 15);
		ansichtDatenquelle.getContentPane().add(lblSerielleVerbindung);
		
		JLabel lblVerbindung = new JLabel("Verbindung");
		lblVerbindung.setBounds(136, 61, 114, 15);
		ansichtDatenquelle.getContentPane().add(lblVerbindung);
		
		JLabel lblBaud = new JLabel("Baudrate");
		lblBaud.setBounds(369, 61, 95, 15);
		ansichtDatenquelle.getContentPane().add(lblBaud);
		
		comboBox_verbindung = new JComboBox();
		comboBox_verbindung.setBounds(99, 88, 171, 24);
		ansichtDatenquelle.getContentPane().add(comboBox_verbindung);
		
		comboBox_baudrate = new JComboBox();
		comboBox_baudrate.setModel(new DefaultComboBoxModel(new String[] {"300", "600", "1200", "2400", "4800", "9600 (Standard)", "14400", "19200", "28800", "31250", "38400", "57600", "115200"}));
		comboBox_baudrate.setSelectedIndex(5);
		comboBox_baudrate.setBounds(326, 88, 171, 24);
		ansichtDatenquelle.getContentPane().add(comboBox_baudrate);
		
		JLabel lblInfo = new JLabel("Info:");
		lblInfo.setBounds(99, 143, 46, 15);
		ansichtDatenquelle.getContentPane().add(lblInfo);
		
		JLabel lblInfotext = new JLabel("keine Info");
		lblInfotext.setBounds(149, 143, 121, 15);
		ansichtDatenquelle.getContentPane().add(lblInfotext);
		
		JLabel lblExterne_Quelle = new JLabel("Externe Quelle");
		lblExterne_Quelle.setFont(new Font("Dialog", Font.BOLD, 14));
		lblExterne_Quelle.setBounds(225, 219, 171, 15);
		ansichtDatenquelle.getContentPane().add(lblExterne_Quelle);
		
		comboBox_extern = new JComboBox();
		comboBox_extern.setModel(new DefaultComboBoxModel(new String[] {"OpenWeatherMap.org"}));
		comboBox_extern.setBounds(179, 246, 221, 24);
		ansichtDatenquelle.getContentPane().add(comboBox_extern);
		
		JButton btnVerbindungstest = new JButton("Verbindung testen");
		btnVerbindungstest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVerbindungstest.setBounds(326, 138, 171, 25);
		ansichtDatenquelle.getContentPane().add(btnVerbindungstest);
		ansichtDatenquelle.setVisible(true);
		
		
		//Wenn Sonstiges ausgewählt, so soll ein anderes JInternalFrame angezeigt werden.
		//Erzeuge ihn hier und schalte um mit Listener je nach Auswahl.
		ansichtSonstiges = new JInternalFrame("Sonstiges");
		ansichtSonstiges.setBorder(new LineBorder(new Color(0 ,0 ,0), 1, true));
		ansichtSonstiges.setVisible(false);
		
		//Platziere weitere Elemente
		
		//Lade die zuletzt gespeicherten Einstellungen welche dann gesetzt werden.
		Einstellungen.getEinstellungenLaden();
	}
	
	public static void setEinstellungen(int combobox_baud_index, int combobox_extern_index) {
		
		comboBox_extern.setSelectedIndex(combobox_extern_index);
		comboBox_baudrate.setSelectedIndex(combobox_baud_index);
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

				Einstellungen.setEinstellungenSpeichern(comboBox_baudrate.getSelectedIndex(), comboBox_extern.getSelectedIndex());

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
