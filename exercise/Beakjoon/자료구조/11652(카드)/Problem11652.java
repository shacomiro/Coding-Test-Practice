import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

class Solution11652 {
    private int n;
    private long[] cards;
    private Map<Long, Integer> map;

    public Solution11652(int n, long[] cards) {
        this.n = n;
        this.cards = cards;
        this.map = new HashMap<>();
    }

    public String solve() {
        int count = 0;
        long id = Long.MAX_VALUE;

        for(long card : cards) {
            map.put(card, map.getOrDefault(card, 0) + 1);

            if(count < map.get(card)) {
                count = map.get(card);
                id = card;
            } else if(card < id && count == map.get(card)) {
                id = card;
            }
        }

        return String.valueOf(id);
    }
}


public class Problem11652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        bw.write(new Solution11652(n, arr).solve());
        bw.flush();
        bw.close();
    }
}
