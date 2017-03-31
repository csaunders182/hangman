/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.*;

public class Hangman extends ConsoleProgram {
	private HangmanLexicon hangmanLexicon = new HangmanLexicon();
	private String word = "";
	//sets up the hangman game
	public void init(){
		
	}
	
	//executes playing hangman 
    public void run() {
		word = hangmanLexicon.getWord(0);
		println(word);
	}

}
