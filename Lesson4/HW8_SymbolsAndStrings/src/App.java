import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        GuessTheWordGame guessTheWord = new GuessTheWordGame();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Guess the word:");

        while (true) {
            String playerWord = scanner.next();

            if (guessTheWord.isGuessed(playerWord)) {
                System.out.println("Congratulations! You win!");
                return;
            }
            System.out.println("Wrong!");
            System.out.println("Guessed symbols: " + guessTheWord.computeGuessedSymbols(playerWord));
        }
    }
}
