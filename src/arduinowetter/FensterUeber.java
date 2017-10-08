package arduinowetter;

import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JInternalFrame;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class FensterUeber {	
	// TODO Beim Klicken wird das innere Fenster aktiviert und blau markiert - beheben.
	private JFrame fenster;
	private JLabel label;
	private JLabel labelWebseite;
	private JButton knopf;
	private JInternalFrame inneresFenster;
	
	String text = "Autor: Eugen Fischer" + "<br>" +
            "Version: " + ArduinoWetter.VERSIONSNUMMER + "<br>" +
            "Datum: " + ArduinoWetter.VERSIONSDATUM + "<br>";
	
	
	public FensterUeber() {
		initialisierung();
	}
	
	private void initialisierung() {
		fenster = new JFrame();
		fenster.setBounds(100, 100, 400, 250);
		fenster.setLocationRelativeTo(null);
		fenster.setAlwaysOnTop(true);
		fenster.setTitle("ArduinoWetter - super-physik.de");
		fenster.getContentPane().setLayout(null);
		fenster.setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 394, 218);
		fenster.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		inneresFenster = new JInternalFrame("Über");
		panel.add(inneresFenster);
		inneresFenster.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		inneresFenster.getContentPane().setLayout(null);
		
		label = new JLabel("<html><div style='text-align: center;'>" + text + "<br></div></html>");
		label.setBounds(118, 43, 143, 60);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setVerticalAlignment(SwingConstants.BOTTOM);
		inneresFenster.getContentPane().add(label);
		
		labelWebseite = new JLabel("<html> Webseite : <a href=\"https://super-physik.de\">https://super-physik.de</a>");
		labelWebseite.setBounds(75, 115, 237, 15);
		labelWebseite.setHorizontalAlignment(SwingConstants.CENTER);
		labelWebseite.setCursor(new Cursor(Cursor.HAND_CURSOR));
		labelWebseite.addMouseListener(new ListenerFensterUeber());
		inneresFenster.getContentPane().add(labelWebseite);
		
		knopf = new JButton("Schließen");
		knopf.setBounds(279, 157, 101, 25);
		knopf.addMouseListener(new ListenerFensterUeber());
		inneresFenster.getContentPane().add(knopf);
		inneresFenster.setVisible(true);
		fenster.setVisible(true);
	}
	
	private class ListenerFensterUeber implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			if (labelWebseite == e.getSource()) {
				//Leite auf die Webseite um.
				try {
					Desktop.getDesktop().browse(new URI("https://www.super-physik.de"));
					fenster.setVisible(false);
				} catch (IOException | URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
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
			if (knopf == e.getSource()) {
				//Fenster schließen
				fenster.setVisible(false);
			}
		}
	}
}
