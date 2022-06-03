import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public int solution(String str) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') stack.push('(');
            else {
                stack.pop();
                if (str.charAt(i - 1) == '(') answer += stack.size();
                else answer++;
            }
        }

        return answer;
    }
    //풀이 실패. 풀이법 확인 후 재풀이. 이전 단어를 조회할 때는 스택이 아닌 기존 str를 이용해야 함.

    public int alternativeSolution(String str) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') stack.push('(');
            else {
                stack.pop();
                if(str.charAt(i - 1) == '(') answer += stack.size();
                else answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str= br.readLine();

        System.out.println(T.solution(str));
    }
}
