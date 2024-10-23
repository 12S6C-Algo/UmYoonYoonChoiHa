import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String text = sc.next();
		int N = text.length();
		text += text;
		int acnt = 0;
		for(int i = 0; i < N; i++) {
			if(text.charAt(i) == 'a') acnt++;
		}
		
		int cnt = 0;
		for(int i = 0; i < acnt; i++) {
			if(text.charAt(i) == 'b') cnt++;
		}
		
		int answer = cnt;
		for(int i = 0; i < N; i++) {
			if(text.charAt(i) == 'b') cnt--;
			if(text.charAt(i + acnt) == 'b') cnt++;
			answer = Math.min(answer, cnt);
		}
		System.out.println(answer);
	}
}
