package companies.az;

import java.util.ArrayList;
import java.util.List;

public class CellStateTransition {

    public List<Integer> cellCompete(int[] states, int days) {
        // WRITE YOUR CODE HERE
        int[] stateTransition = parseForStateChange(states);

        int[] temp = transitionToNewState(states, stateTransition);
        List<Integer> newStates = new ArrayList<>();
        for (int i = 0; i < temp.length; i++) {
            newStates.add(temp[i]);
        }

        return newStates;

    }

    private int[] parseForStateChange(int[] arr) {
        int[] flags = new int[arr.length];

        int prev = 0, next = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                prev = 0;
                next = arr[i + 1];
            } else if (i == arr.length - 1) {
                next = 0;
                prev = arr[i - 1];
            } else {
                prev = arr[i - 1];
                next = arr[i + 1];
            }

            flags[i] = findNextState(prev, next);

        }

        return flags;
    }

    private int[] transitionToNewState(int[] arr, int[] flags) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = flags[i];
        }

        return arr;
    }

    private int findNextState(int prev, int next) {
        if (prev == next)
            return 1;

        return 0;
    }
}
