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
		leftArm.setVisible(false);
		leftHand.setVisible(false);
		rightArm.setVisible(false);
		rightHand.setVisible(false);
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
		case 1: ground.setVisible(true);
				break;
		case 2: 
				break;
		case 3: head.setVisible(true);
				break;
		case 4: body.setVisible(true);
				break;
		case 5: leftArm.setVisible(true);
				leftHand.setVisible(true);
				break;
		case 6: rightArm.setVisible(true);
				rightHand.setVisible(true);
				break;
		case 7: leftHip.setVisible(true);
				leftLeg.setVisible(true);
				leftFoot.setVisible(true);
				break;
		case 8: rightHip.setVisible(true);
				rightLeg.setVisible(true);
				rightFoot.setVisible(true);
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
	private static final int GROUND_OFFSET = 10;
	
	private GOval head;
	private GLine leftArm, leftHand, rightArm, rightHand, leftHip, leftLeg, leftFoot, rightHip, rightLeg, rightFoot, body , ground, scaffoldPole, scaffoldBeam , scaffoldRope;
	
	private void createBodyParts(){
		
		ground = new GLine(0, getHeight()/2 - BODY_LENGTH/2 - LEG_LENGTH - GROUND_OFFSET, getWidth(), getHeight()/2 - BODY_LENGTH/2 - LEG_LENGTH - GROUND_OFFSET);
		add(ground);
		ground.setVisible(false);
		
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
		
		rightArm = new GLine (getWidth()/2, getHeight()/2 - BODY_LENGTH/2 + ARM_OFFSET_FROM_HEAD, getWidth()/2 + UPPER_ARM_LENGTH, getHeight()/2 - BODY_LENGTH/2 + ARM_OFFSET_FROM_HEAD);
		add(rightArm);
		rightArm.setVisible(false);
		rightHand = new GLine (getWidth()/2 + UPPER_ARM_LENGTH, getHeight()/2 - BODY_LENGTH/2 + ARM_OFFSET_FROM_HEAD, getWidth()/2 + UPPER_ARM_LENGTH, getHeight()/2 - BODY_LENGTH/2 + ARM_OFFSET_FROM_HEAD + LOWER_ARM_LENGTH);
		add(rightHand);
		rightHand.setVisible(false);
		
		leftHip = new GLine (getWidth()/2, getHeight()/2 + BODY_LENGTH/2, getWidth()/2 - HIP_WIDTH/2, getHeight()/2 + BODY_LENGTH/2);
		add(leftHip);
		leftHip.setVisible(false);
		leftLeg = new GLine (getWidth()/2 - HIP_WIDTH/2, getHeight()/2 + BODY_LENGTH/2, getWidth()/2 - HIP_WIDTH/2, getHeight()/2 + BODY_LENGTH/2 + LEG_LENGTH);
		add(leftLeg);
		leftLeg.setVisible(false);
		leftFoot = new GLine (getWidth()/2 - HIP_WIDTH/2, getHeight()/2 + BODY_LENGTH/2 + LEG_LENGTH, getWidth()/2 - HIP_WIDTH/2 - FOOT_LENGTH , getHeight()/2 + BODY_LENGTH/2 + LEG_LENGTH);
		add(leftFoot);
		leftFoot.setVisible(false);
		
		rightHip = new GLine (getWidth()/2, getHeight()/2 + BODY_LENGTH/2, getWidth()/2 + HIP_WIDTH/2, getHeight()/2 + BODY_LENGTH/2);
		add(rightHip);
		rightHip.setVisible(false);
		rightLeg = new GLine (getWidth()/2 + HIP_WIDTH/2, getHeight()/2 + BODY_LENGTH/2, getWidth()/2 + HIP_WIDTH/2, getHeight()/2 + BODY_LENGTH/2 + LEG_LENGTH);
		add(rightLeg);
		rightLeg.setVisible(false);
		rightFoot = new GLine (getWidth()/2 + HIP_WIDTH/2, getHeight()/2 + BODY_LENGTH/2 + LEG_LENGTH, getWidth()/2 + HIP_WIDTH/2 + FOOT_LENGTH , getHeight()/2 + BODY_LENGTH/2 + LEG_LENGTH);
		add(rightFoot);
		rightFoot.setVisible(false);
		
		
		
		
	}
	

}
