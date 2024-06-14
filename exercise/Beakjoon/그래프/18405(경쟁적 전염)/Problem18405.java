import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution18405 {
    private final int D_SIZE = 4;
    private final int[] DX = {1, 0, -1, 0};
    private final int[] DY = {0, 1, 0, -1};
    private final int SIZE;
    private List<Virus> viruses;
    private int[][] testTube;
    private boolean[][] visited;
    private int seconds;
    private int x;
    private int y;

    public Solution18405(int size, List<Virus> viruses, int[][] testTube, int seconds, int x, int y) {
        this.SIZE = size;
        this.viruses = viruses;
        this.testTube = testTube;
        this.visited = new boolean[size][size];
        this.seconds = seconds;
        this.x = x;
        this.y = y;
    }
    
    public String solve() {
        Collections.sort(viruses);
        bfs();

        return String.valueOf(testTube[x - 1][y - 1]);
    }

    private void bfs() {
        Queue<Virus> queue = new ArrayDeque<>();
        for(Virus virus : viruses) {
            queue.offer(virus);
            visited[virus.getX()][virus.getY()] = true;
        }
        int time = 0;
        
        while(!queue.isEmpty()) {
            int qSize = queue.size();

            if(time == seconds) {
                break;
            }

            for(int i = 0; i < qSize; i++) {
                Virus virus = queue.poll();
                int cx = virus.getX();
                int cy = virus.getY();
    
                for(int j = 0; j < D_SIZE; j++) {
                    int nx = cx + DX[j];
                    int ny = cy + DY[j];
    
                    if(!(0 <= nx && nx < SIZE && 0 <= ny && ny < SIZE)) {
                        continue;
                    }
    
                    if(visited[nx][ny]) {
                        continue;
                    }
    
                    queue.offer(new Virus(virus.getType(), nx, ny));
                    visited[nx][ny] = true;
                    testTube[nx][ny] = testTube[cx][cy];
                }
            }

            time++;
        }
    }

    static class Virus implements Comparable<Virus> {
        private int type;
        private int x;
        private int y;

        public Virus(int type, int x, int y) {
            this.type = type;
            this.x = x;
            this.y = y;
        }

        public int getType() {
            return type;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public int compareTo(Virus o) {
            return this.type - o.type;
        }
    }
}

public class Problem18405 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int k = Integer.parseInt(st1.nextToken());
        int[][] arr = new int[n][n];
        List<Solution18405.Virus> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st2.nextToken());

                if(arr[i][j] != 0) {
                    list.add(new Solution18405.Virus(arr[i][j], i, j));
                }
            }
        }
        StringTokenizer st3 = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st3.nextToken());
        int x = Integer.parseInt(st3.nextToken());
        int y = Integer.parseInt(st3.nextToken());

        bw.write(new Solution18405(n, list, arr, s, x, y).solve());
        bw.flush();
        bw.close();
    }
}
