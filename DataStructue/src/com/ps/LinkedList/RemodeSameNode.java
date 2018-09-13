package com.ps.LinkedList;

/**
 * @Author:panshuang
 * @Data:2018/9/13 23:46
 * @Description:ɾ��ָ�������нڵ�,ͨ������ͷ�ڵ�ʵ��
 */
public class RemodeSameNode {
    /**
     * ʹ������ͷ�ڵ�ɾ��Ԫ��
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElementsByDummyNode(ListNode head, int val) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode prev = dummyNode;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummyNode.next;
    }

    /**
     * ��ʹ������ͷ�ڵ�ɾ��Ԫ��
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        while (head.val == val) {
            head = head.next;
            if (head == null) {
                return head;
            }
        }

        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }
}
