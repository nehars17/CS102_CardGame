package main;

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
        
        this.deck = new Deck(); 
        this.passCounter = 0;
    }
    
    public void startGame() {
        deck.shuffle(); 
        dealCards();
        findStartingPlayer();
    }
    
    private void dealCards() {
        for (int i = 0; i < 13; i++) {
            for (Player player : players) {
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
        }
    }
    
    private void setActivePlayer(Player player) {
        this.currentPlayer = player;
    }

}
