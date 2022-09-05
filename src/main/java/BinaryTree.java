import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    private Node root;
    private int size;

    public BinaryTree() {
        this.root = null;
        this.size = 0;
    }

    public void push(Node node){
        if(size==0){
            this.root = node;
            size++;
        }else{
            Queue<Node> q = new LinkedList<Node>();
            q.add(root);

            while(!q.isEmpty()){
                Node temp = q.poll();
                if(temp.left == null){
                    temp.left = node;
                    break;
                }else{
                    q.add(temp.left);
                }

                if(temp.right == null){
                    temp.right = node;
                    break;
                }else{
                    q.add(temp.right);
                }
            }
        }
        size++;
    }
    public void deleteLastNode(){
        Node last;

        if(size == 1){
            root = null;
        }else{
            Queue<Node> q = new LinkedList<Node>();
            last = findLastNode();
            q.add(root);
            while(!q.isEmpty()){
                Node temp = q.poll();
                if(temp.left != null){
                    if(isSame(temp.left,last)){
                        temp.left = null;
                        break;
                    }else{
                        q.add(temp.left);
                    }
                }
                if(temp.right != null){
                    if(isSame(temp.right,last)){
                        temp.right = null;
                        break;
                    }else{
                        q.add(temp.right);
                    }
                }
            }
        }
        size--;
    }
    public boolean isSame(Node a, Node b){
        return (a.left == b.left && a.right == b.right && a.value == b.value);
    }
    public Node findLastNode(){
        Node last = root;
        Queue<Node> q = new LinkedList<Node>();
        q.add(last);
        while(!q.isEmpty()){
            Node temp = q.poll();
            last = temp;
            if(temp.left != null) {
                q.add(temp.left);
            }
            if(temp.right != null) {
                q.add(temp.right);
            }
        }
        return last;
    }
    public void delete(Node deletedNode){
        if(checkNode(deletedNode)){
            Node last = findLastNode();
            if(size != 0){
                if(isSame(root,deletedNode)){
                    root.value = last.value;
                }else{
                    Queue<Node> q = new LinkedList<>();
                    q.add(root);
                    while(!q.isEmpty()){
                        Node temp = q.poll();
                        if(temp.left != null) {
                            if (isSame(temp.left, deletedNode)) {
                                temp.left.value = last.value;
                                break;
                            }
                        }else{
                            q.add(temp.left);
                        }
                        if(temp.right != null) {
                            if (isSame(temp.right, deletedNode)) {
                                temp.right.value = last.value;
                                break;
                            }
                        }else{
                            q.add(temp.right);
                        }
                    }
                }
            }
            deleteLastNode();
            size--;
        }
    }
    public boolean checkNode(Node node){
        boolean flag = false;
        if(size != 0){
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                Node temp = q.poll();
                if(temp.left != null){
                    if(isSame(temp.left,node)){
                        flag = true;
                        break;
                    }
                }else{
                    q.add(temp.left);
                }
                if(temp.right != null){
                    if(isSame(temp.right,node)){
                        flag = true;
                        break;
                    }
                }else{
                    q.add(temp.right);
                }
            }
        }
        return flag;
    }

    public void BFS(Node node){
        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while(!q.isEmpty()){
            Node temp = q.poll();
            System.out.print(temp.value + " ");
            if(temp.left != null){
                q.add(temp.left);
            }
            if(temp.right != null){
                q.add(temp.right);
            }
        }
    }

    public void DFS(Node node){
        if(node.left == null && node.right == null){
            System.out.print(node.value + " ");
        }else{
            if(node.left != null){
                DFS(node.left);
            }
            System.out.print(node.value + " ");
            if(node.right != null){
                DFS(node.right);
            }
        }
    }
}
