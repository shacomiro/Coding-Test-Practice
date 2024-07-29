import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Solution5648 {
    private List<String> elements;
    private List<Long> numbers;

    public Solution5648(List<String> elements) {
        this.elements = elements;
        this.numbers = new ArrayList<>(elements.size());
    }

    public String solve() {
        for(String element : elements) {
            char[] chars = element.toCharArray();
            int lt = 0;
            int rt = chars.length - 1;
            
            while(lt < rt) {
                char temp = chars[lt];
                chars[lt] = chars[rt];
                chars[rt] = temp;

                lt++;
                rt--;
            }

            numbers.add(Long.valueOf(String.valueOf(chars)));
        }

        Collections.sort(numbers);

        StringBuilder sb = new StringBuilder();
        for(long number : numbers) {
            sb.append(number).append("\n");
        }

        return sb.toString();
    }
}

public class Problem5648 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        List<String> list = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            if(st.hasMoreTokens()) {
                list.add(st.nextToken());
            } else {
                st = new StringTokenizer(br.readLine());
                i--;
            }
        }

        bw.write(new Solution5648(list).solve());
        bw.flush();
        bw.close();
    }
}
