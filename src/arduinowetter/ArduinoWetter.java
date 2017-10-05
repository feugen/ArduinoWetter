package arduinowetter;

import java.awt.EventQueue;

import javax.swing.JFrame;

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
		frame.setTitle("ArduinoWetter - super-physik.de");;
	}

}
