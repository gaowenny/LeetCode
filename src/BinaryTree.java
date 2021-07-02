
import com.sun.source.tree.Tree;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

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

//        Stack<Pair<TreeNode, Integer>> stack = new Stack<Pair<TreeNode, Integer>>();
//        if (root != null){
//            stack.push(new Pair(root, 1));
//        }
//        int nDepth = 0;
//
//        while (!stack.empty()){
//            Pair<TreeNode, Integer> current = stack.pop();
//            int nCurrentDepth = current.getValue();
//            TreeNode p = current.getKey();
//            if(p != null){
//                nDepth = nDepth > nCurrentDepth ? nDepth: nCurrentDepth;
//                stack.push(new Pair(p.left, nCurrentDepth + 1));
//                stack.push(new Pair(p.right, nCurrentDepth + 1));
//            }
//        }
//        return nDepth;
        return 0;
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
    // 非递归前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null){
            return result;
        }
        result.add(root.val);
        if (root.left != null){
            result.addAll(preorderTraversal(root.left));
        }
        if (root.right != null){
            result.addAll(preorderTraversal(root.right));
        }
        return result;
    }
   // 非递归前序遍历
    public List<Integer> preorderTraversalEx(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()){
            while (root != null){
                result.add(root.val);
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()){
                root = stack.pop();
                root = root.right;
            }
        }
        return result;
    }
    //94 中序
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null){
            return result;
        }
        if (root.left!= null){
            result.addAll(inorderTraversal(root.left));
        }
        result.add(root.val);
        if (root.right != null){
            result.addAll(inorderTraversal(root.right));
        }
        return result;
    }
    // 中序非递归
    public List<Integer> inorderTraversalEx(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()){
                root = stack.pop();
                result.add(root.val);
                root = root.right;
            }
        }
        return result;
    }
    // 145后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null){
            return result;
        }
        if (root.left != null){
            result.addAll(postorderTraversal(root.left));
        }
        if (root.right != null){
            result.addAll(postorderTraversal(root.right));
        }
        result.add(root.val);
        return result;
    }
    // 后序遍历非递归
    public List<Integer> postorderTraversalEx(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode last = root;
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()){
                root = stack.pop();
                if (root.right == null || root.right == last ){
                    result.add(root.val);
                    last = root;
                    root = null;
                }else {
                    stack.push(root);
                    root = root.right;
                }
            }
        }
        return result;
    }
    // 111最小深度
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.right == null && root.left == null){
            return 1;
        }
        int minDep = Integer.MAX_VALUE;
        if (root.right != null){
            minDep = Math.min(minDep, minDepth(root.right));
        }
        if (root.left != null){
              minDep = Math.min(minDep, minDepth(root.left));
        }
        return minDep + 1;
    }
    //非递归
    public int minDepthEx(){

        return 0;
    }
    public static void main(String[] args){
        BinaryTree tree = new BinaryTree();
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        TreeNode left = new TreeNode(3);
        root.right = right;
        right.left = left;
        int n = tree.minDepth(root);
        System.out.print(n);
    }
}
