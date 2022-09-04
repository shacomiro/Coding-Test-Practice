import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //해석 실패.
    //1행 수열을 nCr(n개 중 r개 선택한 조합수)에 맞춰 각 자릿수마다 n-1C1 ~ n-1Cn를 곱한 후 합하면 f가 나온다. : 규칙 습득해야 풀 수 있음.

    //이전 문제 '조합수'를 활용해서 미리 배열 p를 생성해놓은 뒤, DFS를 수행한다. 다시 해석해보기.
    
    static int n, f;
    static int[] b, p, check;
    boolean flag = false;
    int[][] dy = new int[35][35];

    public int combi(int n, int r) {
        if(dy[n][r] > 0) return dy[n][r];
        if(n == r || r == 0) return 1;
        else return dy[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
    }

    public void DFS(int L, int sum) {
        if(flag) return;
        if(L == n) {
            if(sum == f) {
                for(int x : p) System.out.print(x + " ");
                flag = true;
            }
        } else {
            for(int i = 1; i <= n; i++) {
                if(check[i] == 0) {
                    check[i] = 1;
                    p[L] = i;
                    DFS(L + 1, sum + (p[L] * b[L]));
                    check[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st1.nextToken());
        f = Integer.parseInt(st1.nextToken());
        b = new int[n];
        p = new int[n];
        check = new int[n + 1];

        for(int i = 0; i < n; i++) {
            b[i] = T.combi(n - 1, i);
        }
        T.DFS(0, 0);
    }
}
