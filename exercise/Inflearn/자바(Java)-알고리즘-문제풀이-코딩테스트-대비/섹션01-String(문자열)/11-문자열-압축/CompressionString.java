import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public String solution(String str) {
        StringBuilder answer = new StringBuilder();
        char pivotChar = str.charAt(0);
        int idx = 0;
        int size = 0;

        while(true) {
            if(idx > str.length() - 1) {
                if(size == 1) answer.append(pivotChar);
                else answer.append(pivotChar).append(size);

                break;
            }

            if(str.charAt(idx) == pivotChar) {
                idx++;
                size++;
            } else {
                if(size == 1) answer.append(pivotChar);
                else answer.append(pivotChar).append(size);

                str = str.substring(idx);
                pivotChar = str.charAt(0);
                idx = 0;
                size = 0;
            }
        }

        return answer.toString();
    }
    // Time: 114ms, Memory: 26MB

    public String alternativeSolution(String str) {
        String answer = "";
        str += " ";
        int cnt = 1;

        for(int i = 0; i < str.length() - 1; i++) {
            if(str.charAt(i) == str.charAt(i + 1)) cnt++;
            else {
                answer += str.charAt(i);
                if(cnt > 1) answer += String.valueOf(cnt);
                cnt = 1;
            }
        }

        return answer;
    }
    // Time: 119ms, Memory: 26MB

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        System.out.println(T.alternativeSolution(str));
    }
}
