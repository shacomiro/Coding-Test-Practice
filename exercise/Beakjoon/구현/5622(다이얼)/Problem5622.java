import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

class Solution5622 {
    String word;
    Map<Character, Integer> dialMap;

    public Solution5622(String word) {
        this.word = word;
        this.dialMap = new HashMap<>() {{
            put('A', 2); put('B', 2); put('C', 2);
            put('D', 3); put('E', 3); put('F', 3);
            put('G', 4); put('H', 4); put('I', 4);
            put('J', 5); put('K', 5); put('L', 5);
            put('M', 6); put('N', 6); put('O', 6);
            put('P', 7); put('Q', 7); put('R', 7); put('S', 7);
            put('T', 8); put('U', 8); put('V', 8);
            put('W', 9); put('X', 9); put('Y', 9); put('Z', 9);
        }};
    }

    public String solve() {
        int time = 0;

        for(char c : word.toCharArray()) {
            time +=  dialMap.get(c) + 1;
        }

        return String.valueOf(time);
    }
}

public class Problem5622 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        bw.write(new Solution5622(str).solve());
        bw.flush();
        bw.close();
    }
}