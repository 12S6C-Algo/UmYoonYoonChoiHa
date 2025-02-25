package me.dylan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][5];

        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            String[] num = inputs[0].split("");
            arr[i][0] = Integer.parseInt(num[0]);
            arr[i][1] = Integer.parseInt(num[1]);
            arr[i][2] = Integer.parseInt(num[2]);

            arr[i][3] = Integer.parseInt(inputs[1]);
            arr[i][4] = Integer.parseInt(inputs[2]);
        }

        int result = 0;

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                here :for (int k = 1; k <= 9; k++) {
                    if (i == j || i == k || j == k) {
                        continue;
                    }
                    int s = 0;
                    int b = 0;

                    for (int[] ints : arr) {
                        // 검증,
                        s = 0;
                        b = 0;
                        if (i == ints[0]) {
                            s++;
                        } else if (j == ints[0]) {
                            b++;
                        } else if (k == ints[0]) {
                            b++;
                        }

                        if (i == ints[1]) {
                            b++;
                        } else if (j == ints[1]) {
                            s++;
                        } else if (k == ints[1]) {
                            b++;
                        }

                        if (i == ints[2]) {
                            b++;
                        } else if (j == ints[2]) {
                            b++;
                        } else if (k == ints[2]) {
                            s++;
                        }

                        if (ints[3] != s || ints[4] != b) {
                            continue here;
                        }
                    }
                    result ++;
                }

            }
        }
        System.out.println(result);
    }
}

/*
123 ~ 987 까지 완전 탐색으로 되는것들을 확인
9*8*7 번돌아감


 */
