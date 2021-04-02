import CITS2200.Deque;


public class DequeCyclicTest {
	public static void main(String[] args) {
		Object mynum = new Object();
		Object mynum2 = new Object();
		Object mynum3 = new Object();
		Object mynum4 = new Object();
		Deque<Object> deque = new DequeCyclic(3);
		/*
		boolean b = deque.isEmpty();
		System.out.println(b);
		
		boolean c = deque.isFull();
		System.out.println(c);
		*/
		deque.pushLeft(4);
		
		mynum = deque.peekLeft();
		System.out.println(mynum);
		
		deque.pushRight(8);
		
		mynum2 = deque.peekRight();
		System.out.println(mynum2);
		
		deque.pushLeft(5);
		
		mynum3 = deque.peekLeft();
		System.out.println(mynum3);
		
		mynum4 = deque.popLeft();
		System.out.println(mynum4);
		
		mynum4 = deque.popLeft();
		System.out.println(mynum4);
		
		mynum4 = deque.popRight();
		System.out.println(mynum4);
		/*
		mynum4 = deque.peekRight();
		System.out.println(mynum4);
		
		
		mynum2 = deque.peekRight();
		System.out.println(mynum2);
		
		deque.popRight();
		System.out.println("ab");
		
		boolean t = deque.isEmpty();
		System.out.println(t);
		
		deque.pushRight(2);
		
		mynum3 = deque.peekLeft();
		System.out.println(mynum3);
		
		mynum4 = deque.peekLeft();
		System.out.println(mynum4);
		
		boolean g = deque.isEmpty();
		System.out.println(g);
		
		deque.popLeft();
		
		boolean l = deque.isEmpty();
		System.out.println(l);
		
		System.out.println("ab");
		*/
	}

}
