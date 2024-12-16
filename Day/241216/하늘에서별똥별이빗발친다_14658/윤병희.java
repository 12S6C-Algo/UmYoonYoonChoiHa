import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        int L = Integer.parseInt(firstLine[0]);
        int N = Integer.parseInt(firstLine[1]);
        int T = Integer.parseInt(firstLine[2]);
        int M = Integer.parseInt(firstLine[3]);

        int[][] meteors = new int[M][2];
        for (int i = 0; i < M; i++) {
            String[] inputs = br.readLine().split(" ");
            meteors[i][0] = Integer.parseInt(inputs[0]);
            meteors[i][1] = Integer.parseInt(inputs[1]);
        }

        int maxStars = 0; 

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                int x1 = meteors[i][0]; 
                int y1 = meteors[j][1]; 

                int count = 0;
                for (int[] meteor : meteors) {
                    int x = meteor[0];
                    int y = meteor[1];
                    if (x1 <= x && x <= x1 + T && y1 <= y && y <= y1 + T) {
                        count++;
                    }
                }

                // 최대값 갱신
                maxStars = Math.max(maxStars, count);
            }
        }

        System.out.println(M - maxStars);
    }
}
