package com.panli.sword.offer.medium_difficulty._0004;

/**
 * @author lipan
 * @date 2021-04-04
 */
public class Solution {

    
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix == null){
            return false;
        }
        int rows = matrix.length - 1, columns = 0;
        while(rows >= 0 && columns < matrix[0].length){
            if(matrix[rows][columns]  == target){
                return true;
            }else if(matrix[rows][columns] < target){
                columns++;
            }else{
                rows--;
            }
        }
        return false;
    }
}
