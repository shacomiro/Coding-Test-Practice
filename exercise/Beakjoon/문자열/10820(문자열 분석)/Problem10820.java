import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

class Solution10820 {
    List<String> strings;

    public Solution10820(List<String> strings) {
        this.strings = strings;
    }

    public String solve() {
        StringBuilder sb = new StringBuilder();

        for(String str : strings) {
            int lowerAlphabetCnt = 0;
            int upperAlphabetCnt = 0;
            int numberCnt = 0;
            int emptyCnt = 0;

            for(char c : str.toCharArray()) {
                if(Character.isLowerCase(c)) {
                    lowerAlphabetCnt++;
                } else if(Character.isUpperCase(c)) {
                    upperAlphabetCnt++;
                } else if(Character.isDigit(c)) {
                    numberCnt++;
                } else if(c == ' ') {
                    emptyCnt++;
                }
            }

            sb.append(lowerAlphabetCnt).append(" ")
                .append(upperAlphabetCnt).append(" ")
                .append(numberCnt).append(" ")
                .append(emptyCnt).append("\n");
        }

        return sb.toString();
    }
}

public class Problem10820 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<String> list = new ArrayList<>(100);
        String input;
        while((input = br.readLine()) != null) {
            list.add(input);
        }

        bw.write(new Solution10820(list).solve());
        bw.flush();
        bw.close();
    }
}
