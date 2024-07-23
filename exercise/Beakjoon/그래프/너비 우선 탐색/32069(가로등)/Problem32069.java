import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

class Solution32069 {
    private final int[] MOVE = {-1, 1};
    private long length;
    private int count;
    private List<Position> streetlights;

    public Solution32069(long length, int count, List<Position> streetlights) {
        this.length = length;
        this.count = count;
        this.streetlights = streetlights;
    }

    public String solve() {
        return bfs();
    }

    private String bfs() {
        StringBuilder record = new StringBuilder();
        Queue<Position> queue = new ArrayDeque<>();
        Set<Long> visited = new HashSet<>();

        for(Position p : streetlights) {
            queue.offer(p);
            visited.add(p.getId());
        }

        while(!queue.isEmpty() && count > 0) {
            Position currPos = queue.poll();

            record.append(currPos.getDarkness()).append("\n");
            count--;

            for(int i = 0; i < 2; i++) {
                long nextId = currPos.getId() + MOVE[i];

                if(!(0 <= nextId && nextId < length + 1)) {
                    continue;
                }
                if(visited.contains(nextId)) {
                    continue;
                }

                queue.offer(new Position(nextId, currPos.getDarkness() + 1));
                visited.add(nextId);
            }
        }

        return record.toString();
    }

    static class Position {
        private long id;
        private int darkness;

        public Position(long id, int darkness) {
            this.id = id;
            this.darkness = darkness;
        }

        public long getId() {
            return id;
        }

        public int getDarkness() {
            return darkness;
        }
    }
}

public class Problem32069 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        long l = Long.parseLong(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        List<Solution32069.Position> list = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            list.add(new Solution32069.Position(Long.parseLong(st.nextToken()), 0));
        }
        
        bw.write(new Solution32069(l, k, list).solve());
        bw.flush();
        bw.close();
    }
}
