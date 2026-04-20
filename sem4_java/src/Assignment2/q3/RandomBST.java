// Name - Biprarshi Biswas
// Roll No - 002410501094
// BCSE-II A3

// Supporting class for q3 - binary search tree with root-to-leaf path finder

package Assignment2.q3;

import java.util.*;

public class RandomBST {
    private Node root;
    private Random random = new Random();

    // classic BST insert - smaller values go left, larger go right
    private Node insert(Node walker, Node newnode) {
        if (walker == null) {
            return newnode;
        }
        if (newnode.getVal() < walker.getVal()) {
            walker.left = insert(walker.left, newnode);
        } else {
            walker.right = insert(walker.right, newnode);
        }
        return walker;
    }

    // build the tree by inserting each input value in order
    public Node buildLevelOrder(Integer[] arr) {
        for (int value : arr) {
            root = insert(root, new Node(value));
        }
        return root;
    }

    // start DFS with an empty current path
    public ArrayList<ArrayList<Integer>> findPaths() {
        ArrayList<ArrayList<Integer>> allPaths = new ArrayList<>();
        dfs(root, new ArrayList<>(), allPaths);
        return allPaths;
    }

    // append current node, recurse into kids, and pop on the way out
    private void dfs(Node walker, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> allPaths) {
        if (walker == null) {
            return;
        }
        path.add(walker.getVal());
        // leaf -> capture the path
        if ((walker.left == null && walker.right == null)) {
            allPaths.add(new ArrayList<>(path));
        } else {
            dfs(walker.left, path, allPaths);
            dfs(walker.right, path, allPaths);
        }
        path.removeLast(); // pop while backtracking
    }
}
