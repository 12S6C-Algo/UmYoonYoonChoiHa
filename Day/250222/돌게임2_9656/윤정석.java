// 25.02.15 Sun

package problems;

import java.io.*;

public class B_9656 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String answer = "SK";
        if (N % 2 == 1) answer = "CY";

        System.out.println(answer);
    }
}
