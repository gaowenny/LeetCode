import Common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Codec {
    private TreeNode getTreeNode(List<String> list){
        Queue<TreeNode> queue = new LinkedList<>();
        return null;
    }
    public List<String> levelOrder(TreeNode root) {
       List<String> list = new LinkedList<>();
        if (root == null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size!=0) {
                size--;
                root = queue.poll();
                if (root == null){
                    list.add("");
                    continue;
                }
                list.add(String.valueOf(root.val));
                if (root.right == null && root.left == null){
                    continue;
                }
                queue.offer(root.left);
                queue.offer(root.right);
            }
        }
        if (list.get(list.size() - 1).isEmpty()){
            list.remove(list.size() - 1);
        }
        return list;
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list = levelOrder(root);
        return String.join(",", list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()){
            return null;
        }
        return null;
    }

    public static void main(String[] args){
        Codec codec = new Codec();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(0);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(1);
        String s = codec.serialize(root);
        TreeNode treeNode = codec.deserialize(s);
    }
}