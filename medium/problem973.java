package medium;

import java.util.Comparator;
import java.util.TreeSet;
import java.util.AbstractMap.SimpleEntry;

public class problem973 implements Comparator<SimpleEntry<Integer,Integer>> {

    public static void main(String[] args) {
        problem973 p = new problem973();
        System.out.println(p.kClosest(new int[][]{new int[]{0,1}, new int[]{1,0}}, 2));
    }

    public int[][] kClosest(int[][] points, int k) {
        TreeSet<SimpleEntry<Integer, Integer>> tree = new TreeSet<>((a,b) -> compare(a,b));
        int i = 0;
        for (int[] p: points) {
            tree.add(new SimpleEntry<>(p[0]*p[0] + p[1]*p[1], i++));
        }
        int[][] result = new int[k][];
        for (int j = 0; j < k; j++) {
            result[j] = points[tree.pollFirst().getValue()];
        }
        return result;
    }

    @Override
    public int compare(SimpleEntry<Integer, Integer> o1, SimpleEntry<Integer, Integer> o2) {
        int t = o1.getKey()-o2.getKey();
        return (t != 0) ? t : o1.getValue() - o2.getValue();
    }
}
