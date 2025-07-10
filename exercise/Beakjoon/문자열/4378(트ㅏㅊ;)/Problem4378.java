import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

class Solution4378 {
    private static final Map<Character, Character> KEY_MAP;
    static {
        Map<Character, Character> map = new HashMap<>();
        String[] keyboardRows = { "`1234567890-=", "QWERTYUIOP[]\\", "ASDFGHJKL;'", "ZXCVBNM,./" };

        for (String row : keyboardRows) {
            for (int i = 1; i < row.length(); i++) {
                map.put(row.charAt(i), row.charAt(i - 1));
            }
        }

        KEY_MAP = Map.copyOf(map);
    }

    private String paragraph;

    public Solution4378(String paragraph) {
        this.paragraph = paragraph;
    }

    public String solve() {
        StringBuilder sb = new StringBuilder();

        for (char c : paragraph.toCharArray()) {
            sb.append((KEY_MAP.containsKey(c)) ? KEY_MAP.get(c) : c);
        }

        return sb.toString();
    }
}

public class Problem4378 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;

        while ((input = br.readLine()) != null) {
            bw.write(new Solution4378(input).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
