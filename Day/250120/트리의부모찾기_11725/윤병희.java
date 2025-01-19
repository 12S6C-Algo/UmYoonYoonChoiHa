import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 트리의부모찾기_11725 {
    static int N;
    static List<List<Integer>> adjList;
    static int[] result;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        adjList = new ArrayList<>();
        result = new int[N + 1];
        
        // 인접 리스트 초기화
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }
        
        // 간선 정보 입력
        for (int i = 0; i < N - 1; i++) {
            String[] inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);
            
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }
        
        // BFS를 사용해 부모 노드 찾기
        Queue<Integer> q = new LinkedList<>();
        q.add(1); // 루트 노드
        result[1] = 1; // 루트 노드는 자기 자신이 부모
        
        while (!q.isEmpty()) {
            int now = q.poll();
            
            for (int next : adjList.get(now)) {
                if (result[next] == 0) { // 아직 방문하지 않은 노드라면
                    result[next] = now; // 부모 설정
                    q.add(next);
                }
            }
        }
        
        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(result[i]).append("\n");
        }
        System.out.println(sb);
    }
}
