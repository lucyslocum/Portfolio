import java.util.Scanner;
public class WizardBlackJack {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        instructions();
        gameRun();
        System.out.println("The wizard asks if you would like to play again.");
        System.out.println("Would you like to play again?");
        String answer = input.nextLine();
        while (answer.equalsIgnoreCase("yes")) {
            gameRun();
            System.out.println("Would you like to play again?");
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
    public static void instructions() {
        System.out.println("You are stopped in your tracks on your way to the grocery store by a stranger wearing a wizard hat and robes.");
        System.out.println("He holds out two decks of cards: one of playing cards, the other appearing to be a tarot deck.");
        System.out.println("He tells you that you must play a game with him if you wish to pass.");
        System.out.println(" \"The game is played thusly:\" he says in a screeching voice.");
        System.out.println("\"We both shall draw two cards from this deck of playing cards.");
        System.out.println("\"You will be able to see one of my cards, and I will not be able to see yours.\"");
        System.out.println("You can draw more cards if you wish, as can I.");
        System.out.println("\"The player with the highest score wins. BUT BE WARY!\" the wizard shrieks suddenly, making you wince.");
        System.out.println("He continues, \"If you draw a card that puts your score over 21, you lose automatically!\"");
        System.out.println("You tell the wizard that this just sounds like a game of Blackjack.");
        System.out.println(" \"It's different than Blackjack. It's Wizard Blackjack.\" the wizard says defensively.");
        System.out.println("The wizard shows you the deck of tarot cards and explains that they too are part of Wizard Blackjack.");
        System.out.println("The tarot cards have powers that will affect the game. Keep in mind which card you have drawn as you play.");



    }
}