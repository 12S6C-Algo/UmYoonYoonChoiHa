import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class swea1259 {
	static int N;
	static int[] heads;
	static int[] tails;
	static boolean[] isUsed;
	static List<Integer> tmp;
	static List<Integer> answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			heads = new int[N];
			tails = new int[N];
			isUsed = new boolean[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				heads[i] = Integer.parseInt(st.nextToken());
				tails[i] = Integer.parseInt(st.nextToken());
			}
			tmp = new LinkedList<Integer>();
			answer = new LinkedList<Integer>();
			
			perm(0);
			System.out.print("#" + tc);
			for(int i = 0; i < answer.size(); i++) {
				System.out.print(" " + heads[answer.get(i)] + " " + tails[answer.get(i)]);
			}
			System.out.println();
		}
	}
	
	static void perm(int d) {
		if(answer.size() < tmp.size()) {
			answer = new LinkedList<Integer>();
			for(int i = 0; i < d; i++)
				answer.add(tmp.get(i));
		}
		
		if(tmp.size() == 0)
			for(int i = 0; i < N; i++) {
				isUsed[i] = true;
				tmp.add(i);
				perm(d+1);
				isUsed[i] = false;
				tmp.remove(d);
			}
		
		else{ 
			int back = tails[tmp.get(tmp.size()-1)];
			for(int i = 0; i < N; i++) {
				if(isUsed[i]) continue;
				if(heads[i] != back) continue;
				isUsed[i] = true;
				tmp.add(i);
				perm(d+1);
				isUsed[i] = false;
				tmp.remove(d);
			}
		}
	}
}
