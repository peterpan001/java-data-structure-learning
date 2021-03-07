package com.panli.sword.offer.medium_difficulty._0026;

import com.panli.sword.offer.domain.TreeNode;

/**
 * @author lipan
 * @date 2020-08-28
 * @desc 树的子结构
 */
public class Main {

    /**
     * 借助递归遍历两颗树，并比较其值是否相等，相等则是，否则则不是
     * 并且B是A的子树有三种可能，1：B是A的根节点的子树
     * 2: B是A的左孩子节点的子树
     * 3: B是A的右孩子节点的子树
     *
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) { // 临界值判断，如果其中一个为空则为false
            return false;
        }
        // isSubTree(A, B)：B是A的根节点的子树
        // isSubStructure(A.left, B): B是A的左孩子节点的子树
        // isSubStructure(A.right, B)：B是A的右孩子节点的子树
        return isSubTree(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    /**
     * 递归遍历判断两颗树的节点是否相同
     *
     * @param A
     * @param B
     * @return
     */
    private boolean isSubTree(TreeNode A, TreeNode B) {
        if (B == null) { // 如果B为null，说明B遍历结束，那么B是A的子树
            return true;
        }
        if (A == null || A.val != B.val) { // 如果A为null或者A的值不等于B的值，则说明B不是A的子树
            return false;
        }
        // 继续递归的遍历左节点和右节点
        return isSubTree(A.left, B.left) && isSubTree(A.right, B.right);
    }
}
