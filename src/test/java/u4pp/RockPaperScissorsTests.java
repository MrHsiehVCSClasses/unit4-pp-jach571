package u4pp;

import static com.github.stefanbirkner.systemlambda.SystemLambda.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import java.util.Scanner;

public class RockPaperScissorsTests {
    @Test
    void displaysScoreCorrectly() throws Exception {
        withTextFromSystemIn("a", "y", "a", "y", "a", "y", "a", "n").execute(() -> {
            String output = tapSystemOutNormalized(() -> {
                Scanner sc = new Scanner(System.in);
                RockPaperScissors.play(sc);
            });
            String[] tokens = output.split(System.lineSeparator());
            int[] winsLossesDraws = { 0, 0, 0 };
            for (String tk : tokens) {
                tk = tk.toLowerCase();
                if (tk.indexOf("you win") > 0) {
                    winsLossesDraws[0]++;
                } else if (tk.contains("you lose")) {
                    winsLossesDraws[1]++;
                } else if (tk.contains("its a tie")) {
                    winsLossesDraws[2]++;
                }
            }

            String[] results = tokens[tokens.length - 2].split(" ");
            assertAll("logic results", () -> assertEquals(winsLossesDraws[0], Integer.parseInt(results[2])),
                    () -> assertEquals(winsLossesDraws[1], Integer.parseInt(results[5])),
                    () -> assertEquals(winsLossesDraws[2], Integer.parseInt(results[8])));
        });
    }

    @Test
    void gameLoopsCorrectly() throws Exception {
        withTextFromSystemIn("a", "y", "a", "y", "a", "y", "a", "n").execute(() -> {
            String output = tapSystemOutNormalized(() -> {
                Scanner sc = new Scanner(System.in);
                RockPaperScissors.play(sc);
            });
            String[] tokens = output.split("\n");
            assertEquals(10, tokens.length);
        });
    }

    @Test
    void doesRockPaperScissorLogicCorrectly() {
        int[] results = { -1, 0, 1, -1, 0, 1, -1, 0, 1 };

        assertAll("logic results", 
                () -> assertEquals(results[0], RockPaperScissors.results("R", "P")),
                () -> assertEquals(results[1], RockPaperScissors.results("R", "R")),
                () -> assertEquals(results[2], RockPaperScissors.results("R", "S")),
                () -> assertEquals(results[3], RockPaperScissors.results("S", "R")),
                () -> assertEquals(results[4], RockPaperScissors.results("S", "S")),
                () -> assertEquals(results[5], RockPaperScissors.results("S", "P")),
                () -> assertEquals(results[6], RockPaperScissors.results("P", "S")),
                () -> assertEquals(results[7], RockPaperScissors.results("P", "P")),
                () -> assertEquals(results[8], RockPaperScissors.results("P", "R")));
    }
}