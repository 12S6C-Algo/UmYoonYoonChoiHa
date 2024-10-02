import java.io.*;

public class 현주가좋아하는제곱근놀이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		
		for (int t = 1; t <= T;t++) {
			long N = Long.parseLong(br.readLine());
			
			int result = 0;
			if (N == 2) {
				System.out.println("#" + t + " " + result);
				continue;
			}
						
			while (N!=2) {
				long ceilN = (long) Math.pow(Math.ceil(Math.sqrt(N)), 2);
				
				long gap = ceilN -N;
				N += gap;
				result += gap;
				
				N = (long) Math.sqrt(N);
				result++;
			}
			
			System.out.println("#" + t + " " + result);
		}
	}
}
