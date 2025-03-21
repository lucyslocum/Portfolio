import java.util.Scanner;
public class WizardBlackJack {
    public static void main(String[] args) {
        CardManager newDeck = new CardManager();
        Scanner input = new Scanner(System.in);
        newDeck.instructions();
        gameRun();
        System.out.println("Would you like to play again? ");
        String answer = input.nextLine();
        while (answer.equalsIgnoreCase("yes")) {
            gameRun();
            System.out.println("Would you like to play again? ");
            answer = input.nextLine();
        }
    }
    public static void gameRun(){
        CardManager newDeck = new CardManager();
        newDeck.shuffle();
        newDeck.tarotDeal();
        newDeck.computerTurn();
        newDeck.playerDeal();
        newDeck.hitMe();
        newDeck.endGame();
    }
}
