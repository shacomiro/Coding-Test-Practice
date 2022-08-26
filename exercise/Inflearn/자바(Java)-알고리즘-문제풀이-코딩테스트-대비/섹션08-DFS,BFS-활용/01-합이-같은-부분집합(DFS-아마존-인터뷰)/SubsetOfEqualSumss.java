import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr, arr1, arr2;
    static int[] check, check1, check2;
    static HashSet<Integer> sums, sums1, sums2;
    static String answer;

    public void dfs(int v) {
        if(v == arr.length) {
            int sum1 = 0;
            int sum2 = 0;

            for(int i = 1; i < arr.length; i++)
                if(check[i] == 1) {
                    sum1 += arr[i];
                } else {
                    sum2 += arr[i];
                }
            if(sum1 == sum2) answer = "YES";
        } else {
            check[v] = 1;
            dfs(v + 1);
            check[v] = 0;
            dfs(v + 1);
        }
    }

    static int total = 0;
    boolean flag = false;

    public void DFS(int L, int sum, int[] arr) {
        if(flag) return;
        if(sum > total / 2) return; //두 서로소 부분집합의 합이 같으려면, sum이 전체 합의 절반을 초과하는 경우는 탐색할 필요가 없다.
        if(L == n) {
            if((total - sum) == sum) {
                answer = "YES";
                flag = true;    //참이 되면 메모리 스택 상의 모든 재귀 함수를 종료하기 위한 플래그.
            }
        } else {
            DFS(L + 1, sum + arr[L], arr);      //L번째 부분집합 사용
            DFS(L + 1, sum, arr);                    //L번째 부분집합 미사용
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        check = new int[n + 1];
        sums = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());
        answer = "NO";

        T.dfs(1);
        T.DFS(0, 0, arr);

        System.out.println(answer);
    }
}
