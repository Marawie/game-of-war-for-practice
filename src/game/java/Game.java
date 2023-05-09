package game.java;

import java.util.*;

public class Game {

    Scanner scanner = new Scanner(System.in);


    public void warGame() {
        Players players = new Players();
        int numbOfRound = 1;
        players.howManyPlayers();
        List<Card> playedCardInRound = new ArrayList<>();
        List<Players> playersWithWinningCard = new ArrayList<>();
        Card winningCard = players.getPlayerList().get(0).getCards().get(0);

    //maybe should create map with <key Players and value getValue card?
        do {
            System.out.println("We are starting round number: \n" + "       ***** " + numbOfRound + " ***** ");

            for (int i = 0; i < players.getPlayerList().size(); i++) {
                Players playersName = players.getPlayerList().get(i);
                Card card = players.getPlayerList().get(i).getCards().get(0);
                players.getPlayerList().get(i).removeCardFromPlayer(card);
                playedCardInRound.add(card);

                System.out.println("Player " + playersName.getName() + " played " + card);
                if (card.getValue() > winningCard.getValue()){
                    winningCard = card;
                    playersWithWinningCard.add(players.getPlayerList().get(i));
                } else if (card.getValue() == winningCard.getValue()) {
                    playersWithWinningCard.add(players.getPlayerList().get(i));
                }if (playersWithWinningCard.size() > 1){
                    Random random = new Random();
                    System.out.println("There is more than one players with winning card so i would random, get card to 1 player");
                    Players winner = playersWithWinningCard.get(random.nextInt(playersWithWinningCard.size()));
                    System.out.println("There is a winner!" + winner.getName());
                }
            }



            System.out.println("\n Card played this round: \n");
            System.out.println(playedCardInRound);
            playedCardInRound.clear();
            playersWithWinningCard.clear();
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









