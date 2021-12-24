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
        ArrayList<int[]> merge = new ArrayList<>();
        
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]); // Sort input

        merge.add(intervals[0]);

        for (int[] i: intervals) {
            if (i[0] <= merge.get(merge.size()-1)[1]) { 
                // The next interval can be merged if its start is before or at the end of the previous
                merge.get(merge.size()-1)[0] = Integer.min(merge.get(merge.size()-1)[0], i[0]);
                merge.get(merge.size()-1)[1] = Integer.max(merge.get(merge.size()-1)[1], i[1]);
            } else { // Cannot be merged
                merge.add(i);
            }
        }
        // Transform 2d-ArrayList to 2d-array
        return merge.toArray(new int[merge.size()][]);
    }
}
