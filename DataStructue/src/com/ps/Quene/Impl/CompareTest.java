package com.ps.Quene.Impl;

import com.ps.Quene.Quene;

import java.util.Random;

/**
 * @Author:panshuang
 * @Data:2018/9/2 14:41
 * @Description:数组队列与循环队列的比较
 */
public class CompareTest {

    /**
     * 在十万级别情况下，消耗时间差距一百倍以上
     * @param quene
     * @param optNum
     * @return
     */
    public static double testQuene(Quene<Integer> quene, int optNum){
        long start = System.nanoTime();
        for (int i = 0; i < optNum; i++) {
            Random random = new Random(optNum);
            quene.enQuene(random.nextInt());
        }

        for (int i = 0; i < optNum; i++) {
            quene.deQuene();
        }
        long end = System.nanoTime();
        return (end - start)/1000000000.0;
    }

    public static void main(String[] args) {
        Quene<Integer> arrayQuene = new QueneImpl<>();
        System.out.println(testQuene(arrayQuene,100000));

        Quene<Integer> loopQuene = new LoopQuene<>();
        System.out.println(testQuene(loopQuene,100000));

        Quene<Integer> linkedListQueue = new LinkedListQueue<>();
        System.out.println(testQuene(linkedListQueue,100000));
    }
}
