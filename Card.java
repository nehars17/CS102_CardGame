public class Card implements Comparable<Card> {
    private int rank;
    private char suit;

    public Card(String rank, char suit) {
        boolean isValid=false;
        try{
            this.rank = Integer.parseInt(rank);
            isValid=true;

        } catch (NumberFormatException ignored ){
        }

        if (isValid==false){
            switch (rank) {
                case "T":
                    this.rank = 10;
                    break;
                case "J":
                    this.rank = 11;
                    break;
                case "Q":
                    this.rank = 12;
                    break;
                case "K":
                    this.rank = 13;
                    break;
                case "A":
                    this.rank = 14;
                    break;
                default:
                    this.rank = -1; // Invalid rank
                    break;
            }
        }
            this.suit = suit;
        }


    public int getRank() {
        return rank;
    }

    public char getSuit() {
        return suit;
    }

    @Override
    public int compareTo(Card otherCard) {
        return Integer.compare(this.rank, otherCard.rank);
    }
}

