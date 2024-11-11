import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        long total = 0;
        int[] cnts = new int[100001]; // 수의 범위가 최대 100,000까지
        
        int left = 0;
        // 슬라이딩 윈도우 방식으로 두 포인터 사용
        for (int right = 0; right < N; right++) {
            cnts[nums[right]]++; // 오른쪽 포인터 위치의 숫자 카운트 증가
            // 숫자 중복이 발생하면 left 포인터를 옮겨서 중복을 제거
            while (cnts[nums[right]] > 1) {
                cnts[nums[left]]--;
                left++;
            }
            // 현재 부분 수열의 개수는 (right - left + 1)만큼 가능
            total += (right - left + 1);
        }
        
        System.out.println(total);
    }
}
