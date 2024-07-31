import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

class Solution2668 {
    private int[] table;
    private boolean[] visited;
    private List<Integer> group;

    public Solution2668(int size, List<Integer> numbers) {
        this.table = new int[size + 1];
        this.visited = new boolean[size + 1];
        this.group = new ArrayList<>(size);

        for(int i = 1; i < table.length; i++) {
            table[i] = numbers.get(i - 1);
        }
    }

    public String solve() {
        for(int i = 1; i < table.length; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(group.size()).append("\n");
        for(int num : group) {
            sb.append(num).append("\n");
        }

        return sb.toString();
    }

    private void dfs(int start, int target) {
        if(!visited[table[start]]) {
            visited[table[start]] = true;
            dfs(table[start], target);
            visited[table[start]] = false;
        }

        if(table[start] == target) {
            group.add(target);
        }
    }
}

public class Problem2668 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        bw.write(new Solution2668(n, list).solve());
        bw.flush();
        bw.close();
    }
}
