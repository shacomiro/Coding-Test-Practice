import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

class Solution25757 {
    private char game;
    private Set<String> players;

    public Solution25757(char game, List<String> players) {
        this.game = game;
        this.players = new HashSet<>(players);
    }

    public String solve() {
        int times = 0;

        switch(game) {
            case 'Y':
                times += players.size();
                break;
            case 'F':
                times += players.size() / 2;
                break;
            case 'O':
                times += players.size() / 3;
                break;
        }

        return String.valueOf(times);
    }
}

public class Problem25757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        char g = st.nextToken().charAt(0);
        List<String> list = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        bw.write(new Solution25757(g, list).solve());
        bw.flush();
        bw.close();
    }
}
