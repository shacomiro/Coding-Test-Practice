import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution1316 {
    private String[] words;

    public Solution1316(String[] words) {
        this.words = words;
    }

    public String solve() {
        int count = 0;

        for(String word : words) {
            if(isGroupWord(word)) {
                count++;
            }
        }

        return String.valueOf(count);
    }

    private boolean isGroupWord(String word) {
        boolean[] isUsed = new boolean[26];
        int prev = -1;

        for(int i = 0; i < word.length(); i++) {
            int curr = word.charAt(i);
            
            if(prev != curr) {
                if(!isUsed[curr - 'a']) {
                    isUsed[curr - 'a'] = true;
                    prev = curr;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}

public class Problem1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for(int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        bw.write(new Solution1316(arr).solve());
        bw.flush();
        bw.close();
    }
}
