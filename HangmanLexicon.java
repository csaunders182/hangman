/*
 * File: HangmanLexicon.java
 * -------------------------
 * This file contains a stub implementation of the HangmanLexicon
 * class that you will reimplement for Part III of the assignment.
 */

import java.io.*;
import acm.util.*;


public class HangmanLexicon {

/** Returns the number of words in the lexicon. */
	public int getWordCount() {
		return lexicon.length;
	}

/** Returns the word at the specified index. */
	public String getWord(int index) {
		return lexicon[index];
	}
	

	//initializer for hangmanLexicon 
	public HangmanLexicon(){
		int count = 0;
		BufferedReader rd = null;
		try {
			rd = new BufferedReader(new FileReader("HangmanLexicon.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (true){
				String line = rd.readLine();
				if (line != null){
					count += 1;
				} else {
					count += 1;
					break;
				}
			}
//			rd.close();
		} catch (IOException ex) {
			throw new ErrorException(ex);
		}
		lexicon = new String [25];
		try {
			for (int i=0; i<count; i++){
				lexicon[i] = rd.readLine();
			}
			rd.close();
		} catch (IOException ex) {
			throw new ErrorException(ex);
		}
	}
	
	private String[] lexicon;
}
