package u4pp;
import java.util.Scanner;

/**
* Let's the user play a game of rock, paper, scissors with a computer. The player will be prompted to choose one of the three, or 
randomly generate one of the three, and the computer will choose one of the three options as well. User can choose to play again at 
the end of the game.
*/

public class RockPaperScissors {
    /**
     * Has a while statement that runs the code the first time, and if the user wants to play again and types "y" or "Y," then the
     code will run again. If the user doesn't want to play again and types "n" or "N," then the code will stop running and a thank
     you message will play. If the user ever enters an invalid input, they will be prompted to enter the input again. The user types
     either "R," "P," or "S" to choose the options rock, paper, and scissors respectively. The code will keep a running count of
     the game's total score of the user's wins, losses, and ties.
     */
    public static void play(Scanner sc) {
        boolean play = true;
        int playerWinCount = 0;
        int playerTieCount = 0;
        int playerLoseCount = 0;

        System.out.println("Welcome to Rock Paper Scissors");
        while(play == true){
            System.out.print("Would you like to pick (R)ock, (P)aper, (S)cissors, or (A)ny: ");
            String input = sc.nextLine();

            String pChoice = "";
            String humanPlayerWord = "";
            String humanComputerWord = "";

            if(input.toUpperCase().equals("R")){
                pChoice = "R";
                humanPlayerWord = "Rock";
            } else if(input.toUpperCase().equals("P")){
                pChoice = "P";
                humanPlayerWord = "Paper";
            } else if(input.toUpperCase().equals("S")){
                pChoice = "S";
                humanPlayerWord = "Scissors";
            } else if(input.toUpperCase().equals("A")){
                int pRandom = (int)(Math.random() * 3) + 1;

                if(pRandom == 1){
                    pChoice = "R";
                    humanPlayerWord = "Rock";
                } else if(pRandom == 2){
                    pChoice = "P";
                    humanPlayerWord = "Paper";
                } else if(pRandom == 3){
                    pChoice = "S";
                    humanPlayerWord = "Scissors";
                }
            } else{
                while(!input.toUpperCase().equals("R") && !input.toUpperCase().equals("P") && !input.toUpperCase().equals("S") && !input.toUpperCase().equals("A")){
                    System.out.println("Invalid input, please try again");
                    System.out.print("Would you like to pick (R)ock, (P)aper, (S)cissors, or (A)ny: ");
                    input = sc.nextLine();
                }
            }
            String cChoice = "";
            int cRandom = (int)(Math.random() * 3) + 1;
                
            if(cRandom == 1){
                cChoice = "R";
                humanComputerWord = "Rock";
            } else if(cRandom == 2){
                cChoice = "P";
                humanComputerWord = "Paper";
            } else if(cRandom == 3){
                cChoice = "S";
                humanComputerWord = "Scissors";
            }

            int result = RockPaperScissors.results(pChoice, cChoice);
            if(result == 1){
                playerWinCount += 1;
                System.out.println("You picked " + humanPlayerWord + ", and the Computer picked " + humanComputerWord + ". You win!");
            } else if(result == 0){
                playerTieCount += 1;
                System.out.println("You both picked " + humanPlayerWord + ". Its a tie!");
            } else if(result == -1){
                playerLoseCount += 1;
                System.out.println("You picked " + humanPlayerWord + ", and the Computer picked " + humanComputerWord + ". You lose!");
            }
            System.out.println("You have " + playerWinCount + " wins and " + playerLoseCount + " losses and " + playerTieCount + " ties");

            System.out.print("Would you like to play again? (Y)es or (N)o: ");
            input = sc.nextLine();

            if(input.toUpperCase().equals("Y")){
                play = true;
            } else if(input.toUpperCase().equals("N")){
                play = false;
                System.out.println("Thanks for playing!");
            } else{
                while(!input.toUpperCase().equals("Y") && !input.toUpperCase().equals("N")){
                    System.out.println("Invalid input, please try again");
                    System.out.print("Would you like to play again? (Y)es or (N)o: ");
                    input = sc.nextLine();
                }
                System.out.print("Thanks for playing!");
                play = false;
            }
        }
    }

    /**
     * This is the code that checks whether the player won, lost, or tied. If the player won vs. the computer, then a value of 1
     will return. If the player lost vs. the computer, then a value of -1 will return. If the player and the computer tied, then a
     value of 0 will return. THe function only returns integers. Takes in two strings as its parameters, the strings being the user
     and computer's choices.
     */
    public static int results(String playerChoice, String computerChoice) {
        int value = 0;
        if(playerChoice.equals(computerChoice)){
            value = 0;
        } else if(playerChoice.equals("R") && computerChoice.equals("P")){
            value = -1;
        } else if(playerChoice.equals("R") && computerChoice.equals("S")){
            value = 1;
        } else if(playerChoice.equals("S") && computerChoice.equals("R")){
            value = -1;
        } else if(playerChoice.equals("S") && computerChoice.equals("P")){
            value = 1;
        } else if(playerChoice.equals("P") && computerChoice.equals("S")){
            value = -1;
        } else if(playerChoice.equals("P") && computerChoice.equals("R")){
            value = 1;
        }
        return value;
    }

    /* Any other code comments */
}