/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getTheCardsReady;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author laptopAdrian
 */
public class The_Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            Deck deck = new Deck();
            deck.shuffle();
            //deck.shuffleCardsALot(3);

            Hand bobsHand = new Hand(5, deck);
            Hand samsHand = new Hand(5, deck);

            GameEngine bobsGameEngine = new GameEngine();
            GameEngine samsGameEngine = new GameEngine();

            
            System.out.println("------- Bob' Cards ---------");
            Player bob = new Player("BoB");
            bob.setHand(bobsHand);
            bob.getHand().displayHand();
            //bob.getHand().printValueArray();
            //bob.getHand().valueArr();
            
            System.out.println("\n-------- Sam's Cards ---------");
            Player sam = new Player("Sam");
            sam.setHand(samsHand);
            sam.getHand().displayHand();
            //sam.getHand().printValueArray();

            
            System.out.println("\n----------- Print Scores --------------\n");
            System.out.print("Bob ");
            bobsGameEngine.evaluatePlayersHand(bobsHand);
            System.out.print("Sam ");
            samsGameEngine.evaluatePlayersHand(samsHand);

            
////////////////////////////////////////////////////////////////////////////////
//            Card one = new Card(1, 1);
//            Card two = new Card(2, 2);
//            Card three = new Card(1, 4);
//            Card four = new Card(5, 3);
//            Card five = new Card(1, 4);
//
//            ArrayList<Card> goodList = new ArrayList<>();
//            goodList.add(one);
//            goodList.add(two);
//            goodList.add(three);
//            goodList.add(four);
//            goodList.add(five);
//
//            Hand goodHand = new Hand(goodList);
//            goodHand.displayHand();
//
//            GameEngine1.evaluatePlayersHand(goodHand);
//            goodHand.printValueArray();
////////////////////////////////////////////////////////////////////////////////
        } catch (Exception ex) {
            Logger.getLogger(The_Tester.class.getName())
                    .log(Level.SEVERE, null, ex);
        }

    }

}
