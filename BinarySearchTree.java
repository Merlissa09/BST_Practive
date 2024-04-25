public class BinarySearchTree {
    Node root;
    int count;

    public void insert(Node node) {
        root = insertHelper(root, node);
    }
    
    private Node insertHelper(Node root, Node node) {
        int data = node.data;

        if (root == null) {
            root = node;
            return root;
        } else if (data < root.data) {
            root.left = insertHelper(root.left, node);
        } else {
            root.right = insertHelper(root.right, node);
        }

        
        return root;
    }

    public void display() {
        displayHelper(root);
    }
    
    public int countNumberOfNodes(Node root) {
        if (root == null) {
            return 0;
        }

        return 1 + countNumberOfNodes(root.left) + countNumberOfNodes(root.right);
    }

    public int countNumberOfLeafNodes(Node root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        return countNumberOfLeafNodes(root.left) + countNumberOfLeafNodes(root.right);


    }

    private void displayHelper(Node root) {
        if(root != null) {
            displayHelper(root.left);
            System.out.println(root.data);
            displayHelper(root.right);
        }
    }
    
    public boolean search(int data) {
        return searchHelper(root, data);
    }
    
    private boolean searchHelper(Node root, int data) {
        if (root == null) {
            return false;
        }

        if (root.data == data) {
            return true;
        } else if (data < root.data) {
            searchHelper(root.left, data);
        } else {
            searchHelper(root.right, data);
        }

        return false;
    }

    public void remove(int data) {
        if (search(data)) {
            removeHelper(root, data);
        } else {
            System.out.println(data + " could not be found");
        }
    }
    
    public Node removeHelper(Node root, int data) {
        if (root == null) {
            return root;
        } else if(data < root.data) {
            root.left = removeHelper(root.left, data);
        } else if (data > root.data) {
            root.right = removeHelper(root.right, data);
        } else { // found our node
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.right != null) {
                // find a successor to replace this node
                root.data = successor(root);
                root.right = removeHelper(root.right, root.data);
            } else { // find a predecessor to replace this node
                root.data = predecessor(root);
                root.left = removeHelper(root.left, root.data);
            }
        }
        
        return root;
    }

    private int successor(Node root) { // find the least value below the right child of this root node
        root = root.right;

        while (root.left != null) {
            root = root.left;
        }
        return root.data;
    }

    private int predecessor(Node root) { // find the greatest
        root = root.left;

        while (root.right != null) {
            root = root.right;
        }
        return root.data;
    }

}
