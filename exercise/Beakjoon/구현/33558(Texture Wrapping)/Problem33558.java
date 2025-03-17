import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution33558 {
    private int n;
    private int m;
    private int u;
    private int v;
    private char[][] planar;
    private char[][] texture;
    private String method;

    public Solution33558(int n, int m, int u, int v, char[][] texture, String method) {
        this.n = n;
        this.m = m;
        this.u = u;
        this.v = v;
        this.planar = new char[n][m];
        this.texture = texture;
        this.method = method;
    }

    public String solve() {
        switch (method) {
            case "clamp-to-edge":
                clampToEdge();
                break;
            case "repeat":
                repeat();
                break;
            case "mirrored-repeat":
                mirroredRepeat();
                break;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                sb.append(planar[i][j]);
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    private void clampToEdge() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                planar[i][j] = texture[Math.min(i, u - 1)][Math.min(j, v - 1)];
            }
        }
    }

    private void repeat() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                planar[i][j] = texture[i % u][j % v];
            }
        }
    }

    private void mirroredRepeat() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                planar[i][j] = texture[((i / u) % 2 == 1) ? ((u - 1) - (i % u)) : i % u][((j / v) % 2 == 1) ? ((v - 1) - (j % v)) : j % v];
            }
        }
    }
}

public class Problem33558 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        char[][] arr = new char[u][v];
        for(int i = 0; i < u; i++) {
            char[] chars = br.readLine().toCharArray();
            for(int j = 0; j < v; j++) {
                arr[i][j] = chars[j];
            }
        }
        String method = br.readLine();

        bw.write(new Solution33558(n, m, u, v, arr, method).solve());
        bw.flush();
        bw.close();
    }
}
