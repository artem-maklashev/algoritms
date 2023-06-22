class Tree{
    private Node root;
    class Node{
        int value;
        Node left;
        Node right;

        //boolean color; // true = RED, false = BLACK
        Color color;
    }

    enum Color{
        BLACK,
        RED
    }

    public void insert(int value){
        if(root == null){
            root = new Node();
            root.value = value;
        }else{
            insert(root, value);
            root = balance(root);
        }
        root.color = Color.BLACK;
    }



    private void insert(Node node, int value){
        if(node.value != value){
            if(node.value < value){
                if(node.right == null){
                    node.right = new Node();
                    node.right.value = value;
                    node.right.color = Color.RED;
                }else{
                    insert(node.right, value);
                    node.right = balance(node.right);
                }
            }else{
                if(node.left == null){
                    node.left = new Node();
                    node.left.value = value;
                    node.left.color = Color.RED;
                }else{
                    insert(node.left, value);
                    node.left = balance(node.left);
                }
            }
        }
    }

    private Node rightRotate(Node node){
        Node newNode = node.left;
        node.left = newNode.right;
        newNode.right = node;
        newNode.color = node.color;
        node.color = Color.RED;
        return newNode;
    }
    private Node leftRotate(Node node){
        Node newNode = node.right;
        node.right = newNode.left;
        newNode.left = node;
        newNode.color = node.color;
        node.color = Color.RED;
        return newNode;
    }
    private void swapColors(Node node){
        node.color = Color.RED;
        node.left.color = Color.BLACK;
        node.right.color = Color.BLACK;
    }
    private Node balance(Node node){
        boolean isBalanced = true;
        do {
            isBalanced = true;
            if(node.left != null && node.left.color == Color.RED && (node.left.left !=null && node.left.left.color == Color.RED)){
                node = rightRotate(node);
                isBalanced = false;
            }
            if((node.right != null && node.right.color == Color.RED) && (node.left.color == Color.BLACK || node.left == null)){
                node = leftRotate(node);
                isBalanced = false;
            }
            if((node.left != null && node.left.color == Color.RED) && (node.right != null && node.right.color == Color.RED)){
                swapColors(node);
                isBalanced = false;
            }
        } while (!isBalanced);
        return node;
    }

    public Node find(int value){
        return find(root, value);
    }

    private Node find(Node node, int value) {
        if(node == null){
            return null;
        }
        if(node.value == value){
            return node;
        }
        if(node.value < value) {
            return find(node.right, value);
        }else{
            return find(node.left, value);
        }
    }
}

public class HW4 {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(8);
        tree.insert(5);
        tree.insert(10);
        tree.insert(4);
        tree.insert(3);
    }
}


