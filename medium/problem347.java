package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given an integer array nums and an integer k, return the k most frequent
 * elements. You may return the answer in any order.
 */
public class problem347 {
    public static void main(String[] args) {

    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> elements = new HashMap<>();

        for (int n : nums) {
            elements.put(n, elements.getOrDefault(n, 0)+1);
        }

        Queue<Integer> sort = new PriorityQueue<>((a, b) -> elements.get(a) - elements.get(b)); 
        for (Integer i: elements.keySet()) {
            sort.add(i);
            if (sort.size() > k) {
                sort.poll();
            }
        }
        int[] top = new int[sort.size()];
        for (int j = sort.size()-1; j >= 0; j--) {
            top[j] = sort.poll();
        }
        return top;
    }
}