package com.ps.Quene.Impl;

import com.ps.Array.Array;
import com.ps.Quene.Quene;

/**
 * @Author:panshuang
 * @Data:2018/9/2 08:59
 * @Description:队列相关实现
 */
public class QueneImpl <T> implements Quene <T> {

    private Array<T> array;

    public QueneImpl(int capacity){
       array = new Array<>(capacity);
    }

    public QueneImpl(){
        this(10);
    }

    @Override
    public void enQuene(T t) {
        array.addLast(t);
    }

    @Override
    public T deQuene() {
        return array.removeFirst();
    }

    @Override
    public T getFront() {
        return array.getFirst();
    }

    @Override
    public Integer getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
       return array.getSize() == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("front:[");
        for (int i = 0; i < getSize(); i++) {
            sb.append(array.find(i));
            if (i != getSize()-1) {
                sb.append(",");
            }
        }
        sb.append("]:tail");
        return sb.toString();
    }
}
