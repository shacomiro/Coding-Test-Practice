import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

class Solution4948 {
    private final int MAX = 246912;
    private List<Integer> nList;
    private int[] counts;
    private boolean[] checked;
    
    public Solution4948(List<Integer> nList) {
        this.nList = nList;
        this.counts = new int[246913];
        this.checked = new boolean[246913];
    }
    
    public String solve() {
        StringBuilder sb = new StringBuilder();
        
        findPrimes();
        for(int n : nList) {
            sb.append(getPrimesCount(n, 2 * n)).append("\n");
        }
        
        return sb.toString();
    }
    
    private void findPrimes() {
        checked[1] = true;
        counts[1] = 1;
        
        for(int n = 2; n <= MAX; n++){
            counts[n] = counts[n - 1];
            
            if(!checked[n]) {
                counts[n]++;
                
                for(int i = n; i <= MAX; i += n) {
                    checked[i] = true;
                }
            }
        }
    }
    
    private int getPrimesCount(int start, int end) {
        return counts[end] - counts[start];
    }
}

public class Proble4948 {
     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> list = new ArrayList<>();
        while(true) {
            int num = Integer.parseInt(br.readLine());
            
            if(num == 0) {
                break;
            }
            
            list.add(num);
        }
        
        bw.write(new Solution4948(list).solve());
        bw.flush();
        bw.close();
    }
}
