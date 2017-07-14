/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getTheCardsReady;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author laptopAdrian
 */
public class Deck {

    private final ArrayList<Card> deck;
    private ArrayList<Card> disgardedCards;

    public Deck() {
        deck = new ArrayList<>();

        for (int suit = 1; suit <= 4; suit++) {
            for (int rank = 1; rank <= 13; rank++) {

                deck.add(new Card(rank, suit));
            }
        }
    }

    public Card dealCard() {
        disgardedCards = new ArrayList<>();
        Card c = deck.remove(0);
        disgardedCards.add(c);
        return c;
    }

    public void shuffleCardsALot(int times) {
        for (int t = 0; t < times; t++) {
            shuffle();
        }
    }

    /*
     * Bubble sort the cards (with random cards);
     */
    public void shuffle() {
        Random rand = new Random();
        Card temp;

        int index_1, index_2;
        for (int i = 0; i < 199; i++) {

            index_1 = rand.nextInt(deck.size() - 1);
            index_2 = rand.nextInt(deck.size() - 1);
            temp = deck.get(index_2);

            // Complete the swap.
            deck.set(index_2, deck.get(index_1));
            deck.set(index_1, temp);
        }
    }

    /*
     * Getters and Setters
     */
    public int getDeckSize() {
        return deck.size();
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void gettt() {

    }

    public void printDeck() {
         deck.stream().forEach((card) -> {
         System.out.println(card.toString());
         });
        // same as (I think)
//        for (Card card : deck) {
//            System.out.println(card);
//        }
    }

    public ArrayList<Card> getDisgardedCards() {
        return disgardedCards;
    }

    public void setDisgardedCard(Card aDisgardedCard) {
        this.disgardedCards.add(aDisgardedCard);
    }

    @Override
    public String toString() {
        return "Deck{" + "deck=" + deck + '}';
    }

}
