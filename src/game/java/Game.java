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
        boolean anyCardHigher = false;


    //maybe should create map with <key Players and value getValue card?
        do {
            Card winningCard = players.getPlayerList().get(0).getCards().get(0); //1
            System.out.println("We are starting round number: \n" + "       ***** " + numbOfRound + " ***** ");
            System.out.println("This is actually hand from players " + players.getPlayerList());

            for (int i = 0; i < players.getPlayerList().size(); i++) {
                Players player = players.getPlayerList().get(i);
                Card card = player.getCards().get(0);
                player.removeCardFromPlayer(card);
                playedCardInRound.add(card);

                System.out.println("Player " + player.getName() + " played " + card);

                if (card.getValue() > winningCard.getValue()){
                    winningCard = card;
                    playersWithWinningCard.clear();
                    playersWithWinningCard.add(player);
                    anyCardHigher = true;
                } else if (card.getValue() == winningCard.getValue()) {
                    playersWithWinningCard.add(player);
                }
            }

            if (!anyCardHigher) {
                playersWithWinningCard.clear();
                playersWithWinningCard.addAll(players.getPlayerList());
            }

            if (playersWithWinningCard.size() > 1){
                Random random = new Random();
                System.out.println("There is more than one player with the winning card, so I will choose one at random.");
                Players winner = playersWithWinningCard.get(random.nextInt(playersWithWinningCard.size()));
                System.out.println("There is a winner! " + winner.getName());
                for (int j = 0; j < playedCardInRound.size(); j++) {
                    winner.addCardToPlayer(playedCardInRound.get(j));
                }
            } else {
                Players winner = playersWithWinningCard.get(0);
                System.out.println("There is a winner! " + winner.getName());
                for (int j = 0; j < playedCardInRound.size(); j++) {
                    winner.addCardToPlayer(playedCardInRound.get(j));
                }
            }

//There is an issue if first player has higher value then block if else is good but if second player wins then nothing happend


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









