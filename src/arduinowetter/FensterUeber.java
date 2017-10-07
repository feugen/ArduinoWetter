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

public class FensterUeber {	
	private JFrame fenster;
	private JLabel label;
	private JLabel labelWebseite;
	private JButton knopf;
	
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
		
		label = new JLabel("<html><div style='text-align: center;'>" + text + "<br></div></html>");
		label.setBounds(0, 0, 400, 120);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setVerticalAlignment(SwingConstants.BOTTOM);
		
		labelWebseite = new JLabel("<html> Webseite : <a href=\"https://super-physik.de\">https://super-physik.de</a>");
		labelWebseite.setBounds(0, 120, 400, 20);
		labelWebseite.setHorizontalAlignment(SwingConstants.CENTER);
		labelWebseite.setVerticalAlignment(SwingConstants.TOP);
		labelWebseite.setCursor(new Cursor(Cursor.HAND_CURSOR));
		labelWebseite.addMouseListener(new ListenerFensterUeber());
		
		knopf = new JButton("Schliessen");
		knopf.setBounds(250, 170, 120, 25);
		knopf.addMouseListener(new ListenerFensterUeber());
		
		fenster.getContentPane().add(knopf);
		fenster.getContentPane().add(label);
		fenster.getContentPane().add(labelWebseite);
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
