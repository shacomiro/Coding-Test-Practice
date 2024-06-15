import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class Solution2002 {
    private Map<String, Integer> beforeMap;
    private List<String> after;

    public Solution2002(int size, List<String> before, List<String> after) {
        this.beforeMap = new LinkedHashMap<>();
        this.after = after;

        for(int i = 0; i < size; i++) {
            beforeMap.put(before.get(i), i);
        }
    }

    public String solve() {
        int count = 0;

        for(String afterVehicle : after) {
            for(String beforeVehicle : beforeMap.keySet()) {
                if(beforeMap.get(afterVehicle) > beforeMap.get(beforeVehicle)) {
                    count++;

                    break;
                }
            }

            beforeMap.remove(afterVehicle);
        }

        return String.valueOf(count);
    }
}

public class Problem2002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<String> list1 = new ArrayList<>(n);
        List<String> list2 = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            list1.add(br.readLine());
        }
        for(int i = 0; i < n; i++) {
            list2.add(br.readLine());
        }

        bw.write(new Solution2002(n, list1, list2).solve());
        bw.flush();
        bw.close();
    }
}


