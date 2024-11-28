import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

class Solution19637 {
    private List<String> titles;
    private List<Integer> strengths;
    private int[] characters;

    public Solution19637(List<String> titles, List<Integer> strengths, int[] characters) {
        this.titles = titles;
        this.strengths = strengths;
        this.characters = characters;
    }

    public String solve() {
        StringBuilder sb = new StringBuilder();

        for(int c : characters) {
            sb.append(titles.get(binarySearch(c, 0, strengths.size() - 1))).append("\n");
        }

        return sb.toString();
    }
    private int binarySearch(int character, int lt, int rt) {

        while(lt <= rt) {
            int mid = (lt + rt) / 2;

            if(character <= strengths.get(mid)) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        return lt;
    }
}

public class Problem19637 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Set<Integer> set = new HashSet<>();
        List<String> list1 = new ArrayList<>(n);
        List<Integer> list2 = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int s = Integer.parseInt(st.nextToken());

            if(!set.contains(s)) {
                list1.add(str);
                list2.add(s);

                set.add(s);
            }
        }
        int[] arr3 = new int[m];
        for(int i = 0; i < m; i++) {
            arr3[i] = Integer.parseInt(br.readLine());
        }


        bw.write(new Solution19637(list1, list2, arr3).solve());
        bw.flush();
        bw.close();
    }
}
