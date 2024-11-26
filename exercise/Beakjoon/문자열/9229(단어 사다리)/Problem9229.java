import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

class Solution9229 {
    List<String> words;

    public Solution9229(List<String> words) {
        this.words = words;
    }

    public String solve() {
        for(int i = 0; i < words.size() - 1; i++) {
            if(words.get(i).length() != words.get(i + 1).length()) {
                return "Incorrect";
            }

            int cnt = 0;
            
            for(int j = 0; j < words.get(i).length(); j++) {
                if(words.get(i).charAt(j) != words.get(i + 1).charAt(j)) {
                    cnt++;

                    if(cnt > 1) {
                        return "Incorrect";
                    }
                }
            }
            
            if(cnt == 0) {
                return "Incorrect";
            }
        }

        return "Correct";
    }
}

public class Problem9229 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        List<String> list = new ArrayList<>();

        while((input = br.readLine()) != null) {
            if(input.equals("#")) {
                if(list.isEmpty()) {
                    break;
                } else {
                    bw.write(new Solution9229(list).solve());
                    bw.newLine();
                    list.clear();
                }
            } else {
                list.add(input);
            }
        }

        bw.flush();
        bw.close();
    }
}
