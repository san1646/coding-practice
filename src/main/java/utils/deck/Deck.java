package utils.deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
    List<Card> cards = new ArrayList<>();

    /**
     * Spawn 52 standard cards
     */
    private void init(){
        for (Card.Suite suite: Card.Suite.values()             ) {
            for(Card.Value value: Card.Value.values()){
                cards.add(new Card(suite, value));
            }
        }
    }
    public Deck() {
        init();
        this.cards = cards;
    }

    public void shuffle(){
        //cards.sort(Card::compareTo);
        long seed = System.nanoTime();
        Collections.shuffle(cards, new Random(seed));
    }

    public void print(){

        for (Card card: cards             ) {
            System.out.println(card.toString());
        }
    }

}
