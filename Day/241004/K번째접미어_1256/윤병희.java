import java.util.*;
import java.io.*;
 
public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T;t++) {
            int k = Integer.parseInt(br.readLine());
            String input = br.readLine();
            String[] arr = new String[input.length()];
             
            for (int i = 0; i < input.length(); i++) {
                arr[i] = input.substring(i);
            }
            Arrays.sort(arr);
             
            System.out.println("#" + t + " " + arr[k-1]);
        }
    }
}
