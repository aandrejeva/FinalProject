package FinalProjectFinalVersion;

//class with methods related to the letters and word to be guessed
public class HangmanWordChecker {

	//declare method to convert randomly selected word to the stars
	public StringBuffer convertRandomWordToStars(String randomWord) {
		StringBuffer sb = new StringBuffer();
		//traverse the randomWord using for loop
		for(int i = 0; i < randomWord.length(); i++) {
			sb.append('*');//add each star to the StringBuffer
		}//end for loop
		return sb;
	}
	
	//declare method to check if the letter is already used
	public boolean checkIsLetterAlreadyUsed(StringBuffer lettersUsed, char letter) {
		boolean isLetterAlreadyUsed = false; //by default the letter is not already used
		//traverse the lettersUsed using for loop (lettersUsed store all letters entered by the user)
		for(int x = 0; x < lettersUsed.length(); x++) {
			if(letter == lettersUsed.charAt(x)) {//if the user's entered letter is equal to the letter stored in the StringBuffer lettersUsed
				isLetterAlreadyUsed = true;//update the value of the variable to true
				break; //break the loop to continue the current game
			}//end if
		}//end for loop
		return isLetterAlreadyUsed;
	}
		
	//declare method to check if the letter provided by the user is found in the randomly chosen word
	public boolean checkHasUserGuessedTheLetter(String randomWord, char letter) {
		boolean hasUserGuessedTheLetter = false; //by default letter is not guessed
		//traverse the randomWord using for loop
		for(int i = 0; i < randomWord.length(); i ++) {	
			if(letter == randomWord.charAt(i)) { //if the randomWord contains the user's provided letter
				hasUserGuessedTheLetter = true; //update the value of the variable to true
			}//end if
		}//end for loop
		return hasUserGuessedTheLetter;
	}
		
	//declare method to replace '*' in the secretWord with the correctly guessed letter
	public StringBuffer replaceTheLetter(String randomWord, char letter, StringBuffer secretWord) {
		//traverse the randomWord using for loop
		for(int i = 0; i < randomWord.length(); i ++) {	
			if(letter == randomWord.charAt(i)) { //if the randomWord contains the user's provided letter
				Character letterObj = letter; //declare new variable of type Character and assign to it value of char letter
				secretWord.replace(i, i+1, letterObj.toString());//replace '*' with the correctly guessed letter and store it in StringBuffer secretWord
			}//end if
		}//end for loop
		return secretWord;
	}
		
	//declare method to count and check number of stars in the secretWord to understand is the word guessed or not
	public boolean checkHasUserGuessedTheWord(StringBuffer secretWord) {
		int starCounter = 0;//declare int variable starCounter and assign to it value 0 (by default the number of stars is 0)
		//traverse the secretWord using for loop
		for(int j = 0; j < secretWord.length(); j++) {
			if(secretWord.charAt(j) == '*') {//if star is found
				starCounter++;//update starCounter after each iteration
			}//end if
		}//end for

		//if the number of stars is 0 it means that the word is guessed
		if(starCounter == 0) {
			return true; 
		} else {
			return false;
		}
	}
	
}//end class
