package medium;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * You are given an array of non-overlapping intervals intervals where
 * intervals[i] = [starti, endi] represent the start and the end of the ith
 * interval and intervals is sorted in ascending order by starti. You are also
 * given an interval newInterval = [start, end] that represents the start and
 * end of another interval.
 * 
 * Insert newInterval into intervals such that intervals is still sorted in
 * ascending order by starti and intervals still does not have any overlapping
 * intervals (merge overlapping intervals if necessary).
 * 
 * Return intervals after the insertion.
 */
public class problem57 {
    public static void main(String[] args) {
        insert(new int[][] { { 1, 3 }, { 6, 9 } }, new int[] { 2, 5 });
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] newIntervals = Arrays.copyOf(intervals, intervals.length+1);
        newIntervals[newIntervals.length-1] = newInterval;

        return problem56.merge(newIntervals);
    }
}
