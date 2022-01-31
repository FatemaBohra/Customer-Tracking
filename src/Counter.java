/**
 * Represents a counter with methods or manipulating a count.
 * @author fatemabohra
 *
 */
public class Counter {
	
	//instance variables
	
	/**
	 * Internal count for counter
	 */
	int count;
	
	//constructor
	/**
	 * Creates counter with given initial count
	 * @param initialCount to start with.
	 */
	public Counter(int initialCount) {
		this.setCount(initialCount);//call setCount with given initial count
	}
	
	//methods
	/**
	 * Increment the internal count by 1.
	 */
	public void increment() {
		this.count++;
	}
	
	/**
	 * Returns internal count
	 * @return count
	 */
	public int getCount() {
		return this.count;
	}
	
	/**
	 * Sets the internal count to given count
	 * @param count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}

}
