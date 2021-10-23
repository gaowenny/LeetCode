import Common.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Codec {
    private TreeNode buildTreeNode(String value){
        return value.isEmpty() ? null: new TreeNode(Integer.valueOf(value));
    }
    private TreeNode getTreeNode(List<String> list){
        if (list == null || list.isEmpty()){
            return null;
        }
        Integer index = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(list.get(index++)));
        queue.offer(root);
        while (index < list.size()){
            TreeNode parent = queue.poll();
            if (index == list.size() - 1){
                parent.left = buildTreeNode(list.get(index++));
                continue;
            }
            parent.left = buildTreeNode(list.get(index++));
            parent.right = buildTreeNode(list.get(index++));
            if (parent.left != null)
                queue.offer(parent.left);
            if (parent.right != null)
                queue.offer(parent.right);
        }
        return root;
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
                queue.offer(root.left);
                queue.offer(root.right);
            }
        }
        while (list.get(list.size() - 1).isEmpty()){
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
       String str[] = data.split(",");
        return getTreeNode(Arrays.asList(str));
    }

    public static void main(String[] args){
        Codec codec = new Codec();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(0);
        root.right = new TreeNode(5);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(3);
        root.right.left.right = new TreeNode(4);
        root.right.left.right.left  = new TreeNode(3);
        String s = codec.serialize(root);
        TreeNode treeNode = codec.deserialize(s);
        System.out.print(treeNode.val);
    }
}