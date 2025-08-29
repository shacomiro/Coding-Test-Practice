import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Problem2456 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solver(n, arr).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int n;
        private int[][] votes;
        List<Candidate> candidates;

        public Solver(int n, int[][] votes) {
            this.n = n;
            this.votes = votes;
            this.candidates = new ArrayList<>(3);
        }

        public String solve() {
            for (int i = 1; i <= 3; i++) {
                candidates.add(new Candidate(i));
            }

            for (int i = 0; i < n; i++) {
                candidates.get(0).addSocre(votes[i][0]);
                candidates.get(1).addSocre(votes[i][1]);
                candidates.get(2).addSocre(votes[i][2]);
            }

            Collections.sort(candidates);

            return candidates.get(0).getId() + " " + candidates.get(0).getTotalScore();
        }

        static class Candidate implements Comparable<Candidate> {
            private int id;
            private int totalScore;
            private int pointThreeCounts;
            private int pointTwoCounts;

            public Candidate(int id) {
                this.id = id;
            }

            public int getId() {
                return id;
            }

            public int getTotalScore() {
                return totalScore;
            }

            public void addSocre(int point) {
                totalScore += point;

                if (point == 3) {
                    pointThreeCounts++;
                } else if (point == 2) {
                    pointTwoCounts++;
                }
            }

            @Override
            public int compareTo(Problem2456.Solver.Candidate o) {
                if (this.totalScore != o.totalScore) {
                    return Integer.compare(o.totalScore, this.totalScore);
                }
                if (this.pointThreeCounts != o.pointThreeCounts) {
                    return Integer.compare(o.pointThreeCounts, this.pointThreeCounts);
                }
                if (this.pointTwoCounts != o.pointTwoCounts) {
                    return Integer.compare(o.pointTwoCounts, this.pointTwoCounts);
                }

                this.id = 0;
                o.id = 0;

                return 0;
            }
        }
    }
}
