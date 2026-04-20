// Name - Biprarshi Biswas
// Roll No - 002410501094
// BCSE-II A3

// Question:
// Given the root of a binary tree, return all root-to-leaf paths in any order. A leaf is
// a node with no children. Treat a node as an inner class. Write appropriate code
// representing the node containing an integer (1>n>100) or a string (6 letter names).

package Assignment2.q3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RandomBST tree = new RandomBST();

        // read how many nodes we'll insert
        System.out.println("Enter the number of elements:");
        int n = scanner.nextInt();
        Integer[] arr = new Integer[n];

        System.out.println("Enter " + n + " integers to build the BST:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // build tree and walk every path
        tree.buildLevelOrder(arr);

        System.out.println("\nRoot-to-Leaf Paths");
        ArrayList<ArrayList<Integer>> paths = tree.findPaths();
        for (ArrayList<Integer> path : paths) {
            System.out.println(path);
        }

        scanner.close();
    }
}
