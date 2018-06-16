package test.one;

public class BinarySearchTree {

   

    Node root;

    public BinarySearchTree() {
        root = null;
    }
    
    void printPostOrder(Node node) {
        while(true) {
            if(node.left != null) {
                printPostOrder(node.left);
            }
            
            if(node.right !=null) {
                printPostOrder(node.right);
            }
            
            System.out.println(node.val);
            return;
        }
    }
    
    int sizeOfTree(Node node) {
        if(node==null) return 0;
        return 1 + sizeOfTree(node.left) + sizeOfTree(node.right);
    }
    public static void main(String[] args)
    {
        BinarySearchTree tree = new BinarySearchTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.right.left= new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
 
        //System.out.println("Preorder traversal of binary tree is ");
        //tree.printPreorder();
 
        //System.out.println("\nInorder traversal of binary tree is ");
        //tree.printInorder();
 
        System.out.println("\nPostorder traversal of binary tree is ");
        tree.printPostOrder(tree.root);
        
        System.out.println("\nSize of binary tree is :"+tree.sizeOfTree(tree.root));
    }
}

class Node {
    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}
