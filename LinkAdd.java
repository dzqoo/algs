/**
 * @author dzq
 * @date createtime： 2016年9月22日下午8:02:49
 * @version 1.0
 */
package com.xiaoxiang.algs.firstweek;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LinkAdd
{
	private static void init(List<Integer> ll1,List<Integer> ll2){
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("*********输入第一个加数位数********");
		int m = sc.nextInt();
		System.out.println("*********输入第一个加数********");
		for(int i=0;i<m;i++){
			ll1.add(sc.nextInt());
		}
		System.out.println("*********输入第二个加数位数********");
		int n = sc.nextInt();
		System.out.println("*********输入第二个加数********");
		for(int i=0;i<n;i++){
			ll2.add(sc.nextInt());
		}
	}
	public static List<Integer> add(List<Integer> ll1,List<Integer> ll2){
		LinkedList<Integer> ll3= new LinkedList<Integer>();
		int carry = 0;
		int value = 0;
		int l1 = ll1.size();
		int l2 = ll2.size();
		int minlen = l1>=l2?l2:l1;
		for(int i = 1;i<=minlen;i++){
			value = ll1.get(l1-i)+ll2.get(l2-i)+carry;
			carry = value / 10;
			value %= 10;
			ll3.addFirst(value);
		}
		List<Integer> ll4 = new LinkedList<Integer>();
		ll4 = l1>=l2?ll1:ll2;
		/*
		 * 为了防止当两个链表长度相等时有进位却不再执行落数操作，对这种情况进行特殊考虑
		 */
		if(l1==l2&&carry==1){
			ll3.addFirst(carry);
		}
		for(int j=ll4.size()-minlen-1;j>=0;j--){
			value = ll4.get(j)+carry;
			carry = value/10;
			value %= 10;
			ll3.addFirst(value);
		}
		return ll3;
	}
	public static void main(String[] args)
	{
		List<Integer> ll1= new LinkedList<Integer>();
		List<Integer> ll2= new LinkedList<Integer>();
		init(ll1,ll2);
	}
}
