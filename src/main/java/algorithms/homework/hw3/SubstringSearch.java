package algorithms.homework.hw3;

public class SubstringSearch {
    public static void main(String[] args) {
        String s1 = "Happy happy joy joy"; // happy -> index: 6
        String key1 = "happy";

        String s2 = "Where is the dog?";   // cat -> index: -1
        String key2 = "cat";

        String s3 = "fun fun fun";         // fun -> index 0
        String key3 = "fun";

        String s4 = "I love coding!";      // Me too! -> index -1
        String key4 = "Me too!";


        System.out.println(findSubstring(s1, key1));
        System.out.println(findSubstring(s2, key2));
        System.out.println(findSubstring(s3, key3));
        System.out.println(findSubstring(s4, key4));
    }

    public static int findSubstring(String s, String k) {
        int searchLength = s.length();
        int keyLength = k.length();

        for (int i = 0; i <= searchLength - keyLength; i++) {
            int j;
            for (j = 0; j < keyLength; j++) {
                if (s.charAt(i + j) != k.charAt(j)) {
                    break;
                }
            }
            if (j == keyLength) {
                return i;
            }
        }
        return -1; // pattern not found
    }
}
