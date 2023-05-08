public class Card {
    private String rank;
    private int value;
    private String suit;

    public Card(){}

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public Card(String rank, String suit, int value) {
        this.rank = rank;
        this.value = value;
        this.suit = suit;
    }

    public String toString() {
        return  "( "+ this.rank +" of " + this.suit + " has value: " + this.value + " )";
    }
}
