/*
Team DeltaPriorityBoarding: George Liang, Joshua Weiner, Larry Wong
APCS2 - pd08
v2

/*****************************************************
 * class ArrayPriorityQueue
 * An ArrayList based, prioritized queue
 * Queues Strings in the order in which they were and compares them
 ******************************************************/

import java.util.ArrayList;

public class ArrayPriorityQueue implements PriorityQueue{

    private ArrayList<String> queue;

    public ArrayPriorityQueue(){
	queue = new ArrayList<String>();
    }

    /**********************************************************
     * precondition:  given a String
     * postcondition: _data adds at the end
     * O(1) - independent of other elements
     **********************************************************/
    public void add(String x){
	queue.add(x);
    }

    /**********************************************************
     * precondition:  _data is not null
     * postcondition: returns true if size is 0, else return true
     * O(1) - independent of other elements
     **********************************************************/
    public boolean isEmpty(){
	return queue.size() == 0;
    }

    /**********************************************************
     * precondition:  _data.size() > 0
     * postcondition: returns the minimum string
     * O(n) - traverses through all elements using reign-of-champion
     **********************************************************/
    public int size(){
	return queue.size();
    }

    /**********************************************************
     * precondition:  _data.size() > 0
     * postcondition: removes the minimum string and returns the minimum string
     * O(n) - traverses through all elements using reign-of-champion
     **********************************************************/
    public String peekMin(){
	String retStr = queue.get(0);

	if(isEmpty()){
	    throw new RuntimeException();
	}

	for(String item: queue){
	    if(item.compareTo(retStr) < 0){
		retStr = item;
	    }
	}
	return retStr;
    }

    //Returns and removes the minimum value of the PriorityQueue
    //Runtime: O(n)
    public String removeMin(){
	String retStr = queue.get(0);
	int indexToRemove = 0;

	if(isEmpty()){
	    throw new RuntimeException();
	}

	int i = 0;
	for(String item : queue){
	    if(item.compareTo(retStr) < 0 ){
		retStr = item;
		indexToRemove = i;
	    }
	    i ++;
	}
	queue.remove(indexToRemove);
	return retStr;
    }

    public String toString(){
	String retStr = "[";
	for(String item: queue){
	    retStr += (item + ",");
	}

	if (!isEmpty())
	    return  retStr.substring(0, retStr.length() - 1) + "]";
	else
	    return "[" + retStr.substring(0, retStr.length() - 1) + "]";
    }


    public static void main(String[] args){

	ArrayPriorityQueue q = new ArrayPriorityQueue();

	System.out.println(q.isEmpty());

	q.add("hello");
	q.add("there");
	q.add("jolly");
	q.add("green");
	q.add("giant");

	System.out.println(q);
	System.out.println("size: " + q.size());


	System.out.print("Removing...");
	System.out.println(q.peekMin()); //should be giant
	System.out.println(q.removeMin()); //should be giant
	System.out.println(q);

	System.out.print("Removing...");
	System.out.println(q.removeMin()); //should be green
	System.out.println(q);

	System.out.print("Removing...");
	System.out.println(q.removeMin()); //should be hello
	System.out.println(q);

	System.out.print("Removing...");
	System.out.println(q.removeMin()); //should be jolly
	System.out.println(q);

	System.out.print("Removing...");
	System.out.println(q.removeMin()); //should be there
	System.out.println(q);
	System.out.println("size: " + q.size()); //should be 0
    }

}//end class
