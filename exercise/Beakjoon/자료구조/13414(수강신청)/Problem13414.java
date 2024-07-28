import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.StringTokenizer;

class Solution13414 {
    private HashSet<String> enrollmentList;
    private int limit;
    private List<String> studentNumbers;

    public Solution13414(int limit, List<String> studentNumbers) {
        this.enrollmentList = new LinkedHashSet<>();
        this.limit = limit;
        this.studentNumbers = studentNumbers;
    }

    public String solve() {
        for(String studentNumber : studentNumbers) {
            if(enrollmentList.contains(studentNumber)) {
                enrollmentList.remove(studentNumber);
            }
            enrollmentList.add(studentNumber);
        }

        if(enrollmentList.size() < limit) {
            limit = enrollmentList.size();
        }

        StringBuilder sb = new StringBuilder();
        Iterator<String> iter = enrollmentList.iterator();
        for(int i = 0; i < limit; i++) {
            sb.append(iter.next()).append("\n");
        }

        return sb.toString();
    }
}

public class Problem13414 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        List<String> list = new ArrayList<>(l);
        for(int i = 0; i < l; i++) {
            list.add(br.readLine());
        }

        bw.write(new Solution13414(k, list).solve());
        bw.flush();
        bw.close();
    }
}
