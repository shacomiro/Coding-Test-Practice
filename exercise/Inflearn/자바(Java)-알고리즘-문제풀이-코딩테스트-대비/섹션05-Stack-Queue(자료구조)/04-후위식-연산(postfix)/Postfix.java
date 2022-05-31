import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public int solution(String str) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for(char c : str.toCharArray()) {
            if(Character.isDigit(c)) stack.push(Character.getNumericValue(c));
            else {
                int b = stack.pop();
                int a = stack.pop();

                if(c == '+') stack.push(a + b);
                if(c == '-') stack.push(a - b);
                if(c == '*') stack.push(a * b);
                if(c == '/') stack.push(a / b);
            }
        }

        answer = stack.pop();

        return answer;
    }

    public int alternativeSolution(String str) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for(char x : str.toCharArray()) {
            if(Character.isDigit(x)) stack.push(x - 48);
            else {
                int rt = stack.pop();
                int lt = stack.pop();

                if(x == '+') stack.push(lt + rt);
                else if(x == '-') stack.push(lt - rt);
                else if(x == '*') stack.push(lt * rt);
                else if(x == '/') stack.push(lt / rt);
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        System.out.println(T.solution(str));
    }
}
