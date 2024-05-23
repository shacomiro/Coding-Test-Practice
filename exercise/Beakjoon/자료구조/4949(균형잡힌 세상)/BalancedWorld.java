import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class BalancedWorld {
    private static Deque<Character> stack = new ArrayDeque<>();

    public static String solution(String str) {
        stack.clear();
        char[] charArr = str.toCharArray();

        for(char c : charArr) {
            if(c == '(' || c == '[') {
                stack.push(c);
            }

            if(c == ')') {
                if(!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    return "no";
                }
            }

            if(c == ']') {
                if(!stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                } else {
                    return "no";
                }
            }
        }

        return stack.isEmpty() ? "yes" : "no";
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input;
        while(!(input = br.readLine()).equals(".")) {
            bw.write(solution(input));
            bw.newLine();
        }
        bw.flush();
        bw.close();        
    }
}