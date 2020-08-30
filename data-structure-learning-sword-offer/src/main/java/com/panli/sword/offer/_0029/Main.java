package com.panli.sword.offer._0029;

/**
 * @author lipan
 * @date 2020-08-29
 * @desc 顺时针打印矩阵
 */
public class Main {

    /**
     * 顺时针打印矩阵只需控制好指针索引即可
     * @param matrix
     * @return
     */
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) { // 临界值判断
            return new int[0];
        }
        int row = matrix.length, column = matrix[0].length; // 获取二维数组行与列的值
        int nums[] = new int[row * column]; // 声明一维数组大小
        int up = 0, down = row - 1, left = 0, right = column - 1, index = 0; // 声明上下左右四个指针
        while (true) {
            // 上边行遍历，从左到右
            for (int i = left; i <= right; i++) {
                nums[index++] = matrix[up][i];
            }
            if (++up > down) { //如果上指针大于下指针结束
                break;
            }

            // 右边列遍历，从上到下
            for (int j = up; j <= down; j++) {
                nums[index++] = matrix[j][right];
            }
            if (--right < left) { // 如果右指针小于左指针结束
                break;
            }

            //下面行遍历，从右到左
            for (int i = right; i >= left; i--) {
                nums[index++] = matrix[down][i];
            }
            if (--down < up) { //如果下指针小于上指针结束
                break;
            }

            // 左边列遍历，从下到上
            for (int j = down; j >= up; j--) {
                nums[index++] = matrix[j][left];
            }
            if (++left > right) { //如果左指针大于右指针结束
                break;
            }
        }
        return nums;
    }
}
