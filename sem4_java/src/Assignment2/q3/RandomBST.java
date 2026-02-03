package Assignment2.q3;

import java.util.*;

public class RandomBST {
    private Node root;
    private Random random = new Random();

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

    public Node buildLevelOrder(Integer[] arr) {
        for (int value : arr) {
            root = insert(root, new Node(value));
        }
        return root;
    }

    public ArrayList<ArrayList<Integer>> findPaths() {
        ArrayList<ArrayList<Integer>> allPaths = new ArrayList<>();
        dfs(root , new ArrayList<>() , allPaths);
        return allPaths;
    }

    private void dfs(Node walker , ArrayList<Integer> path , ArrayList<ArrayList<Integer>> allPaths){
        if(walker == null) {
            return;
        }
        path.add(walker.getVal());
        if((walker.left==null && walker.right==null)) {
            allPaths.add(new ArrayList<>(path));
        }
        else {
            dfs(walker.left , path , allPaths);
            dfs(walker.right , path , allPaths);
        }
        path.removeLast(); // pop while backtracking
    }
}
