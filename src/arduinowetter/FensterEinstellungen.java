package arduinowetter;

import javax.swing.JFrame;

public class FensterEinstellungen {
	
	private JFrame fenster;
	
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

	}

}
