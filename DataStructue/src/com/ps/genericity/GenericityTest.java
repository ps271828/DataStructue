package com.ps.genericity;

import com.ps.model.Employee;
import com.ps.model.Person;
import com.ps.model.Student;

public class GenericityTest {

	public static void testGenericity() {
		//����ͨ������������ʱ���ǻ������ͣ����ø��ָ࣬�����࣬ѧ�����ǹ��ˣ��ͻ��ת������һ��������ʱ����
//		Person[] arr = new Employee[5];
//		arr[0] = new Student();
//		arr[1] = new Employee();
		
		//Э���������ͣ�����������ʱ���ݵģ��Լ�������������ݿ������䱾�����������
		Person[] arr1 = new Person[5];
		arr1[0] = new Student();
		arr1[1] = new Employee();
	}
	
	public static void main(String[] args) {
		testGenericity();
	}
}
