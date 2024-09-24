package TreePrac;
import java.util.*;
public class ZigZagPrint {



    public static void main(String[] args) {
        TreeNode root=new TreeNode(1,new TreeNode(2),new TreeNode(3));
        root.left.left=new TreeNode(4,new TreeNode(8),new TreeNode(9));
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6,new TreeNode(10),new TreeNode(11));
        root.right.right=new TreeNode(7);
        List<List<Integer>> zigZagVal=zigzagLevelOrder(root);
        for(List<Integer> listVal:zigZagVal){
            System.out.println(Arrays.toString(listVal.toArray()));
        }

    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean reverse = false;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);
            for (int i=0; i < levelSize; i++) {
                if (!reverse) {
                    TreeNode currentNode = queue.pollFirst();
                    currentLevel.add(currentNode.val);
                    if (currentNode.left != null) {
                        queue.addLast(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        queue.addLast(currentNode.right);
                    }
                } else {
                    TreeNode currentNode = queue.pollLast();
                    currentLevel.add(currentNode.val);
                    if (currentNode.right != null) {
                        queue.addFirst(currentNode.right);
                    }
                    if (currentNode.left != null) {
                        queue.addFirst(currentNode.left);
                    }
                }
            }
            reverse = !reverse;
            result.add(currentLevel);
        }
        return result;
    }
}
