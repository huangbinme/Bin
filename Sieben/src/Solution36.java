import java.util.Deque;
import java.util.LinkedList;

public class Solution36 {

    public static void main(String[] args) {
        Node node3 =  new Node(3);
        Node node1 =  new Node(1);
        Node node2 =  new Node(2, node1, node3);
        Node node5 =  new Node(5);
        Node node4 =  new Node(4, node2, node5);
        Node res = treeToDoublyList(node4);
        while(res !=null){
            System.out.println(res.val);
        }
    }

    public static Node treeToDoublyList(Node root){

        Deque<Node> q = new LinkedList<>();
        if (root==null){
            return null;
        }
        while(root.left !=null){
            q.offerLast(root);
            root = root.left;
        }
        Node res = root;
        while(!q.isEmpty()) {
            Node temp = q.pollLast();
            root.right = temp;
            Node rightTemp = temp.right;
            if (!q.contains(rightTemp)) {
                rightTemp = treeToDoublyList(rightTemp);
            }
            temp.right = rightTemp;
            rightTemp.left = temp;
            root = temp.right;
        }
        res.left = root;
        root.right= res;
        return res;
    }


}

class Node{
    int val;
    Node left;
    Node right;

    public Node(){}

    public Node(int val){
        this.val = val;
    }

    public Node(int val, Node left, Node right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}