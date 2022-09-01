import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int answer = Integer.MAX_VALUE;
    static int n, m;

    public void DFS(int L, int sum, Integer[] arr) {
        if(L >= answer) return;  //현재 구한 최소 동전 갯수와 동일하거나 많은 동전은 사용할 필요가 없음!
        if(sum > m) return;
        if(sum == m) {
            answer = Math.min(answer, L);
        } else {
            for(int i = 0; i < n; i++) {
                DFS(L + 1, sum + arr[i], arr);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        coins = new int[n];
        Integer[] arr = new Integer[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }
        Arrays.sort(arr, Collections.reverseOrder());
        m = Integer.parseInt(br.readLine());

        T.DFS(0, 0, arr);
        System.out.println(answer);
    }
}
