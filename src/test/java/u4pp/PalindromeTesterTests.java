package u4pp;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOutNormalized;
import static com.github.stefanbirkner.systemlambda.SystemLambda.withTextFromSystemIn;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

class PalindromeTesterTests {


    @Test
    void isPalindrome_whenCalledWithAllUpperCaseOddPalindrome_returnsTrue() {
        assertTrue(PalindromeTester.isPalindrome("XYZYX"));
    }

    @Test
    void isPalindrome_whenCalledWithAllUpperCaseEvenPalindrome_returnsTrue() {
        assertTrue(PalindromeTester.isPalindrome("QWERREWQ"));
    }

    @Test
    void isPalindrome_whenCalledWithAllLowerCaseOddPalindrome_returnsTrue() {
        assertTrue(PalindromeTester.isPalindrome("abcdcba"));
    }

    @Test
    void isPalindrome_whenCalledWithAllLowerCaseEvenPalindrome_returnsTrue() {
        assertTrue(PalindromeTester.isPalindrome("abccba"));
    }

    @Test
    void isPalindrome_whenCalledWithAllLowerCaseLongPalindrome_returnsTrue() {
        assertTrue(PalindromeTester.isPalindrome("aaaabbccddeeddeeddggaaddggddaaaeeeeppeeeeaaaddggddaaggddeeddeeddccbbaaaa"));
    }

    @Test
    void isPalindrome_whenCalledWithSpacesAndCaptilizationDiffferences_returnsTrue() {
        assertTrue(PalindromeTester.isPalindrome("Never odd or Even"));
    }

    @Test
    void isPalindrome_whenCalledWithASingleWordPalindromeWithCapitalizationDifferences_returnsTrue() {
        assertTrue(PalindromeTester.isPalindrome("raCecAr"));
    }

    @Test
    void isPalindrome_whenCalledWithAPalindromeThatHasNumbersSpacesAndSymbols_returnsTrue() {
        assertTrue(PalindromeTester.isPalindrome("r98123 ace  137&&109c 00AR"));
    }

    @Test
    void isPalindrome_whenCalledWithASimpleStringThatIsNotAPalindrome_returnsFalse() {
        assertFalse(PalindromeTester.isPalindrome("thisISnoTApalindrome"));
    }

    @Test
    void isPalindrome_whenCalledWithAStringWithSpacesAndSymbolsThatIsNotAPalindrome_returnsFalse() {
        assertFalse(PalindromeTester.isPalindrome("thi@@isIsNot       a Palindrome"));
    }

    @Test
    void execute_whenCalled_executesTheLoopsCorrectly() throws Exception {
        int timesExecuted = 6;
        withTextFromSystemIn("ask;ljasd", "y", "racecar", "Y", "monkey", "peanut", "n").execute(() -> {
            String output = tapSystemOutNormalized(() -> {
                Scanner sc = new Scanner(System.in);
                PalindromeTester.execute(sc);
            });
            assertEquals(timesExecuted, output.split("\n").length);
        });
    }
}