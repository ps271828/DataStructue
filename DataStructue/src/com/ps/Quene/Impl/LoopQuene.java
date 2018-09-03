package com.ps.Quene.Impl;

import com.ps.Quene.Quene;

/**
 * @Author:panshuang
 * @Data:2018/9/2 10:03
 * @Description:循环队列实现
 */
public class LoopQuene <T> implements Quene <T> {

    private T[] data;

    private int fornt,tail;

    private int size;

    public LoopQuene(int capacity){
        data = (T[]) new Object[capacity+1];
        fornt = 0;
        tail = 0;
        size = 0;
    }

    public LoopQuene(){
        this(10);
    }

    //此处reSize的容量应为data.length-1的两倍，但是此时size的大小就是data.length-1,因此可以用size
    @Override
    public void enQuene(T t) {
        if ((tail + 1)%data.length == fornt) {
            reSize(size*2+1);
        }
        data[tail] = t;
        size++;
        tail = (tail+1)%data.length;
    }
    
    @Override
    public T deQuene() {
        if (isEmpty()) {
            throw new IllegalStateException("The Quene is empty,no element can take out!");
        }

        T t = data[fornt];
        data[fornt] = null;
        fornt = (fornt+1)%data.length;
        size--;
        //这个位置不是很合理，初始给5的容量，入队一个，出队一个，容量就会减少，没有也别好的办法，只要能放进元素进行，后面再进行扩容
        if (size == (data.length-1)/4 && (data.length-1)/2 != 0) {
            reSize((data.length-1)/2+ 1);
        }
        return t;
    }

    @Override
    public T getFront() {
        return data[this.fornt];
    }

    @Override
    public Integer getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return tail == fornt;
    }

    public void reSize(int newCapicity){
        T[] newData = (T[]) new Object[newCapicity];
        //(i+1)%data.length+1 != tail
        for (int i = 0; i < size ; i++ ) {
            newData[i] = data[(i+fornt)%data.length];
        }
        data = newData;
        fornt = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("size:"+size+"    capicity:"+(data.length-1)+"\n");
        sb.append("front:[");
        for (int i = fornt; i !=tail; i = (i+1)%data.length) {
           sb.append(data[i%data.length]);
           if (i%data.length+1 != tail) {
               sb.append(",");
           }
        }
        sb.append("]:tail");
        return sb.toString();
    }
}
