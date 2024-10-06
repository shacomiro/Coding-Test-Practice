import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class Solution1264 {
    private List<String> paragraphs;
    private Set<Character> vowel;

    public Solution1264(List<String> paragraphs) {
        this.paragraphs = paragraphs;
        this.vowel = Set.of('a', 'e', 'i', 'o', 'u');
    }

    public String solve() {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        for(String p : paragraphs) {
            for(char c : p.toLowerCase().toCharArray()) {
                if(vowel.contains(c)) {
                    count++;
                }
            }
            sb.append(count).append("\n");
            count = 0;
        }

        return sb.toString();
    }
}

public class Problem1264 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str;
        List<String> list = new ArrayList<>();
        while(!(str = br.readLine()).equals("#")) {
            list.add(str);
        }

        bw.write(new Solution1264(list).solve());
        bw.flush();
        bw.close();
    }
}
