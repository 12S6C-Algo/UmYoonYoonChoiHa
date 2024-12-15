import java.util.Scanner;

public class bj2467 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Long[] liqs = new Long[N];
		for(int i = 0; i < N; i++) {
			liqs[i] = sc.nextLong();
		}
		Long diff = Long.MAX_VALUE;
		int left = 0;
		int right = N-1;
		Long[] answers = new Long[2];
		while(left < right) {
			Long mixed = liqs[left] + liqs[right];
			if(Math.abs(mixed) < diff) {
				diff = Math.abs(mixed);
				answers[0] = liqs[left];
				answers[1] = liqs[right];
			}
			
			if(0 < mixed)
				right -= 1;
			else
				left += 1;
		}
		
		System.out.println(answers[0] + " " + answers[1]);
	}
}
