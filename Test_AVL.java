package BST;

public class Test_AVL {
    public static void main(String[] args) {
        AVL tree = new AVL();
        tree.root = tree.insert(tree.root, 15);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 24);
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 13);
        tree.root = tree.insert(tree.root, 7);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 36);
        tree.root = tree.insert(tree.root, 25);
        tree.inOrder(tree.root);
    }

}
