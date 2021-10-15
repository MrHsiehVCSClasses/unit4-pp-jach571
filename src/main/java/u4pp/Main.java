package u4pp;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); 
        RockPaperScissors.play(scan);
        PalindromeTester.execute(scan);
        scan.close();
    }
}