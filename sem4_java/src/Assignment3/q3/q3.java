// Name - Biprarshi Biswas
// Roll No - 002410501094
// BCSE-II A3

// Question:
// Given preorder and inorder traversal outcomes of a family tree, construct and return
// the corresponding binary tree. If two nodes in the tree has the same depth then they
// are cousins. So, print the names who are cousins in generations of the family history.
// Try to use java collections classes and functions as much as you can.

package Assignment3.q3;

import java.util.*;

public class q3 {

    // inner node class - each one holds a name and two children
    static class Node {
        String name;
        Node left, right;
        Node(String name) { this.name = name; }
    }

    // lookup map so we can find inorder positions in O(1)
    static Map<String, Integer> inorderIndex = new HashMap<>();
    static int preIdx = 0;

    // rebuild the tree using standard preorder+inorder reconstruction
    static Node build(String[] preorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;

        // next preorder item is the root of this subtree
        String rootName = preorder[preIdx++];
        Node root = new Node(rootName);

        int mid = inorderIndex.get(rootName);
        // everything before mid in inorder is the left subtree
        root.left  = build(preorder, inStart, mid - 1);
        // everything after mid is the right subtree
        root.right = build(preorder, mid + 1, inEnd);
        return root;
    }

    // BFS layer-by-layer, grouping names by their depth
    static Map<Integer, List<String>> groupByDepth(Node root) {
        Map<Integer, List<String>> levels = new LinkedHashMap<>();
        if (root == null) return levels;

        Queue<Node> queue = new ArrayDeque<>();
        Queue<Integer> depths = new ArrayDeque<>();
        queue.add(root);
        depths.add(0);

        // standard BFS, carrying depth in a parallel queue
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int d = depths.poll();
            levels.computeIfAbsent(d, k -> new ArrayList<>()).add(cur.name);

            if (cur.left  != null) { queue.add(cur.left);  depths.add(d + 1); }
            if (cur.right != null) { queue.add(cur.right); depths.add(d + 1); }
        }
        return levels;
    }

    public static void main(String[] args) {
        // sample family - root A, children B & C, grand-children D E F G
        String[] preorder = {"A", "B", "D", "E", "C", "F", "G"};
        String[] inorder  = {"D", "B", "E", "A", "F", "C", "G"};

        // index the inorder array for quick lookup during reconstruction
        for (int i = 0; i < inorder.length; i++) inorderIndex.put(inorder[i], i);

        Node root = build(preorder, 0, inorder.length - 1);

        Map<Integer, List<String>> levels = groupByDepth(root);

        // generation 0 = root - no cousins possible at this level
        System.out.println("Cousins by generation:");
        for (var entry : levels.entrySet()) {
            int gen = entry.getKey();
            List<String> names = entry.getValue();
            if (gen == 0 || names.size() < 2) continue;
            System.out.println("Generation " + gen + ": " + names);
        }
    }
}
