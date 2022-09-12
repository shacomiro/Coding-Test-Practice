import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public int solution(int n, int[][] players) {
        int answer = n;

        Arrays.sort(players, (o1, o2) -> {
            if(o1[0] < o2[0]) return -1;
            else if(o1[0] > o2[0]) return 1;
            else {
                if(o1[1] < o2[1]) return -1;
                else if(o1[1] > o2[1]) return 1;
            }
            return 0;
        });

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(players[i][0] < players[j][0] && players[i][1] < players[j][1]) {
                    answer--;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] players = new int[n][2];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            players[i][0] = Integer.parseInt(st.nextToken());
            players[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.println(T.solution(n, players));
    }
}
