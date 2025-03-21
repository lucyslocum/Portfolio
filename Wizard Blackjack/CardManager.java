import java.security.SecureRandom;
import java.util.*;

public class CardManager{
    Scanner input = new Scanner(System.in);
    private Stack <Card> deck;
    private Random random;
    private int playerScore;
    private int compScore;
    private boolean sun;
    private boolean tower;
    private boolean lovers;
    private boolean hangedMan;
    private boolean death;
    private boolean magician;
    private boolean wheel;
    private boolean hermit;

    public CardManager() {
        String[] ranks = {"2", "3", "4", "5", "6",
            "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        deck = new Stack <>();
        List deckInteract = new ArrayList<>();
        random = new Random();
        for (String suit : suits) {
            for (String rank : ranks) {
                Card card = (new Card(rank, suit));
                deckInteract.add(card);
            }
        }
        deck.addAll(deckInteract);
    }
    public void shuffle() {
        Collections.shuffle(deck, random);
    }
    public Card dealCard() {
        if (deck.size() > 0) {
            return deck.pop();
        }
        else {
            return null;
        }
    }
    public int findCardValue(Card card) {
        int cardValue = 0;
        if (card.getRank().equals("Ace")) {
            cardValue = 11;
        }
        else if (card.getRank().equals("Jack") || card.getRank().equals("Queen") || card.getRank().equals("King")) {
            cardValue = 10;
        }
        else {
            cardValue = Integer.parseInt(card.getRank());
        }
        return cardValue;
    }
    public boolean tarotDeal() {
        System.out.println("You reach out and draw one of the tarot cards offered to you by the wizard.");
        int roll = random.nextInt(8) + 1;
        if (roll == 1) {
            sun = true;
            System.out.println("The Sun card has been drawn. Your final score will increase by 5.");
            return sun;
        }
        else if (roll == 2) {
            tower = true;
            System.out.println("The Tower card has been drawn. Both your and the dealer's final score will decrease by 5.");
            return tower;
        }
        else if (roll == 3) {
            lovers = true;
            System.out.println("The Lovers card has been drawn. Both your and the dealer's final score will increase by 5.");
            return lovers;
        }
        else if (roll == 4) {
            hangedMan = true;
            System.out.println("The Hanged Man card has been drawn. Your final score will decrease by 5.");
            return hangedMan;
        }
        else if (roll == 5) {
            death = true;
            System.out.println("The Death card has been drawn. The dealer's final score will decrease by 5.");
            return death;
        }
        else if (roll == 6) {
            magician = true;
            System.out.println("The Magician card has been drawn. The dealer's final score will increase by 5.");
            return magician;
        }
        else if (roll == 7) {
            wheel = true;
            System.out.println("The Wheel of Fortune card has been drawn. The Wheel of Fortune will decide your fate.");
            return wheel;
        }
        else {
            hermit = true;
            System.out.println("The Hermit card has been drawn. The Hermit will reveal the dealer's second card.");
            return hermit;
        }
    }
    public int playerDeal() {
        playerScore = 0;
        Card playerCard1 = dealCard();
        System.out.println("Card 1: " + playerCard1);
        System.out.println("Card Value: " + findCardValue(playerCard1));
        playerScore += findCardValue(playerCard1);
        Card playerCard2 = dealCard();
        System.out.println("Card 2: " + playerCard2);
        System.out.println("Card Value: " + findCardValue(playerCard2));
        playerScore += findCardValue(playerCard2);
        System.out.println("Current Score: " + playerScore);
        return playerScore;
    }
    public int computerDeal(boolean hermit, boolean magician, boolean lovers) {
        compScore = 0;
        Card compCard1 = dealCard();
        System.out.println("Wizard's Card: " + compCard1);
        compScore += findCardValue(compCard1);
        Card compCard2 = dealCard();
        if (hermit == true) {
            System.out.println("The lantern on the Hermit card glows for a moment, and reveals the wizard's second card; the " + compCard2);
        }
        compScore += findCardValue(compCard2);
        if(magician == true || lovers == true) {
            while (compScore < 11) {
                Card compCard = dealCard();
                compScore += findCardValue(compCard);
            }
        }
        else {
            while (compScore < 14) {
                Card compCard = dealCard();
                compScore += findCardValue(compCard);
            }
        }
        return compScore;
    }
    public int hit(int playerScore) {
            Card playerCard = dealCard();
            System.out.println("Card: " + playerCard);
            System.out.println("Card Value: " + findCardValue(playerCard));
            playerScore += findCardValue(playerCard);
            System.out.println("Current Score: " + playerScore);
        return playerScore;
    }
    public void gameResults(int playerScore, int compScore, boolean sun, boolean tower, boolean lovers, boolean hangedMan, boolean death, boolean magician, boolean wheel) {
        System.out.println("Initial Score: " + playerScore);
        System.out.println("Wizard's Initial Score: " + compScore);
        if (sun == true) {
            System.out.println("The tarot card in your hand grows warm for a moment.");
            playerScore += 5;
        }
        else if (tower == true) {
            System.out.println("The tarot card in your hand grows cold for a moment.");
            playerScore -= 5;
            compScore -= 5;
        }
        else if (lovers == true) {
            System.out.println("The tarot card in your hand grows warm for a moment.");
            playerScore += 5;
            compScore += 5;
        }
        else if (hangedMan == true) {
            System.out.println("The tarot card in your hand grows cold for a moment.");
            playerScore -= 5;
        }
        else if (death == true) {
            System.out.println("The tarot card in your hand grows cold for a moment.");
            compScore -= 5;
        }
        else if (magician == true) {
            System.out.println("The tarot card in your hand grows warm for a moment.");
            compScore += 5;
        }
        else if (wheel == true) {
            int coinFlip = random.nextInt(2) + 1;
            if (coinFlip == 1) {
                System.out.println("The Wheel of Fortune has decided that your score will increase by 5.");
                playerScore += 5;
            }
            else {
                System.out.println("The Wheel of Fortune has decided that your score will decrease by 5.");
                playerScore -= 5;
            }
        }
        System.out.println("Final Score: " + playerScore);
        System.out.println("Wizard's Final Score: " + compScore);
        if (playerScore > 21) {
            System.out.println("You busted! The wizard wins.");
        }
        else if (compScore > 21) {
            System.out.println("The wizard busted! You win.");
        }
        else if (playerScore > compScore) {
            System.out.println("You win!");
        }
        else if (compScore > playerScore) {
            System.out.println("The wizard wins.");
        }
        else {
            System.out.println("It's a tie.");
        }
    }
    public int hitMe(){
        System.out.println("Draw another card? (yes or no): ");
        String hit = input.next();
        if (hit.equalsIgnoreCase("no")) {
            return playerScore;
        }
        do {
            playerScore = hit(playerScore);
            System.out.println("Draw another card? (yes or no): ");
            hit = input.next();
        } while (hit.equalsIgnoreCase("yes"));
        return playerScore;
    }
    public void endGame(){
        gameResults(playerScore, compScore, sun, tower, lovers, hangedMan, death, magician, wheel);
    }
    public void computerTurn() {
        computerDeal(hermit, magician, lovers);
    }
}