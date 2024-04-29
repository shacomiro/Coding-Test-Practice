import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;


public class NumberCard2 {
    public static int[] solution(int[] cards, int[] targets) {
        HashMap<Integer, Integer> cardMap = new HashMap<>();
        for(int card : cards) {
            cardMap.put(card, cardMap.getOrDefault(card, 0) + 1);
        }

        int[] answer = new int[targets.length];
        for(int i = 0; i < targets.length; i++) {
            answer[i] = cardMap.getOrDefault(targets[i], 0);
        }
        
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] cards = new int[n];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st1.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        int[] targets = new int[m];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            targets[i] = Integer.parseInt(st2.nextToken());
        }
        
        StringBuilder sb = new StringBuilder();
        for(int num : solution(cards, targets)) {
            sb.append(num).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}