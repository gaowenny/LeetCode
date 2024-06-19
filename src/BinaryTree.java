
import Common.TreeNode;

import java.util.*;
import java.util.stream.Collectors;



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
    // 递归前序遍历
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
    //非递归最小深度深度遍历（后序）
    public int minDepthEx(TreeNode root){
        int min = Integer.MAX_VALUE, level = 0;
        if (root == null){
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode last = root;
        while (!stack.isEmpty() || root != null){
            while (root != null){
                stack.push(root);
                level++;
                root = root.left;
            }
            if (!stack.isEmpty()){
                root = stack.pop();
                if (root.right == null || root.right == last){
                    if (root.left == null && root.right == null){
                        min = Math.min(level, min);
                    }
                    last = root;
                    level--;
                    root = null;
                }else {
                    stack.push(root);
                    root = root.right;
                }
            }
        }
        return min;
    }
    //非递归最小深度之广度遍历
    public int minDepthEEx(TreeNode root){
        int min = Integer.MAX_VALUE, level = 0;
        if (root == null){
            return 0;
        }
        Queue<Map.Entry<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new AbstractMap.SimpleEntry<TreeNode, Integer>(root, 1));
        while (!queue.isEmpty()){
            Map.Entry<TreeNode, Integer> temp = queue.poll();
            root = temp.getKey();
            level = temp.getValue();
            if (root.right == null && root.left == null){
                return level;
            }
            if (root.left != null){
                queue.offer(new AbstractMap.SimpleEntry<TreeNode, Integer>(root.left, level + 1));
            }
            if (root.right != null){
                queue.offer(new AbstractMap.SimpleEntry<TreeNode, Integer>(root.right, level + 1));
            }
        }
        return 0;
    }
    int maxSum = Integer.MIN_VALUE;
    private int doGetMax(TreeNode root){
        if(root == null){
            return  0;
        }
        int left = Math.max(0, doGetMax(root.left));
        int right = Math.max(0, doGetMax(root.right));
        maxSum = Math.max(maxSum, left+right+root.val);
        return Math.max(right, left) + root.val;
    }
    public int maxPathSum(TreeNode root) {
        int n = doGetMax(root);
        return maxSum;
    }
    //112. 路径总和 I 递归
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null){
            return false;
        }
        if (root.left == null && root.right == null){
            return targetSum == root.val;
        }
        return hasPathSum(root.left, targetSum - root.val) ||
                hasPathSum(root.right, targetSum - root.val);
    }
    //112. 路径总和 I 非递归 深度遍历
    public boolean hasPathSumEx(TreeNode root, int targetSum) {
        boolean bResult  = false;
        if (root == null){
            return bResult;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode last = root;
        Integer tempSum = 0;
        while (root != null || !stack.isEmpty()){
            while (root != null){
                tempSum = tempSum + root.val;
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()){
                root = stack.pop();
                if (root.right == null || root.right == last){
                    if (root.left == null && root.right == null){
                        if(tempSum == targetSum){
                            bResult = true;
                            break;
                        }
                    }
                    tempSum = tempSum - root.val;
                    last = root;
                    root = null;
                }else{
                    if (root.right != null){
                        stack.push(root);
                        root = root.right;
                    }
                }
            }
        }
        return bResult;
    }
    //112. 路径总和 I 非递归 广度
    public boolean hasPathSumEEx(TreeNode root, int targetSum) {
        boolean bResult = false;
        if (root == null){
            return bResult;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> sumQueue = new LinkedList<>();
        queue.offer(root);
        sumQueue.offer(root.val);
        while (!queue.isEmpty()){
            root = queue.poll();
            Integer tempSum = sumQueue.poll();
            if (root.right == null && root.left == null){
                if (tempSum == targetSum){
                    bResult = true;
                    break;
                }
            }else {
                if(root.left != null){
                    queue.offer(root.left);
                    sumQueue.offer(tempSum + root.left.val);
                }
                if (root.right != null){
                    queue.offer(root.right);
                    sumQueue.offer(tempSum + root.right.val);
                }
            }
        }
        return bResult;
    }
    //113. 路径总和 II 递归
    List<List<Integer>> sumList = new LinkedList<>();
    Deque<Integer> tempList = new LinkedList<>();
    private void doPathSum(TreeNode root, int targetSum){
        if(root == null){
            return;
        }
        tempList.offer(root.val);
        if (root.left == null && root.right == null && targetSum == root.val){
            sumList.add(new LinkedList<>(tempList));
        }
        doPathSum(root.left, targetSum - root.val);
        doPathSum(root.right, targetSum - root.val);
        tempList.pollLast();
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        doPathSum(root, targetSum);
        return sumList;
    }
    //113. 路径总和 II 深度遍历
    public List<List<Integer>> pathSumEx(TreeNode root, int targetSum) {
        List<List<Integer>> sumList = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode last = root;
        Deque<Integer> tempList = new LinkedList<>();
        int tempSum = 0;
        if (root == null){
            return sumList;
        }
        while(root != null || !stack.isEmpty()){
            while(root != null){
                tempSum = tempSum + root.val;
                tempList.offer(root.val);
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()){
                root = stack.pop();
                if (root.right == null || root.right == last){
                    if (root.left == null && root.right == null){
                        if (tempSum  == targetSum){
                            sumList.add(new LinkedList<>(tempList));
                        }
                    }
                    tempList.pollLast();
                    tempSum = tempSum - root.val;
                    last = root;
                    root = null;
                }else {
                    stack.push(root);
                    root = root.right;
                }
            }
        }
        return sumList;
    }

    //113. 路径总和 II 广度遍历
    Map<TreeNode, TreeNode> map = new HashMap<>();
    private void getPath(TreeNode root){
       List<Integer> list = new LinkedList<>();
       while (root != null){
           list.add(root.val);
           root = map.get(root);
       }
       Collections.reverse(list);
       sumList.add(list);
    }
    public List<List<Integer>> pathSumEEx(TreeNode root, int targetSum) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> sumQueue = new LinkedList<>();
        if (root == null){
            return sumList;
        }
        queue.offer(root);
        sumQueue.offer(root.val);
        while (!queue.isEmpty()){
            root = queue.poll();
            int temp = sumQueue.poll();
            if (root.right == null && root.left == null){
                if (temp == targetSum){
                    getPath(root);
                }
            }
            else {
                if (root.left != null) {
                    queue.offer(root.left);
                    sumQueue.offer( temp + root.left.val);
                    map.put(root.left, root);
                }
                if (root.right != null) {
                    queue.offer(root.right);
                    sumQueue.offer( temp + root.right.val);
                    map.put(root.right, root);
                }
            }
        }
        return sumList;
    }
    //257. 二叉树的所有路径
    List<String> binaryList = new LinkedList<>();
    private void doBinaryTreePaths(TreeNode root, String path){
        if (root == null){
            return ;
        }
        StringBuffer buffer = new StringBuffer(path);
        buffer.append(root.val);
        if(root.right == null && root.left == null){
            binaryList.add(buffer.toString());
        }else {
            buffer.append("->");
            doBinaryTreePaths(root.left, buffer.toString());
            doBinaryTreePaths(root.right, buffer.toString());
        }
    }
    public List<String> binaryTreePaths(TreeNode root) {
        doBinaryTreePaths(root, "");
        return binaryList;
    }
    //剑指 Offer 27. 二叉树的镜像   226. 翻转二叉树
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null){
            return root;
        }
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        root.right = left;
        root.left = right;
        return root;
    }

    public TreeNode mirrorTreeEx(TreeNode root){
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return root;
    }
    public TreeNode mirrorTreeEEx(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                TreeNode temp = root.left;
                root.left = root.right;
                root.right = temp;
                root = root.left;
            }
            if (!stack.isEmpty()){
                root = stack.pop();
                root = root.right;
            }
        }
        return node;
    }
    //剑指 Offer 32 - II. 从上到下打印二叉树 II
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> listList = new LinkedList<>();
        if (root == null){
            return listList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> temp = new LinkedList<>();
            int size = queue.size();
            while (size!=0) {
                size--;
                root = queue.poll();
                temp.add(root.val);
                if (root.left != null) {
                    queue.offer(root.left);
                }
                if (root.right != null) {
                    queue.offer(root.right);
                }
            }
            listList.add(temp);
        }
        return listList;
    }
    public Integer getDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        if (root.right == null && root.left == null){
            return 1;
        }
        Integer max = 0;
        if (root.left != null){
            max = Math.max(max, getDepth(root.left) + 1);
        }
        if (root.right != null){
            max =  Math.max(max, getDepth(root.right) +1);
        }
        return max;
    }
