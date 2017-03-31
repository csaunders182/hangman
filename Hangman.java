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
		println("word matched!!");
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
    		if (guessChar.charAt(0) > 'a' && guessChar.charAt(0) < 'z' && !guessChar.equals("")){
    			guessChar.toUpperCase();
    		}
    		if (guessChar.length() != 1){
    			println("guessChar.length() = " + guessChar.length());
    			guessChar = "";
    		}
    	}
    }
    
    private void checkGuess(){
    	for (int i=0; i<word.length(); i++){
    		if (word.charAt(i) == guessChar.charAt(0)){
        		println(word.charAt(i));
    			println("match found");
    			userWord = userWord.substring(0, i) + guessChar + userWord.substring(i+1);
    		}
    	}
    	guessChar = "";
    }
    
    

}
