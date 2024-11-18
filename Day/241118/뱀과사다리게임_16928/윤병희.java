import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 뱀과사다리게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        
        int[] arr = new int[101];
        boolean[] visited = new boolean[101];
        
        for (int i = 1; i <= 100; i++) {
            arr[i] = i;
        }
        
        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            arr[Integer.parseInt(inputs[0])] = Integer.parseInt(inputs[1]);
        }
        
        for (int i = 0; i < M; i++) {
            String[] inputs = br.readLine().split(" ");
            arr[Integer.parseInt(inputs[0])] = Integer.parseInt(inputs[1]);
        }
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {1, 0}); // 현재 위치, 이동 횟수
        visited[1] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int position = current[0];
            int moves = current[1];
            
            if (position == 100) {
                System.out.println(moves);
                return;
            }
            
            for (int i = 1; i <= 6; i++) {
                int next = position + i;
                
                if (next <= 100 && !visited[arr[next]]) {
                    visited[arr[next]] = true;
                    queue.add(new int[] {arr[next], moves + 1});
                }
            }
        }
    }
}
