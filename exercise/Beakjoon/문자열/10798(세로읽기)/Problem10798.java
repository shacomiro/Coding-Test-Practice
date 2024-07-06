import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem10798 {
	public static void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = new String[5];
		String answer = "";
		int maxLength = 0;
		
		for(int i = 0; i < 5; i++) {
			str[i] = br.readLine();
			maxLength = Math.max(maxLength, str[i].length());
		}
		
		for(int i = 0; i < maxLength; i++) {
			for(int j = 0; j < 5; j++) {
				if(str[j].length() <= i) continue;
				answer += str[j].charAt(i);
			}
		}
		
		System.out.println(answer);
		br.close();
	}
	
	public static void main(String[] args) throws IOException {
		Problem10798.solution();
	}
}
