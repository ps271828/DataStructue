package com.ps.tree;

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
        }else if (t.compareTo(node.t) > 0) {
            node.right = new Node(t);
            this.size ++;
            return;
        }else if (t.compareTo(node.t) < 0) {
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
}
