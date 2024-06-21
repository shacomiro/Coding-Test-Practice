import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution7562 {
    private static final int[] DX = {-2, -1, 1, 2, 2, 1, -1, -2};
    private static final int[] DY = {1, 2, 2, 1, -1, -2, -2, -1};
    private int size;
    private boolean[][] visited;
    private int[] start;
    private int[] goal;
    private int count;

    public Solution7562(int size, int[] start, int[] goal) {
        this.size = size;
        this.visited = new boolean[size][size];
        this.start = start;
        this.goal = goal;
        this.count = 0;
    }

    public String solve() {
        bfs();

        return String.valueOf(count);
    }

    private void bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start[0]][start[1]] = true;

        while(!queue.isEmpty()) {
            int qSize = queue.size();

            for(int s = 0; s < qSize; s++) {
                int[] curr = queue.poll();
                int cx = curr[0];
                int cy = curr[1];

                if(cx == goal[0] && cy == goal[1]) {
                    return;
                }
    
                for(int i = 0; i < 8; i++) {
                    int nx = cx + DX[i];
                    int ny = cy + DY[i];
    
                    if(!(0 <= nx && nx < size && 0 <= ny && ny < size)) {
                        continue;
                    }
    
                    if(visited[nx][ny]) {
                        continue;
                    }
    
                    queue.offer(new int[] {nx, ny});
                    visited[nx][ny] = true;
                }
            }

            count++;
        }
    }
}

public class Problem7562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            int l = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] arr1 = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            st = new StringTokenizer(br.readLine());
            int[] arr2 = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            bw.write(new Solution7562(l, arr1, arr2).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
