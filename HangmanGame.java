package FinalProjectFinalVersion;
/*
1.Generate random word from String[] words;
2.Convert word (replace each letter to *);
3.Show game status to user;
4.User enter letter try to guess the word. Looping if letter has been used;
5.Compare letter provided by user if letters is in the current word;
6.If user guess letter then replace star * in word to show, otherwise decrement -1 lives;
7.Check if all letters are guess and set completed to true;
8.Loop working until lives >0 and word not completed;
9.Show user result of the game ( lost, won ) and update games statistics;
10.Ask user to continue a game or end game;
11.If user press Y then continue loop;
12.If not display game statistics and finish program.
*/
import java.util.Scanner;

//class that contains main logic of the game
public class HangmanGame {
	
	//declare an array of type String and assign value to each element
	String underwaterWorld[] = {"dolphin", "jellyfish", "whale", "seahorse", "octopus", "shark", "starfish", "crab", "lobster", 
								"prawn", "seal", "squid", "oyster", "turtle", "tuna", "stingray", "swordfish", "eel", "blowfish", "sawfish"};
	//declare instance variables
	private int numOfGames;//to store the number of games
	private int numOfWins;//to store the number of wins
	private int numOfLosses;//to store the number of losses
	private boolean gameOn;//to store the game status

	//declare a variable named input and create an object of type Scanner
	Scanner input = new Scanner(System.in);
	
	//declare a variable named hangmanPicture and create an object of type HangmanPicture
	HangmanPicture hangmanPicture = new HangmanPicture();
	
	//declare a variable named wordChecker and create an object of type HangmanWordChecker;
	HangmanWordChecker wordChecker = new HangmanWordChecker();
	
	//declare method to start the game
	public void startGame() {
		gameOn = true; //assign to the variable gameOn value true
		
		//make main do-while loop of the game
		do {
			int lives = 7;//declare variable of type int and assign the value 7
			numOfGames++;//update numOfGames after each iteration
		
			//declare a variable named lettersUsed and create an object of type StringBuffer to store used letters
			StringBuffer lettersUsed = new StringBuffer();
			
			displayIntroMessage();//call method to display game intro message
			
			//declare a variable of type String and assign to it value of randomly selected word
			String randomWord = selectRandomWord();
			
			//declare a variable of type StringBuffer and assign to it value of randomly selected word converted to the stars
			StringBuffer secretWord = wordChecker.convertRandomWordToStars(randomWord);
			
			//make while loop
			//run current game till int lives is higher than 0
			while(lives > 0) {
				
				displayCurrentGameStatus(lives, secretWord, lettersUsed);//call method to display current game status
				
				System.out.println("Please enter the letter: ");//ask user to input the letter
				char letter = input.next().toLowerCase().charAt(0); //declare variable of type char to store the user's entered letter
					
				//declare variable of type boolean to store the result of method that checks is the letter already used or not
				boolean isLetterAlreadyUsed = wordChecker.checkIsLetterAlreadyUsed(lettersUsed, letter);
				
				//if the letter entered by the user is already used then inform user about it
				if(isLetterAlreadyUsed == true) { 
					System.out.println("The letter is already used: " + letter); 
					System.out.println();
					continue; //stop while loop iteration and continue with the next iteration
				}
					
				lettersUsed.append(letter + " "); //add letter entered by the user to the StringBuffer lettersUsed
					
				//declare variable of type boolean to store the result of method that checks is the letter guessed or not
				boolean hasUserGuessedTheLetter = wordChecker.checkHasUserGuessedTheLetter(randomWord, letter);
				
				if (hasUserGuessedTheLetter == true) {//if the user guessed the letter
					secretWord = wordChecker.replaceTheLetter(randomWord, letter, secretWord);//update secretWord replacing '*' with letter
						
					//declare variable of type boolean to store the result of method that checks is the word guessed or not
					boolean hasUserGuessedTheWord = wordChecker.checkHasUserGuessedTheWord(secretWord);
					if(hasUserGuessedTheWord == true) {//if word is guessed
						System.out.println("_______________________");//inform user that the word is guessed and display game info
						System.out.println("You won!" + "\n"
											+ "You found the word: " + secretWord + "\n"
											+ "With " + lives + " more live(s) left");
						numOfWins++;//update numOfWins
						break;//jumps out of the while loop if the word is guessed
					}
				} else { //if the letter is not guessed then decrease number of lives by 1
					lives--;
					if(lives == 0) {//if number of lives is 0, the game is ended with status "lost"
						System.out.println("You lost!" + "\n" //inform user about current game status
										  	+ "You have not found the word: " + randomWord);
						numOfLosses++;//update numOfLosses
					}
				}
				hangmanPicture.displayHangman(lives);//call method to display Hangman picture according to the lives left
			}
			askUserToPlayAgain(lives);//call method to ask user to play again
		}while(gameOn); //continue running the main loop of the game while the value of the variable gameOn is true
		
	}//end startGame()
	
	//declare method to display game conditions to the user
	public void displayIntroMessage() {
		System.out.println("Hello!" + "\n" 
				  + "Welcome to the game Hangman!" + "\n"
				  + "Try to guess the name of the underwater world inhabitants." + "\n"
				  + "Note! You have limited number of lifes!" + "\n"
				  + "Let's GO!"
					);
		System.out.println();
	}
	
	//declare method to select random word from the underwaterWorld array and assign the value of it to the randomWord variable
	public String selectRandomWord() {
		String randomWord = underwaterWorld [(int)(Math.random() * underwaterWorld.length)];
		return randomWord;
	}
	
	//declare method to display current game status
	public void displayCurrentGameStatus(int lives, StringBuffer secretWord, StringBuffer lettersUsed) {
		System.out.println("Lives: " + lives);
		System.out.println("Word: " + secretWord);
		
		if(lettersUsed.length() == 0) {//if there is no used letters then print following message
			System.out.println("Letters used: Waiting for your first letter");
		} else {
			System.out.println("Letters used: " + lettersUsed);}
	}

	//declare method to ask the user to play another game or not
	public void askUserToPlayAgain(int lives) {
		System.out.println("Do you wish to play another game? (choose y/n)");
		String answer = input.next().toLowerCase();//declare new variable to store the user's answer, convert it to lower case
		System.out.println();
		//if the user's answer is yes 'y', then assign to the variable gameOn value true and update the number of lives
		if(answer.equals("y")) {
			gameOn = true;
			lives = 7;
		} else { //if the answer is no 'n' assign to the variable gameOn value false 
		//and inform user about the game statistics
			gameOn = false;
			System.out.println("Thank You! The game is finished!" + "\n"
								+ "_______________________" + "\n"
								+ "Game statistics" + "\n"
								+ "Games played: " + numOfGames +"\n"
								+ "Games won: " + numOfWins + "\n"
								+ "Games lost: " + numOfLosses + "\n");
		}
	}
	
}//end class