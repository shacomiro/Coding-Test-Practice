import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public String solution(String str) {
        char[] s = str.toLowerCase().toCharArray();
        int lt = 0;
        int rt = s.length - 1;

        while(lt < rt) {
            if(!Character.isAlphabetic(s[lt])) {
                lt++;
            } else if(!Character.isAlphabetic(s[rt])) {
                rt--;
            } else if(s[lt] != s[rt]) {
                return "NO";
            } else {
                lt++;
                rt--;
            }
        }

        return "YES";
    }

    public String alternativeSolution(String str) {
        String rStr = str.replaceAll("[^a-zA-Z]", "");
        StringBuilder sb = new StringBuilder(rStr);

        if(rStr.equalsIgnoreCase(sb.reverse().toString()))
            return "YES";
        else
            return "NO";
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        System.out.println(T.solution(str));
    }
}
