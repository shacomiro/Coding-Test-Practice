import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;

public class Parenthesis {
    public static String[] solution(int n, String[] psArr) {
        String[] answer = new String[n];
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        for(int i = 0; i < n; i++) {
            boolean isNonComplete = false;

            for(char c : psArr[i].toCharArray()) {
                if(c == '(') {
                    stack.push(c);
                }

                if(c == ')') {
                    if(stack.isEmpty()) {
                        isNonComplete = true;
                        break;
                    }

                    if(stack.peek() == '(') {
                        stack.pop();
                    }
                }
            }

            if(isNonComplete) {
                answer[i] = "NO";
            } else {
                if(stack.isEmpty()) {
                    answer[i] = "YES";
                } else {
                    answer[i] = "NO";
                }
            }

            stack.clear();
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] psArr = new String[n];
        for(int i = 0; i < n; i++) {
            psArr[i] = br.readLine();
        }

        for(String a : solution(n, psArr)) {
            bw.write(a);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
