package com.panli.sword.offer.medium_difficulty._0013;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lipan
 * @date 2020-08-23
 * @desc 机器人的运动范围
 * @solution 两种解法：深度优先遍历算法和广度优先遍历算法
 */
public class Main {

    public static void main(String[] args) {

    }

    /**
     * 深度优先算法
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount_1(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n]; // visited存储机器人走过的路径，初始化默认值为false，走过visited[i][j]就将其元素值设置为true
        return dfs(0, 0, m, n, k, visited); // 深度优先遍历算法
    }

    /**
     * 深度优先搜索算法：因为机器人可以上下左右走，但是因为其从某一个格子进来，所以只能去往其他三个方向，并且不可以重复；
     * 如果从左上第一个角开始行走，所以其实沿着右边和下边的思路即可解答此题。
     *
     * @param i
     * @param j
     * @param m
     * @param n
     * @param k
     * @param visited
     * @return
     */
    private int dfs(int i, int j, int m, int n, int k, boolean[][] visited) {
        if (i >= m || j >= n || k < sum(i, j) || visited[i][j]) { // 边界值判断
            return 0;
        }
        visited[i][j] = true; // 机器人行走过的位置标志为true
        return 1 + dfs(i + 1, j, m, n, k, visited) + dfs(i, j + 1, m, n, k, visited); // 右边和下边递归进行遍历，查找机器人可以运动的范围
    }

    private int sum(int i, int j) { // 判断机器人是否可走的下标路径计算方法sum()
        int sum = 0;
        while (i != 0) {
            sum += i % 10;
            i = i / 10;
        }
        while (j != 0) {
            sum += j % 10;
            j = j / 10;
        }
        return sum;
    }


    /**
     * 广度优先搜索算法：借助于队列即可解答
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount_2(int m, int n, int k) {
        int res = 0; // 存储机器人可以走的路径长度
        boolean[][] visited = new boolean[m][n]; // 存储机器人走过的路径，初始化为false
        Queue<int[]> queue = new LinkedList<int[]>(); // 借助队列进行广度优先遍历
        queue.add(new int[]{0, 0}); // 初始化机器人的第一个位置路径，加入到队列尾部
        while (!queue.isEmpty()) {
            int[] x = queue.poll(); // 队列先进先出，移除头部元素
            int i = x[0], j = x[1]; // 获取当前机器人的位置坐标
            if (i >= m || j >= n || k < sum(i, j) || visited[i][j]) { // 判断是否为边界值，是返回，否则继续
                continue;
            }
            visited[i][j] = true; // 设置机器人走过节点为true
            queue.add(new int[]{i + 1, j}); // 向右走，进队列
            queue.add(new int[]{i, j + 1}); // 向下走，进队列
            res++; // 路径长度加1
        }
        return res; // 返回路径长度
    }
}
