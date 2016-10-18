/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
	private static int deep = 0;

	private void DFS(TreeNode node){
		if(node == null)	return;
		deep++;
		DFS(node.left);
	}

    public int countNodes(TreeNode root) {
        if(root == null)	return 0;
        deep = 0;
        DFS(root);
        int l = (int)Math.pow(2, deep-1), r = (int)Math.pow(2, deep) - 1;
        int pl = 0, pr = 0;
        while( l <= r){
        	if(l == pl && r == pl) break;
        	pl = l;
        	pr = r;
        	int mid = (l + r) >> 1;
        	int len = deep, t = mid;
        	
        	TreeNode p = root;
        	while(len > 1){
        		int isRight = mid & (1 << (len-2));
        		len--;
        		if(isRight > 0)	p = p.right;
        		else p = p.left;
        	}
        	if(p == null){
        		r = mid;
        	}else{
        		l = mid+1;
        	}
        }

        return l-1;
    }
}