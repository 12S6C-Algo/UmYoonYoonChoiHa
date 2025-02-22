package uyyh_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class 인사성밝은곰곰이_25192 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Set<String> set = new HashSet<String>();
		int ans = 0;
		for (int i = 0; i < N; i++) {
			String chat = br.readLine();
			if (chat.equals("ENTER")) {
				set.clear();
			} else if (!set.contains(chat)) {
				set.add(chat);
				ans++;
			}
		}
		
		System.out.println(ans);
		
	}

}
