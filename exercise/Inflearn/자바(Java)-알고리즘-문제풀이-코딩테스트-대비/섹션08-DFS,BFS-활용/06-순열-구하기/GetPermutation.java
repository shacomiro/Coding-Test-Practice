import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] check, arr, pm;

    public void DFS(int L) {
        if(L == m) {
            for(int x : pm) System.out.print(x + " ");
            System.out.println();
        } else {
            for(int i = 0; i < n; i++) {
                if(check[i] == 0) {
                    check[i] = 1;
                    pm[L] = arr[i];
                    DFS(L + 1);
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
        m = Integer.parseInt(st1.nextToken());
        arr = new int[n];
        check = new int[n];
        pm = new int[m];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        T.DFS(0);
    }
}
