package fun.edx.proass1;

import java.util.Scanner;
import java.util.Stack;

public class CheckBrackets2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] arr = sc.next().toCharArray();
		Stack<Character> st = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '{' || arr[i] == '[' 
					|| arr[i] == '(') {
				st.push(arr[i]);
			} else if (arr[i] == '}') {
				if(st.pop() != '{') {
					System.out.println(i+1);
					return;
				}
			} else if (arr[i] == ']') {
				if(st.pop() != '[') {
					System.out.println(i+1);
					return;
				}
			} else if (arr[i] == ')') {
				if(st.pop() != '(') {
					System.out.println(i+1);
					return;
				}
			}
		}
		if(st.isEmpty()) {
			System.out.println("Success");
		} else {
			System.out.println(st.size());
		}
		
		sc.close();
	}

}
