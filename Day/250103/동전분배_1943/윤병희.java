import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  
    static class Coin {
        int price, amount;
        public Coin(int price, int amount) {
            this.price = price;
            this.amount = amount;
        }
    }

    static Coin[] coins;
    static boolean[][] DP;
    static final int MAX_PRICE = 100000;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int tc = 0; tc < 3; tc++) {
            N = Integer.parseInt(br.readLine());
            coins = new Coin[N];
            int sum = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int price = Integer.parseInt(st.nextToken());
                int amount = Integer.parseInt(st.nextToken());
                coins[i] = new Coin(price, amount);
                sum += price * amount;
            }

            if (sum % 2 == 1) {
                System.out.println("0");
            } else {
                sum /= 2;
                DP = new boolean[N + 1][sum + 1];
                DP[0][0] = true;

                for (int i = 1; i <= N; i++) {
                    Coin cur = coins[i - 1];
                    for (int j = 0; j <= sum; j++) {
                        if (DP[i - 1][j]) {
                            for (int k = 0; k <= cur.amount; k++) {
                                int tempAmount = j + cur.price * k;
                                if (tempAmount <= sum) {
                                    DP[i][tempAmount] = true;
                                }
                            }
                        }
                    }
                }

                if (DP[N][sum]) {
                    System.out.println("1");
                } else {
                    System.out.println("0");
                }
            }
        }
    }
}
