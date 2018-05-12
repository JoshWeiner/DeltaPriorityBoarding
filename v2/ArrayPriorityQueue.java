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
     * postcondition: adds at the end of queue
     * O(1) - independent of other elements
     **********************************************************/
    public void add(String x){
	queue.add(x);
    }

    /**********************************************************
     * precondition:  queue is not null
     * postcondition: returns true if size is 0, else return true
     * O(1) - independent of other elements
     **********************************************************/
    public boolean isEmpty(){
	return queue.size() == 0;
    }

    /**********************************************************
     * precondition:  queue is not null
     * postcondition: returns the minimum string
     * O(n) - traverses through all elements using reign-of-champion
     **********************************************************/
    public int size(){
	return queue.size();
    }

    /**********************************************************
     * precondition:  queue.size() > 0
     * postcondition: returns the minimum string w/o altering queue
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

    /**********************************************************
     * precondition:  queue.size() > 0
     * postcondition: removes the minimum string and returns the minimum string
     * O(n) - traverses through all elements using reign-of-champion
     **********************************************************/
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

    /**********************************************************
     * precondition:  queue exists
     * postcondition: returns a string with all elements in the queue (not in priority queue)
     		      used for debugging
     * O(n) - traverses through all elements
     **********************************************************/
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
