package com.ps.LinkedList;

/**
 * @Author:panshuang
 * @Data:2018/9/13 23:46
 * @Description:删除指定得所有节点,通过虚拟头节点实现
 */
public class RemoveSameNode {
    /**
     * 使用虚拟头节点删除元素
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
     * 不使用虚拟头节点删除元素
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

    /**
     * 通过递归删除相同元素
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElementByRecursion(ListNode head, int val){
        if (head == null){
            return null;
        }
        //更好得处理了删除元素得操作，当下个元素等于删除元素得时候，就返回要删除元素得下一个元素
        head.next = removeElementByRecursion(head.next, val);
        return head.val == val ? head.next:head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        node.initNode(node, new int[]{1,2,3}, 0);
    }
}
