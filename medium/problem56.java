package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 * Given an array of intervals where intervals[i] = [starti, endi], 
 * merge all overlapping intervals, and return an array of the non-overlapping 
 * intervals that cover all the intervals in the input.
 */
public class problem56 {
    public static void main(String[] args) {
        merge(new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } });
    }

    public static int[][] merge(int[][] intervals) {
        ArrayList<ArrayList<Integer>> merge = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]); // Sort input

        for (int i: intervals[0]){ // Consider first element merged
            list.add(i);
        }
        merge.add(list);

        for (int[] i: intervals) {
            if (i[0] < merge.get(merge.size()-1).get(1)) { 
                // The next interval can be merged if its start is before or at the end of the previous
                merge.get(merge.size()-1).set(0, Integer.min(merge.get(merge.size()-1).get(0), i[0]));
                merge.get(merge.size()-1).set(1, Integer.max(merge.get(merge.size()-1).get(1), i[1]));
            } else { // Cannot be merged
                list = new ArrayList<>();
                for (int ii: i){
                    list.add(ii);
                }
                merge.add(list);
            }
        }
        // Transform 2d-ArrayList to 2d-array
        int[][] solution = new int[merge.size()][2];
        int x = 0;
        int y = 0;
        for (ArrayList<Integer> l: merge) {
            for (Integer i: l) {
                solution[x][y++] = (int) i;
            }
            y=0;
            x++;
        }
        return solution;
    }
}
