import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /**
     * 방문할때마다 해당 노드를 부모라고 가정하면, 소그룹(3개 노드 조합)이 생성된다. 방문 순서에 따라 순회 방식이 결정된다.
     *
     * 부모-왼쪽-오른쪽 방문 : 전위 순회 -> 미로 탐색,
     * 왼쪽-부모-오른쪽 방문 : 중위 순회 ->
     * 왼쪽-오른쪽-부모 방문 : 후위 순회 -> 병합 정렬,
     */
    
    Node root; //최상위 root 주소를 가지는 객체

    public void DFS(Node root) {
        if(root == null) return;
        else {
            System.out.print(root.data + " ");//전위 순회
            DFS(root.lt);
//            System.out.print(root.data + " ");//중위 순회
            DFS(root.rt);
//            System.out.print(root.data + " ");//후위 순회
        }
    }

    public static void main(String[] args) throws IOException {
        Main tree = new Main();

        tree.root = new Node(1); //최상위 부모 : 1번 노드
        tree.root.lt = new Node(2); // 1번 노드의 왼쪽 자식 - 2번 노드
        tree.root.rt = new Node(3); // 1번 노드의 오른쪽 자식 - 3번 노드
        
        tree.root.lt.lt = new Node(4); //2번 노드의 왼쪽 자식 - 4번 노드
        tree.root.lt.rt = new Node(5); //2번 노드의 오른쪽 자식 - 5번 노드
        
        tree.root.rt.lt = new Node(6); //3번 노드의 왼쪽 자식 - 6번 노드
        tree.root.rt.rt = new Node(7); //3번 노드의 오른쪽 자식 - 7번 노드

        tree.DFS(tree.root); //root 노드를 기준으로 깊이우선탐색 시작
    }
}

class Node { //특정 노드를 가리키는 객체 Node
    int data; //노드가 가질 데이터
    Node lt, rt; //왼쪽, 오른쪽 자식 노드(각 자식 노드를 가리키는 주소)

    public Node(int val) {
        data = val;
        lt = null;
        rt = null;
    }
}