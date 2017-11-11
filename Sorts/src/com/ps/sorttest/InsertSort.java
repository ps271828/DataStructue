package com.ps.sorttest;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Map.Entry;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
/**
 * 核心思想：
 * 选择一个排好序的数组，然后进行比较插入
 * @author Administrator
 *
 */
public class InsertSort {
    public static void main(String[] args) throws ParserConfigurationException {
		int[] arr = {1,4,3,2,5,9,6,8,7,0};
		insertSort(arr);
		System.out.println(Arrays.toString(arr));
		InputStream in = InsertSort.class.getClassLoader().getResourceAsStream("hibernate.properties");
		Properties p = new Properties();
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document d = db.newDocument();
		Element root = d.createElement("hibernate");
		d.appendChild(root);
		try {
			p.load(in);
			for(Entry<Object, Object> curr:p.entrySet()){
				System.out.println(curr.getKey()+"="+curr.getValue());
				Element element = d.createElement((String) curr.getKey());
				element.setNodeValue((String) curr.getValue());
				root.appendChild(element);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(d);
		TransformerFactory tff = TransformerFactory.newInstance();
		try {
			Transformer tf = tff.newTransformer();
			tf.transform(new DOMSource(d), new StreamResult("2.xml"));
			tf.setOutputProperty(OutputKeys.INDENT, "yes");
			tf.setOutputProperty(OutputKeys.STANDALONE, "yes");
			System.out.println(1);
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @param arr
	 */
	public static void insertSort(int[] arr){
		//完成控制排好序的数组长度，内层控制比较的轮数
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<i;j++){
		 		if((i+1)<arr.length&&arr[i+1]<=arr[j]){                
		 			int temp = arr[i+1]; 
					arr[i+1] = arr[j];                       
					arr[j] = temp;
				}
			}
		}
		
	}
}
