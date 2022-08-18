import section7.recursivetreegraph.aNode;

import java.util.LinkedList;
import java.util.Queue;

class Node { //특정 노드를 가리키는 객체 Node
    int data; //노드가 가질 데이터
    Node lt, rt; //왼쪽, 오른쪽 자식 노드(각 자식 노드를 가리키는 주소)

    public Node(int val) {
        data = val;
        lt = null;
        rt = null;
    }
}

public class Main {
    Node root;

    // BFS는 '최단 거리'에 최적화 됨.
    // 여기서도 최단 간선 갯수를 찾는 순간 탐색이 종료되기 때문에, 모든 깊이를 다 탐색하는 DFS보다 효율적임.
    public int BFS(Node root) {
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        int L = 0;

        while(!Q.isEmpty()) {
            int len = Q.size();

            for(int i = 0; i < len; i++) {
                Node tmp = Q.poll();

                if(tmp.lt == null && tmp.rt == null) return L;

                if(tmp.lt != null) Q.offer(tmp.lt);
                if(tmp.rt != null) Q.offer(tmp.rt);
            }

            L++;
        }

        return L;
    }

    public static void main(String[] args) {
        Main tree = new Main();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);

        System.out.println(tree.DFS(0, tree.root));
    }
}
