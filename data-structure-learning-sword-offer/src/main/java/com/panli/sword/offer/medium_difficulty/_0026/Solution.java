package com.panli.sword.offer.medium_difficulty._0026;

import com.panli.sword.offer.domain.TreeNode;

/**
 * 树的子结构
 *
 * @author lipan
 * @date 2021-04-05
 */
public class Solution {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null){
            return false;
        }
        return isSubTree(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean isSubTree(TreeNode nodeA, TreeNode nodeB){
        if(nodeB == null){
            return true;
        }
        if(nodeA == null || nodeA.val != nodeB.val){
            return false;
        }
        return isSubTree(nodeA.left, nodeB.left) && isSubTree(nodeA.right, nodeB.right);
    }
}
