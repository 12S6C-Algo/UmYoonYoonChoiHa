// 25.02.04 Tue

package problems;

import java.io.*;

public class B_1254 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int len = str.length();
        for (int i = 0; i < len; i++) {
            if (isPalindrome(str.substring(i))) {
                System.out.print(len + i);
                return;
            }
        }

    }

    static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
