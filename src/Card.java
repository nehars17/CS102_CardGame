public class Card {
    enum Suit {
        Diamonds(1), Clubs(2), Hearts(3), Spades(4);
        
        private final int rank;
        
        Suit(int rank) {
            this.rank = rank;
        }
        
        public int getRank() {
            return this.rank;
        }
    }

    enum Value {
        Three(3), Four(4), Five(5), Six(6), Seven(7), Eight(8), Nine(9), Ten(10),
        Jack(11), Queen(12), King(13), Ace(14), Two(15);

        private final int rank;

        Value(int rank) {
            this.rank = rank;
        }

        public int getRank() {
            return this.rank;
        }
    }

    private final Value value;
    private final Suit suit;

    public Card(Value value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    public String toString() {
        return value.name() + " of " + suit.name();
    }

    public int getRank() {
        return value.getRank() * 10 + suit.getRank(); 
    }
}