//110. 平衡二叉树
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(Math.abs(getDepth(node.right)-getDepth(node.left)) > 1){
                return false;
            }
            if (node.right != null) queue.offer(node.right);
            if (node.left != null) queue.offer(node.left);
        }
        return true;
    }
    private TreeNode getTreeNode(int begin, int end, int[] nums){
        if (end < begin)
            return null;
        int mid = begin + (end - begin) /2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = getTreeNode(begin, mid - 1, nums);
        node.right = getTreeNode(mid + 1, end, nums);
        return node;
    }
//108. 将有序数组转换为二叉搜索树
    public TreeNode sortedArrayToBST(int[] nums) {
        return getTreeNode(0, nums.length - 1, nums);
    }
    public TreeNode findNum(TreeNode root, int num){
        if (root == null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node.val == num){
                return node;
            }
            if (node.val > num && node.left != null) queue.offer(node.left);
            if (node.val < num && node.right != null) queue.offer(node.right);
        }
        return null;
    }
    //653 两数之和 IV - 输入 BST
    public boolean findTarget(TreeNode root, int k) {
        if (root == null){
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            int temp = k - node.val;
            TreeNode treeNode = findNum(root, temp);
            if(treeNode != null && treeNode != node){
                return true;
            }
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return false;
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode root = null;
        if (root1 != null && root2 != null){
            root = new TreeNode(root1.val + root2.val, mergeTrees(root1.left, root2.left) ,mergeTrees(root1.right, root2.right));
        } else if (root1 != null){
            root = new TreeNode(root1.val, root1.left, root1.right);
        }
        else if (root2 != null){
            root = new TreeNode(root2.val, root2.left, root2.right);
        }
        return root;
    }
//101. 对称二叉树
    private boolean isSymmetric(TreeNode root1, TreeNode root2){
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val && (isSymmetric(root1.left, root2.right)) && (isSymmetric(root1.right, root2.left)) )
             return true;
        }
        return false;
    }
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }


    public boolean isSymmetricEx(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> left = new LinkedList<>();
        List<Integer> right = new LinkedList<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
            }
        }
        return false;
    }

    public boolean isSymmetricEEx(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if (node1 == null && node2 == null) continue;
            if (node1 == null || node2 == null || node1.val != node2.val)return false;
            queue.offer(node1.left);
            queue.offer(node2.right);
            queue.offer(node1.right);
            queue.offer(node2.left);
        }
        return true;
    }
    // 层序遍历II
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> listList = new LinkedList<>();
        if (root == null) {
            return listList;
        }
        Queue<Map.Entry<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new AbstractMap.SimpleEntry<>(root, 0));
        List<Integer> list = new LinkedList<>();
        list.add(root.val);
        listList.addFirst(list);
        int level = 0;
        while(!queue.isEmpty()){
            Map.Entry<TreeNode, Integer> node = queue.poll();
            if (node.getKey().left == null && node.getKey().right == null){
                continue;
            }
            List<Integer> tempList;
            if (level == node.getValue()){
                tempList = new LinkedList<>();
                listList.addFirst(tempList);
            }else {
                tempList = listList.get(0);
            }
            level = node.getValue() + 1;
            if (node.getKey().left != null) {
                tempList.add(node.getKey().left.val);
                queue.offer(new AbstractMap.SimpleEntry<>(node.getKey().left, level));
            }
            if (node.getKey().right != null){
                tempList.add(node.getKey().right.val);
                queue.offer(new AbstractMap.SimpleEntry<>(node.getKey().right, level));
            }
        }
        return listList;
    }
