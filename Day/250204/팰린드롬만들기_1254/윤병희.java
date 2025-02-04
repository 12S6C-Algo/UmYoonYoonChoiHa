import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        
        for (int i = 0; i < word.length(); i++) {
            String suffix = word.substring(i);
            String reversedSuffix = new StringBuilder(suffix).reverse().toString();
            
            if (suffix.equals(reversedSuffix)) {
                System.out.println(word.length() + i);
                break;
            }
        }
    }
}
