package game.java;

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


    Scanner scanner = new Scanner(System.in);
    List<Players> playerList = new ArrayList<>();

    public List<Players> getPlayerList() {
        return playerList;
    }

    public String toString() {
        return "Player: " + this.getName() + " has these cards: " + this.cards + "\n";
    }

    public void removeCardFromPlayer(Card card) {
        cards.remove(card);
    }

    public String getName() {
        return name;
    }

    public void addCardToPlayer(Card card) {
        cards.add(card);
    }

    public void howManyPlayers() {
        try {
            System.out.println("Welcome to card game names of War Game!");

            Players player;
            Deck deck = new Deck();
            deck.createDeck();
            deck.shuffleDeck();
            System.out.println("We are starting the game!");
            System.out.println("How many players you would like to play?");
            System.out.println("Max - 4, Min - 2!");
            int choice = scanner.nextInt();

            if (choice >= 2 && choice <= 4) {
                for (int i = 0; i < choice; i++) {
                    System.out.println("Set name of player");
                    String names = scanner.next();
                    player = new Players(names);
                    getPlayerList().add(player);
                }
                int howManyCardsShouldPlayerHave = deck.getDeck().size() / choice;
                for (int i = 0; i < deck.getDeck().size(); i++) {
                    for (Players players : playerList) {
                        if (players.cards.size() <= howManyCardsShouldPlayerHave) {
                            Card card = deck.draw();
                            players.cards.add(card);
                        }
                    }
                }

                System.out.println("Now Dealer add cards to your hand!");
                System.out.println("So game started with: " + "\n" + getPlayerList());
            } else
                System.out.println("I said you, there has to be at least 2 or maximum 4 players!");
            System.exit(1);
        } catch (InputMismatchException e) {
            System.out.println("You input string, only numbers accepted");
            System.exit(1);
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            System.out.println("The number is out of bound!");

        } catch (Exception e) {
            System.out.println("Something went wrong! :( ");
        }
    }
}
