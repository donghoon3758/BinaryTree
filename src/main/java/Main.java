public class Main {
    public static void main(String[] args){
        BinaryTree bt = new BinaryTree();

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        bt.push(node1);
        bt.push(node2);
        bt.push(node3);
        bt.push(node4);
        bt.push(node5);

        System.out.println("======DFS======");
        bt.DFS(node1);
        System.out.println("======BFS======");
        bt.BFS(node1);
    }
}
