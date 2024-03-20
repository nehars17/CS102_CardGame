

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Game {
    private ArrayList<Player> players;
    private Deck deck;
    private Player currentPlayer;
    private int passCounter;

    public Game() {
        this.players = new ArrayList<>();

        this.players.add(new Player("Player1"));
        this.players.add(new Player("Player2"));
        this.players.add(new Player("Player3"));
        this.players.add(new Player("Player4"));
        Deck deck = new Deck();
        deck.buildDeck();
        this.deck = deck;
        this.passCounter = 0;
    }

    public void startGame() {
        deck.shuffle();
        dealCards();
        findStartingPlayer();
    }

    private void dealCards() {
//        System.out.println("deck size " + deck.getDeck().size());
        for (Player player : players) {
        for (int i = 0; i < 12; i++) {
            Card card = deck.drawCard();
            player.getHand().addCard(card);
            }
        }
    }

    private void findStartingPlayer() {
        for (Player player : players) {
            if (player.hasThreeOfDiamonds(player.getHand())) {
                setActivePlayer(player);
                break;
            }
            else{
                new Game();
            }
        }
    }

    public ArrayList<Player> getAllPlayers(){
        return players;
    }

    public void setActivePlayer(Player player) {
        this.currentPlayer = player;
    }
    public Player getActivePlayer() {
        return currentPlayer;
    }

}