package com.ps.Array;

import java.util.*;

/**
 * @Author:panshuang
 * @Data:2018/8/28 22:14
 * @Description:
 */
public class ArrayTest {
    public static void main(String[] args){
        //˳����Ӳ���
        Array<Integer> arrInt = new Array<>(10);
        for (int i = 0; i <10; i++) {
            arrInt.add(i);
        }
        System.out.println(arrInt.toString());

        //������Ӳ���
        arrInt.addFirst(99);
        System.out.println(arrInt.toString());

        //β�����
        arrInt.addLast(100);
        System.out.println(arrInt.toString());

        //���������Ƴ�Ԫ��
        arrInt.remove(3);
        System.out.println(arrInt.toString());

        //��������
        System.out.println(arrInt.contains(5));

        //����Ԫ��ɾ������
        arrInt.removeByElement(5);
        System.out.println(arrInt.toString());

        //����������Ѱ����
        System.out.println(arrInt.find(1));

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        //�������Դ�remove����ɾ��Ԫ�ز����ƻ��������ĺϷ���
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            iterator.remove();
        }
        System.out.println(list.size());

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < 10; i++) {
           map.put(i, i);
        }

        //mao��Ҫת��ΪSet����ʹ�õ���������Ҳֻ�ܽ���remove���������ܽ�����Ӳ���
        Set<Map.Entry<Integer, Integer>> mapEntry = map.entrySet();
        Iterator mapIterator = mapEntry.iterator();
        while (mapIterator.hasNext()){
            mapIterator.remove();
        }
    }
}
