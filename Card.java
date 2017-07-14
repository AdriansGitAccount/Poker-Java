/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getTheCardsReady;

/**
 *
 * @author laptopAdrian
 */
public class Card implements Comparable<Card> {

    // http://www.dreamincode.net/forums/topic/116864-how-to-make-a-poker-game-in-java/
    private static String[] rank_list = {null, "Ace", "2", "3", "4", "5", "6",
        "7", "8", "9", "10", "Jack", "Queen", "King"};
    private static String[] suit_list = {null, "Spades", "Diamonds", "Clubs",
        "Hearts"};

    private final int suit;
    private final int rank;

    public Card() {
        this.rank = 1;
        this.suit = 1;
    }

    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    /*
     Getters 
     and Setters
     */
    public int getSuit() {
        return this.suit;
    }

    // public void setSuit(int suit) {
    // this.suit = suit;
    // }
    public int getRank() {
        return this.rank;
    }
    // public void setRank(int rank) {
    // this.rank = rank;
    // }

    @Override
    public int compareTo(Card that) {
//        int cmp; 
//        cmp = this.getRank().compareTo(that.getRank());         
//	return cmp != 0 ? cmp : this.getRank().compareTo(that.getRank()); 

        if (this.getRank() > that.getRank()) {
            return 1;
        } else if (this.getRank() < that.getRank()) {
            return -1;
        }
        return 0; // if cards are equal.
    }

    public static String rankAsString(int rank) {
        
        //if (rank_list[rank] == 1)
        return rank_list[rank];
    }

    public static String suitAsString(int suit) {
        return suit_list[suit];
    }

    
    @Override
    public String toString() {
        return rank_list[rank] + " of " + suit_list[suit];
    }
}
