// 24.12.24 Tue
package problems;

import java.io.*;
import java.util.*;

public class B_7490 {

    static StringBuilder answer;
    static String[] symbols;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        answer = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            N = Integer.parseInt(br.readLine());
            symbols = new String[N - 1];
            dfs(0);
            answer.append("\n");
        }

        System.out.println(answer);
    }

    // dfs로 공백, +, - 선택 -> symbols 배열에 담기
    static void dfs(int depth) {
        if (depth == N - 1) {
            List<Integer> nums = new ArrayList<>(); // 숫자들
            List<String> ops = new ArrayList<>(); // 연산자들
            StringBuilder eq = new StringBuilder(); // 방정식
            int mergedNum = 0; // 병합 숫자

            for (int i = 0; i < N; i++) {
                int curNum = i + 1;
                eq.append(curNum);

                if (i < N - 1 && symbols[i].equals(" ")) { // 공백일 때
                    mergedNum = mergedNum * 10 + curNum;
                    eq.append(" ");
                } else { // 연산자일 때
                    if (mergedNum == 0) { // 병합 숫자가 없으면 -> 현재 숫자
                        nums.add(curNum);
                    } else { // 병합 숫자가 있으면 -> 병합 숫자 + 현재 숫자
                        mergedNum = mergedNum * 10 + curNum;
                        nums.add(mergedNum);
                        mergedNum = 0;
                    }

                    // 연산자 및 방정식 처리
                    if (i < N - 1) {
                        if (symbols[i].equals("+")) {
                            eq.append("+");
                            ops.add("+");
                        } else {
                            eq.append("-");
                            ops.add("-");
                        }
                    }
                }
            }

            // 방정식 계산
            int sum = nums.get(0);
            int numIdx = 1;
            while (numIdx < nums.size()) {
                if (ops.get(numIdx - 1).equals("+")) {
                    sum += nums.get(numIdx++);
                } else {
                    sum -= nums.get(numIdx++);
                }
            }

            if (sum == 0) {
                answer.append(eq).append("\n");
            }
            return;
        }

        symbols[depth] = " ";
        dfs(depth + 1);
        symbols[depth] = "+";
        dfs(depth + 1);
        symbols[depth] = "-";
        dfs(depth + 1);
    }
}
