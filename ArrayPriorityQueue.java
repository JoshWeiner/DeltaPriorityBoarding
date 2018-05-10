/*
Joshua Weiner
APCS2 - pd08
HW #46: Arrr, There Be Priorities Here Matey . . .
2018 - 05 - 09
*/
import java.util.ArrayList;

public class ArrayPriorityQueue implements PriorityQueue{

	private ArrayList<String> queue;
	private int size;

	public ArrayPriorityQueue(){
		queue = new ArrayList<String>();
		size = 0;
	}

	/* Adds value to back of queue, does not order it
	Runtime: O(1)
	*/
	public void add(String x){
		queue.add(x);
		size++;
	}

	//Returns boolean of queue is empty
	public boolean isEmpty(){
		return size == 0;
	}

	//returns size of the queue
	public int size(){
		return size;
	}

	//Returns but does not remove the minimum value of the PriorityQueue
	//Runtime: O(n)
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
		size--;
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
