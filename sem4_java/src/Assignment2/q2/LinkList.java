// Name - Biprarshi Biswas
// Roll No - 002410501094
// BCSE-II A3

// Supporting class for q2 - circular linked list

package Assignment2.q2;

public class LinkList {
    Node head;
    Node tail;
    int size = 0;

    // add a new node at the tail and close the loop back to head
    public void add(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            // first node points to itself
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            // hook it onto the tail and point back to head
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
        size++;
    }

    // walk once through every node
    public void display() {
        if (size == 0) {
            System.out.println("CLL is empty");
            return;
        }
        Node walker = head;
        System.out.print("CLL: ");
        for (int i = 0; i < size; i++) {
            System.out.print(walker.data + " -> ");
            walker = walker.next;
        }
        System.out.println("(head)");
    }

    // sum only the even-valued nodes
    public void evenSum() {
        if (size == 0) {
            System.out.println("LL is empty");
        }
        Node walker = head;
        int sum = 0;
        for (int i = 0; i < size; i++) {
            if (walker.data % 2 == 0) {
                sum += walker.data;
            }
            walker = walker.next;
        }
        System.out.println("Even Sum across CLL = " + sum);
    }
}
