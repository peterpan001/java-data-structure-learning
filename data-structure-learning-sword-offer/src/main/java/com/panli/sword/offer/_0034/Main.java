package com.panli.sword.offer._0034;

import com.panli.sword.offer.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lipan
 * @date 2020-09-02
 * @desc 二叉树中和为某一值的路径
 * @solution 此方法的思路都是减去当前节点值，看叶子结点是否为剩余sum值；还可以路径节点元素值相加与sum值进行比较
 */
public class Main {

    /**
     * 使用递归深度优先遍历算法，在每遍历一个节点就将当前sum值减去当前节点值，直到叶子节点，如果叶子节点值等于剩余sum值则此路径满足
     * 放入子list中，再将子list放入list中
     *
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum_1(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfsPathSum_1(root, sum, new ArrayList<Integer>(), result);
        return result;
    }

    private void dfsPathSum_1(TreeNode root, int sum, List<Integer> list, List<List<Integer>> result) {
        if (root == null) { // 临界条件，如果节点为空，直接返回
            return;
        }
        List<Integer> subList = new ArrayList<Integer>(list); // list为引用传递，故为避免修改原分支，此处需要新声明一个subList
        subList.add(root.val); // 将节点值放入subList中
        if (root.left == null && root.right == null) { // 此时说明遍历到叶子节点了
            if (root.val == sum) { // 判断叶子节点是否等于剩余sum值，是则将此subList放入list中
                result.add(subList);
            }
            return; // 终止条件，返回
        }
        dfsPathSum_1(root.left, sum - root.val, subList, result); // 递归深度遍历左分支
        dfsPathSum_1(root.right, sum - root.val, subList, result); // 递归深度遍历右分支
    }


    /**
     * 使用递归回溯的方法解决此题
     *
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum_2(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfsPathSum_2(root, sum, new ArrayList<Integer>(), result);
        return result;
    }

    private void dfsPathSum_2(TreeNode root, int sum, List<Integer> list, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                result.add(new ArrayList<Integer>(list));
            }
            list.remove(list.size() - 1);
            return;
        }
        dfsPathSum_2(root.left, sum - root.val, list, result);
        dfsPathSum_2(root.right, sum - root.val, list, result);
        list.remove(list.size() - 1);
    }
}
