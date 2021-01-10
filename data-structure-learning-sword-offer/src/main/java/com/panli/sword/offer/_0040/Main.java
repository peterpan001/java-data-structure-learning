package com.panli.sword.offer._0040;

/**
 * @author lipan
 * @date 2021-01-10
 * @desc 最小的k个数
 */
public class Main {

    public int[] getLeastNumbers(int[] arr, int k) {
        // 边界校验
        if (arr.length == 0 || k <= 0) {
            return new int[0];
        }
        quickSort(arr, 0, arr.length - 1);

        // copy前k个元素到结果集
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    /**
     * 快速排序
     *
     * @param arr
     * @param low
     * @param high
     */
    private void quickSort(int[] arr, int low, int high) {
        int pivotKey = partition(arr, low, high);
        quickSort(arr, low, pivotKey - 1);
        quickSort(arr, pivotKey + 1, high);
    }

    private int partition(int[] arr, int low, int high) {
        int pVal = arr[low];
        while (low < high) {
            while (low < high && arr[low] <= pVal) {
                low++;
            }
            swap(arr, low, high);
            while (low < high && arr[high] >= pVal) {
                high--;
            }
            swap(arr, low, high);
        }
        return low;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
