import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Queue<int[]> q = new LinkedList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		boolean[] visited = new boolean[100_001];
		q.add(new int[] {n,0});
		visited[n] = true; // 자기자리 방문 처리
		while(!q.isEmpty()) {
			int[] k = q.poll();
			if(k[0]==x)	{
				System.out.println(k[1]);
				return;// 찾은 경우
			}
			if(k[0]-1 >=0 && !visited[k[0]-1]) {
				visited[k[0]-1] = true;
				q.add(new int[] {k[0]-1,k[1]+1});
			}
			if(k[0]+1 <=100_000 && !visited[k[0]+1]) {
				visited[k[0]+1] = true;
				q.add(new int[] {k[0]+1,k[1]+1});
			}
			if(k[0]*2 <=100_000 && !visited[k[0]*2]) {
				visited[k[0]*2] = true;
				q.add(new int[] {2*k[0],k[1]+1});
			}
		}
	}
}
