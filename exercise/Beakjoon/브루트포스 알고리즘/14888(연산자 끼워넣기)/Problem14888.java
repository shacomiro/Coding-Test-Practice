import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem14888 {
    public int[] solution(int n, int[] numbers, int[] operators) {
        int[] answer = new int[] {Integer.MIN_VALUE, Integer.MAX_VALUE};
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < operators.length; i++) {
            int cnt = operators[i];
            for(int j = 0; j < cnt; j++) {
                if(i == 0) sb.append("+");
                else if(i == 1) sb.append("-");
                else if(i == 2) sb.append("*");
                else if(i == 3) sb.append("/");
            }
        }
        
        int[] check = new int[sb.length()];
        choiceOperatorAndCalc(1, 0, check, sb, numbers, numbers[0], answer);

        return answer;
    }

    public void choiceOperatorAndCalc(int idx, int s, int[] check, StringBuilder operators, int[] numbers, int result, int[] answer) {
        if(s == operators.length()) {
            answer[0] = Math.max(answer[0], result);
            answer[1] = Math.min(answer[1], result);
        } else {
            for(int i = 0; i < operators.length(); i++) {
                int tmp = result;

                if(check[i] == 0) {
                    char op = operators.charAt(i);
                    check[i] = 1;

                    if(op == '+') tmp += numbers[idx];
                    else if(op == '-') tmp -= numbers[idx];
                    else if(op == '*') tmp *= numbers[idx];
                    else if(op == '/') tmp /= numbers[idx];

                    choiceOperatorAndCalc(idx + 1, s + 1, check, operators, numbers, tmp, answer);
                    check[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Problem14888 main = new Problem14888();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        int[] operators = new int[4];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) numbers[i] = Integer.parseInt(st1.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) operators[i] = Integer.parseInt(st2.nextToken());
        br.close();

        for(int x : main.solution(n, numbers, operators)) System.out.println(x);
    }
}