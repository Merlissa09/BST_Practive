/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(new Node(5));
        tree.insert(new Node(1));
        tree.insert(new Node(9));
        tree.insert(new Node(7));
        tree.insert(new Node(3));
        tree.insert(new Node(6));
        tree.insert(new Node(4));
        tree.insert(new Node(0));
        tree.display();
        System.out.println("5 " + tree.search(5));
        System.out.println("80 " + tree.search(80));
        int count = tree.countNumberOfNodes(tree.root);
        System.out.println("number of nodes" + count);
        System.out.println(tree.countNumberOfLeafNodes(tree.root));
    }
}