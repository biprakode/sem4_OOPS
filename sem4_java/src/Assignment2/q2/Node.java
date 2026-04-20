// Name - Biprarshi Biswas
// Roll No - 002410501094
// BCSE-II A3

// Supporting class for q2 - single node in the circular linked list

package Assignment2.q2;

public class Node {
    int data;
    Node next;

    public Node(int d) {
        // payload value and null next until the list links it up
        data = d;
        next = null;
    }

    @Override
    public String toString() {
        return data + "->";
    }
}
