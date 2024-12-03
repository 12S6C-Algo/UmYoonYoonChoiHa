// 24.11.20

package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B_2179 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<String>[] str = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            str[i] = new ArrayList<>();
        }

        boolean[] visit = new boolean[26];
        List<Integer> idxList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            int num = line.charAt(0) - 'a';
            if(!visit[num]){
                visit[num] = true;
                idxList.add(num);
            }
            str[num].add(line);
        }

        int result = 0;
        String res1 = "", res2 = "";

        for(int i : idxList){
            if(str[i].size() < 2) continue;

            int n = str[i].size();
            for (int j = 0; j < n - 1; j++) {
                String com1 = str[i].get(j);
                for (int k = j + 1; k < n; k++) {
                    String com2 = str[i].get(k);

                    int cnt = 0;
                    int len = Math.min(com1.length(), com2.length());
                    for (int l = 0; l < len; l++) {
                        if(com1.charAt(l) == com2.charAt(l)) cnt++;
                        else break;
                    }

                    if(result < cnt){
                        result = cnt;
                        res1 = com1;
                        res2 = com2;
                    }
                }
            }
        }

        System.out.println(res1);
        System.out.println(res2);
    }
}
