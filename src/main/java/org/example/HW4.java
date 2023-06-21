package org.example;

public class HW4 {
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
//                root = balance(root);
            }
            //root.color = Color.BLACK;
            //root.color = false;
        }

        private void insert(Node node, int value){
            if(node.value != value){
                if(node.value < value){
                    if(node.right == null){
                        node.right = new Node();
                        node.right.value = value;
                        //node.right.color = RED;
                    }else{
                        insert(node.right, value);
                    }
                }else{
                    if(node.left == null){
                        node.left = new Node();
                        node.left.value = value;
                        //node.left.color = RED;
                    }else{
                        insert(node.left, value);
                    }
                }
            }
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

    public class Main {
        public static void main(String[] args) {
//        HashMap map = new HashMap();
//
//        map.push(-1, 2);
//        map.push(17, 3);
//        map.push(3, 4);
//
//        System.out.println(map.find(-1));
//        System.out.println(map.find(17));
//        System.out.println(map.find(3));
//        System.out.println(map.find(5));
//
//        map.remove(17);
//        System.out.println(map.find(17));



        }
    }
}
