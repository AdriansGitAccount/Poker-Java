/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getTheCardsReady;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author laptopAdrian
 */
public final class Hand { //implements Comparable<Hand>

    private int[] totalRanks; // size 14 , represents the number 1-13
    private String[] totalSuits; // size 14, represents the number 1-13,
    // holds
    // string of the suit
    private int[] value;

    ArrayList<Card> hand;
    int totalHandValue;

    private boolean highCard = false;
    private boolean pair = false;
    private boolean twoPair = false;
    private boolean threeOfAKind = false;
    private boolean straight = false;
    private boolean flush = false;
    private boolean fullHouse = false;
    private boolean fourOfAKind = false;
    private boolean straightFlush = false;
    private boolean royalFlush = false;

    
    
    /**
     * Set the cards that I want to use for testing.
     *
     * @param cards
     */
    public Hand(ArrayList<Card> cards) {
        // Card one, Card two, Card three, Card four, Card five
        setHand(cards);
        Collections.sort(hand);
        //fillTotalValueArray();
    }

    /**
     * Deal a number of cards from the deck.
     *
     * @param numberOfCards
     * @param theDeck
     */
    public Hand(int numberOfCards, Deck theDeck) {

        //value = new int[numberOfCards + 1];
        hand = new ArrayList<>(numberOfCards);
        for (int i = 0; i < numberOfCards; i++) {
            hand.add(theDeck.dealCard());
        }
        Collections.sort(hand);
        fillTotalValueArray();
    }

    /**
     * Empty constructor
     */
    public Hand() {

    }

    public void printValueArray() {
        System.out.println("---------- totalRank ------- totalSuit ----------");
        for (int i = 0; i < hand.size(); i++) {
            System.out.println("Card -> " + (i) + " [(Rank : "
                    + hand.get(i).getRank() + ") <-->  (Suit : "
                    + hand.get(i).getSuit() + ")]");
        }
    }

    public void displayHand() throws Exception {

        try {
            hand.stream().forEach((cardInHand) -> {
                System.out.println(cardInHand.toString());
            });
//            for (Card c : hand) {
//                System.out.println(c.toString());
//            }
        } catch (Exception e) {
            print("You do not have any cards yet" + e.getMessage());
        }

    }

    // Not used ..
//    @Override
//    public int compareTo(Hand that) {
//
//        for (int x = 0; x < value.length; x++) // cycle through values
//        {
//            if (this.hand.get(x).getSuit() > that.getCardSuit(x)) {
//                return 1;
//            } else if (hand.get(x).getSuit() < that.getCardSuit(x)) {
//                return -1;
//            }
//        }
//        return 0; // if hands are equal
//    }
    private void print(Object o) {
        System.out.println(o);
    }

    /*
     * toString method's
     */
    @Override
    public String toString() {
        return hand.toString();
    }

    public String toString(Object str) {
        return str.toString();
    }

    /*
     * Getters and Setters
     */
    public int getTotalHandValue() {
        return totalHandValue;
    }

    public void addToTotalHandValue(int value) {
        this.totalHandValue += value;
    }

    public void setTotalHandValue(int totalHandValue) {
        this.totalHandValue = totalHandValue;
    }

    public int getSize() {
        return hand.size();
    }

    public int getCardSuit(int cardNum) {
        return hand.get(cardNum).getSuit();
    }

    public int getCardRank(int cardNum) {
        return hand.get(cardNum).getRank();
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public void setCard(Card card, int position) {
        this.hand.set(position, card);
    }

    public Card getCard(int position) {
        return hand.get(position);
    }
public int[] getValue() {
        return value;
    }

    public void setValue(int[] value) {
        this.value = value;
    }

    public boolean isHighCard() {
        return highCard;
    }

    public void setHighCard(boolean highCard) {
        this.highCard = highCard;
    }

    public boolean isPair() {
        return pair;
    }

    public void setPair(boolean pair) {
        this.pair = pair;
    }

    public boolean isTwoPair() {
        return twoPair;
    }

    public void setTwoPair(boolean twoPair) {
        this.twoPair = twoPair;
    }

    public boolean isThreeOfAKind() {
        return threeOfAKind;
    }

    public void setThreeOfAKind(boolean threeOfAKind) {
        this.threeOfAKind = threeOfAKind;
    }

    public boolean isStraight() {
        return straight;
    }

    public void setStraight(boolean straight) {
        this.straight = straight;
    }

    public boolean isFlush() {
        return flush;
    }

    public void setFlush(boolean flush) {
        this.flush = flush;
    }

    public boolean isFullHouse() {
        return fullHouse;
    }

    public void setFullHouse(boolean fullHouse) {
        this.fullHouse = fullHouse;
    }

    public boolean isFourOfAKind() {
        return fourOfAKind;
    }

    public void setFourOfAKind(boolean fourOfAKind) {
        this.fourOfAKind = fourOfAKind;
    }

    public boolean isStraightFlush() {
        return straightFlush;
    }

    public void setStraightFlush(boolean straightFlush) {
        this.straightFlush = straightFlush;
    }

    public boolean isRoyalFlush() {
        return royalFlush;
    }

    public void setRoyalFlush(boolean royalFlush) {
        this.royalFlush = royalFlush;
    }
    
    // --------------------------------------------------------
     public int[] getTotalRanks() {
        return totalRanks;
    }

    public void setTotalRanks(int[] totalRanks) {
        this.totalRanks = totalRanks;
    }

    public int getTotalRanksIndex(int index) {
        return totalRanks[index];
    }

    public String[] getTotalSuits() {
        return totalSuits;
    }

    public void setTotalSuits(String[] totalSuits) {
        this.totalSuits = totalSuits;
    }
    private void fillTotalValueArray() {

        totalRanks = new int[14];
        totalSuits = new String[14];

        for (int x = 0; x <= 13; x++) {
            totalRanks[x] = 0; // zero the contents of the array
            totalSuits[x] = "";
        }
        for (Card card : hand) {
            int cardRank = card.getRank();
            int cardSuit = card.getSuit();
            totalRanks[cardRank]++;

            if (totalSuits[cardRank].equals("")) {
                totalSuits[cardRank] = Card.suitAsString(cardSuit);
            } else {
                totalSuits[cardRank] = totalSuits[cardRank] + " , "
                        + Card.suitAsString(cardSuit);
            }
        }
    }

     public void valueArr() {
        System.out.println("-- Count of Ranks -- Count of Suits --");
        for (int i = 1; i < totalRanks.length; i++) {
            System.out.println("Card->" + (i) + " (Rank : " + totalRanks[i]
                    + ")<-->(Suit : " + totalSuits[i] + ")");
        }
    }
}
