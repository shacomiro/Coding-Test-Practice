import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

class Solution14891 {
    List<Deque<Integer>> cogwheels;
    List<int[]> ratateInfo;

    public Solution14891(List<List<Integer>> cogwheelsInfo, List<int[]> rotateInfo) {
        this.cogwheels = new ArrayList<>(4);
        this.ratateInfo = rotateInfo;

        for(List<Integer> info : cogwheelsInfo) {
            cogwheels.add(new ArrayDeque<>(info));
        }
    }

    public String solve() {
        for(int[] info : ratateInfo) {
            roate(info[0] - 1, info[1], 0);
        }

        return String.valueOf(getPoint());
    }

    private void roate(int id, int direction, int pivot) {
        if((pivot == -1 || pivot == 0) && (id - 1 >= 0) && cogwheels.get(id).toArray()[6] != cogwheels.get(id - 1).toArray()[2]) {
            roate(id - 1, direction * -1, -1);
        }
        if((pivot == 1 || pivot == 0) && (id + 1 <= 3) && cogwheels.get(id).toArray()[2] != cogwheels.get(id + 1).toArray()[6]) {
            roate(id + 1, direction * -1, 1);
        }

        switch (direction) {
            case 1:
                clolckwise(id);
                break;
            case -1:
                counterColckwise(id);
                break;
        }
    }

    private void clolckwise(int id) {
        cogwheels.get(id).offerFirst(cogwheels.get(id).pollLast());
    }

    private void counterColckwise(int id) {
        cogwheels.get(id).offerLast(cogwheels.get(id).pollFirst());
    }

    private int getPoint() {
        int sum = 0;

        for(int i = 0; i < 4; i++) {
            sum += cogwheels.get(i).peek() * Math.pow(2, i);
        }

        return sum;
    }
}

public class Problem14891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<List<Integer>> list1 = new ArrayList<>();
        List<Integer> list2;
        StringTokenizer st;

        for(int i = 0; i < 4; i++) {
            String str = br.readLine();
            list2 = new ArrayList<>(8);

            for(char c : str.toCharArray()) {
                switch (c) {
                    case '0':
                        list2.add(0);
                        break;
                    case '1':
                        list2.add(1);
                        break;
                }
            }
            list1.add(list2);
        }
        int n = Integer.parseInt(br.readLine());
        List<int[]> list3 = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            list3.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        bw.write(new Solution14891(list1, list3).solve());
        bw.flush();
        bw.close();
    }
}
