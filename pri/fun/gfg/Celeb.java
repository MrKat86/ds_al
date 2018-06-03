package fun.gfg;

import java.util.Stack;

/**
 * In a party of N people, only one person is known to everyone. Such a person
 * may be present in the party, if yes, (s)he doesn’t know anyone in the party.
 * We can only ask questions like “does A know B? “. Find the stranger
 * (celebrity) in minimum number of questions.
 * 
 * We can describe the problem input as an array of numbers/characters
 * representing persons in the party. We also have a hypothetical function
 * HaveAcquaintance(A, B) which returns true if A knows B, false otherwise. How
 * can we solve the problem.
 * 
 * @author KathirS1
 *
 */
public class Celeb {
	
	public static void main(String[] args) {
		char[] p = {'a', 'b', 'c', 'd', 'e'};
		Stack<Character> st = new Stack<>();
		st.push(p[0]);
		for(int i=1; i<p.length; i++) {
			if(st.isEmpty()) {
				st.push(p[i]);
				continue;
			}
			char p1 = st.pop();
			char p2 = p[i];
			if(haveAcquaintence(p1, p2)) {
				st.push(p2);
			} else if(haveAcquaintence(p2, p1)) {
				st.push(p1);
			}
		}
		if(!st.isEmpty())
			System.out.println(st.pop());
		System.out.println(st.size());
		
	}

	/**
	 * if a know b then return true.
	 * @param a
	 * @param b
	 * @return
	 */
	private static boolean haveAcquaintence(char a, char b) {
		if(b == 'c') {
			return true;
		}
		return false;
	}

}
