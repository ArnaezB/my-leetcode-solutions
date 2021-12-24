package medium;

public class problem394 {
    public static void main(String[] args) {
        System.out.println(decodeString("100[leetcode]"));
    }

    private static String decodeString(String s) {
        if (s.length() == 0) {
            return s;
        }
        if (Character.isLetter(s.charAt(0))) {
            return new String(s.charAt(0) + decodeString(s.substring(1, s.length())));
        } else {
            int i = 1;
            while (Character.isDigit(s.charAt(i))) {
                i++;
            }
            // repetir la cadena n veces
            // la cadena puede ser una cadena codificada. (recursividad)
            String stringInBrackets = s.substring(i+1, getIndexBracket(s));
            int k = Integer.parseInt(s.substring(0, i));
            String stringAfterBrakets = s.substring(getIndexBracket(s)+1, s.length());
            return decodeString(stringInBrackets).repeat(k) + decodeString(stringAfterBrakets);
        }
    }

    private static int getIndexBracket(String s) {
        int checkNext = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                checkNext++;
            } else if (s.charAt(i) == ']') {
                if (checkNext == 1) return i;
                else checkNext--;
            }
        }
        return -1;
    }
}
