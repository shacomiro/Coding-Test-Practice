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

class Solution10815 {
    Set<Integer> cardSet;
    List<Integer> finds;
    
    public Solution10815(List<Integer> cards, List<Integer> finds) {
        this.cardSet = new HashSet<>(cards);
        this.finds = finds;
    }
    
    public String solve() {
        StringBuilder sb = new StringBuilder();
        
        for(int f : finds) {
            if(cardSet.contains(f)) {
                sb.append(1);        
            } else {
                sb.append(0);
            }
            
            sb.append(" ");
        }
        
        return sb.toString();
    }
}

public class Problem10815 {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        List<Integer> list1 = new ArrayList<>(n);
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            list1.add(Integer.parseInt(st.nextToken()));
        }
        int m = Integer.parseInt(br.readLine());
        List<Integer> list2 = new ArrayList<>(m);
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            list2.add(Integer.parseInt(st.nextToken()));
        }
        
        bw.write(new Solution10815(list1, list2).solve());
        bw.flush();
        bw.close();
    }
}
