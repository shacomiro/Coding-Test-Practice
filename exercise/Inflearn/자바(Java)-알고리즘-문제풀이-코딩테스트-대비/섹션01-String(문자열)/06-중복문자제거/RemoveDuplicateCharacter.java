import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public String solution(String str) {
        String answer;
        StringBuilder sb = new StringBuilder();

        for(char c : str.toCharArray()) {
            if(sb.indexOf(String.valueOf(c)) == -1)
                sb.append(c);
        }
        answer = String.valueOf(sb);

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        System.out.println(T.solution(str));
    }
}