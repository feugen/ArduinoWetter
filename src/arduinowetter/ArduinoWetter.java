package arduinowetter;

import java.awt.EventQueue;


public class ArduinoWetter {
	
	public static final String VERSIONSNUMMER = "0.2";
	public static final String VERSIONSDATUM = "07.10.2017";

	/**
	 * Launch application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Hauptfenster();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
