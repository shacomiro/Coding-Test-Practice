import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution14503 {
    private int height;
    private int width;
    private int machineX;
    private int machineY;
    private Direction direction;
    private int[][] room;

    public Solution14503(int height, int width, int machineX, int machineY, int directionId, int[][] room) {
        this.height = height;
        this.width = width;
        this.machineX = machineX;
        this.machineY = machineY;
        this.direction = Direction.values()[directionId];
        this.room = room;
    }

    public String solve() {
        return String.valueOf(cleanup(machineX, machineY, direction));
    }

    private int cleanup(int x, int y, Direction direction) {
        boolean isReverse = false;
        int nextDirectionId = -1;
        int count = 0;

        while(true) {
            isReverse = false;

            if(room[x][y] == 0) {
                room[x][y] = 2;
                count++;
            }

            nextDirectionId = getNonCleanedDirection(x, y, direction);

            if(nextDirectionId == -1) {
                isReverse = true;
            } else {
                direction = Direction.values()[nextDirectionId];
            }

            x += isReverse ? -direction.getMove()[0] : direction.getMove()[0];
            y += isReverse ? -direction.getMove()[1] : direction.getMove()[1];

            if(!isValidCoor(x, y) || room[x][y] == 1) {
                break;
            }
        }

        return count;
    }

    private int getNonCleanedDirection(int cx, int cy, Direction direction) {
        for (int i = 0; i < 4; i++) {
            direction = direction.turnLeft();
            int nx = cx + direction.getMove()[0];
            int ny = cy + direction.getMove()[1];

            if (isValidCoor(nx, ny) && room[nx][ny] == 0) {
                return direction.getId();
            }
        }

        return -1;
    }

    private boolean isValidCoor(int x, int y) {
        return (0 <= x && x < height && 0 <= y && y < width) ? true : false;
    }

    static enum Direction {
        NORTH(0, new int[] {-1, 0}),
        EAST(1, new int[] {0, 1}),
        SOUTH(2, new int[] {1, 0}),
        WEST(3, new int[] {0, -1});

        private final int id;
        private final int[] move;

        Direction(int id, int[] move) {
            this.id = id;
            this.move = move;
        }

        public int getId() {
            return id;
        }

        public int[] getMove() {
            return move;
        }

        public Direction turnLeft() {
            return values()[(this.id + 3) % 4];
        }

        public Direction turnRight() {
            return values()[(this.id + 1) % 4];
        }
    }
}

public class Problem14503 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(new Solution14503(n, m, r, c, d, arr).solve());
        bw.flush();
        bw.close();
    }
}
