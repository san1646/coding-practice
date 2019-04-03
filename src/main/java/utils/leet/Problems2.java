package utils.leet;

public class Problems2 {

    int sum = 0;
        public int rangeSumBST(TreeNode root, int L, int R) {
            inOrderTraversal(root, L, R);
            return sum;
        }

        /*      11
                5
                3
                2
                4
                6
                7
                8
                12
                11
                14*/
        private void inOrderTraversal(TreeNode root, int L, int R) {
            if (root == null) {
                return;
            }
            if(root.val >=L && root.val <=R){
                sum += root.val;
            }

            if (root.left != null) {
                inOrderTraversal(root.left, L, R);
            }
            if (root.right != null) {
                inOrderTraversal(root.right, L, R);
            }
        }

}
