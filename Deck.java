import java.util.ArrayList;

public class Deck {

    private ArrayList<Card> deck;

    public void buildDeck() {
        deck = new ArrayList<>();
        String[] values = { "a", "2", "3", "4", "5", "6", "7", "8", "9", "j", "q", "k" };
        String[] types = { "d", "c", "h", "s" };

        for (int i = 0; i < types.length; i++) {
            for (int j = 0; j < values.length; j++) {
                Card card = new Card(values[j], types[i]);
                deck.add(card);
            }
        }

//        System.out.println("BUILD DECK:");
//        System.out.println(deck);
    }

    public void shuffle() {
        for (int i = 0; i < deck.size(); i++) {
            int randomIndex = (int) (Math.random() * deck.size());
            Card temp = deck.get(i);
            deck.set(i, deck.get(randomIndex));
            deck.set(randomIndex, temp);
        }

        // System.out.println("SHUFFLE DECK:");
        // System.out.println(deck);
    }
    public ArrayList<Card> getDeck(){
        return deck;
    }
    public Card drawCard() {
        return deck.remove(0);
    }

    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.buildDeck();
        deck.shuffle();
    }
}