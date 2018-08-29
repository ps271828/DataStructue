package com.ps.stack.Impl;

import com.ps.Array.Array;
import com.ps.stack.ArrayStack;

/**
 * @Author:panshuang
 * @Data:2018/8/29 22:44
 * @Description:栈的实现类以及基本维护
 */
public class ArrayStackImpl <T> implements ArrayStack <T> {

    private Array<T> array;

    public ArrayStackImpl(int capacity){
        array = new Array<T>(capacity);
    }

    public ArrayStackImpl(){
        array = new Array<T>();
    }

    @Override
    public void push(T t) {
     array.addLast(t);
    }

    @Override
    public T pop() {
        return array.removeLast();
    }

    @Override
    public T peek() {
        return array.getLast();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        if (array.getSize() == 0) {
            return true;
        }
        return false;
    }

    /**
     * 获取栈的容量
     * @return
     */
    public Integer getCapicity(){
        return array.getCapicity();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("stack:[");
        for (int i = 0; i<array.getSize(); i++) {
            sb.append(array.find(i));
            if (i != array.getSize() -1) {
                sb.append(",");
            }
        }
        sb.append("]  top");
        return sb.toString();
    }
}
