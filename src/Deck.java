import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> deck;

    public Deck() {
        deck = new ArrayList<>();
        buildDeck();
        shuffle();
    }

    private void buildDeck() {
        deck.clear();
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Value value : Card.Value.values()) {
                deck.add(new Card(value, suit));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public Card drawCard() {
        if (!deck.isEmpty()) {
            return deck.remove(0);
        } else {
            throw new IllegalStateException("Cannot draw from an empty deck.");
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Card card : deck) {
            builder.append(card.toString()).append("\n");
        }
        return builder.toString();
    }
}
