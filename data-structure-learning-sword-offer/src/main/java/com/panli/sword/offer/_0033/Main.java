package com.panli.sword.offer._0033;

/**
 * @author lipan
 * @date 2020-09-01
 * @desc 二叉搜索树的后续遍历序列
 */
public class Main {

    /**
     * 递归解决此问题
     *
     * @param postorder
     * @return
     */
    public boolean verifyPostorder_1(int[] postorder) {
        return verifyPostorder(postorder, 0, postorder.length - 1);
    }

    private boolean verifyPostorder(int[] postorder, int left, int right) {
        if (left >= right) { // 如果左指针大于等于右指针，说明已经校验完毕，满足后续二叉搜索树的要求
            return true;
        }
        int rootVal = postorder[right]; // 获取二叉搜索树的跟节点值
        int mid = left; // 查找二叉搜索树的右孩子节点下标
        while (postorder[mid] < rootVal) {
            mid++;
        }
        int tmp = mid; //二叉搜索树的右孩子第一个元素下标
        while (tmp < right) {
            if (postorder[tmp++] < rootVal) { // 二叉搜索树的右孩子都会大于跟节点值，如果小于则不满足二叉搜索树
                return false;
            }
        }
        // 递归的遍历以跟节点左右孩子为跟节点的左右子树是否满足二叉搜索树
        return verifyPostorder(postorder, left, mid - 1) && verifyPostorder(postorder, mid, right - 1);
    }
}
