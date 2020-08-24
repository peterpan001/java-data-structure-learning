package com.panli.sword.offer._0007;


import com.panli.sword.offer.domain.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lipan
 * @date 2020-08-23
 * @desc 重建二叉树:先序遍历：根左右；中序遍历：左根右；后序遍历：左右根；其中先序遍历和中序遍历可以唯一确定一颗二叉树，中序遍历和后序遍历也可以唯一确定一颗二叉树
 */
public class Main {


    /**
     * 借助递归与List集合：由先序与中序遍历确定一颗二叉树
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree_1(int[] preorder, int[] inorder) {
        List<Integer> preorderList = new ArrayList<Integer>(); // 声明List存入先序数组
        List<Integer> inorderList = new ArrayList<Integer>(); // 声明List存入中序数组
        for (int i = 0; i < preorder.length; i++) {
            preorderList.add(preorder[i]);
            inorderList.add(inorder[i]);
        }
        return helper(preorderList, inorderList); // 开始构建二叉树
    }

    private TreeNode helper(List<Integer> preorderList, List<Integer> inorderList) {
        if (inorderList.size() == 0) { // 截止条件
            return null;
        }
        int rootval = preorderList.remove(0); // 先序遍历，第一个元素为根节点
        int mid = inorderList.indexOf(rootval); // 中序遍历，根节点在数组中间，左边为root的左孩子节点，右边为root的右孩子节点
        TreeNode root = new TreeNode(rootval);
        root.left = helper(preorderList, inorderList.subList(0, mid)); // 递归遍历计算出左子树
        root.right = helper(preorderList, inorderList.subList(mid + 1, inorderList.size())); // 递归遍历计算出右子树
        return root; // 返回二叉树根节点
    }


    /**
     * 借助递归和HashMap：由先序和中序遍历确定一颗二叉树，因为二叉树节点元素不相同，故可以借助HashMap来建立二叉树
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree_2(int[] preorder, int[] inorder) {
        Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>(); // 将中序遍历结果构建HashMap结构，key为元素，value为索引
        for (int i = 0; i < preorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, indexMap);
    }

    /**
     * 构建二叉树
     *
     * @param preorder
     * @param preorderStart
     * @param preorderEnd
     * @param inorder
     * @param inorderStart
     * @param inorderEnd
     * @param indexMap
     * @return
     */
    private TreeNode helper(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int inorderStart, int inorderEnd, Map<Integer, Integer> indexMap) {
        if (preorderStart > preorderEnd) { // 如果preorderStart>preorderEnd，则返回null
            return null;
        }
        int rootVal = preorder[preorderStart]; // 获取中序遍历的根节点索引，左边为左子树，右边为右子树
        TreeNode root = new TreeNode(rootVal); // 创建根节点
        if (preorderStart == preorderEnd) { // 如果preorderStart=preorderEnd，返回当前节点
            return root;
        } else {
            Integer rootIndex = indexMap.get(rootVal); // 获取中序遍历根节点索引
            int leftNodes = rootIndex - inorderStart, rightNodes = inorderEnd - rootIndex; // 求出左/右节点孩子元素个数
            // 左节点 = helper(先序数组，先序索引+1，先序+左节点个数，中序数组，中序索引，中序左半部分，中序map)
            root.left = helper(preorder, preorderStart + 1, preorderStart + leftNodes, inorder, inorderStart, rootIndex - 1, indexMap);
            // 右节点 = helper(先序数组，先序右半部分，先序末尾，中序数组，中序右边部分，中序末尾，中序map)
            root.right = helper(preorder, preorderEnd - rightNodes + 1, preorderEnd, inorder, rootIndex + 1, inorderEnd, indexMap);
            return root; // 返回根节点
        }
    }
}
