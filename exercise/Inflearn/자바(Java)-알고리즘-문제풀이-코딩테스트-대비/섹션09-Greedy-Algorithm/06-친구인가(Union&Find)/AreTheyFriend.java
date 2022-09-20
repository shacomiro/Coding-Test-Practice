import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] unf;

    public static int find(int v) {
        if(v == unf[v]) return v;
        else return unf[v] = find(unf[v]);
    }

    public static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if(fa != fb) unf[fa] = fb;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());
        unf = new int[n + 1];

        for(int i = 1; i <= n; i++) unf[i] = i;
        for(int i = 1; i <= m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());

            union(a, b);
        }

        StringTokenizer st3 = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st3.nextToken());
        int b = Integer.parseInt(st3.nextToken());
        int fa = find(a);
        int fb = find(b);

        if(fa == fb) System.out.println("YES");
        else System.out.println("NO");
    }
}