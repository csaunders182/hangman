/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import acm.graphics.*;

public class HangmanCanvas extends GCanvas {

/** Resets the display so that only the scaffold appears */
	public void reset() {
		head.setVisible(false);
		body.setVisible(false);
	}

/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	public void displayWord(String word) {
		/* You fill this in */
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(char letter, int wrongGuess) {
		if (head == null){
			createBodyParts();
		}
		
		switch (wrongGuess) {
		case 1: head.setVisible(true);
				break;
		case 2: body.setVisible(true);
				break;
		case 3: leftArm.setVisible(true);
				leftHand.setVisible(true);
				break;
		default:
				break;
		}
		
	}
	

/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;
	
	private GOval head;
	private GLine leftArm, leftHand, rightArm, rightHand, leftLeg, rightLeg, body;
	
	private void createBodyParts(){
		head = new GOval(getWidth()/2 - HEAD_RADIUS, getHeight()/2 - BODY_LENGTH/2 - HEAD_RADIUS*2 ,HEAD_RADIUS*2, HEAD_RADIUS *2);
		add(head);
		head.setVisible(false);
		body = new GLine(getWidth()/2, getHeight()/2 + BODY_LENGTH/2 , getWidth()/2, getHeight()/2 - BODY_LENGTH/2);
		body.setVisible(false);
		add(body);
		leftArm = new GLine (getWidth()/2, getHeight()/2 - BODY_LENGTH/2 + ARM_OFFSET_FROM_HEAD, getWidth()/2 - UPPER_ARM_LENGTH, getHeight()/2 - BODY_LENGTH/2 + ARM_OFFSET_FROM_HEAD);
		add(leftArm);
		leftArm.setVisible(false);
		leftHand = new GLine (getWidth()/2 - UPPER_ARM_LENGTH, getHeight()/2 - BODY_LENGTH/2 + ARM_OFFSET_FROM_HEAD, getWidth()/2 - UPPER_ARM_LENGTH, getHeight()/2 - BODY_LENGTH/2 + ARM_OFFSET_FROM_HEAD + LOWER_ARM_LENGTH);
		add(leftHand);
		leftHand.setVisible(false);
	}
	

}
