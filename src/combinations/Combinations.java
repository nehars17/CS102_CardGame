package combinations;

import cards.Card;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import players.*;

public class Combinations extends Hand {
    private ArrayList<Card> cardList;
    private int numOfCards;
    public Combinations(){

    }
    public Combinations(ArrayList<Card> hand) {
        this.cardList = hand;
        this.numOfCards = hand.size();
    }


     public boolean isValid(ArrayList<Card> cardList){
        return false;
     }


    public Card getTopCard() {
        return cardList.get(0);
    }

    public int getNumOfCards() {
        return this.numOfCards;
    }



    public static Map<Integer, Integer> getRankCount(ArrayList<Card> cardList) {
        Map<Integer, Integer> rankCount = new HashMap<>();
        for (Card card : cardList) {
            int rank = card.getValue();
            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
        }

        return rankCount;
    }

    public boolean isGreaterThan(Hand h1, Hand h2) {
        int cardTotal1 = 0;
        int cardTotal2 = 0;
        if (h1.getHand() == null && h2.getHand() == null) {
            return true;
        }

        else if (h1.getHand().size() != h2.getHand().size()) {
            return false;
        }

        else {
                for (int i = 0; i < h1.getHand().size(); i++) {
                    Card card = h1.getHand().get(i);
                    Card card2 = h2.getHand().get(i);
                    cardTotal1 += card.getValue();
                    cardTotal2 += card2.getValue();


                }
                System.out.println(cardTotal1 + "  " + cardTotal2);
                if (cardTotal1 < cardTotal2) {
                    return true;
                } else {
                    return false;
                }
            }
//        } if (this.getType().equals(hand.getType())) {
//            return this.getTopCard().compareTo(hand.getTopCard()) > 0;
//        } else {
//            // Assuming getType() returns a String, not a List
//            return this.getType().compareTo(hand.getType()) > 0;
//        }
        }
    }
