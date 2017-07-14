/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getTheCardsReady;

import java.util.ArrayList;

/**
 *
 * @author laptopAdrian
 */
public class GameEngine {

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

    // private static String result_str = "";
    // private static int result_int = 0;
    private final ArrayList<Card> goodCards = new ArrayList<>();

    /**
     * Evaluate the hand.
     *
     * @param hand
     */
    public void evaluatePlayersHand(Hand hand) {

        boolean isFlush = find_Flush(hand);

        boolean isStraight = find_Straight(hand);
        boolean isAcehighStraight = find_AceHighStraight(hand);

        boolean isFourOfAKind = find_FourOfAKind(hand);
        boolean isThreeOfAKind = find_ThreeOfAKind(hand);
        int findTotalPairs = find_Pairs(hand);

        if (isFlush && isAcehighStraight) {
            for (int i = 0; i < hand.getSize(); i++) {
                goodCards.add(hand.getCard(i));
            }
            setRoyalFlush(true);
            hand.setRoyalFlush(true);
            
        } else if (isFlush && isStraight) {
            for (int i = 0; i < hand.getSize(); i++) {
                goodCards.add(hand.getCard(i));
            }
            setStraightFlush(true);
            hand.setStraightFlush(true);
            
        } else if (isFourOfAKind) {
            setFourOfAKind(true);
            hand.setFourOfAKind(true);
            
        } else if (isThreeOfAKind && findTotalPairs == 1) {
            setFullHouse(true);
            hand.setFullHouse(true);
            
        } else if (isFlush) {
            for (int i = 0; i < hand.getSize(); i++) {
                goodCards.add(hand.getCard(i));
            }
            setFlush(true);
            hand.setFlush(true);
            
        } else if (isStraight) {
            for (int i = 0; i < hand.getSize(); i++) {
                goodCards.add(hand.getCard(i));
            }
            setStraight(true);
            hand.setStraight(true);
            
        } else if (isThreeOfAKind) {
            setThreeOfAKind(true);
            hand.setThreeOfAKind(true);
            
        } else if (findTotalPairs == 2) {
            setTwoPair(true);
            hand.setTwoPair(true);
            
        } else if (findTotalPairs == 1) {
            setPair(true);
            hand.setPair(true);
            
        } else {
            Card theHighcard = find_Highcard(hand);
            goodCards.add(theHighcard);
            setHighCard(true);
            hand.setHighCard(true);
        }
        printScore(hand);
    }

    /**
     * 
     * @param player1Hand
     * @param player2Hand 
     */
    public void compairPlayersHands(Hand player1Hand, Hand player2Hand){
        Card player1Card = player1Hand.getCard(0);
        Card player2Card = player2Hand.getCard(0);
        
        //player1Hand.
        
//        if (player1Hand.getCard(0).compareTo(player2Hand.getCard(0)) ){
//                        
//        }
    }
    
    /**
     * Find a Flush. Find that all the (5)suits are the same.
     *
     * @param hand
     * @return boolean
     */
    private boolean find_Flush(Hand hand) {
        return (hand.getCardSuit(0) == hand.getCardSuit(1))
                && (hand.getCardSuit(1) == hand.getCardSuit(2))
                && (hand.getCardSuit(2) == hand.getCardSuit(3))
                && (hand.getCardSuit(3) == hand.getCardSuit(4));
    }

    /**
     * Find a Ace High Straight. i.e. (Ace, 10, Jack, Queen, King)
     *
     * @param hand
     * @return boolean
     */
    private boolean find_AceHighStraight(Hand hand) {
        return ((hand.getCardRank(0) == 1
                && hand.getCardRank(1) == 10
                && hand.getCardRank(2) == 11
                && hand.getCardRank(3) == 12
                && hand.getCardRank(4) == 13));
    }

    /**
     * Find if a Straight.
     *
     * @param hand
     * @return boolean
     */
    private boolean find_Straight(Hand hand) {
        int firstRank = hand.getCardRank(0);
        return ((firstRank + 1 == hand.getCardRank(1))
                && (hand.getCardRank(1) + 1) == hand.getCardRank(2)
                && (hand.getCardRank(2) + 1) == hand.getCardRank(3)
                && (hand.getCardRank(3) + 1) == hand.getCardRank(4));
    }

    /**
     * Find if Four of a kind.
     *
     * @param hand
     * @return boolean
     */
    private boolean find_FourOfAKind(Hand hand) {

        if ((hand.getCardRank(0) == hand.getCardRank(1))
                && (hand.getCardRank(1) == hand.getCardRank(2))
                && (hand.getCardRank(2) == hand.getCardRank(3))) {

            for (int i = 0; i < 4; i++) {
                goodCards.add(hand.getCard(i));
            }
            return true;

        } else if ((hand.getCardRank(1) == hand.getCardRank(2))
                && (hand.getCardRank(2) == hand.getCardRank(3))
                && (hand.getCardRank(3) == hand.getCardRank(4))) {

            for (int i = 1; i < 5; i++) {
                goodCards.add(hand.getCard(i));
            }
            return true;
        }

        return false;
    }

