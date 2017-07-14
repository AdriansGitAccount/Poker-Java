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
public class Player {

    private String name;
    private Hand hand;
    
    
    public Player() {
        this.name = "Insert Name Here";
        this.hand = null;
    }

    public Player(String name) {
        this.name = name;
    }

    public Player(String name, Hand hand) {
        this.name = name;
        this.hand = hand;
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
   

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

     @Override
    public String toString() {
        return "Player " + "name=" + name + ", Your Hand=" + hand.toString() ;
    }
    
}
