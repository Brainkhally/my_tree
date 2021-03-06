package university;

public class Tree {

    private static class Node {
        int key;
        Object inf;
        Node left;
        Node right;

        /*  public Node(int key)
          {
              this.key=key;
          }
          */
        public Node(int key, Object inf) {
            this.key = key;
            this.inf = inf;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", inf=" + inf +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    private Node root;

    public Node getRoot() {
        return root;
    }

    public void add(int key, Object inf) {
        if (root == null) {
            root = new Node(key, inf);
        } else {
            Node parent = findNode(root, key);
            if (key < parent.key) {
                parent.left = new Node(key, inf);
            } else {
                parent.right = new Node(key, inf);
            }
        }
    }

    public Node findNode(Node current, int key) {
        if (key < current.key) {
            if (current.left == null) {
                return current;
            } else {
                return findNode(current.left, key);
            }
        } else {
            if (current.right == null) {
                return current;
            } else {
                return findNode(current.right, key);
            }
        }
    }
    public Node find(Node current, int key) {
        if (current!=null && key < current.key) {

                return find(current.left, key);
            }
        else {
            if(current!=null && key>current.key)
            {
                return find(current.right,key);
            }
            else
            {
                return  current;
            }
        }

    }

    public void showSimetric(Node n){
        if (n != null){
            showSimetric(n.left);
            System.out.println(n);
            showSimetric(n.right);
        }
    }
    public void showPriamoy(Node n){
        if (n != null) {
            System.out.println(n);
            showPriamoy(n.left);
            showPriamoy(n.right);
        }
    }

    public void showZvorot(Node n){
        if (n !=null){
            showZvorot(n.left);
            showZvorot(n.right);
            System.out.println(n);
        }
    }

    public boolean checkKey(int key)
    {
        Node tmp=find(root,key);
        return tmp!=null;
    }
}
