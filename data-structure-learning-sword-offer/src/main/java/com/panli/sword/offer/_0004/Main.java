package com.panli.sword.offer._0004;

/**
 * @author lipan
 * @date 2020-08-21
 * @desc 二维数组中的查找
 */
public class Main {


    /**
     * 暴力破解法：直接遍历二维数组，查找是否有对应的元素
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray_1(int[][] matrix, int target) {
        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) { // 对数组进行校验
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == target){
                    return true;
                }
            }
        }
        return false; // 遍历结束，没有直接返回false
    }

    /**
     * 借助二维数组特性：从右上开始查找
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray_2(int[][] matrix, int target) {
        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) { // 对数组进行校验
            return false;
        }
        int rows = matrix.length, columns = matrix[0].length, row = 0, column = columns - 1; // 初始值matrix[row][column]为右上第一个值
        while (row < rows && column >= 0) {
            if (matrix[row][column] == target) { // 相等直接返回
                return true;
            } else if (matrix[row][column] > target) { // 如果比目标值大，列-1
                column--;
            } else if (matrix[row][column] < target) { // 如果比目标值小，行+1
                row++;
            }
        }
        return false; // 遍历结束，没有直接返回false
    }

    /**
     * 借助二维数组特性：从左下开始查找
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray_3(int[][] matrix, int target) {
        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) { // 对数组进行校验
            return false;
        }
        int rows = matrix.length, columns = matrix[0].length, row = rows - 1, column = 0; // 初始值matrix[row][column]为左下第一个值
        while (row >= 0 && column < columns) {
            if (matrix[row][column] == target) { // 相等直接返回
                return true;
            } else if (matrix[row][column] > target) { // 如果比目标值大，行-1
                row--;
            } else if (matrix[row][column] < target) { // 如果比目标值小，列+1
                column++;
            }
        }
        return false; // 遍历结束，没有直接返回false
    }
}
