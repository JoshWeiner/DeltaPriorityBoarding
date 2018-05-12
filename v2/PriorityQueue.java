
/*****************************************************
 * interface PriorityQueue (for strings)
 * Specifies actions a Priority Queue must be able to perform (for Strings at the moment)
 * Underlying container not specified.
 *****************************************************/
public interface PriorityQueue{

	//add element to end of a list
    	public void add(String x);

	//traverses the list and returns the minimum (according to the standard conventions of string comparison)
	public String peekMin();
	
	//traverses the list and removes the minimum (according to the standard conventions of string comparison)
	public String removeMin();

	//return if list is empty
	public boolean isEmpty();


}
