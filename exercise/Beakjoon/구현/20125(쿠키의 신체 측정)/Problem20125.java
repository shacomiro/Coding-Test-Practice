import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution20125 {
    private int n;
    private char[][] body;

    public Solution20125(int n, char[][] body) {
        this.n = n;
        this.body = body;
    }

    public String solve() {
        StringBuilder sb = new StringBuilder();

        int[] heart = findHeart();
        sb.append(heart[0] + 1).append(" ").append(heart[1] + 1).append("\n");

        for(int length : measure(heart)) {
            sb.append(length).append(" ");
        }

        return sb.toString();
    }

    private int[] findHeart() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(body[i][j] == '*') {
                    return new int[] {i + 1, j};
                }
            }
        }

        return new int[] {-1, -1};
    }
    
    private int[] measure(int[] heart) {
        int idx = 0;
        int[] bodyMeasurement = new int[5];

        int[][] move = new int[][] {{0, -1}, {0, 1}, {1, 0}};

        for(int i = 0; i < 3; i++) {
            int[] start = new int[] {heart[0] + move[i][0], heart[1] + move[i][1]};
            int[] end = getEnd(start, move[i]);
            bodyMeasurement[idx++] = Math.abs(start[0] - end[0] + start[1] - end[1]) + 1;

            if(i == 2) {
                for(int j = -1; j <= 1; j += 2) {
                    int[] legStart = new int[] {end[0] + 1, end[1] + j};
                    int[] legEnd = getEnd(legStart, move[i]);
                    bodyMeasurement[idx++] = Math.abs(legStart[0] - legEnd[0] + legStart[1] - legEnd[1]) + 1;
                }
            }
        }

        return bodyMeasurement;
    }

    private int[] getEnd(int[] start, int[] move) {
        int cx = start[0];
        int cy = start[1];
        int nx = start[0] + move[0];
        int ny = start[1] + move[1];

        while((0 <= nx && nx < n && 0 <= ny && ny < n) && body[nx][ny] == '*') {
            cx += move[0];
            cy += move[1];
            nx += move[0];
            ny += move[1];
        }

        return new int[] {cx, cy};
    }
}

public class Problem20125 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n][n];
        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            for(int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        bw.write(new Solution20125(n, arr).solve());
        bw.flush();
        bw.close();
    }
}
