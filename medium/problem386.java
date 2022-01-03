package medium;

import java.util.ArrayList;
import java.util.List;

public class problem386 {
    public static void main(String[] args) {
        var a = new problem386();
        System.out.println(a.lexicalOrder(101));
    }
    /**
     * {1 [10 (100 101 102 103) 11 12 13 14 15 16 17 18 19] 2 3 4 5 6 7 8 9}
     */
    public List<Integer> lexicalOrder(int n) {
        List<Integer> numbers = new ArrayList<>(n);
        for (int i = 1; i < 10 && i <= n; i++) {
            numbers.add(i);
            insertMultiples(n, numbers, i * 10);
        }
        return numbers;
    }

    private void insertMultiples(int n, List<Integer> numbers, int k) {
        int k1 = k;
        for (int i = 0; i < 10 && k1 <= n; i++) {
            numbers.add(k1++);
            insertMultiples(n, numbers, k++ * 10);
        }
        return;
    }
}
