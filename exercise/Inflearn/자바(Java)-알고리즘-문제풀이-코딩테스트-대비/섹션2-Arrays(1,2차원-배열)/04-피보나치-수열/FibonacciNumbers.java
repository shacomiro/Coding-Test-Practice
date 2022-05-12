import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public int[] solution(int n) {
        int[] answer = new int[n];

        answer[0] = 1;
        answer[1] = 1;
        getFibonacciNumbers(answer, 2, answer[0], answer[1]);

        return answer;
    }

    public void getFibonacciNumbers(int[] answer, int idx, int a, int b) {
        int nextNum = a + b;

        answer[idx] = nextNum;
        idx++;

        if(answer.length > idx) getFibonacciNumbers(answer, idx, b, nextNum);
    }

    public int[] alternativeSolutionOne(int n) {
        int[] answer = new int[n];

        answer[0] = 1;
        answer[1] = 1;

        for(int i = 2; i < n; i++) {
            answer[i] = answer[i - 2] + answer[i - 1];
        }

        return answer;
    }

    public void alternativeSolutionTwo(int n) {
        int a = 1;
        int b = 1;
        int c;
        
        for(int i = 2; i < n;i++) {
            c = a + b;
            System.out.print(c + " ");

            a = b;
            b = c;
        }

    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int num : T.solution(n)) {
            System.out.print(num + " ");
        }
    }
}
