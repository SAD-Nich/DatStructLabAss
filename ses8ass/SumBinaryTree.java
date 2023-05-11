public class SumBinaryTree {
    public static class Node{
        int value;
        Node left;
        Node right;
        public Node(int value){
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    public Node root;
    public SumBinaryTree(){
        root = null;
    }
    public int sumofall(Node temp){
        int total, totalleft, totalright;
        total = totalleft = totalright = 0;
        if(root == null){
            System.out.println("No number of nodes");
            return 0;
        }
        else{
            if(temp.left != null){
                totalleft = sumofall(temp.left);
            }
            if(temp.right != null){
                totalright = sumofall(temp.right);
            }
        
        total = temp.value + totalleft + totalright;
        return total;
        }
    }
    public static void WriteNode(Node node){
        if (node != null){
            WriteNode(node.left);
            System.out.print(" " + node.value);
            WriteNode(node.right);
        }
    }
    public static void main(String[] args){
        SumBinaryTree nTree = new SumBinaryTree();
        nTree.root = new Node(5);
        nTree.root.left = new Node(4);
        nTree.root.right = new Node(6);
        nTree.root.left.left = new Node(2);
        nTree.root.left.right = new Node(3);
        nTree.root.right.left = new Node(7);
        nTree.root.right.right = new Node(8);
        System.out.print("Elements: ");
        WriteNode(nTree.root);
        System.out.println(" ");
        System.out.println("Sum of all nodes: " + nTree.sumofall(nTree.root));
    }
}