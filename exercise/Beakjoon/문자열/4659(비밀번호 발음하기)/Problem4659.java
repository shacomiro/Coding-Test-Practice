import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

class Solution4659 {
    private String password;
    private Set<Character> vowels;

    public Solution4659(String password) {
        this.password = password;
        this.vowels = new HashSet<>() {{
            add('a');
            add('e');
            add('i');
            add('o');
            add('u');
        }};
    }

    public String solve() {
        return String.valueOf("<" + password + "> is " + (isAcceptable(password) ? "acceptable." : "not acceptable."));
    }

    private boolean isAcceptable(String password) {
        char[] pw = password.toCharArray();
        
        boolean isContainVowels = false;
        int vowelCnt = 0;
        int consonantCnt = 0;

        for(int i = 0; i < pw.length; i++) {
            if(vowels.contains(pw[i])) {
                vowelCnt++;
                consonantCnt = 0;

                if(!isContainVowels) {
                    isContainVowels = true;
                }
            } else {
                consonantCnt++;
                vowelCnt = 0;
            }

            if(vowelCnt == 3 || consonantCnt == 3) {
                return false;
            }

            if(i > 0 && pw[i] == pw[i - 1] && (pw[i] != 'e' && pw[i] != 'o')) {
                return false;
            }
        }

        if(!isContainVowels) {
            return false;
        }

        return true;
    }
}

public class Problem4659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;

        while(!(input = br.readLine()).equals("end")) {
            bw.write(new Solution4659(input).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
