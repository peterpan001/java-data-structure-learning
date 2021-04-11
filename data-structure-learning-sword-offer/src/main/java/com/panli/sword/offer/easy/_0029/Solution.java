package com.panli.sword.offer.easy._0029;

/**
 * @author lipan
 * @date 2021-04-11
 */
public class Solution {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int rows = matrix.length, columns = matrix[0].length;
        int[] arr = new int[rows * columns];
        int idx = 0;
        int left = 0, right = columns - 1, up = 0, down = rows - 1;
        while (true) {
            // 从左向右遍历
            for (int i = left; i <= right; i++) {
                arr[idx++] = matrix[up][i];
            }
            if (++up > down) { // 如果上指针大于下指针结束
                break;
            }
            // 从上向下遍历
            for (int i = up; i <= down; i++) {
                arr[idx++] = matrix[i][right];
            }
            if (--right < left) {
                break;
            }
            // 从右向左遍历
            for (int i = right; i >= left; i--) {
                arr[idx++] = matrix[down][i];
            }
            if (--down < up) {
                break;
            }
            // 从下向上遍历
            for (int i = down; i >= up; i--) {
                arr[idx++] = matrix[i][left];
            }
            if (++left > right) {
                break;
            }
        }
        return arr;
    }
}
