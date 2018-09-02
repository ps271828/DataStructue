package com.ps.Quene.Impl;

import com.ps.Quene.Quene;

/**
 * @Author:panshuang
 * @Data:2018/9/2 09:42
 * @Description:
 */
public class QueneTest {

    public static void testLoopQuene(){
        Quene<Integer> loopQuene = new LoopQuene<>(10);
        deQuene(loopQuene);
    }

    public static void main(String[] args) {
//        Quene<Integer> quene = new QueneImpl<>(10);
//        deQuene(quene);
        testLoopQuene();
    }

    private static void deQuene(Quene<Integer> quene) {
        for (int i = 0; i < 10; i++) {
           quene.enQuene(i);
           if (i % 3 == 2) {
               quene.deQuene();
           }
            System.out.println(quene.toString());
        }
    }
}
