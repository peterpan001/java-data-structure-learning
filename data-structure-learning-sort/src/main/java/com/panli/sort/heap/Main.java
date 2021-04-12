package com.panli.sort.heap;

/**
 * @author lipan
 * @date 2020-08-16
 * @desc 堆排序
 */
public class Main {

    public static void main(String[] args) {
        int nums[] = {1, 4, 6, 5, 2, 7, 8, 3};
        heapSort(nums);
        for (int tmp : nums) {
            System.out.print(tmp + " ");
        }
        System.out.println();
    }

    public static void heapSort(int nums[]) {
        if (nums == null || nums.length < 2) {
            return;
        }
        // 开始调整数组为大顶堆。从下往上调
        for (int i = 0; i < nums.length; i++) {
            heapInsert(nums, i);
        }

        int size = nums.length;
        swap(nums, 0, --size); // 把根节点与最后一个元素交换
        while (size > 0) {
            heapify(nums, 0, size); // 从新调整为大根堆
            swap(nums, 0, --size); //  把根节点与最后一个元素交换
        }
    }

    private static void heapify(int nums[], int root, int size) {
        int leftIdx = root * 2 + 1; // 取最小的左节点
        while (leftIdx < size) { // 保证数组不越界
            // 从左右自节点中获取最大的孩子节点下标
            int largestIdx = leftIdx + 1 < size && nums[leftIdx + 1] > nums[leftIdx] ? leftIdx + 1 : leftIdx;
            largestIdx = nums[largestIdx] > nums[root] ? largestIdx : root;
            if (largestIdx == root) {
                break;//如果最大下标是父结点,则不要交换,跳出while循环
            }
            swap(nums, root, largestIdx); // 调整为大根堆
            root = largestIdx; // 将最大节点下标赋值给根节点
            leftIdx = 2 * root + 1; // 获取左节点下标
        }
    }

    // 调整大根堆,不断向上循环,调整大根堆（根节点与叶子节点关系：左子节点 = 2*根 + 1；右子节点 = 2 * 根 + 2）
    private static void heapInsert(int nums[], int idx) {
        while (nums[idx] > nums[(idx - 1) / 2]) {
            swap(nums, idx, (idx - 1) / 2);
            idx = (idx - 1) / 2;
        }
    }

    private static void swap(int nums[], int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
