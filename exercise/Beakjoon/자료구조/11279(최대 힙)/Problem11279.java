import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

class MyMaxHeap {
    ArrayList<Integer> heap;

    public MyMaxHeap() {
        heap = new ArrayList<>();
        heap.add(0);
    }

    public void insert(int x) {
        heap.add(x);
        sortByInsert();
    }

    public int delete() {
        if(heap.size() == 1) {
            return 0;
        }

        int max = heap.get(1);
        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        sortByDelete();

        return max;
    }

    public void sortByInsert() {
        int childIdx = heap.size() - 1;

        while(childIdx > 1) {
            int parentIdx = childIdx / 2;
            int parent = heap.get(parentIdx);
            int child = heap.get(childIdx);

            if(parent > child) {
                break;
            }

            int temp = parent;
            heap.set(parentIdx, child);
            heap.set(childIdx, temp);
            childIdx = parentIdx;
        }
    }

    public void sortByDelete() {
        int parentIdx = 1;

        while(parentIdx * 2 < heap.size()) {
            int leftChildIdx = parentIdx * 2;
            int rightChildIdx = leftChildIdx + 1;
            int parent = heap.get(parentIdx);
            int maxChild = heap.get(leftChildIdx);
            int maxChildIdx = leftChildIdx;

            if(rightChildIdx < heap.size() && heap.get(rightChildIdx) > maxChild) {
                maxChild = heap.get(rightChildIdx);
                maxChildIdx = rightChildIdx;
            }

            if(parent > maxChild) {
                break;
            }

            int temp = parent;
            heap.set(parentIdx, maxChild);
            heap.set(maxChildIdx, temp);
            parentIdx = maxChildIdx;
        }
    }
}

public class Problem11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        MyMaxHeap myMaxHeap = new MyMaxHeap();
        for(int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

            if(x == 0) {
                bw.write(String.valueOf(myMaxHeap.delete()));
                bw.newLine();
            } else {
                myMaxHeap.insert(x);
            }
        }

        bw.flush();
        bw.close();
    }
}