    /**
     * Find if Three of a kind.
     *
     * @param hand
     * @return boolean
     */
    private boolean find_ThreeOfAKind(Hand hand) {

        if ((hand.getCardRank(0) == hand.getCardRank(1))
                && (hand.getCardRank(1) == hand.getCardRank(2))) {
            for (int i = 0; i < 3; i++) {
                goodCards.add(hand.getCard(i));
            }
            return true;
        } else if ((hand.getCardRank(1) == hand.getCardRank(2))
                && (hand.getCardRank(2) == hand.getCardRank(3))) {
            for (int i = 1; i < 4; i++) {
                goodCards.add(hand.getCard(i));
            }
            return true;
        } else if ((hand.getCardRank(2) == hand.getCardRank(3))
                && (hand.getCardRank(3) == hand.getCardRank(4))) {
            for (int i = 2; i < 5; i++) {
                goodCards.add(hand.getCard(i));
            }
            return true;
        }

        return false;
    }

    /**
     * Find Pairs.
     *
     * Will return (0, 1, 2) depending on if there are any pairs.
     *
     * @param hand
     * @return int
     */
    private int find_Pairs(Hand hand) {

        int pairs = 0;
        int index = 0;
        for (int i = 1; i < hand.getSize(); i++) {
            if (hand.getCardRank(index) == hand.getCardRank(i)) {
                ArrayList<Card> al = new ArrayList<>();
                al.add(hand.getCard(index));
                al.add(hand.getCard(i));
                if (!goodCards.containsAll(al)) {
                    goodCards.add(hand.getCard(index));
                    goodCards.add(hand.getCard(i));
                    pairs++;
                }
            }
            index++;
        }
        int totalPairs = evaluatePairs(pairs);
        return totalPairs;
    }

    /**
     * Evaluate how many pairs there are.(if any).
     *
     * @param howManyPairs
     * @return int (0, 1, 2)
     */
    private int evaluatePairs(int howManyPairs) {

        if (howManyPairs == 1) {
            return 1;
        } else if (howManyPairs == 2) {
            return 2;
        }
        return 0;
    }

    /**
     * Find the high Card in the hand.
     *
     * @param hand
     * @return Card (the Highest Card in players hand)
     */
    private Card find_Highcard(Hand hand) {

        Card theHighCard;
        if (hand.getCardRank(0) == 1) {
            theHighCard = hand.getCard(0);
        } else {
            theHighCard = hand.getCard(4);
        }
        return theHighCard;
    }

   

    /**
     * Print the scores.
     *
     * @param hand
     */
    public void printScore(Hand hand) {

        if (isRoyalFlush()) {
            System.out.print("You have a Royal Flush : (");
            printGoodCards();

        } else if (isStraightFlush()) {
            System.out.print("You have a Straight Flush : (");
            printGoodCards();

        } else if (isFourOfAKind()) {
            System.out.print("You have a Quads : (");
            printGoodCards();

        } else if (isFullHouse()) {
            System.out.print("You have a Full House : (");
            printGoodCards();

        } else if (isFlush()) {
            System.out.print("You have a Flush : (");
            printGoodCards();

        } else if (isStraight()) {
            System.out.print("You have a Straight : (");
            printGoodCards();

        } else if (isThreeOfAKind()) {
            System.out.print("You have a Trips : (");
            printGoodCards();

        } else if (isTwoPair()) {
            System.out.print("You have Two Pair : (");
            printGoodCards();

        } else if (isPair()) {
            System.out.print("You have a Pair : (");
            printGoodCards();

        } else if (isHighCard()) {
            System.out.print("You have a High Card : ");
            printGoodCards();
        }
        //resetVariables();
    }

     private void resetVariables() {
        setRoyalFlush(false);
        setStraightFlush(false);
        setFourOfAKind(false);
        setFullHouse(false);
        setFlush(false);
        setStraight(false);
        setThreeOfAKind(false);
        setTwoPair(false);
        setPair(false);
        setHighCard(false);
    }
     
    public void printGoodCards() {

        for (int i = 0; i < goodCards.size(); i++) {
            if (i == 0) {
                System.out.print(goodCards.get(i));
            } else {
                System.out.print(", " + goodCards.get(i));
            }
        }
        if (goodCards.size() > 1) {
            System.out.print(")");
        }
        System.out.println();
    }

    /**
     * A to_String method.
     *
     * To print out the values of all the boolean values for the hand.
     *
     * @return
     */
    @Override
    public String toString() {
        return "GameEngine {"
                + "\n highCard= " + isHighCard()
                + ",\n pair= " + isPair()
                + ",\n twoPair= " + isTwoPair()
                + ",\n threeOfAKind= " + isThreeOfAKind()
                + ",\n straight= " + isStraight()
                + ",\n flush= " + isFlush()
                + ",\n fullHouse= " + isFullHouse()
                + ",\n fourOfAKind= " + isFourOfAKind()
                + ",\n straightFlush= " + isStraightFlush()
                + ",\n royalFlush= " + isRoyalFlush() + "\n}";
    }
    
    /* 
     * Getters and Setters 
     */
    public ArrayList<Card> getGoodCards() {
        return goodCards;
    }

    public void setGoodCards(ArrayList<Card> hand) {
        goodCards.addAll(0, hand);
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

    public void setThreeOfAKind(boolean trips) {
        this.threeOfAKind = trips;
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

    public void setFourOfAKind(boolean quads) {
        this.fourOfAKind = quads;
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

}
