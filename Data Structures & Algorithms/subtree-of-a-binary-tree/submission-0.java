class Solution {  
    public boolean check(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null) {
            return true;
        }
        if(root == null || subRoot == null) {
            return false;
        }
        if(root.val == subRoot.val){
           return check(root.left, subRoot.left) && check(root.right, subRoot.right);
        }
        else{
            return false;
        }
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if(check(root, subRoot)){
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}