package com.panli.sword.offer.medium_difficulty._0032_III;

import com.panli.sword.offer.domain.TreeNode;

import java.util.*;

/**
 * @author lipan
 * @date 2021-04-11
 */
public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int idx = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            idx++;
            List<Integer> subList = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                subList.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (idx % 2 == 0) {
                Collections.reverse(subList);
            }
            list.add(subList);
        }
        return list;
    }
}
