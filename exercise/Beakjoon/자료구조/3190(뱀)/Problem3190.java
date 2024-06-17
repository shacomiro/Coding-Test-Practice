import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Deque;
import java.util.HashMap;
import java.util.StringTokenizer;

class Solution3190 {
    private final int[] DX = {0, 1, 0, -1};
    private final int[] DY = {1, 0, -1, 0};
    private int directionIndex;
    private int size;
    private boolean[][] board;
    private boolean[][] visited;
    private Map<Integer, String> commandsMap;
    private Deque<int[]> deque;
    private int time;

    public Solution3190(int size, boolean[][] board, List<String> commands) {
        this.directionIndex = 0;
        this.size = size + 1;
        this.board = board;
        this.visited = new boolean[size + 1][size + 1];
        this.commandsMap = new HashMap<>();
        this.deque = new ArrayDeque<>();
        this.time = 0;

        for(String command : commands) {
            StringTokenizer st = new StringTokenizer(command);
            commandsMap.put(Integer.parseInt(st.nextToken()), st.nextToken());
        }
    }

    public String solve() {
        deque.offerFirst(new int[] {1, 1});
        visited[1][1] = true;

        move();

        return String.valueOf(time);
    }

    private void move() {
        while(true) {
            time++;

            int[] coor = deque.peek();
            int nx = coor[0] + DX[directionIndex];
            int ny = coor[1] + DY[directionIndex];

            if(!(1 <= nx && nx < size && 1 <= ny && ny < size) || visited[nx][ny]) {
                break;
            }

            deque.offerFirst(new int[] {nx, ny});
            visited[nx][ny] = true;
            
            if(board[nx][ny]) {
                board[nx][ny] = false;
            } else {
                int[] tailCoor = deque.pollLast();
                visited[tailCoor[0]][tailCoor[1]] = false;
            }

            rotate(commandsMap.get(time));
        }
    }

    private void rotate(String nextDirection) {
        if(nextDirection == null) {
            return;
        }
        
        switch (nextDirection) {
            case "L":
                directionIndex = (directionIndex + 3) % 4;
                break;
            case "D":
                directionIndex = (directionIndex + 1) % 4;
                break;
        }
    }
}

public class Problem3190 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        boolean[][] arr = new boolean[n + 1][n + 1];
        for(int i = 0; i < k; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            arr[Integer.parseInt(st1.nextToken())][Integer.parseInt(st1.nextToken())] = true;
        }
        int l = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>(l);
        for(int i = 0; i < l; i++) {
            list.add(br.readLine());
        }

        bw.write(new Solution3190(n, arr, list).solve());
        bw.flush();
        bw.close();
    }
}
