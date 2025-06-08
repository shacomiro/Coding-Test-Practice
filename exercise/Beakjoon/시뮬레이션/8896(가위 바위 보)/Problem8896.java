import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution8896 {
    private int n;
    private int m;
    private char[][] robots;
    boolean[] isAlive;
    int aliveCount;

    public Solution8896(int n, String[] robots) {
        this.n = n;
        this.m = robots[0].length();
        this.robots = new char[n][m];
        this.isAlive = new boolean[n];
        this.aliveCount = n;

        for (int i = 0; i < n; i++) {
            this.robots[i] = robots[i].toCharArray();
            this.isAlive[i] = true;
        }
    }

    public String solve() {
        char winner;
        boolean sissor;
        boolean rock;
        boolean paper;

        for (int round = 0; round < m; round++) {
            if (aliveCount == 1) {
                break;
            }

            sissor = false;
            rock = false;
            paper = false;

            for (int id = 0; id < n; id++) {
                if (!isAlive[id]) {
                    continue;
                }

                switch (robots[id][round]) {
                    case 'S':
                        sissor = true;
                        break;
                    case 'R':
                        rock = true;
                        break;
                    case 'P':
                        paper = true;
                        break;
                }
            }

            if (sissor && rock && !paper) {
                winner = 'R';
            } else if (sissor && !rock && paper) {
                winner = 'S';
            } else if (!sissor && rock && paper) {
                winner = 'P';
            } else {
                winner = 'X';
            }

            updateIsAlive(round, winner);
        }

        StringBuilder sb = new StringBuilder();
        for (int id = 0; id < n; id++) {
            if (isAlive[id]) {
                sb.append(id + 1);
            }
        }

        return aliveCount == 1 ? sb.toString() : "0";
    }

    private void updateIsAlive(int round, char winner) {
        for (int id = 0; id < n; id++) {
            if (!isAlive[id]) {
                continue;
            }

            if (winner == 'X' || robots[id][round] == winner) {
                isAlive[id] = true;
            } else {
                isAlive[id] = false;
                aliveCount--;
            }
        }
    }
}

public class Problem8896 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] arr = new String[n];
            for (int j = 0; j < n; j++) {
                arr[j] = br.readLine();
            }
            bw.write(new Solution8896(n, arr).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
