// Name - Biprarshi Biswas
// Roll No - 002410501094
// BCSE-II A3

// Supporting class for q3 - BST node with integer value

package Assignment2.q3;

public class Node {
    private int value;
    Node left;
    Node right;

    public Node(int val) {
        // left/right start null - BST will fill them in later
        value = val;
        left = null;
        right = null;
    }

    public int getVal() {
        return value;
    }

    // handy helper to compare two nodes by value
    public static boolean isGreater(Node node1, Node node2) {
        return node1.getVal() >= node2.getVal();
    }

    @Override
    public String toString() {
        return "Val = " + value;
    }
}
