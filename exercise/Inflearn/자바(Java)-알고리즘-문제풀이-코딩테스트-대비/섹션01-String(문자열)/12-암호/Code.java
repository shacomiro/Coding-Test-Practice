import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public String solution(int num, String code) {
        StringBuilder answer = new StringBuilder();
        code = code.replaceAll("[#]", "1").replaceAll("[*]", "0");

        for(int i = 0; i < num; i++)
            answer.append((char) Integer.parseInt(code.substring(i * 7, (i + 1) * 7), 2));

        return answer.toString();
    }
    // Time: 132ms, Memory: 26MB

    public String alternativeSolution(int num, String code) {
        String answer = "";

        for(int i = 0; i < num; i++) {
            String tmp = code.substring(0, 7).replace('#', '1').replace('*', '0');
            int number = Integer.parseInt(tmp, 2);
            answer += (char) number;

            code = code.substring(7);
        }

        return answer;
    }
    // Time: 120ms, Memory: 26MB

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String code = br.readLine();

        System.out.println(T.solution(num, code));
    }
}
