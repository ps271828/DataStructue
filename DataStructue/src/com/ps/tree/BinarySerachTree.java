package com.ps.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author:panshuang
 * @Data:2018/10/5 22:55
 * @Description:二分搜索树，性质：左节点小于右节点
 */
//泛型继承comparable类，有比较才好构成二叉树
public class BinarySerachTree <T extends Comparable> {

    private class Node{
        public T t;
        public Node left;
        public Node right;

        public  Node(T t){
            this.t = t;
            this.left = null;
            this.right = null;
        }
    }
    private Node root;
    private Integer size;
    public BinarySerachTree(T t){
        this.root = new Node(t);
        this.size = 1;
    }

    public BinarySerachTree(){
        this.root = null;
        this.size = 0;
    }

    public int getSize(){
        return this.size;
    }

    public boolean isEmpty(){
        return this.root == null;
    }

    public void add(T t){
        if (this.root == null) {
            this.root = new Node(t);
            this.size ++;
        }else {
            add(this.root, t);
        }
    }

    //递归添加新元素，但是没有递归到最底层
    private void add(Node node, T t){
        if (t.equals(node.t)) {
            return;
        }else if (t.compareTo(node.t) > 0 && node.right == null) {
            node.right = new Node(t);
            this.size ++;
            return;
        }else if (t.compareTo(node.t) < 0 && node.left == null) {
            node.left = new Node(t);
            this.size ++;
            return;
        }

        if (t.compareTo(node.t) > 0) {
            add(node.right, t);
        }else {
            add(node.left, t);
        }
    }

    //递归到最底层，如果不为空，将原来的☞赋一遍，否则新建一个，但是违反了递归可的合成效益原则，虽然这样写代码量很小
    private Node add1(Node node, T t){
        if (node == null) {
            this.size ++;
            return new Node(t);
        }

        if (t.compareTo(node.t) < 0) {
            node.left = add1(node.left, t);
        } else if (t.compareTo(node.t) > 0) {
            node.right = add1(node.right, t);
        }
        return node;
    }

    public boolean contains(T t){
        return contains(this.root, t);
    }

    /**
     * 递归判断是否包含某元素
     * @param node
     * @param t
     * @return
     */
    private boolean contains(Node node, T t){
        if (node == null) {
            return false;
        }

        if (t.compareTo(node.t) == 0) {
            return  true;
        }else if (t.compareTo(node.t) > 0) {
            return contains(node.right, t);
        }else {
            return contains(node.left, t);
        }
    }

    /**
     * 先序后序中序区别在于根节点的读取位置，根再开头就为先序，中间就为中序，最后就为后续
     */
    //先序遍历
    public void preFix(){
        preFix(this.root);
    }

    /**
     * z指定节点遍历其以及其下的子节点  前序遍历
     * @param node
     */
    private void preFix(Node node){
        if (node == null) {
            return ;
        }
        System.out.println(node.t);
        preFix(node.left);
        preFix(node.right);
    }

    //中序遍历
    public void inOrder(){
        inOrder(this.root);
    }

    public  void inOrder(Node node){
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.t);
        inOrder(node.right);
    }

    //后序遍历
    public void lastRoot(){
        lastRoot(this.root);
    }

    private void lastRoot(Node node){
        if (node == null) {
            return;
        }
        lastRoot(node.left);
        lastRoot(node.right);
        System.out.println(node.t);
    }

    /**
     * 深度优先二叉树，适用于查看深度以及获取底层元素等场景
     */
    public void stackPreFix(){
        Stack<Node> stack = new Stack<>();
        stack.push(this.root);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.t);
            if (cur.right != null) {
                stack.push(cur.right);
            }

            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    /**
     * 广度优先遍历二叉树  适用于寻找某元素得最短路径
     */
    public void levelFix(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(this.root);
        while (!queue.isEmpty()){
            Node cur = queue.remove();
            System.out.println(cur.t);

            if (cur.left != null) {
                queue.add(cur.left);
            }

            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    public static void main(String[] args) {
        BinarySerachTree<Integer> bst = new BinarySerachTree<>();

        /**
         *       5
         *     3   6
         *   2   4   8
         */

        int[] num = new int[]{5,3,2,6,8,4};

        for (int curr:num) {
            bst.add(curr);
        }
       //bst.inorder();
//       bst.prefix();
       //bst.lastroot();

        //bst.stackprefix();

        bst.levelFix();
    }
}
