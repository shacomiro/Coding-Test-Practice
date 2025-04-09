import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Solution2890 {
    private int r;
    private int c;
    private char[][] satelliteImage;

    public Solution2890(int r, int c, char[][] satelliteImage) {
        this.r = r;
        this.c = c;
        this.satelliteImage = satelliteImage;
    }

    public String solve() {
        List<Team> teams = new ArrayList<>(9);

        for(int i = 0; i < r; i++) {
            int count = 0;

            for(int j = 1; j < c - 1; j++) {
                if(satelliteImage[i][j] != '.' && satelliteImage[i][j] != 'F') {
                    teams.add(new Team(Character.getNumericValue(satelliteImage[i][j]), count));
                    break;
                }
                count++;
            }
        }
        Collections.sort(teams, Collections.reverseOrder());

        int rank = 1;
        int prevMoved = teams.get(0).getMoved();
        for(int i = 0; i < 9; i++) {
            if(teams.get(i).getMoved() < prevMoved) {
                prevMoved = teams.get(i).getMoved();
                rank++;
            }
            teams.get(i).setRank(rank);
        }

        int[] ranks = new int[9];
        for(Team t : teams) {
            ranks[t.getId() - 1] = t.getRank();
        }

        StringBuilder sb = new StringBuilder();
        for(int rnk : ranks) {
            sb.append(rnk).append("\n");
        }

        return sb.toString();
    }

    static class Team implements Comparable<Team> {
        private int id;
        private int moved;
        private int rank;

        public Team(int id, int moved) {
            this.id = id;
            this.moved = moved;
            this.rank = -1;
        }

        public int getId() {
            return id;
        }

        public int getMoved() {
            return moved;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        @Override
        public int compareTo(Solution2890.Team o) {
            return Integer.compare(this.moved, o.moved);
        }
    }
}

public class Problem2890 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        char[][] arr = new char[r][c];
        for(int i = 0; i < r; i++) {
            String str = br.readLine();
            for(int j = 0; j < c; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        bw.write(new Solution2890(r, c, arr).solve());
        bw.flush();
        bw.close();
    }
}
