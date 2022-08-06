import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public int[] solution(int n) {
        int[] answer = new int[n];
        int i = 0;

        recursive(i, n, answer);

        return answer;
    }

    public void recursive(int i, int n, int[] arr) {
        if(i < n) {
            arr[i++] = i;
            recursive(i, n, arr);
        }
    }

    // 재귀함수는 일종의 반복문 형태.
    // 재귀함수는 스택 프레임을 사용하기 때문에 아래의 함수 구성이면,
    /**
     * Syso(1);
     * Syso(2);
     * Syso(3);
     *
     * 처럼 누적된 후 실행된다.
     */

    public void DFS(int n) {
        if(n == 0) return;
        else {
            DFS(n - 1);
            System.out.print(n + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i : T.solution(n)) System.out.print(i + " ");
        System.out.println();
        T.DFS(n);
    }
}
