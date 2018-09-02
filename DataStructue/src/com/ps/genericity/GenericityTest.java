package com.ps.genericity;

import com.ps.model.Employee;
import com.ps.model.Person;
import com.ps.model.Student;

public class GenericityTest {

	public static void testGenericity() {
		//编译通过，但是运行时还是会检查类型，引用父类，指向子类，学生不是工人，就会包转换类型一场的运行时错误
//		Person[] arr = new Employee[5];
//		arr[0] = new Student();
//		arr[1] = new Employee();

		//协变数组类型，即数组类型时兼容的，以及数组包含的内容可以是其本身或者其子类
		Person[] arr1 = new Person[5];
		arr1[0] = new Student();
		arr1[1] = new Employee();
	}
	
	public static void main(String[] args) {
		testGenericity();
	}
}
