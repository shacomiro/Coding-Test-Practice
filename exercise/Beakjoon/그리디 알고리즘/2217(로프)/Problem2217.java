import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution2217 {
    private int n;
    private List<Integer> ropes;
    
    public Solution2217(int n, List<Integer> list) {
        this.n = n;
        this.ropes = list;
    }
    
    public String solve() {
        Collections.sort(ropes, Collections.reverseOrder());
        
        int maxWeight = ropes.get(0);
        int currentWeight = 0;
        int ropeCount = 0;
        
        for(int rope : ropes) {
            currentWeight = rope * ++ropeCount;
            
            if(currentWeight >= maxWeight) {
                maxWeight = currentWeight;
            }
        }
        
        return String.valueOf(maxWeight);
    }
}

public class Problem2217 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        
        bw.write(new Solution2217(n, list).solve());
        bw.flush();
        bw.close();
    }
}
