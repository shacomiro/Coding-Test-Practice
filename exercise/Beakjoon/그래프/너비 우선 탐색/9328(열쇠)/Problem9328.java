import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

class Solution9328 {
    private final int[] DX = {0, 1, 0, -1};
    private final int[] DY = {1, 0, -1, 0};
    private int height;
    private int width;
    private char[][] map;
    private boolean[][][] visited;
    private Set<Character> keySet;

    public Solution9328(int height, int width, char[][] map, List<Character> keys) {
        this.height = height;
        this.width = width;
        this.map = map;
        this.visited = new boolean[27][height][width];
        this.keySet = new HashSet<>(keys);
    }

    public String solve() {
        int maxCount = 0;
        boolean researchRequired = false;

        for(int x = 0; x < height; x++) {
            for(int y = 0; y < width; y++) {
                int currKeySetSize = keySet.size();

                if(researchRequired) {
                    x = 0;
                    y = 0;
                    researchRequired = false;
                }

                if((x == 0 || x == height - 1) || (y == 0 || y == width - 1)) {
                    if(visited[keySet.size()][x][y]) {
                        continue;
                    }
                    if(map[x][y] == '*') {
                        continue;
                    }
                    if(('A' <= map[x][y] && map[x][y] <= 'Z') && !keySet.contains(Character.toLowerCase(map[x][y]))) {
                        continue;
                    }

                    int count = bfs(new int[] {x, y});
                    if(keySet.size() > currKeySetSize) {
                        researchRequired = true;
                    }

                    maxCount += count;
                }
            }
        }

        return String.valueOf(maxCount);
    }

    private int bfs(int[] start) {
        int count = 0;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {start[0], start[1]});
        visited[keySet.size()][start[0]][start[1]] = true;

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cx = curr[0];
            int cy = curr[1];

            if(map[cx][cy] == '$') {
                count++;
                map[cx][cy] = '.';
            }
            if('a' <= map[cx][cy] && map[cx][cy] <= 'z') {
                keySet.add(map[cx][cy]);
                map[cx][cy] = '.';
            }

            for(int i = 0; i < 4; i++) {
                int nx = cx + DX[i];
                int ny = cy + DY[i];

                if(!(0 <= nx && nx < height && 0 <= ny && ny < width)) {
                    continue;
                }
                if(visited[keySet.size()][nx][ny]) {
                    continue;
                }
                if(map[nx][ny] == '*') {
                    continue;
                }
                if(('A' <= map[nx][ny] && map[nx][ny] <= 'Z') && !keySet.contains(Character.toLowerCase(map[nx][ny]))) {
                    continue;
                }

                queue.offer(new int[] {nx, ny});
                visited[keySet.size()][nx][ny] = true;
            }
        }

        return count;
    }
}

public class Problem9328 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            char[][] arr = new char[h][w];
            for(int x = 0; x < h; x++) {
                char[] chars = br.readLine().toCharArray();
                for(int y = 0; y < w; y++) {
                    arr[x][y] = chars[y];
                }
            }
            List<Character> list = new ArrayList<>();
            for(char c : br.readLine().toCharArray()) {
                if(c == '0') {
                    break;
                }
                list.add(c);
            }
            bw.write(new Solution9328(h, w, arr, list).solve());
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
