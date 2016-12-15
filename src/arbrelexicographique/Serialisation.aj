package arbrelexicographique;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

public aspect Serialisation {
	
	declare parents : arbrelexicographique.ArbreLexicographique implements Serializable;

public void ArbreLexicographique.sauve(String nomFichier) {
	try {
		FileWriter f =  new FileWriter(nomFichier);
		BufferedWriter bf = new BufferedWriter(f);
		bf.write(this.toString());
		bf.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}	

public void ArbreLexicographique.charge(String nomFichier) {
	try {
		FileReader f =  new FileReader(nomFichier);
		BufferedReader bf = new BufferedReader(f);	
		String line = bf.readLine();
		while (line != null) { // while loop begins here
			this.ajout(line);
		}
		
		bf.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}