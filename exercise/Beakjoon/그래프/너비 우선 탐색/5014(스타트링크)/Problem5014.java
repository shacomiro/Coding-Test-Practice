import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution5014 {
    private int floor;
    private int start;
    private int goal;
    private int[] move;
    private boolean[] visited;

    public Solution5014(int floor, int start, int goal, int up, int down) {
        this.floor = floor;
        this.start = start;
        this.goal = goal;
        this.move = new int[] {up, -down};
        this.visited = new boolean[floor + 1];
    }

    public String solve() {
        int btnCount = bfs(start, goal);

        return String.valueOf(btnCount != -1 ? btnCount : "use the stairs");
    }

    private int bfs(int start, int goal) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {start, 0});
        visited[start] = true;

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cf = curr[0];
            int ct = curr[1];

            if(cf == goal) {
                return ct;
            }

            for(int m : move) {
                int nf = cf + m;
                int nt = ct + 1;

                if(!(1 <= nf && nf <= floor)) {
                    continue;
                }
                if(visited[nf]) {
                    continue;
                }

                queue.offer(new int[] {nf, nt});
                visited[nf] = true;
            }
        }

        return -1;
    }
}

public class Problem5014 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        bw.write(new Solution5014(f, s, g, u, d).solve());
        bw.flush();
        bw.close();
    }
}
