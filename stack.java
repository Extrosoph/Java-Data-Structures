import CITS2200.Stack;

public class StackTest {

	public static void main(String[] args) {
		Object mynum = new Object();
		Stack stack = new StackBlock(1);
		stack.pop();
		
		stack.push("1");
		//stack.push("fbhdjwakf");
		mynum = stack.examine();
		System.out.println(mynum);
		stack.pop();
		mynum = stack.examine();
		/*
		for(int i = 1; i <= 100; i++)
		{
			stack.push(i);
			boolean b = ((StackBlock) stack).isFull();
			System.out.println(b);
		}
		
		boolean b = ((StackBlock) stack).isFull();
		System.out.println(b);
		
		stack.push(1);
		
		stack.pop();
		
		for(int i = 0; i < 100; i++)
		{
			mynum = stack.examine();
			System.out.println(mynum);
			stack.pop();
		}
		
		boolean c = stack.isEmpty();
		System.out.println(c);
		*/

	}

}
