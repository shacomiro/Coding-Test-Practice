import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution25192 {
    private Set<String> emoji;
    private List<String> logs;
    
    public Solution25192(List<String> logs) {
        this.emoji = new HashSet<>();
        this.logs = logs;
    }

    public String solve() {
        int count = 0;

        for(String log : logs) {
            if(log.equals("ENTER")) {
                count += emoji.size();
                emoji.clear();
            } else {
                emoji.add(log);
            }
        }
        count += emoji.size();

        return String.valueOf(count);
    }
}

public class Problem25192 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        bw.write(new Solution25192(list).solve());
        bw.flush();
        bw.close();
    }
}
