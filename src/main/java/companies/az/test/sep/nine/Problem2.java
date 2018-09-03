package companies.az.test.sep.nine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem2 {
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    List<List<Integer>> optimalUtilization(
            int deviceCapacity,
            List<List<Integer>> foregroundAppList,
            List<List<Integer>> backgroundAppList) {
        // WRITE YOUR CODE HERE

        Map<Integer, List<List<Integer>>> totalmemory = new HashMap<Integer, List<List<Integer>>>();
        Integer optimalMemory = 0;

        for (int f = 0; f < foregroundAppList.size(); f++) {
            for (int b = 0; b < backgroundAppList.size(); b++) {
                Integer mem = foregroundAppList.get(f).get(1) + backgroundAppList.get(b).get(1);
                if (mem <= deviceCapacity) {
                    if (mem >= optimalMemory) {
                        optimalMemory = mem;
                    }

                    List<List<Integer>> key = new ArrayList<List<Integer>>();
                    // new ArrayList<>();
                    key.add(new ArrayList<Integer>(foregroundAppList.get(f).get(0)));
                    key.add(new ArrayList<Integer>(backgroundAppList.get(b).get(0)));

                    if (totalmemory.containsKey(mem)) {
                        List<List<Integer>> existingValues = totalmemory.get(mem);
                        existingValues.addAll(key);
                        totalmemory.put(mem, existingValues);
                    } else {
                        totalmemory.put(mem, key);
                    }

                }

            }
        }
        if (totalmemory.get(optimalMemory) == null || totalmemory.get(optimalMemory).isEmpty()) {
            return new ArrayList<List<Integer>>();
        }
        return totalmemory.get(optimalMemory);

    }
    // METHOD SIGNATURE ENDS
}
