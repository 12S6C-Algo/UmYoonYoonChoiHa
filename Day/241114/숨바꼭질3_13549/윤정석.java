// 24.11.11 Fri

/*
 * 가중치의 값이 일정하다면 BFS을 사용하는 것이 맞지만
 * 그렇지 않다면 다익스트라를 사용해야된다.
 * 
 * 숨바꼭질2 문제의 경우, 앞, 뒤, 순간 이동 시 1초를 동일하게 사용하기 때문에
 * 시간에 대한 가중치가 동일한 상황이었고, 따라서 가장 먼저 도착하는 값이 정답이 되는 전형적이 BFS 문제였다.
 * 
 * 하지만 이번 문제의 경우, 앞, 뒤는 1초를 사용하지만 순간 이동은 0초를 사용한다.
 * 시간 가중치가 다른 상황에서, 가장 먼저 도착하는 값이 정답이라는 보장이 없다.
 * 가장 먼저 도착하는 값을 정답으로 보장하기 위해 우선순위큐를 사용하게 되면 시간 초과가 나온다.
 * 이를 해결하기 위해 방문 처리르 도입하여 이미 방문한 노드의 재방문을 막아 시간 초과를 해결할 수 있다.
 * 여기서 문제는 방문처리를 어디서 할것이냐이다.
 * 숨바꼭질2 문제의 경우, 큐에 넣자마자 방문처리를 한다.
 * 이는 3가지 조건의 depth가 같기 때문에 가능한 일이다.
 * 하지만 이 문제의 경우, 우선순위큐에 넣자마자 방문처리를 하면 안된다.
 * 이럴 경우, 우선적으로 우선순위큐에서 꺼내는 친구가 가는 경로에 차선 방문이 들어가
 * 최선의 경로를 찾을 수 없게 된다.
 * 따라서 우선순위큐에서 꺼낼 때 방문처리해주는 방식을 채택해야한다.
 * 
 * 우선순위큐 : 정답은 나오나 시간초과 
 * 우선순위큐 + 방문처리
 * 
 * ※ 번외
 * 우선순위큐 + 방문처리 + 갱신 -> 다익스트라 : 정답 -> 하지만 굳이 갱신할 필요는 없음
 * 큐 + 갱신 : 오답, 첫번째 도달한 값이 정답이라는 보장이 없음
 */

package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_13549 {
	
	static class Node implements Comparable<Node> {
		int loc, time;
		
		public Node(int loc, int time) {
			this.loc = loc;
			this.time = time;
		}

		@Override
		public int compareTo(Node n) {
			return Integer.compare(time, n.time);
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		boolean[] visit = new boolean[100_001];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(N, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			visit[cur.loc] = true;
			
			if(cur.loc == K) {
				System.out.println(cur.time);
				return;
			}
			
			int plus = cur.loc + 1;
			int minus = cur.loc - 1;
			int mul = 2*cur.loc;
			
			if(plus <= 100_000 && !visit[plus]) {
				pq.offer(new Node(plus, cur.time + 1));
			}
			if(minus >= 0 && !visit[minus]) {
				pq.offer(new Node(minus, cur.time + 1));
			}
			if(mul <= 100_000 && !visit[mul]) {
				pq.offer(new Node(mul, cur.time));
			}
		}
	}

}
