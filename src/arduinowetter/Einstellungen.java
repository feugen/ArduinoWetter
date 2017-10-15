package arduinowetter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Einstellungen {
	
	private static String konfigurationsdatei = "config.properties";
	
	public static void setEinstellungenSpeichern(int combobox_baudrate_index, int combobox_extern_index, boolean checkboxSpracheAuto){
		
		Properties prop = new Properties();
		FileOutputStream output = null;
		
		try {
			output = new FileOutputStream(konfigurationsdatei);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		prop.setProperty("ComboBox_Extern", Integer.toString(combobox_extern_index));
		prop.setProperty("ComboBox_Baudrate", Integer.toString(combobox_baudrate_index));
		prop.setProperty("CheckBox_AutoLang", Boolean.toString(checkboxSpracheAuto));

		try {
			prop.store(output, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void getEinstellungenLaden(){
		Properties prop = new Properties();
		FileInputStream input = null;
		
		try {
			input = new FileInputStream(konfigurationsdatei);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int combobox_extern_index = 0;
		if (prop.getProperty("ComboBox_Extern") != null) {
			combobox_extern_index = Integer.valueOf(prop.getProperty("ComboBox_Extern"));
		}
		
		int combobox_baudrate_index = 5;
		if (prop.getProperty("ComboBox_Baudrate") != null) {
			combobox_baudrate_index = Integer.valueOf(prop.getProperty("ComboBox_Baudrate"));
		}
		
		boolean checkboxSpracheAuto = true;
		if (prop.getProperty("CheckBox_AutoLang") !=null) {
			checkboxSpracheAuto = Boolean.valueOf(prop.getProperty("CheckBox_AutoLang"));
		}
		
		FensterEinstellungen.setEinstellungen(combobox_baudrate_index, combobox_extern_index, checkboxSpracheAuto);
	}
}
