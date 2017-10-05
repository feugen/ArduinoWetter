package arduinowetter;

import javax.swing.JFrame;

public class FensterUeber {
	
	private JFrame fenster;
	
	public FensterUeber() {
		initialize();
	}
	
	private void initialize() {
		fenster = new JFrame();
		fenster.setBounds(100, 100, 400, 200);
		fenster.setLocationRelativeTo(null);
		fenster.setVisible(true);
		fenster.setAlwaysOnTop(true);
	}
}
