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
                    if (mem > optimalMemory) {
                        optimalMemory = mem;
                    }
                    List<List<Integer>> value = new ArrayList<List<Integer>>();
                    List<Integer> t1 = new ArrayList<Integer>();
                    t1.add(foregroundAppList.get(f).get(0));
                    t1.add(backgroundAppList.get(b).get(0));
                    value.add(t1);
                    List<List<Integer>> existingValues = totalmemory.get(mem);
                    if (existingValues != null) {
                        existingValues.addAll(value);
                        totalmemory.put(mem, existingValues);
                    } else {
                        totalmemory.put(mem, value);
                    }
                }
            }
        }

        List<List<Integer>> optimalIds = totalmemory.get(optimalMemory);
        return optimalIds != null ? optimalIds : new ArrayList<List<Integer>>();
    }
    // METHOD SIGNATURE ENDS
}
