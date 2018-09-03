package companies.hackerrank.comparator;

import java.util.Arrays;
import org.testng.annotations.Test;
import companies.hackerrank.comparator.Checker.Player;

public class CheckerComparatorTest {

    @Test
    public void testSortingByChecker() {
        Checker checker = new Checker();

        Player p1 = checker.new Player("amy", 100);
        Player p2 = checker.new Player("david", 100);
        Player p3 = checker.new Player("heraldo", 50);
        Player p4 = checker.new Player("aakansha", 75);
        Player p5 = checker.new Player("aleksa", 150);

        Player[] players = new Player[5];
        players[0] = p1;
        players[1] = p2;
        players[2] = p3;
        players[3] = p4;
        players[4] = p5;

        Arrays.sort(players, checker);

        for (int i = 0; i < players.length; i++) {
            System.out.printf("%s %s\n", players[i].name, players[i].score);
        }

    }
    
    
    
    @Test
    public void testSortingByChecker2() {
        Checker checker = new Checker();

        Player p1 = checker.new Player("zzz", 5);
        Player p2 = checker.new Player("bbb", 5);
        Player p3 = checker.new Player("zza", 5);

        Player[] players = new Player[3];
        players[0] = p1;
        players[1] = p2;
        players[2] = p3;

        Arrays.sort(players, checker);

        for (int i = 0; i < players.length; i++) {
            System.out.printf("%s %s\n", players[i].name, players[i].score);
        }

    }
}
