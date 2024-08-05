import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution15723 {
    private int size;
    private boolean[][] graph;
    private List<int[]> conclusions;

    public Solution15723(int size, boolean[][] graph, List<int[]> conclusions) {
        this.size = graph.length;
        this.graph = graph;
        this.conclusions = conclusions;
    }

    public String solve() {
        floydWarshall();

        StringBuilder sb = new StringBuilder();
        for(int[] c : conclusions) {
            int from = c[0];
            int to = c[1];

            sb.append(graph[from][to] ? "T" : "F").append("\n");
        }

        return sb.toString();
    }

    private void floydWarshall() {
        for(int k = 0; k < size; k++) {
            for(int i = 0; i < size; i++) {
                for(int j = 0; j < size; j++) {
                    if(i == j || j == k || k == i) {
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

public class Problem15723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        boolean[][] arr = new boolean[26][26];
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char from = st.nextToken().charAt(0);
            st.nextToken();
            char to = st.nextToken().charAt(0);
            arr[from - 'a'][to - 'a'] = true;
        }
        int m = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>(n);
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            char from = st.nextToken().charAt(0);
            st.nextToken();
            char to = st.nextToken().charAt(0);
            list.add(new int[] {from - 'a', to - 'a'});
        }

        bw.write(new Solution15723(n, arr, list).solve());
        bw.flush();
        bw.close();
    }
}
