package u4pp;
/**
* Program takes in an input from the user and determines if the input is a palindrome or not. A palindrome, in this code, is any
string that reads the same forward and backwards when spaces, numbers, punctuation, and capitalization are all ignored. Hence, 
this code will ignore spaces, numbers, punctuation, and capitlization when checking for a palindrome.
*/
import java.util.Scanner;

public class PalindromeTester {
    /**
     * Executes the code that checks whether the user input is a palindrome. First prompts the user to enter an input to check if
     the code is a palindrome. If the code is a palindrome, then the output will tell the user that it was a palindrome, and if the
     input was not a palindrome, then the output will tell the user so. The user will then be prompted with an option to either
     keep testing or leave. If the user enters "y" or "Y," then the palindrome checker will run again, and if the user enters "n" or
     "N," then the palindrome checker will stop running.
     */
    public static void execute(Scanner sc) {
        boolean play = true;
        System.out.println("Welcome to Palindrome Tester");

        while(play == true){
            System.out.print("Enter a phrase: ");
            String input = sc.nextLine();

            boolean result = isPalindrome(input);
            if(result == true){
                System.out.println(input + " is a palindrome");
            } else{
                System.out.println(input + " is not a palindrome");
            }
            System.out.print("Keep testing? (Y)es or (N)o: ");
            input = sc.nextLine();

            if(input.toUpperCase().equals("Y")){
                play = true;
            } else if(input.toUpperCase().equals("N")){
                play = false;
            } else{
                while(!input.toUpperCase().equals("Y") && !input.toUpperCase().equals("N")){
                System.out.println("Invalid Input, please try again");
                System.out.print("Keep testing? (Y)es or (N)o: ");
                input = sc.nextLine();
            }
                play = false;
            }
        }
    }

    /**
     * This is the code to check whether a user input is a palindrome or not. If the user's input was a palindrome, then the function
     will return as true, and if the user's input was not a palindrome, then the function will return as false. The code works by 
     checking each of the letters of the word starting from the first and last letters of the word and working inwards. If any two
     of these combinations does not return as the same character, then the code returns false. If all of the letters returned as the
     same, then the function returns true since the input was a palindrome.
     */
    public static boolean isPalindrome(String phrase) {
        String replaceString = phrase.replaceAll("\\d","");
        replaceString = replaceString.replaceAll("\\p{Punct}","");
        replaceString = replaceString.replaceAll(" ","");
        replaceString = replaceString.toLowerCase();

        for(int start = 0; start < replaceString.length(); start++){
            if(replaceString.charAt(start) != replaceString.charAt(replaceString.length() - 1 - start)){
                return false;
            } else{
                return true;
            }
        }
        return false;
    }
}