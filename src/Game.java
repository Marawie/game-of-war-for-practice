import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {

    Scanner scanner = new Scanner(System.in);

    public void warGame() {
        Players players = new Players();
        int numbOfRound = 1;
        players.howManyPlayers();


    try {
        do {
            System.out.println("It's round number:" + numbOfRound);
            List<Card> cardsInPlay = new ArrayList<>();
            for (int i = 0; i < players.getPlayerList().size(); i++) {
                Card card = players.playerList.get(i).getCards().get(0);
                System.out.println("Player " + players.getName() + " played: " + card);
                cardsInPlay.add(card);
            }
            int highestValue = cardsInPlay.get(0).getValue();
            int highestValueIndex = 0;
            for (int i = 1; i < cardsInPlay.size(); i++) {
                if (cardsInPlay.get(i).getValue() > highestValue) {
                    highestValue = cardsInPlay.get(i).getValue();
                    highestValueIndex = i;
                }
            }
            System.out.println("Player " + (highestValueIndex+1) + " won the round!");
            for (int i = 0; i < cardsInPlay.size(); i++) {
                players.playerList.get(highestValueIndex).addCardToPlayer(cardsInPlay.get(i));
            }
            numbOfRound++;
        } while (doYouWantToPlayMore() == true);

    }catch (IndexOutOfBoundsException e){
        System.out.println("Not that type which was expected!");
    }
    }

    public boolean doYouWantToPlayMore() {
        System.out.println("Do you want to play more? Y/N");
        String choice = scanner.next().toUpperCase();
        if (choice.equals("Y")) {
            return true;
        }
        return false;
    }
}







