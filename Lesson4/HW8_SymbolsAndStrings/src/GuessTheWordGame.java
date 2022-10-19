public class GuessTheWordGame {
    private String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
            "broccoli", "carrot", "cherry", "garlic", "grape", "melon",
            "leek", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
            "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
    private String computerWord;
    private String guessedSymbols = "###############";

    public GuessTheWordGame() {
        computerWord = words[(int) (Math.random() * words.length)];
    }

    public boolean isGuessed(String playerWord) {
        return playerWord.equals(computerWord);
    }

    public String getGuessedSymbols(String playerWord) {
        char[] guessedSymbols = this.guessedSymbols.toCharArray();

        for (int i = 0; i < computerWord.length() && i < playerWord.length(); i++) {
            if (playerWord.charAt(i) == computerWord.charAt(i)) {
                guessedSymbols[i] = computerWord.charAt(i);
            }
        }

        this.guessedSymbols = String.valueOf(guessedSymbols);
        return this.guessedSymbols;
    }
}
