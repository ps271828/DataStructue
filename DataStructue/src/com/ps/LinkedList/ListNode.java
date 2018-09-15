package com.ps.LinkedList;

import java.util.List;

/**
 * @Author:panshuang
 * @Data:2018/9/13 23:47
 * @Description:
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    /*public ListNode(int num[]){
        next = initNode(next, 0);
    }*/

    /**
     * 递归初始化ListNode
     * @param node
     * @param num
     * @param l
     * @return
     */
    public ListNode initNode (ListNode node, int num[], int l) {
        if (l == num.length) {
            return null;
        }
        node.val = num[l];
        node.next = initNode(new ListNode(0), num, l+1);
        return node;
    }
}
