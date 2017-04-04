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
	private static final int MAXWRONGGUESSES = 8;
	private HangmanLexicon hangmanLexicon;
	private String word = "";
	private String userWord = "";
	private String guessChar = "";
	private int wrongGuess = 0;
	private HangmanCanvas hangmanCanvas;
	private RandomGenerator rGen;
	private boolean guessedWrong = false;
	private String guessCharString = "";
	
	//sets up the hangman game
	public void init(){
		rGen = RandomGenerator.getInstance();
		hangmanCanvas = new HangmanCanvas();
		add(hangmanCanvas);
		hangmanLexicon = new HangmanLexicon()
	}
	
	//executes playing hangman 
    public void run() {
    	while (true){
    		getWordFromLexicon();
    		createUserWord();
			hangmanCanvas.displayWord(userWord, guessCharString, guessedWrong);
    		while (!userWord.equals(word)){
    			userGuessCharacter();
    			checkGuess();
    			println("userWord = " + userWord);
    			println("word = " + word);
    			if (wrongGuess > MAXWRONGGUESSES){
    	    		hangmanCanvas.reset();
    	    		wrongGuess = 0;
    	    		guessCharString = "";
    	    		break;
    			}
    			hangmanCanvas.displayWord(userWord, guessCharString, guessedWrong);
    			guessedWrong = false;
    		}
    		guessedWrong = false;
			hangmanCanvas.displayWord(userWord, guessCharString, guessedWrong);
			if (userWord.equals(word)){
    		println("word matched!!  ");
			} else {
				println("better luck next time");
			}
    		readLine("press enter to continue");
    		userWord = "";
    	}
	}
    
    private void getWordFromLexicon(){
    	word = hangmanLexicon.getWord(rGen.nextInt(0, hangmanLexicon.getWordCount() - 1));
    }
    
    private void createUserWord(){
    	for (int i=0; i<word.length();i++){
    		userWord = (userWord + "-");
    	}
    }
    
    //for user guess entry. will run until user enters a string of length 1 and will convert lower to uppercase
    private void userGuessCharacter(){
    	while (guessChar == ""){
    		//keep this print line for user instruction
    		println("Please enter guess letter");
    		guessChar = readLine();
    		if (guessChar.length() != 1){
    			guessChar = "";
    		}
    	}
    	if (guessChar.charAt(0) >= 'a' && guessChar.charAt(0) <= 'z'){
			guessChar = guessChar.toUpperCase();
		}
    }
    
    //checks for a match with picked word. then resets guessChar so that user will be prompted to guess again on next loop iteration
    private void checkGuess(){
    	int wrongCount = 0;
    	for (int i=0; i<word.length(); i++){
    		if (word.charAt(i) == guessChar.charAt(0)){
        		println(word.charAt(i));
    			println("match found");
    			userWord = userWord.substring(0, i) + guessChar + userWord.substring(i+1);
    			
    		} 
    		if (word.charAt(i) != guessChar.charAt(0)){
				wrongCount += 1;
			}
    	}
    	if (wrongCount == word.length()){
    		wrongGuess += 1;
    		println("wongGuess = " + wrongGuess);
    		hangmanCanvas.noteIncorrectGuess(guessChar.charAt(0), wrongGuess);
    		guessCharString = (guessCharString + guessChar + " "); 
    		guessedWrong = true;
    	}
    	guessChar = "";
    } 
}
