import java.util.*;
import java.util.stream.Collectors;

public class Game {

    Scanner scanner = new Scanner(System.in);
    Players players;

    public void warGame() {
        Players players = new Players();
        int numbOfRound = 1;
        players.howManyPlayers();
        Card card;
        List<Card> playedCardInRound = new ArrayList<>();

        do {
            System.out.println("We are starting round number: \n" + "       ***** " + numbOfRound + " ***** ");

            for (int i = 0; i < players.getPlayerList().size(); i++) {
                Players playersName = players.getPlayerList().get(i);
                card = players.getPlayerList().get(i).getCards().get(0);
                players.getPlayerList().get(i).removeCardFromPlayer(card);
                playedCardInRound.add(card);

                System.out.println("Player " + playersName.getName() + " played " + card);

            }
            System.out.println("\n Card played this round: \n");
            System.out.println(playedCardInRound);
            playedCardInRound.clear();
            numbOfRound++;
        }
        while (doYouWantToPlayMore());

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









