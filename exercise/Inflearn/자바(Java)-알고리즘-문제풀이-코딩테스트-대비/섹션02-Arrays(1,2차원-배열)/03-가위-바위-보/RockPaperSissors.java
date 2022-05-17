import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public String[] solution(int n, int[] a, int[] b) {
        String[] answer = new String[n];

        for(int i = 0; i < n; i++) {
            int currA = a[i];
            int currB = b[i];

            if(currA == 1) {
                if(currB == 1) answer[i] = "D";
                else if(currB == 2) answer[i] = "B";
                else if(currB == 3) answer[i] = "A";
            } else if(currA == 2) {
                if(currB == 1) answer[i] = "A";
                else if(currB == 2) answer[i] = "D";
                else if(currB == 3) answer[i] = "B";
            } else if(currA == 3) {
                if(currB == 1) answer[i] = "B";
                else if(currB == 2) answer[i] = "A";
                else if(currB == 3) answer[i] = "D";
            }
        }

        return answer;
    }

    public String[] alternativeSolution(int n, int[] a, int[] b) {
        String[] answer = new String[n];

        for(int i = 0; i < n; i++) {
            if(a[i] == b[i]) answer[i] = "D";
            else if(a[i] == 1 && b[i] == 2) answer[i] = "B";
            else if(a[i] == 1 && b[i] == 3) answer[i] = "A";
            else if(a[i] == 2 && b[i] == 1) answer[i] = "A";
            else if(a[i] == 2 && b[i] == 3) answer[i] = "B";
            else if(a[i] == 3 && b[i] == 1) answer[i] = "B";
            else if(a[i] == 3 && b[i] == 2) answer[i] = "A";
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] b = new int[n];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st1.nextToken());
            b[i] = Integer.parseInt(st2.nextToken());
        }

        for(String s : T.solution(n, a, b)) {
            System.out.println(s);
        }
    }
}
