package Assignment3.q3;

import java.util.*;

public class q3 {

    static class Node {
        String name;
        Node left, right;
        Node(String name) { this.name = name; }
    }

    // index map for O(1) inorder lookup
    static Map<String, Integer> inorderIndex = new HashMap<>();
    static int preIdx = 0;

    static Node build(String[] preorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;

        String rootName = preorder[preIdx++];
        Node root = new Node(rootName);

        int mid = inorderIndex.get(rootName);
        root.left  = build(preorder, inStart, mid - 1);
        root.right = build(preorder, mid + 1, inEnd);
        return root;
    }

    // BFS, grouping names by depth
    static Map<Integer, List<String>> groupByDepth(Node root) {
        Map<Integer, List<String>> levels = new LinkedHashMap<>();
        if (root == null) return levels;

        Queue<Node> queue = new ArrayDeque<>();
        Queue<Integer> depths = new ArrayDeque<>();
        queue.add(root);
        depths.add(0);

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
        // sample family: root A, children B & C, then D E F G
        String[] preorder = {"A", "B", "D", "E", "C", "F", "G"};
        String[] inorder  = {"D", "B", "E", "A", "F", "C", "G"};

        for (int i = 0; i < inorder.length; i++) inorderIndex.put(inorder[i], i);

        Node root = build(preorder, 0, inorder.length - 1);

        Map<Integer, List<String>> levels = groupByDepth(root);

        // generation 0 = root, no cousins there
        System.out.println("Cousins by generation:");
        for (var entry : levels.entrySet()) {
            int gen = entry.getKey();
            List<String> names = entry.getValue();
            if (gen == 0 || names.size() < 2) continue;
            System.out.println("Generation " + gen + ": " + names);
        }
    }
}