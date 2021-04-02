import CITS2200.WindowLinked;


public class ListLinkedTest {
	public static void main(String[] args) {
		//Create new list
		ListLinked list = new ListLinked();
		
		//Create new window
		WindowLinked wind1 = new WindowLinked();
		
		//Check if isEmpty works properly
		/*
		System.out.println("Check if isEmpty works properly");
		boolean a = list.isEmpty();
		System.out.println(a);
		*/
		
		//Check if insertBefore throws an exception
		/*
		list.beforeFirst(wind1);
		System.out.println("Check if insertBefore throws an exception");
		list.insertBefore(1, wind1);
		*/
		
		//Check if insertAfter throws an exception
		/*
		list.afterLast(wind1);
		System.out.println("Check if insertAfter throws an exception");
		list.insertAfter(1, wind1);
		*/
		
		//Check if insertAfter, next, examine and isEmpty works fine
		/*
		Object test = new Object();
		list.beforeFirst(wind1);
		System.out.println("Check if insertAfter works fine");
		list.insertAfter(1, wind1);
		list.next(wind1);
		test = list.examine(wind1);
		System.out.println("The current object in the window: " + test);
		System.out.println("Check if isEmpty works properly");
		boolean b = list.isEmpty();
		System.out.println(b);
		*/
		
		//Check if insertBefore, previous, examine and isEmpty works fine
		/*
		Object test = new Object();
		list.afterLast(wind1);
		System.out.println("Check if insertBefore works fine");
		list.insertBefore(1, wind1);
		list.previous(wind1);
		test = list.examine(wind1);
		System.out.println("The current object in the window: " + test);
		System.out.println("Check if isEmpty works properly");
		boolean b = list.isEmpty();
		System.out.println(b);
		*/
		
		//Check if replace works fine
		/*
		Object test = new Object();
		list.beforeFirst(wind1);
		list.insertAfter(1, wind1);
		list.next(wind1);
		test = list.replace(5, wind1);
		System.out.println("The current object in the window: " + test);
		test = list.examine(wind1);
		System.out.println("The new object in the window: " + test);
		*/
		
		//Check if previous throws an exception
		/*
		list.beforeFirst(wind1);
		list.previous(wind1);
		*/
		
		//Check if next throws an exception
		/*
		list.afterLast(wind1);
		list.next(wind1);
		*/
		
		//Check if examine throws an exception for before first
		/*
		Object test = new Object();
		list.beforeFirst(wind1);
		test = list.examine(wind1);
		*/
		
		//Check if examine throws an exception for after last
		/*
		Object test = new Object();
		list.afterLast(wind1);
		test = list.examine(wind1);
		*/
		
		//Check if delete works fine
		/*
		Object test = new Object();
		list.beforeFirst(wind1);
		list.insertAfter(1, wind1);
		list.next(wind1);
		test = list.delete(wind1);
		System.out.println("The previous object: " + test);
		test = list.examine(wind1);
		*/
		
		//Check if replace throws an exception
		/*
		Object e = new Object();
		list.afterLast(wind1);
		e = list.replace(2, wind1);
		*/
		
		list.beforeFirst(wind1);
		list.insertAfter(1, wind1);
		list.next(wind1);
		Object c = list.examine(wind1);
		System.out.println(c);
		list.insertBefore(2, wind1);
		Object d = list.examine(wind1);
		System.out.println(d);
		list.previous(wind1);
		Object s = list.examine(wind1);
		System.out.println(s);
		list.next(wind1);
		Object a = list.examine(wind1);
		System.out.println(a);
		list.next(wind1);
		Object b = list.examine(wind1);
		System.out.println(b);
		
	}
}
