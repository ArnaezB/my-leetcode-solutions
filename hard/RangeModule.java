package hard;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * A Range Module is a module that tracks ranges of numbers. Design a data
 * structure to track the ranges represented as half-open intervals and query
 * about them.
 * 
 * A half-open interval [left, right) denotes all the real numbers x where left
 * <= x < right.
 * 
 * Implement the RangeModule class:
 * 
 * RangeModule() Initializes the object of the data structure.
 * void addRange(int left, int right) Adds the half-open interval [left, right),
 * tracking every real number in that interval. Adding an interval that
 * partially overlaps with currently tracked numbers should add any numbers in
 * the interval [left, right) that are not already tracked.
 * boolean queryRange(int left, int right) Returns true if every real number in
 * the interval [left, right) is currently being tracked, and false otherwise.
 * void removeRange(int left, int right) Stops tracking every real number
 * currently being tracked in the half-open interval [left, right).
 * 
 */
class RangeModule {
    public static void main(String[] args) {
        var a = new RangeModule();
        a.addRange(5,7);
        System.out.println("ALERTA:");
        System.out.println(a.queryRange(2,7));
        System.out.println("ALERTA:");
        a.addRange(6,9);
        System.out.println("ALERTA:");
        System.out.println(a.queryRange(2,9));
        System.out.println("ALERTA:");
        a.addRange(2,7);
        a.removeRange(3,10);
        a.removeRange(1,8);
        a.removeRange(1,10);
        a.addRange(5, 6);
        System.out.println("ALERTA:");
        System.out.println(a.queryRange(4,7));
        System.out.println("ALERTA:");
    }

    private SortedSet<Integer> numbers;

    public RangeModule() {
        numbers = new TreeSet<>();
    }

    public void addRange(int left, int right) {
        for (int i = left; i < right; i++) {
            numbers.add(i);
        }
    }

    public boolean queryRange(int left, int right) {
        for (int i = left; i < right; i++) {
            if (!numbers.contains(i)) {
                return false;
            }
        }
        return true;
    }

    public void removeRange(int left, int right) {
        for (int i= left; i < right; i++) {
            numbers.remove(i);
        }
    }
}