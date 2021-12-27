package easy;

/**
 * The complement of an integer is the integer you get when you flip all the 0's
 * to 1's and all the 1's to 0's in its binary representation.
 * 
 * For example, The integer 5 is "101" in binary and its complement is "010"
 * which is the integer 2.
 * 
 * Given an integer num, return its complement.
 */
public class problem476 {
    public static void main(String[] args) {
        System.out.println(findComplement(5));
    }

    public static int findComplement(int num) {
        String s = Integer.toBinaryString(num);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append((s.charAt(i) == '1')? '0': '1'); 
        }
        return Integer.parseInt(sb.toString(), 2);
    }
}
