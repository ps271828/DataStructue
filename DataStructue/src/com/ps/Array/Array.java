package com.ps.Array;

/**
 * @Author:panshuang
 * @Data:2018/8/27 23:41
 * @Description:数组相关操作,主要是模拟ArrayList的一些操作
 */
public class Array <T> {

    private T[] data;

    private int size;

    public Array(int capacity){
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public Array(){
        this(10);
    }

    public int getSize(){
        return size;
    }

    public int getCapicity(){
        return data.length;
    }

    /**
     * 顺序添加元素
     * @param t
     */
    public void add(T t){
        if (size == data.length) {
            resize(2 * data.length);
        }
        data[size] = t;
        size++;
    }

    /**
     * 根据坐标添加元素，要考虑容量够不够，先前这个位置只判断了索引是不是超出了实际长度
     * @param index
     * @param t
     */
   public void addByIndex(int index, T t){
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index is Illegal");
        }

        if (size == data.length) {
            resize(2 * data.length);
        }

        for (int i = size-1; i >= index; i--) {
            data[i+1] = data[i];
        }
        data[index] = t;
        size++;
   }

    /**
     * 数组扩容
     * @param newCapacity
     */
   public void resize(int newCapacity){
        T[] newData = (T[]) new Object[newCapacity];
        for (int i = 0; i <size; i++) {
            newData[i] = data[i];
        }
        data = newData;
   }

    /**
     * 第一个位置添加元素
     * @param t
     */
   public void addFirst(T t){
        addByIndex(0, t);
   }

    /**
     * 最后一个位置添加元素
     * @param t
     */
   public  void  addLast(T t){
        addByIndex(size, t);
   }

    /**
     * 查找第index个元素，从0到size-1
     * @param index
     * @return
     */
    public T find(int index){
       if (index < 0 && index >= size) {
           throw new IllegalArgumentException("index is out of bound!");
       }
       return data[index];
    }

    /**
     * 根据坐标跟新元素
     * @param index
     * @param t
     */
    public void set(int index, T t){
        if (index < 0 && index >= size) {
            throw new IllegalArgumentException("index is out of bound!");
        }
        data[index] = t;
    }

    /**
     * 查看是否包含某元素，如果包含，返回其索引，否则返回-1
     * @param t
     * @return
     */
    public int contains(T t){
        for (int i = 0; i<size; i++) {
            if (data[i].equals(t)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 根据索引删除元素
     * @param index
     * @return
     */
    public T remove(int index){
        if (index < 0 && index >= size) {
            throw new IllegalArgumentException("index is out of bound!");
        }
        T t = data[index];
        for (int i = index; i < size-1; i++) {
            data[i] = data[i+1];
            if (i+1 == size-1) {
                data[i+1] = null;
            }
        }
        size --;
        //防止data.length/2 == 0 的情况，避免一个元素的时候data[0]报错的情况
        //此处改写成这样是为了防止实际复杂度震荡，具体见映像笔记或者readme
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return t;
    }

    /**
     * 删除第一个元素
     * @return
     */
    public T removeFirst(){
        return remove(0);
    }

    /**
     * 删除最后一个元素
     * @return
     */
    public T removeLast(){
        return remove(size-1);
    }

    /**
     * 根据元素删除
     * @param t
     * @return
     */
    public T removeByElement(T t){
        int index = contains(t);
        if (index == -1)
            throw new IllegalArgumentException("This Element is not exists!");
        return remove(index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("The Size is "+size+"\n");
        sb.append("The Capicity is "+data.length+"\n");
        sb.append("[");
        for (int i = 0; i < size; i++) {
            if (i == size-1) {
                sb.append(data[i].toString()+"]");
                continue;
            }
            sb.append(data[i].toString()+",");
        }
        return sb.toString();
    }

    /**
     * 获取第一个元素
     * @return
     */
    public T getFirst(){
      return find(0);
    }

    /**
     * 获取最后一个元素
     * @return
     */
    public T getLast(){
        return find(size - 1);
    }
}
