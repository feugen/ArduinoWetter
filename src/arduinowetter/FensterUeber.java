package arduinowetter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class FensterUeber {
	
	private JFrame fenster;
	private JLabel label;
	
	// todo Anklickbar machen.
	String text = "Autor: Eugen Fischer" + "<br>" +
            "Version: 0.1" + "<br>" +
            "Datum: 06.10.2017" + "<br>" + "<br>" +
            "Homepage: " + "<a href=\"https://super-physik.de\">https://super-physik.de</a>";
	
	public FensterUeber() {
		initialize();
	}
	
	private void initialize() {
		fenster = new JFrame();
		fenster.setBounds(100, 100, 400, 200);
		fenster.setLocationRelativeTo(null);
		fenster.setAlwaysOnTop(true);
		fenster.setTitle("ArduinoWetter - super-physik.de");
		fenster.setLayout(null);
		fenster.setResizable(false);
		label = new JLabel("<html><div style='text-align: center;'>" + text + "</div></html>");
		//label = new JLabel("The Label");
		label.setBounds(0, 0, 400, 150);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setVerticalAlignment(SwingConstants.CENTER);
		fenster.add(label);
		fenster.setVisible(true);
	}
}
