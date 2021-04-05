package com.panli.sword.offer.easy._0006;

import com.panli.sword.offer.domain.ListNode;

import java.util.Stack;

/**
 * @author lipan
 * @date 2021-04-04
 */
public class Solution {

    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<Integer>();
        while(head!=null){
            stack.push(head.val);
            head = head.next;
        }
        int[] nums = new int[stack.size()];
        int i = 0;
        while(!stack.isEmpty()){
            nums[i++] = stack.pop();
        }
        return nums;
    }
}
