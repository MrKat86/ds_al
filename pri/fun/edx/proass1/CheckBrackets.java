package fun.edx.proass1;

import java.util.Scanner;
import java.util.Stack;

public class CheckBrackets {

	public static void main(String[] args) {
		Scanner sc = null;
		int count = 0;
		try {
			System.out.println("Enter Input: ");
			sc = new Scanner(System.in);
			String input = sc.next();
			System.out.println(input);

			Stack<Character> st = new Stack<Character>();
			char[] arr = input.toCharArray();
			for(; count<arr.length; count++) {
				if(isBracket(arr[count])) {
					if(isClosingBracket(arr[count])) {
						if(!checkPair(arr[count], st.pop())) {
							System.out.println(count+1);
							return;
						}
					} else {
						st.push(arr[count]);
					}
				}
			}
			if(st.size() == 0) {
				System.out.println("Success");
			} else {
				System.out.println(count);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}

	private static boolean checkPair(Character current, Character previous) {
		boolean result = false;
		switch(previous) {
		case '{':
			if(current == '}') {
				result =  true;
			}
			break;
		case '[':
			if(current == ']') {
				result =  true;
			}
			break;
		case '(':
			if(current == ')') {
				result =  true;
			}
			break;
		}
		return result;
	}

	private static boolean isClosingBracket(char c) {
		if(c == '}' || c == ']' || c == ')' ) {
			return true;
		}
		return false;
	}

	private static boolean isBracket(char c) {
		switch(c) {
		case '{':
		case '}':
		case '[':
		case ']':
		case '(':
		case ')':
			return true;
		default:
			return false;
		}
	}


}
