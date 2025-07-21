import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

class Solution1296 {
    private String name;
    private int n;
    private String[] teamNames;

    public Solution1296(String name, int n, String[] teamNames) {
        this.name = name;
        this.n = n;
        this.teamNames = teamNames;
    }

    public String solve() {
        Arrays.sort(teamNames);

        int l, o, v, e;
        double maxWinrate = 0;
        String winnerTeamname = teamNames[0];

        for (int i = 0; i < n; i++) {
            l = 0;
            o = 0;
            v = 0;
            e = 0;

            for (int j = 0; j < name.length(); j++) {
                switch (name.charAt(j)) {
                    case 'L':
                        l++;
                        break;
                    case 'O':
                        o++;
                        break;
                    case 'V':
                        v++;
                        break;
                    case 'E':
                        e++;
                        break;
                }
            }

            for (int j = 0; j < teamNames[i].length(); j++) {
                switch (teamNames[i].charAt(j)) {
                    case 'L':
                        l++;
                        break;
                    case 'O':
                        o++;
                        break;
                    case 'V':
                        v++;
                        break;
                    case 'E':
                        e++;
                        break;
                }
            }

            double currWinrate = ((l + o) * (l + v) * (l + e) * (o + v) * (o + e) * (v + e)) % 100;
            if (maxWinrate < currWinrate) {
                maxWinrate = currWinrate;
                winnerTeamname = teamNames[i];
            }
        }

        return winnerTeamname;
    }
}

public class Problem1296 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        bw.write(new Solution1296(str, n, arr).solve());
        bw.flush();
        bw.close();
    }
}
