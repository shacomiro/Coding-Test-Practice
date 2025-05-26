import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution11558 {
    private int n;
    private int[] graph;
    private boolean[] visited;

    public Solution11558(int n, int[] graph) {
        this.n = n;
        this.graph = graph;
        this.visited = new boolean[n + 1];
    }

    public String solve() {
        int k = 0;
        int next = 1;

        while (true) {
            if (visited[next]) {
                return "0";
            }
            if (next == n) {
                return String.valueOf(k);
            }

            visited[next] = true;
            next = graph[next];
            k++;
        }
    }
}

public class Problem11558 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n + 1];
            for (int j = 1; j < n + 1; j++) {
                arr[j] = Integer.parseInt(br.readLine());
            }

            bw.write(new Solution11558(n, arr).solve());
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
