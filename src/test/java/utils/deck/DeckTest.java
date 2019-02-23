package utils.deck;

import org.junit.Before;
import org.testng.annotations.Test;

public class DeckTest {
    Deck deck;

    @Before
    public void init() {
        deck = new Deck();
    }

    @Test
    public void testDeck() {
        deck = new Deck();
        deck.print();
    }

    @Test
    public void testDeck2() {
        deck = new Deck();
        deck.print();
        deck.shuffle();
        System.out.println("after shuffling-------------------------");
        deck.print();
    }

}
