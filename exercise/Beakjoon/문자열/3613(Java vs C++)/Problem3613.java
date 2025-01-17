import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution3613 {
    private String variable;

    public Solution3613(String variable) {
        this.variable = variable;
    }

    public String solve() {
        StringBuilder sb = new StringBuilder();

        char start = variable.charAt(0);
        char end = variable.charAt(variable.length() - 1);
        if(Character.isUpperCase(start) || start == '_' || end == '_') {
            return "Error!";
        }

        boolean isJava = false;
        boolean isCpp = false;

        for(int i = 0; i < variable.length(); i++) {
            char c = variable.charAt(i);

            if(Character.isUpperCase(c)) {
                isJava = true;
                sb.append('_').append(Character.toLowerCase(c));
            } else if(c == '_') {
                if(Character.isLowerCase(variable.charAt(i + 1))) {
                    isCpp = true;
                    sb.append(Character.toUpperCase(variable.charAt(++i)));
                } else {
                    return "Error!";
                }
            } else {
                sb.append(c);
            }

            if(isJava && isCpp) {
                return "Error!";
            }
        }

        return sb.toString();
    }
}

public class Problem3613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution3613(br.readLine()).solve());
        bw.flush();
        bw.close();
    }
}
