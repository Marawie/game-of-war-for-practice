import java.util.*;

public class Players {
    private String name;

    private List<Card> cards = new ArrayList<>();

    public List<Card> getCards() {
        return cards;
    }

    public Players() {
    }

    public Players(String name) {
        this.name = name;
    }

    public Players(String name, List<Card> cards) {
        this.name = name;
        this.cards = cards;

    }

    Scanner scanner = new Scanner(System.in);
    List<Players> playerList = new ArrayList<>();

    public List<Players> getPlayerList() {
        return playerList;
    }

    public String toString() {
        return "Player: " + this.name + " has these cards: " + this.cards + "\n";
    }

    public void removeCardFromPlayer(Card card) {
        cards.remove(card);
    }

    public void addCardToPlayer(Card card) {
        cards.add(card);
    }

    public void howManyPlayers() {
        Players player;
        Deck deck = new Deck();
        deck.createDeck();
        deck.shuffleDeck();
        System.out.println("We are starting the game!");
        System.out.println("How many players you would like to play?");
        System.out.println("Max - 5, Min - 2!");
        int choice = scanner.nextInt();
        if (choice >= 2 && choice <= 5) {
            for (int i = 0; i < choice; i++) {
                System.out.println("Set name of player");
                String names = scanner.next();
                player = new Players(names);
                getPlayerList().add(player);
            }
                int howManyCardsShouldPlayerHave = deck.getDeck().size() / choice;
            for (int x = 0; x < deck.getDeck().size(); x++) {
                for (int j = 0; j < playerList.size(); j++) {
                    if (playerList.get(j).cards.size() < howManyCardsShouldPlayerHave) {
                        Card card = deck.draw();
                        playerList.get(j).cards.add(card);
                    }
                }
            }


            System.out.println("Now Dealer add cards to your hand!");
            System.out.println("So game started with: " + "\n" + getPlayerList());
        } else
            System.out.println("I said you, there has to be at least 2 or maxiumum 5 players!");
    }
}

