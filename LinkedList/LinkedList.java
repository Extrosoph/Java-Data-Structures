import java.lang.Object;
import CITS2200.Link;
import CITS2200.List;
import CITS2200.OutOfBounds;
import CITS2200.WindowLinked;


/**
 * 
 * @author 22764884(Theoridho Andily)
 * 
 * This class create a signly linked list which implement list from CITS2200
 * archive file.
 *
 */
public class ListLinked implements List{
	private Link before;
	private Link after;
	
	/**
	 * This is the constructor class to create a linked list
	 */
	public ListLinked() {
		after = new Link(null, null);
		before = new Link(null, after);
	}

	/**
	 * Initialises the window to the after last position
	 * 
	 * @param Window a
	 */
	public void afterLast(WindowLinked a) {
		a.link = after;
	}

	/**
	 * Initialises the window to the before first position
	 * 
	 * @param Window a
	 */
	public void beforeFirst(WindowLinked a) {
		a.link = before;
		
	}

	/**
	 * Throws an exception if the window is in the before first or after last position, 
	 * otherwise deletes and returns the element under the window, and places the window over the next 
	 * element
	 * 
	 * @param window  of the located object
	 * @return object from the located window
	 */
	public Object delete(WindowLinked a) throws OutOfBounds {
		Object current = new Object();
		if(isAfterLast(a) == true) {
			throw new OutOfBounds("The located window is on the after last position");
		}
		
		else if(isBeforeFirst(a) == true) {
			throw new OutOfBounds("The located window is on the before the first position");
		}
		
		else {
			current = a.link.item;
			a.link = a.link.successor;
		}
		return current;
	}

	/**
	 * Throws an exception if the window is in the before first or after last position, 
	 * otherwise returns the element under the window
	 * 
	 * @param Window of the located object
	 * @return Object located under the current window
	 */
	public Object examine(WindowLinked a) throws OutOfBounds {
		Object current = new Object();
		if(isAfterLast(a) == true) {
			throw new OutOfBounds("The located window is on the after last position");
		}
		
		else if(isBeforeFirst(a) == true) {
			throw new OutOfBounds("The located window is on the before first position");
		}
		
		else {
			current = a.link.item;
		}
		return current;
	}

	/**
	 * Throws an exception if the window is over the after last position, otherwise an extra object 
	 * a is added to the list after the current window
	 * 
	 * @param Object to be added after the current window
	 */
	public void insertAfter(Object a, WindowLinked b) throws OutOfBounds {
		if(!isAfterLast(b)) {
			b.link.successor = new Link(a, b.link.successor);
		}
		
		else {
			throw new OutOfBounds("Inserting after last of list");
		}
		
	}

	/**
	 * Throws an exception if the window is over the before first position, 
	 * otherwise an extra object is added to the list before the window
	 * 
	 * @param Object to be added before the window and the window where the object
	 * will be placed infront of
	 */
	public void insertBefore(Object a, WindowLinked b) throws OutOfBounds {
		if(!isBeforeFirst(b)) {
			b.link.successor = new Link(b.link.item, b.link.successor);
			if(isAfterLast(b)) {
				after = b.link.successor;
			}
				b.link.item = a;
				b.link = b.link.successor;
		}
		else {
			throw new OutOfBounds ("inserting before start of list");
		}
	}

	/**
	 * This function check whether the window is over the last postion
	 * 
	 * @return boolean true if the position is after last and false for else
	 */
	public boolean isAfterLast(WindowLinked a) {
		if(a.link == after) {
			return true;
		}
		return false;
	}

	/**
	 * This function check whether the window is over the before first
	 * 
	 * @return boolean true if the position is before first and false for else
	 */
	public boolean isBeforeFirst(WindowLinked a) {
		if(a.link == before) {
			return true;
		}
		return false;
	}

	/**
	 * This function checks whether the current window is empty
	 * 
	 * @return boolean true if empty and false is not empty
	 */
	public boolean isEmpty() {
		return before.successor == after;
	}

	/**
	 * This function moves the window to the next position and 
	 * returns an exception if it is after last position
	 */
	public void next(WindowLinked a) throws OutOfBounds {
		if(!isAfterLast(a)) {
			a.link = a.link.successor;
		}
		else {
			throw new OutOfBounds("Calling next after list end.");
		}
		
	}
	
	/**
	 * This function moves the window to the previous position and
	 * returns an exception if it is before first position
	 */
	public void previous(WindowLinked a) throws OutOfBounds {
		if(!isBeforeFirst(a)) {
			Link current = before.successor;
			Link previous = before;
			while (current != a.link) {
				previous = current;
				current = current.successor;
			}
			a.link = previous;
		}
		else {
			throw new OutOfBounds("Calling previous before start of list.");
		}
		
	}

	/**
	 * This function replaces the current object in the window with a new object
	 *  and it throws an exception if the window is located before first or after last
	 *  
	 * @param window of the location and the object to replace the old object
	 * @return old object of the current window
	 */
	public Object replace(Object a, WindowLinked b) throws OutOfBounds {
		Object old = new Object();
		if(isBeforeFirst(b) == true|| isAfterLast(b) == true) {
			throw new OutOfBounds("Window is out of bound for replacement");
		}
		
		else {
			old = b.link.item;
			b.link.item = a;
		}
		
		return old;
	}
	
}
