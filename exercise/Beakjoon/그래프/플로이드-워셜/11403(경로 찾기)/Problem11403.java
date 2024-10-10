import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution11403 {
    private int size;
    private boolean[][] graph;

    public Solution11403(int size, boolean[][] graph) {
        this.size = size;
        this.graph = graph;
    }

    public String solve() {
        floydWarshall();

        StringBuilder sb = new StringBuilder();
        for(boolean[] g : graph) {
            for(boolean b : g) {
                sb.append(b ? 1 : 0).append(" ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    private void floydWarshall() {
        for(int k = 0; k < size; k++) {
            for(int i = 0; i < size; i++) {
                for(int j = 0; j < size; j++) {
                    if(j == k || k == i) {
                        continue;
                    }

                    if(graph[i][k] && graph[k][j]) {
                        graph[i][j] = true;
                    }
                }
            }
        }
    }
}

public class Problem11403 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        boolean[][] arr = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                switch (st.nextToken()) {
                    case "0":
                        arr[i][j] = false;
                        break;
                    case "1":
                        arr[i][j] = true;
                        break;
                }
            }
        }

        bw.write(new Solution11403(n, arr).solve());
        bw.flush();
        bw.close();
    }
}
