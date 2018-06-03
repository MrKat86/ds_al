package fun.gfg;

import java.util.Stack;

/**
 * Given an array, print the Next Greater Element (NGE) for every element. The
 * Next greater Element for an element x is the first greater element on the
 * right side of x in array. Elements for which no greater element exist,
 * consider next greater element as -1.
 * 
 * Examples: 
 * a) For any array, rightmost element always has next greater element
 * as -1. 
 * b) For an array which is sorted in decreasing order, all elements have
 * next greater element as -1. 
 * c) For the input array [4, 5, 2, 25}, the next
 * greater elements for each element are as follows.
 * 
 * Element NGE 
 * 4 --> 5 
 * 5 --> 25 
 * 2 --> 25 
 * 25 --> -1
 * 
 * d) For the input array [13, 7, 6, 12}, the next greater elements for each
 * element are as follows.
 * 
 * Element NGE 
 * 13 --> -1 
 * 7 --> 12 
 * 6 --> 12 
 * 12 --> -1
 *
 * 
 */
public class NGE {

	public void findNGE1(int[] a) {
		boolean skip = false;
		for(int i=0; i<a.length; i++) {
			for(int j=i+1; j<a.length; j++) {
				skip = false;
				if(a[i] < a[j]) {
					System.out.println(a[i]+" --> "+a[j]);
					skip = true;
					break;
				} else {
					continue;
				}
			}
			if(!skip || (i+1 == a.length))
				System.out.println(a[i]+" --> -1");
		}
	}

	public void findNGE2(int[] a) {
		Stack<Integer> st = new Stack<>();
		
		st.push(a[0]);
		
		for(int i=1; i<a.length; i++) {
			int next = a[i];
			while (!st.isEmpty()) {
				int current = st.pop();
				if(next > current) {
					System.out.println(current +" -- "+ next);
				} else {
					st.push(current);
					break;
				}
			}
			st.push(next);
		}
		while(!st.isEmpty()) {
			System.out.println(st.pop() +" -- -1");
		}

	}

	public static void main(String[] args) {
		int[] a = {4,5,2,25};
		NGE o = new NGE();
		o.findNGE2(a);

	}

}
