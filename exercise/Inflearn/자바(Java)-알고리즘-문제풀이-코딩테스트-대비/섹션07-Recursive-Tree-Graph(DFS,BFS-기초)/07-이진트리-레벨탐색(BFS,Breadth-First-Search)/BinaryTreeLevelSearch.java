import java.util.LinkedList;
import java.util.Queue;

class Node { //특정 노드를 가리키는 객체 Node
    int data; //노드가 가질 데이터
    NodeBFS lt, rt; //왼쪽, 오른쪽 자식 노드(각 자식 노드를 가리키는 주소)

    public Node(int val) {
        data = val;
        lt = null;
        rt = null;
    }
}

public class BinaryTreeLevelSearch {
    /**
     * 이진 트리의 레벨별로 탐색하는 것이 BFS.
     * 1(1레벨) / 2 3(2레벨) / 4 5 6 7(3레벨)
     * 각 레벨은 root에서 몇 번만에 도달할 수 있는지를 의미.
     *
     * 최단거리 탐색 문제에서 자주 활용. -> ex) 송아지 찾기
     */

    Node root;

    public void BFS(NodeBFS root) {
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        int L = 0; //초기 레벨은 0(루트)

        while(!Q.isEmpty()) {
            int len = Q.size();

            System.out.print(L + " : "); // L 레벨에는.. (L번 만에 L 레벨에 도착)

            for(int i = 0; i < len; i++) {
                Node cur = Q.poll();
                System.out.print(cur.data + " "); //해당 레벨의 노드(데이터) 출력. (현재 노드에서 할 작업을 이곳에 작성)

                //다음 레벨 노드들(자식들)이 있다면 큐의 끝에 추가
                if(cur.lt != null) Q.offer(cur.lt);
                if(cur.rt != null) Q.offer(cur.rt);
            }

            L++;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Main tree = new Main();

        tree.root = new Node(1); //최상위 부모 : 1번 노드
        tree.root.lt = new Node(2); // 1번 노드의 왼쪽 자식 - 2번 노드
        tree.root.rt = new Node(3); // 1번 노드의 오른쪽 자식 - 3번 노드

        tree.root.lt.lt = new Node(4); //2번 노드의 왼쪽 자식 - 4번 노드
        tree.root.lt.rt = new Node(5); //2번 노드의 오른쪽 자식 - 5번 노드

        tree.root.rt.lt = new Node(6); //3번 노드의 왼쪽 자식 - 6번 노드
        tree.root.rt.rt = new Node(7); //3번 노드의 오른쪽 자식 - 7번 노드

        tree.BFS(tree.root);
    }
}
