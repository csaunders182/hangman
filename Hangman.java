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
	private String userWord = "";
	private String guessChar = "";
	
	//sets up the hangman game
	public void init(){
		
	}
	
	//executes playing hangman 
    public void run() {
		getWordFromLexicon();
		createUserWord();
		while (!userWord.equals(word)){
			userGuessCharacter();
			checkGuess();
			println("userWord = " + userWord);
			println("word = " + word);
		}
	}
    
    private void getWordFromLexicon(){
    	word = hangmanLexicon.getWord(0);
    }
    
    private void createUserWord(){
    	for (int i=0; i<word.length();i++){
    		userWord = (userWord + " ");
    	}
    }
    
    private void userGuessCharacter(){
    	while (guessChar == ""){
    		println("Please enter guess letter");
    		guessChar = readLine();
    		if (guessChar.length() != 1){
    			guessChar = "";
    		}
    	}
    }
    
    private void checkGuess(){
    	for (int i=0; i<word.length(); i++){
    		println("guessChar = " + guessChar);
    		if (word.charAt(i) == guessChar.charAt(0)){
        		println(word.charAt(i));
    			println("match found");
//    			userWord = userWord.substring(0, i) + guessChar + userWord.substring(i+1);
    		}
    	}
    	guessChar = "";
    }
    
    

}
