class Node { //특정 노드를 가리키는 객체 Node
    int data; //노드가 가질 데이터
    Node lt, rt; //왼쪽, 오른쪽 자식 노드(각 자식 노드를 가리키는 주소)

    public Node(int val) {
        data = val;
        lt = null;
        rt = null;
    }
}

public class Main { //노드의 갯수는 DFS로 세는 것은 권장하지 않음 => 완전 트리가 아닌 경우 오류가 발생함.
    Node root;

    public int DFS(int L, Node root) {
        if(root.lt == null && root.rt == null) return L;
        else return Math.min(DFS(L+1, root.lt), DFS(L+1, root.rt)); //두 자식 노드 중 하나가 없는 경우 오류가 발생!
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
