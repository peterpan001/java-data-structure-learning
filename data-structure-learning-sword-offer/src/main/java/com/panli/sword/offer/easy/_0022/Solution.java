package com.panli.sword.offer.easy._0022;

import com.panli.sword.offer.domain.ListNode;

/**
 * @author lipan
 * @date 2021-04-05
 */
public class Solution {


    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode quickNode = head;
        ListNode slowNode = head;
        while (k > 1) {
            if (quickNode.next != null) {
                quickNode = quickNode.next;
                k--;
            } else {
                return null;
            }
        }
        while (quickNode.next != null) {
            quickNode = quickNode.next;
            slowNode = slowNode.next;
        }
        return slowNode;
    }
}
