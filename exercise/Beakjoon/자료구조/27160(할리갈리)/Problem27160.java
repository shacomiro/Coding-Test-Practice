import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Map.Entry;

class Solution27160 {
    private Map<String, Integer> cards;

    public Solution27160(int n, String[] cardTypes, int[] cardCount) {
        this.cards = new HashMap<>();

        for(int i = 0; i < n; i++) {
            cards.put(cardTypes[i], cards.getOrDefault(cardTypes[i], 0) + cardCount[i]);
        }
    }

    public String solve() {
        for(Entry<String, Integer> card : cards.entrySet()) {
            if(card.getValue() == 5) {
                return "YES";
            }
        }

        return "NO";
    }
}
public class Problem27160 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        String[] arr1 = new String[n];
        int[] arr2 = new int[n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr1[i] = st.nextToken();
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution27160(n, arr1, arr2).solve());
        bw.flush();
        bw.close();
    }
}
