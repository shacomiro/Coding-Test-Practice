import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Solution29701 {
    private int length;
    private String morseCode;
    private Map<String, Character> codeMap;
    
    public Solution29701(int length, String morseCode) {
        this.length = length;
        this.morseCode = morseCode;
        this.codeMap = new HashMap<>() {{
            put(".-", 'A'); put("-...", 'B');
            put("-.-.", 'C'); put("-..", 'D');
            put(".", 'E'); put("..-.", 'F');
            put("--.", 'G'); put("....", 'H');
            put("..", 'I'); put(".---", 'J');
            put("-.-", 'K'); put(".-..", 'L');
            put("--", 'M'); put("-.", 'N');
            put("---", 'O'); put(".--.", 'P');
            put("--.-", 'Q'); put(".-.", 'R');
            put("...", 'S'); put("-", 'T');
            put("..-", 'U'); put("...-", 'V');
            put(".--", 'W'); put("-..-", 'X');
            put("-.--", 'Y'); put("--..", 'Z');
            put(".----", '1'); put("..---", '2');
            put("...--", '3'); put("....-", '4');
            put(".....", '5'); put("-....", '6');
            put("--...", '7'); put("---..", '8');
            put("----.", '9'); put("-----", '0');
            put("--..--", ','); put(".-.-.-", '.');
            put("..--..", '?'); put("---...", ':');
            put("-....-", '-'); put(".--.-.", '@');
        }};
    }

    public String solve() {
        StringBuilder sb = new StringBuilder(length);
        StringTokenizer codes = new StringTokenizer(morseCode);

        while(codes.hasMoreTokens()) {
            sb.append(codeMap.get(codes.nextToken()));
        }

        return sb.toString();
    }
}

public class Problem29701 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        bw.write(new Solution29701(n, str).solve());
        bw.flush();
        bw.close();
    }
}
