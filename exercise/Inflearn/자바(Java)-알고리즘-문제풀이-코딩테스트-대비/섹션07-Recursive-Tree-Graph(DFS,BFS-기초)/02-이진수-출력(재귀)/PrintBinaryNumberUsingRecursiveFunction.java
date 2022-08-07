import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public void solution(int n) {
        if(n == 0) return;

        solution(n / 2);
        System.out.print(n % 2);
    }

    public void DFS(int n) {
        if(n == 0) return;
        else {
            DFS(n / 2);
            System.out.print(n % 2);
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        T.solution(n);
        System.out.println();
        T.DFS(n);
    }
}
