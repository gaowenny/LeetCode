import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BinaryTree{
    // 二叉树深度 非递归
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;

        Stack<Pair<TreeNode, Integer>> stack = new Stack<Pair<TreeNode, Integer>>();
        if (root != null){
            stack.push(new Pair(root, 1));
        }
        int nDepth = 0;

        while (!stack.empty()){
            Pair<TreeNode, Integer> current = stack.pop();
            int nCurrentDepth = current.getValue();
            TreeNode p = current.getKey();
            if(p != null){
                nDepth = nDepth > nCurrentDepth ? nDepth: nCurrentDepth;
                stack.push(new Pair(p.left, nCurrentDepth + 1));
                stack.push(new Pair(p.right, nCurrentDepth + 1));
            }
        }
        return nDepth;
    }
    // 二叉树深度 递归
    public int maxDepthRecursive(TreeNode root){
        if(root == null)
            return 0;
        return Math.max(maxDepthRecursive(root.left), maxDepthRecursive(root.right)) + 1;
    }

    //深度遍历找叶子节点 非递归
    public ArrayList<Integer> getLeafs(TreeNode root){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root != null){
            stack.push(root);
        }
        while (!stack.empty()){
            TreeNode p = stack.pop();
            if(p.left != null || p.right != null){
                if (p.right != null)
                    stack.push(p.right);
                if(p.left != null)
                    stack.push(p.left);
            }else {
                result.add(p.val);
            }
        }
        return result;
    }
    public void dfs(TreeNode node, ArrayList<Integer> leafValues){
        if(node != null){
            if(node.right == null && node.left == null)
                leafValues.add(node.val);
            dfs(node.left, leafValues);
            dfs(node.right, leafValues);
        }
    }

    //叶子相似二叉树
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> leafs1 = getLeafs(root1);
        ArrayList<Integer> leafs2 = getLeafs(root2);

        int nLength = Math.min(leafs1.size(), leafs2.size());
        for(int i = 0; i < nLength; i++){
            if(leafs1.get(i) != leafs2.get(i)){
                return false;
            }
        }
        return true;
    }

    public boolean leafSimilarOffical(TreeNode root1, TreeNode root2){
        ArrayList<Integer> leaves1 = new ArrayList();
        ArrayList<Integer> leaves2 = new ArrayList();
        dfs(root1, leaves1);
        dfs(root2, leaves2);
        return leaves1.equals(leaves2);
    }

    public static void main(String[] args){


    }
}
