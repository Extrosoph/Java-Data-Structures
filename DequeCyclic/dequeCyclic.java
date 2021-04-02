import CITS2200.Overflow;
import CITS2200.Underflow;
import CITS2200.Deque;

public class DequeCyclic implements Deque<Object>{
	
	private Object[] deque;
	private int left;
	private int right;
	private int size;
	
	/**
	 * Create an empty deque of size s
	 * 
	 * @param s as size of deque
	 */
	public DequeCyclic(int s) {
		deque = new Object[s];
		right = -1;
		left = 0;
		size = s;
	}
	
	/**
	 * Return true iff the deque is empty, false otherwise
	 * 
	 * @return boolean
	 */
	public boolean isEmpty() {
		boolean empty = false;
		if(right == -1) {
			empty = true;
		}
		return empty;
	}
	/**
	 * Return true iff the deque is full, false otherwise
	 * 
	 * @retrun boolean
	 */
	public boolean isFull() {
		boolean full = false;
		if((right == 0 &&  left == size-1 ) || right == left+1) {
			full = true;
		}
		return full;
	}
	
	/**
	* Add object c as the left-most object in the deque, or throw an Overflow exception if the deque is full
	*
	*@param Object c to be added to the deque
	**/
	public void pushLeft(Object c) {
		if(isFull() == true) {
			throw new Overflow("deque is full");
		}
		else {
			if(right == -1) {
				left = 0;
				right = 0;
			}
			else if(left == size - 1) {
				left = 0;
			}
			else {
				left = left+1;
			}
			deque[left] = c;
		}
	}
	
	/**
	 * Add object c as the right-most object in the deque, or throw an Overflow exception if the deque is full
	 * 
	 * @param Object to be added to the deque
	**/
	public void pushRight(Object c) {
		if(isFull()==true) {
			throw new Overflow("deque is full");
		}
		else {
			if(right == -1) {
				right = 0;
				left = 0;;
			}
			else if(right == 0){
				right = size - 1;
			}
			else {
				right = right - 1;
			}
			deque[right] = c;
		}
	}
	
	/**
	 * Return the left-most object in the deque, or throw an Underflow exception if the deque is empty
	 * 
	 * @return Object of the far left index
	 */
	public Object peekLeft() {
		Object farLeft;
		if(isEmpty() == true) {
			throw new Underflow("deque is empty");
		}
		else {
			farLeft = deque[left];
		}
		return farLeft;
	}
	
	/**
	 * return the right-most object in the deque, or throw an Underflow exception if the deque is empty
	 * 
	 * @return Object of the far right index
	 */
	public Object peekRight() {
		Object farRight;
		if(isEmpty()==true) {
			throw new Underflow("deque is empty");
		}
		else {
				farRight = deque[right];
		}
		return farRight;
	}
	
	/**
	 * Remove and return the left-most object in the deque, or throw an Underflow exception if the deque is empty
	 * 
	 * @return Object of far Left index
	 */
	public Object popLeft() {
		Object farLeft;
		if(isEmpty()==true) {
			throw new Underflow("deque is empty");
		}
		else {
			farLeft = deque[left];
			if(left == right) {
				right = -1;
				left = -1;
			}
			else if (left == 0) {
				left = size-1;
			}
			else {
				left = left-1;
			}
		}
		return farLeft;
	}
	
	/**
	 * Remove and return the right-most object in the deque, or throw an Underflow exception if the deque is empty
	 * 
	 * @return Object of the far right index
	 */
	public Object popRight() {
		Object farRight;
		if(isEmpty()==true) {
			throw new Underflow("deque is empty");
		}
		else {
			farRight = deque[right];
			if(right == left) {
				right = -1;
				left = -1;
			}
			else if (right == size-1) {
				right = 0;
			}
			else {
				right = right + 1;
			}
		} 
		return farRight;
	}
	
}

