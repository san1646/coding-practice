package companies.hackerrank.comparator;

import java.util.Comparator;
import companies.hackerrank.comparator.Checker.Player;

/**
 * https://www.hackerrank.com/challenges/ctci-comparator-sorting/problem
 * 
 * Check out the resources on the page's right side to learn more about sorting. The video tutorial is by Gayle Laakmann
 * McDowell, author of the best-selling interview book Cracking the Coding Interview.
 * 
 * Comparators are used to compare two objects. In this challenge, you'll create a comparator and use it to sort an
 * array. The Player class is provided in the editor below. It has two fields:
 * 
 * : a string.
 * : an integer.
 * Given an array of Player objects, write a comparator that sorts them in order of decreasing score. If or more players
 * have the same score, sort those players alphabetically ascending by name. To do this, you must create a Checker class
 * that implements the Comparator interface, then write an int compare(Player a, Player b) method implementing the
 * Comparator.compare(T o1, T o2) method. In short, when sorting in ascending order, a comparator function returns if ,
 * if , and if .
 * 
 * For example, given Player objects with values of , we want to sort the list as .
 * 
 * Function Description
 * 
 * Declare a Checker class that implements the comparator method as described. It should sort first descending by score,
 * then ascending by name. The code stub reads the input, creates a list of Player objects, uses your method to sort the
 * data, and prints it out properly.
 * 
 * Input Format
 * 
 * Locked stub code in the Solution class handles the following input from stdin:
 * 
 * The first line contains an integer, , the number of players.
 * Each of the next lines contains a player's respective and , a string and an integer.
 * 
 * Constraints
 * 
 * Two or more players can have the same name.
 * Player names consist of lowercase English alphabetic letters.
 * Output Format
 * 
 * You are not responsible for printing any output to stdout. Locked stub code in Solution will create a Checker object,
 * use it to sort the Player array, and print each sorted element.
 * 
 * Sample Input
 * 
 * 5
 * amy 100
 * david 100
 * heraldo 50
 * aakansha 75
 * aleksa 150
 * Sample Output
 * 
 * aleksa 150
 * amy 100
 * david 100
 * aakansha 75
 * heraldo 50
 * Explanation
 * 
 * As you can see, the players are first sorted by decreasing score and then sorted alphabetically by name.
 * 
 * @author H203961
 *
 */
public class Checker implements Comparator<Player> {
    
    public class Player {
        String name;
        int score;

        Player(String name, int score) {
            this.name = name;
            this.score = score;
        }
        
        @Override
        public String toString() {
            return "["+this.name+", "+this.score+"]";
        }
    }

    @Override
    public int compare(Player p1, Player p2) {
        if(p1==null || p2==null) return -1;
        if (p1.score > p2.score)
            return 1;
        else if (p1.score < p2.score)
            return -1;
        int t = (p1.name.compareTo(p2.name));
        if(t<0) return -1;
        if(t>0) return 1;
        return 0;
    }
}
