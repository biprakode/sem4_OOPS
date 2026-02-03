package Assignment2.q3;

public class Node{
    private int value;
    Node left;
    Node right;

    public Node (int val) {
        value = val;
        left = null;
        right = null;
    }

    public int getVal() {
        return value;
    }

    public static boolean isGreater(Node node1 , Node node2) {
        return node1.getVal() >= node2.getVal();
    }

    @Override
    public String toString() {
        return "Val = " + value;
    }
}
