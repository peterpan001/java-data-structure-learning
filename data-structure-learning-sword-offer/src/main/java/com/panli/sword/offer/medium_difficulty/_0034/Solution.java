package com.panli.sword.offer.medium_difficulty._0034;

import com.panli.sword.offer.domain.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author lipan
 * @date 2021-04-11
 */
public class Solution {

    LinkedList<List<Integer>> list = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) {
            return list;
        }
        recur(root, target);
        return list;
    }

    private void recur(TreeNode node, int target) {
        if (node == null) {
            return;
        }
        path.add(node.val);
        target -= node.val;
        if (target == 0 && node.left == null && node.right == null) {
            list.add(new LinkedList(path)); // 下面回溯会移除 path 里面的元素
        }
        recur(node.left, target);
        recur(node.right, target);
        path.removeLast();
    }
}
