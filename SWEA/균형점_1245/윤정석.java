// 24.09.16.Mon

package d5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D5_1245 {
	
	static int N;
	static double[] X, M;
	static double sumL, sumR;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			X = new double[N];
			M = new double[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) X[i] = Integer.parseInt(st.nextToken());
			for (int i = 0; i < N; i++) M[i] = Integer.parseInt(st.nextToken());
			
			StringBuilder result = new StringBuilder();
			for (int i = 0; i < N - 1; i++) {
				String answer = String.format("%.10f", binary(X[i], X[i + 1]));
				result.append(answer).append(" ");
			}
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
	
	static double binary(double left, double right) {
		if(left > right) return left;
		
		double mid = (left + right) / 2;
		equilibrium(mid);
		if(sumL == sumR) return mid;
		else if(sumL < sumR) return binary(left, mid - Math.pow(10, -12));
		else return binary(mid + Math.pow(10, -12), right);
	}
	
	static void equilibrium(double mid) {
		sumL = 0.;
		sumR = 0.;
		for (int i = 0; i < N; i++) {
			if(X[i] < mid) sumL += force(M[i], X[i] - mid);
			else sumR += force(M[i], X[i] - mid);
		}
	}
	
	static double force(double m, double d) {
		return m / (d*d);
	}
	
}
