import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

class Solution9733 {
    private final String[] types = {"Re", "Pt", "Cc", "Ea", "Tb", "Cm", "Ex"};
    private List<String> works;
    private HashMap<String, Integer> summary;

    public Solution9733(List<String> works) {
        this.works = works;
        this.summary = new HashMap<>();
    }

    public String solve() {
        for(String type : types) {
            summary.put(type, 0);
        }

        for(String work : works) {
            if(summary.containsKey(work)) {
                summary.put(work, summary.get(work) + 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(String type : types) {
            sb.append(type).append(" ")
                .append(summary.get(type)).append(" ")
                .append(String.format("%.2f", (double) summary.get(type) / works.size())).append("\n");
        }
        sb.append("Total ").append(works.size()).append(" 1.00");

        return sb.toString();
    }
}

public class Problem9733 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String input;
        List<String> list = new ArrayList<>(24);
        while((input = br.readLine()) != null) {
            st = new StringTokenizer(input);
            while(st.hasMoreTokens()) {
                list.add(st.nextToken());
            }
        }

        bw.write(new Solution9733(list).solve());
        bw.flush();
        bw.close();
    }
}
