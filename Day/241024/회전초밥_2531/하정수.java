import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int d = sc.nextInt();
		int k = sc.nextInt();
		int c = sc.nextInt();
		int answer = 0;
		List<Integer> sushis = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			sushis.add(sc.nextInt());
		}
		
		for(int i = 0; i < k-1; i++) {
			sushis.add(sushis.get(i));
		}
		
		Map<Integer, Integer> ateables = new HashMap<>();
		for(int i = 1; i <= d; i++) {
			ateables.put(i, 0);
		}
		
		ateables.put(c, ateables.get(c)+1);
		
		for(int i = 0; i < k; i++) {
			int kind = sushis.get(i);
			ateables.put(kind, ateables.get(kind)+1);
		}
		
		for(int i = 1; i <= d; i++)
			if(0 < ateables.get(i)) answer++;
		
		for(int i = 0; i < N-1; i++) {
			int start = sushis.get(i);
			int end = sushis.get(i+k);
			ateables.put(start, ateables.get(start)-1);
			ateables.put(end, ateables.get(end)+1);
			int tmp = 0;
			for(int j = 1; j <= d; j++)
				if(0 < ateables.get(j)) tmp++;
			answer = Math.max(answer, tmp);
        }
		System.out.println(answer);
	}
}
