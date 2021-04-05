package com.panli.sword.offer.medium_difficulty._0007;

import com.panli.sword.offer.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lipan
 * @date 2021-04-04
 */
public class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> preList = new ArrayList<Integer>();
        List<Integer> inList = new ArrayList<Integer>();
        for (int i = 0; i < preorder.length; i++) {
            preList.add(preorder[i]);
            inList.add(inorder[i]);
        }
        return buildTreeHandler(preList, inList);
    }

    private TreeNode buildTreeHandler(List<Integer> preList, List<Integer> inList) {
        if (inList.size() == 0) {
            return null;
        }
        int rootVal = preList.remove(0);
        int mid = inList.indexOf(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTreeHandler(preList, inList.subList(0, mid));
        root.right = buildTreeHandler(preList, inList.subList(mid + 1, inList.size()));
        return root;
    }
}
