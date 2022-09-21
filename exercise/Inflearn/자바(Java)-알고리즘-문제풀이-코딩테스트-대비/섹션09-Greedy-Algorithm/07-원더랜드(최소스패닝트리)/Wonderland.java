import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
    public int v1;
    public int v2;
    public int cost;

    public Edge(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

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
        ArrayList<Edge> arr = new ArrayList<>();
        unf = new int[n + 1];
        for(int i = 1; i <= n; i++) unf[i] = i;
        for(int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            int c = Integer.parseInt(st2.nextToken());

            arr.add(new Edge(a, b, c));
        }

        int answer = 0;
        int cnt = 0;
        Collections.sort(arr);

        for(Edge ob : arr) {
            int fv1 = find(ob.v1);
            int fv2 = find(ob.v2);

            if(fv1 != fv2) {
                answer += ob.cost;
                union(ob.v1, ob.v2);
                cnt++;
            }

            if(cnt == n - 1) break;
        }

        System.out.println(answer);
    }
}