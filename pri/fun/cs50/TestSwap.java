package fun.cs50;

public class TestSwap {

	public static void main(String[] args) {
		int x = 1;
		int y = 2;
		
		System.out.println("x is :"+x+" & y is :"+y);
		swap(x ,y);
		System.out.println("x is :"+x+" & y is :"+y);
	}

	private static void swap(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}

}