//98恢复二叉搜索树
    public void recoverTree(TreeNode root) {
        List<Integer> list = inorderTraversal(root);
        int x = -1, y = -1;

        for (int i = 0; i < list.size() -1; i++){
            if (list.get(i) > list.get(i+1)){
                if (x == -1){
                    x = i;
                }else y = i;
            }
        }
        if(y == -1){
            y = list.get(x+1);
        }else {
            y = list.get(y+1);
        }
        x = list.get(x);
        doRecoverTree(root, x, y);
    }
    private void doRecoverTree(TreeNode root, int x, int y){
        if (root == null)
            return;
        if(root.val == x){
            root.val = y;
        }else if(root.val == y){
            root.val = x;
        }
        doRecoverTree(root.left, x, y);
        doRecoverTree(root.right, x, y);
    }
    public void recoverTreeEx(TreeNode root){
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        TreeNode x= null, y = null;
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()){
                root = stack.pop();
                if (pre != null && (pre.val) >root.val){
                    y = root;
                    if (x == null){
                        x = pre;
                    }else break;
                }
                result.add(root.val);
                pre = root;
                root = root.right;
            }
        }
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }
//114转为链表
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.left);
        flatten(root.right);
        if(root.left != null && root.left.left == null){
            TreeNode temp = root.right;
            root.right = root.left;
            TreeNode node = root.left;
            while (node.right != null){
                node = node.right;
            }
            node.right = temp;
            root.left = null;
        }
    }

    private LinkNode getMidNode(LinkNode begin, LinkNode end){
        LinkNode fast = begin;
        LinkNode slow = begin;
        while (fast != end && fast.next != end){
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
    private TreeNode buildBST(LinkNode<Integer> begin, LinkNode end){
        LinkNode<Integer> mid = getMidNode(begin, end);
        TreeNode node = new TreeNode(mid.val);
        node.left = buildBST(begin, mid);
        node.right = buildBST(mid.next, end);
        return node;
    }
    public TreeNode sortedListToBST(LinkNode head) {
       return buildBST(head, null);
    }
//103. 二叉树的锯齿形层序遍历
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> listList = new LinkedList<>();
        if (root == null){
            return listList;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        boolean judge = true;
        while (!queue.isEmpty()){
            List<Integer> temp = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++){
                if (judge){
                    root = queue.pollFirst();
                    temp.add(root.val);
                    if (root.left != null) {
                        queue.addLast(root.left);
                    }
                    if (root.right != null) {
                        queue.addLast(root.right);
                    }
                }else {
                    root = queue.pollLast();
                    temp.add(root.val);
                    if (root.right != null) {
                        queue.addFirst(root.right);
                    }
                    if (root.left != null) {
                        queue.addFirst(root.left);
                    }
                }
            }
            judge = !judge;
            listList.add(temp);
        }
        return listList;
    }
    private TreeNode buildTree(List<Integer> inOrder, List<Integer> postOrder){
        if (postOrder.size() == 0){
            return null;
        }
        TreeNode root = new TreeNode(postOrder.get(postOrder.size()-1));
        int nIndex = inOrder.indexOf(root.val);
        List<Integer> leftInOrder = inOrder.subList(0, nIndex);
        List<Integer> rightInOrder = inOrder.subList(nIndex+1, inOrder.size());
        List<Integer> leftPostOrder = postOrder.subList(0, leftInOrder.size());
        List<Integer> rightPostOrder = postOrder.subList(leftPostOrder.size(), postOrder.size()-1);
        root.right = buildTree(rightInOrder, rightPostOrder);
        root.left = buildTree(leftInOrder, leftPostOrder);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        List<Integer> inOrderList = Arrays.stream(inorder).boxed().collect(Collectors.toList());
        List<Integer> postOrderList = Arrays.stream(postorder).boxed().collect(Collectors.toList());
        return buildTree(inOrderList, postOrderList);
    }
    //8,6,10,5,7,9,11
    public static void main(String[] args){
        BinaryTree tree = new BinaryTree();
        TreeNode root = new TreeNode(8);
        TreeNode right = new TreeNode(10);
        TreeNode left = new TreeNode(6);
        root.right = right;
        root.left = left;
        left.left = new TreeNode(5);
        left.right = new TreeNode(7);
        right.left = new TreeNode(9);
        right.right = new TreeNode(11);

        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(1);
        //root1.left.right = new TreeNode(5);
        root1.right = new TreeNode(4);
        root1.right.left = new TreeNode(2);
        root1.right.right = new TreeNode(5);
        int[] inOrder = {9,3,15,20,7};
        int[] postOrder = {9,15,7,20,3};
        TreeNode node  = tree.buildTree(inOrder, postOrder);
        System.out.println(node.val);
    }
}
