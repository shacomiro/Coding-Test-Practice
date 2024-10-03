import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution26042 {
    private Queue<Integer> queue;
    private List<String> infos;

    public Solution26042(List<String> infos) {
        this.queue = new ArrayDeque<>();
        this.infos = infos;
    }

    public String solve() {
        int max = 0;
        int lastNumber = 0;

        for(String info : infos) {
            StringTokenizer st = new StringTokenizer(info);

            switch (st.nextToken()) {
                case "1":
                    int newNumber = Integer.parseInt(st.nextToken());
                    queue.offer(newNumber);

                    int size = queue.size();
                    if(max < size || (max == size && newNumber < lastNumber)) {
                        max = size;
                        lastNumber = newNumber;
                    }
                    break;
                case "2":
                    queue.poll();
                    break;
            }
        }

        return String.valueOf(max + " " + lastNumber);
    }
}

public class Problem26042 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        bw.write(new Solution26042(list).solve());
        bw.flush();
        bw.close();
    }
}
