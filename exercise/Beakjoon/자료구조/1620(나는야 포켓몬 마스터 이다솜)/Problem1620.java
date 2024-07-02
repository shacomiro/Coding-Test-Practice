import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

class Solution1620 {
    Map<Integer, String> idNameMap;
    Map<String, Integer> nameIdMap;
    List<String> questions;

    public Solution1620(List<String> poketmons, List<String> questions) {
        this.idNameMap = new HashMap<>();
        this.nameIdMap = new HashMap<>();
        this.questions = questions;

        for(int id = 1; id <= poketmons.size(); id++) {
            idNameMap.put(id, poketmons.get(id - 1));
            nameIdMap.put(poketmons.get(id - 1), id);
        }
    }

    public String solve() {
        StringBuilder sb = new StringBuilder();

        for(String question : questions) {
            if(Character.isDigit(question.charAt(0))) {
                sb.append(idNameMap.get(Integer.parseInt(question)));
            } else {
                sb.append(nameIdMap.get(question));
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}

public class Problem1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<String> list1 = new ArrayList<>(n);
        List<String> list2 = new ArrayList<>(m);
        for(int i = 0; i < n; i++) {
            list1.add(br.readLine());
        }
        for(int i = 0; i < m; i++) {
            list2.add(br.readLine());
        }

        bw.write(new Solution1620(list1, list2).solve());
        bw.flush();
        bw.close();
    }
}
