import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public String solution(String str) {
        String answer = "";
        Stack<Character> stack = new Stack<>();

        for(char c : str.toCharArray()) {
            if(c == '(') stack.push(c);
            else if(c == ')') stack.pop();

            if(stack.isEmpty() && c != ')') answer += c;
        }

        return answer;
    }

    public String alternativeSolution(String str) {
        String answer = "";
        Stack<Character> stack = new Stack<>();

        for(char c : str.toCharArray()) {
            if(c == ')') {
                while(stack.pop() != '(');
            } else stack.push(c);
        }

        for(int i = 0; i < stack.size(); i++) answer += stack.get(i);

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        System.out.println(T.solution(str));
    }
}
