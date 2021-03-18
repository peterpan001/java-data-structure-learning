package com.panli.interview.two_dimensional_array_topk;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * n x m 的数组，每一行从大到小有序，行之间无关，求前k大的数（k < m x n）
 *
 * @author lipan
 * @date 2021-03-18
 */
public class Solution {

    public static int[] findTopMinK(int[][] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                heap.offer(arr[i][j]);
            }
        }
        int res[] = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll();
        }
        return res;
    }


    public static int[] findTopMaxK(int[][] arr, int k) {
        Queue<Integer> heap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer x1, Integer x2) {
                return Integer.compare(x1, x2);
            }
        });
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                heap.add(arr[i][j]);
                if (heap.size() > k) {
                    heap.poll();
                }
            }
        }
        int[] res = new int[heap.size()];
        int idx = 0;
        for (int no : heap) {
            res[idx++] = no;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arr = {{4, 1, 8, 9}, {5, 2, 7, 8}, {3, 3, 2}};
        int[] maxArr = findTopMaxK(arr, 1);
        for (int i = 0; i < maxArr.length; i++) {
            System.out.println(maxArr[i]);
        }
        System.out.println("-------------------");
        int[] minArr = findTopMinK(arr, 1);
        for (int i = 0; i < minArr.length; i++) {
            System.out.println(minArr[i]);
        }
    }
}
