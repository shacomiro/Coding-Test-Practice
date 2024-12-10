import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution1972 {
    private String str;
    private Map<Integer, Set<String>> dPairs;

    public Solution1972(String str) {
        this.str = str;
        this.dPairs = new HashMap<>();

        for(int d = 0; d <= str.length() - 2; d++) {
            dPairs.put(d, new HashSet<>());
        }
    }

    public String solve() {
        if(str.length() <= 2) {
            return str + " is surprising.";
        }

        for(int i = 0; i <= str.length() - 2; i++) {
            for(int d = 0; i + d + 1 < str.length(); d++) {
                String pair = new StringBuilder().append(str.charAt(i)).append(str.charAt(i + d + 1)).toString();
                
                if(dPairs.get(d).contains(pair)) {
                    return str + " is NOT surprising.";
                }
                dPairs.get(d).add(pair);
            }
        }

        return str + " is surprising.";
    }
}

public class Problem1972 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;

        while(!(input = br.readLine()).equals("*")) {
            bw.write(new Solution1972(input).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
