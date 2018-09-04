package companies.az.test.sep.nine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Problem1 {
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    List<List<Integer>> ClosestXdestinations(int numDestinations,
            List<List<Integer>> allLocations,
            int numDeliveries) {
        // WRITE YOUR CODE HERE
        Map<Long, List<Integer>> distances = locationsByDistance(allLocations);
        List<List<Integer>> deliveries = sortLocationsByDistance(distances, numDeliveries);

        return deliveries;

    }
    // METHOD SIGNATURE ENDS

    private Map<Long, List<Integer>> locationsByDistance(List<List<Integer>> locations) {
        Map<Long, List<Integer>> distances = new TreeMap<Long, List<Integer>>();
        for (List<Integer> location : locations) {
            Integer x = location.get(0);
            Integer y = location.get(1);
            List<Integer> value = new ArrayList<>();
            value.add(x);
            value.add(y);
            distances.put((long) (x * x + y * y), value);
        }

        return (distances);
    }

    private List<List<Integer>> sortLocationsByDistance(Map<Long, List<Integer>> distances, int numDeliveries) {
        Set<Long> keys = distances.keySet(); // new TreeSet<Long>(distances.keySet());

        List<List<Integer>> sortedDisances = new ArrayList<>();

        for (Long val : keys) {
            if (sortedDisances.size() < numDeliveries) {
                sortedDisances.add(distances.get(val));
            } else {
                return sortedDisances;
            }

        }

        return sortedDisances;

    }
}
