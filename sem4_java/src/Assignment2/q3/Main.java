package Assignment2.q3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RandomBST tree = new RandomBST();

        System.out.println("Enter the number of elements:");
        int n = scanner.nextInt();
        Integer[] arr = new Integer[n];

        System.out.println("Enter " + n + " integers to build the BST:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        tree.buildLevelOrder(arr);

        System.out.println("\nRoot-to-Leaf Paths");
        ArrayList<ArrayList<Integer>> paths = tree.findPaths();
        for (ArrayList<Integer> path : paths) {
            System.out.println(path);
        }

        scanner.close();
    }
}

