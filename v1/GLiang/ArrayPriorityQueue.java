//George Liang
//APCS2 pd08
//HW46 -- Arrr, There Be Priorities Here Matey
//2018-05-10R
import java.util.ArrayList;
public class ArrayPriorityQueue implements PriorityQueue{
    private ArrayList<String> data;

    public ArrayPriorityQueue (){
	data = new ArrayList<String>();
    }

    //Returns true if queue is empty, otherwise returns false O(1)
    public boolean isEmpty(){
	return data.size() == 0;
    }

    //Adds an item to priority queue by adding to the end of arraylist. O(1)
    public void add(String x){
	data.add(x);
    }
    
    //Remove the current smallest element in the queue and return it, Min Val --> Max Priority
    //Each element must be cycled through in worst case O(n)
    //In a removal if min is at the end it would be constant because there is no
    //shift in the array but only the inital cycle through
    public String removeMin(){
	int index = 0;
	for(int i = index; i < data.size() - 1; i++){
	    if (data.get(index).compareTo(data.get(i+1)) > 0){
		index = i+1;
	    }
	}
	String temp = data.get(index);
	data.remove(index);
	return temp;
    }

    //Return the minimum value without removing it
    //Each element must be cycled through in worst case O(n)
    public String peekMin(){
	int index = 0;
	for(int i = index; i < data.size() - 1; i++){
	    if (data.get(index).compareTo(data.get(i+1)) > 0){
		index = i+1;
	    }
	}
	System.out.println(index);
	return data.get(index);
    }

    public static void main(String[]args){
	ArrayPriorityQueue letters = new ArrayPriorityQueue();
	letters.add("b");
	letters.add("a");
	letters.add("c");
	//Expecting peeks that go in the order of a,b,c and removals in order of a,b,c
	System.out.println(letters.peekMin());
	letters.removeMin();
	System.out.println(letters.peekMin());
	letters.removeMin();
	System.out.println(letters.peekMin());
	letters.removeMin();
	System.out.println(letters.isEmpty());
    }
}
