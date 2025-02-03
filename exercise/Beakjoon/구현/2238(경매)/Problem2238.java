import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

class Solution2238 {
    private int u;
    private int n;
    private String[] names;
    private int[] prices;

    public Solution2238(int u, int n, String[] names, int[] prices) {
        this.u = u;
        this.n = n;
        this.names = names;
        this.prices = prices;
    }

    public String solve() {
        HashMap<Integer, Integer> cntMap = new LinkedHashMap<>();
        HashMap<Integer, String> firstBidMap = new HashMap<>();

        for(int i = 0; i < n; i++) {
            if(!cntMap.containsKey(prices[i])) {
                firstBidMap.put(prices[i], names[i]);
            }

            cntMap.put(prices[i], cntMap.getOrDefault(prices[i], 0) + 1);
        }
        
        int cnt = n + 1;
        int price = u + 1;
        for(int bidPrice : cntMap.keySet()) {
            int bidCnt = cntMap.get(bidPrice);

            if(bidCnt < cnt) {
                price = bidPrice;
                cnt = bidCnt;
            } else if(bidCnt == cnt && bidPrice < price) {
                price = bidPrice;
            }
            
        }

        return String.valueOf(firstBidMap.get(price) + " " + price);
    }
}

public class Problem2238 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        String[] arr1 = new String[n];
        int[] arr2 = new int[n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr1[i] = st.nextToken();
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution2238(u, n, arr1, arr2).solve());
        bw.flush();
        bw.close();
    }
}
