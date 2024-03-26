package model.players;

import model.cards.Card;

import java.util.ArrayList;

public class Player {
    private int playerId;
    private Hand hand;

    public Player(int playerId) {
        this.playerId = playerId;
        this.hand = new Hand();
    }

    public void receiveCard(Card card) {
        hand.addCard(card);
    }

    public void playCard(ArrayList<Card> cardsToPlay) {
        for (Card card : cardsToPlay) {
            hand.getCardsInHand().remove(card);
        }
    }

    public ArrayList<Card> getCardsInHand() {
        return hand.getCardsInHand();
    }

    public int getPlayerId() {
        return playerId;
    }
}