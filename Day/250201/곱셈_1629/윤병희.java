import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 곱셈_백준_1629 {
	static long A,B,C;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] inputs = br.readLine().split(" ");
		
		A = Long.parseLong(inputs[0]);
		B = Long.parseLong(inputs[1]);
		C = Long.parseLong(inputs[2]);
		
		System.out.println(recursion(B));
	}
	
	static long recursion(long num) {
		if (num == 0) {
			return (long)1;
		}
		
		if (num % 2 == 1) {
			long r = recursion((num-1)/2);
			return r % C * r % C * A % C;
		} else {
			long r = recursion(num/2);
			return r % C * r % C;
		}
	}
}
