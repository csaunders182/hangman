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
		return count;
	}

/** Returns the word at the specified index. */
	public String getWord(int index) {
		return lexicon[index];
	}
	

	//initializer for hangmanLexicon 
	public HangmanLexicon(){
		BufferedReader rd = newReader();
		getCount(rd);
		try {
			rd.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		lexicon = new String [count];
		rd = newReader();
		try {
			for (int i=0; i<count; i++){
				lexicon[i] = rd.readLine();
			}
			rd.close();
		} catch (IOException ex) {
			throw new ErrorException(ex);
		}
	}
	
	private BufferedReader newReader(){
		BufferedReader rd = null;
		try {
			rd = new BufferedReader(new FileReader("HangmanLexicon.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rd;
	}
	
	private int getCount(BufferedReader rd){
		int count = 0;
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
		} catch (IOException ex) {
		throw new ErrorException(ex);
		}
		return count;
	}
	
	private String[] lexicon;
	private int count = 121808;
}
