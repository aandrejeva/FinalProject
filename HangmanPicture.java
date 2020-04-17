package FinalProjectFinalVersion;

//class to visualize the progress of the game
public class HangmanPicture {
	
	//declare method to display hangman depending on the number of lives
	public void displayHangman(int lives) {
		switch (lives) {
			case 0:
				System.out.println("__________");
				System.out.println("|" + "\t " + " " + "|");
				System.out.println("|"+ "\t " + " " + "O");
				System.out.println("|" + "\t " + "/" + "|" + "\\");
				System.out.println("|" + "\t " + "/" + " " + "\\");
				break;
			case 1:
				System.out.println("__________");
				System.out.println("|" + "\t " + " " + "|");
				System.out.println("|"+ "\t " + " " + "O");
				System.out.println("|" + "\t " + "/" + "|" + "\\");
				System.out.println("|" + "\t " + "/");
				break;
			case 2:
				System.out.println("__________");
				System.out.println("|" + "\t " + " " + "|");
				System.out.println("|"+ "\t " + " " + "O");
				System.out.println("|" + "\t " + "/" + "|" + "\\");
				System.out.println("|");
				break;
			case 3:
				System.out.println("__________");
				System.out.println("|" + "\t " + " " + "|");
				System.out.println("|"+ "\t " + " " + "O");
				System.out.println("|" + "\t " + "/" + "|");
				System.out.println("|");
				break;
			case 4:
				System.out.println("__________");
				System.out.println("|" + "\t " + " " + "|");
				System.out.println("|"+ "\t " + " " + "O");
				System.out.println("|" + "\t " + " " + "|");
				System.out.println("|");
				break;
			case 5:
				System.out.println("__________");
				System.out.println("|" + "\t " + " " + "|");
				System.out.println("|"+ "\t " + " " + "O");
				System.out.println("|");
				System.out.println("|");
				break;
			case 6:
				System.out.println("__________");
				System.out.println("|" + "\t " + " " + "|");
				System.out.println("|");
				System.out.println("|");
				System.out.println("|");
				break;
			case 7:
				System.out.println("__________");
				System.out.println("|");
				System.out.println("|");
				System.out.println("|");
				System.out.println("|");
				break;
		}
	}//end method
	
}//end class
