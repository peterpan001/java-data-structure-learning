package com.panli.sword.offer.medium_difficulty._0012;

/**
 * @author lipan
 * @date 2020-08-22
 * @desc 矩阵中的路径:借助深度优先搜索算法
 */
public class Main {

    /**
     * 深度优先搜索：每遍历到一个元素，就开始上下左右四个方向进行深度优先搜索，如果匹配继续，否则进行下一个元素的深度优先搜索；
     * 如果遍历结束还没有，则矩阵中不存在这样的路径
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) { // 借助深度优先搜索
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] words, int i, int j, int index) {
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || board[i][j] != words[index]) { // 临界条件判断
            return false;
        }
        if (index == words.length - 1) { // 如果index等于words长度，说明寻找到了路径
            return true;
        }
        char tmp = board[i][j]; // 改变当前值，防止回溯
        board[i][j] = '/';
        boolean res = dfs(board, words, i - 1, j, index + 1) || dfs(board, words, i + 1, j, index + 1) || dfs(board, words, i, j - 1, index + 1) || dfs(board, words, i, j + 1, index + 1); // 上下左右四个方向寻找
        board[i][j] = tmp; // 恢复当前值，为了下一次深度遍历
        return res;
    }
}
