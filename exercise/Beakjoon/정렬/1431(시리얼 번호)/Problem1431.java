import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Solution1431 {
    private List<String> serials;

    public Solution1431(List<String> serials) {
        this.serials = serials;
    }

    public String solve() {
        Collections.sort(serials, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() != o2.length()) {
                    return o1.length() - o2.length();
                }

                int gap = getDigitsSum(o1) - getDigitsSum(o2);
                if(gap != 0) {
                    return gap;
                }

                return o1.compareTo(o2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for(String serial : serials) {
            sb.append(serial).append("\n");
        }

        return sb.toString();
    }

    private int getDigitsSum(String serials) {
        int sum = 0;

        for(char c : serials.toCharArray()) {
            if(Character.isDigit(c)) {
                sum += c - '0';
            }
        }

        return sum;
    } 
}

public class Problem1431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        bw.write(new Solution1431(list).solve());
        bw.flush();
        bw.close();
    }
}
