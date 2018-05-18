/*
  Team DeltaPriorityBoarding: George Liang, Joshua Weiner, Larry Wong, Ryan Kim
  APCS2 - pd08
  HW 49 -- Sink || Swim

  /*****************************************************
  * class ALHeapMax
  * SKELETON
  * Implements a min heap using an ArrayList as underlying container
  *****************************************************/

import java.util.ArrayList;

public class ALHeapMax
{

    //instance vars
    private ArrayList<Integer> _heap;

    /*****************************************************
     * default constructor  ---  inits empty heap
     *****************************************************/
    public ALHeapMax()
    {
	_heap = new ArrayList<Integer>();
    }

    /*****************************************************
     * toString()  ---  overrides inherited method
     * Returns either
     * a level-order traversal of the tree (simple version)
     *****************************************************/
    //Level order, but not with ASCII values yet. Nodes are, however, sepatated by level
    public String toString()
    {
	String str = "";

	int level = 0;
	int index = 0;
	int inLevel = 0;

	while (index < _heap.size()) {
	    int numInLevel = (int)Math.pow(2,level);

	    if (inLevel < numInLevel) {
		str += _heap.get(index) + " ";
		inLevel ++;
		index ++;
	    }

	    else {
		inLevel = 0;
		str += System.lineSeparator();
		level ++;
	    }
	}
	System.out.println();
	return str;

    }//O(n)


    

    /*****************************************************
     * boolean isEmpty()
     * Returns true if no meaningful elements in heap, false otherwise
     *****************************************************/
    public boolean isEmpty()
    {
	return _heap.size() == 0;
    }//O(1)


    /*****************************************************
     * Integer peekMax()
     * Returns max value in heap
     * Postcondition: Heap remains unchanged.
     *****************************************************/
    public Integer peekMax()
    {
	if ( isEmpty() )
	    { return null; }
	return _heap.get(0);
    }//O(1)


    /*****************************************************
     * add(Integer)
     * Inserts an element in the heap
     * Postcondition: Tree exhibits heap property.
     * Algo:
     1) Add the new element to an available spot on the bottom row (as a leaf)
     2) Check to see if this element is ordered with respect to its parent
     3) If not, swap with the parent else the element remains there
     4) Repeat steps 2-3 until the element can no longer swap
 *****************************************************/
    public void add( Integer addVal )
    {
	_heap.add(addVal);

	int min = _heap.size()-1;

	for (int pos = min; pos > 0; pos = (int)Math.floor((pos-1)/2) ) {
	    int tempVal = _heap.get(pos);
	    int parentIndex = (int)Math.floor((pos-1)/2);
	    int parent = _heap.get(parentIndex);

	    if (tempVal > parent)
		swap(pos, parentIndex);
	}
    }//O(logn)


    /*****************************************************
     * removeMax()  ---  means of removing an element from heap
     * Removes and returns least element in heap.
     * Postcondition: Tree maintains heap property.
     * Algo:
  1) Remove the element from the tree creating a hole
  2) Go to the node that is farthest right at the lowest level in the current half of the tree and swap that element in
  3) Compare with all the children left and right, then replace the current element with the child that is smaller so that child is promoted as a parent.
  4) Repeat steps 2-3 until the held element from 2 has no child node therefore can no longer swap
     *****************************************************/
    public Integer removeMax()
    {
	int temp,pos ,level,leftIndex,rightIndex;
	ArrayList<Integer> cleanHeap = new ArrayList<Integer>();

	if(isEmpty()){
	    return null;
	}
	leftIndex = 1;
	rightIndex = 2;
	temp = _heap.get(0);
	_heap.set(0,null);
	swap(0,_heap.size() - 1);
	pos = 0;
	leftIndex = 1;
	rightIndex = 2;

	while(!(leftIndex >= _heap.size()) ||!( rightIndex >= _heap.size())){
	    if (_heap.get(leftIndex) == null || _heap.get(rightIndex) == null){
		break;
	    }
	    if(maxOf(_heap.get(leftIndex),_heap.get(rightIndex))==_heap.get(leftIndex)){
		swap(pos,leftIndex);
		pos = leftIndex;
		rightIndex = pos * 2 + 2;
		leftIndex = pos * 2 + 1;
	    }
	    else{
		swap(pos,rightIndex);
		pos = rightIndex;
		rightIndex = pos * 2 + 2;
		leftIndex = pos * 2 + 1;
	    }
	}

	for (int x = 0; x < _heap.size() - 1; x++){
	    cleanHeap.add(x,_heap.get(x));
	}
	_heap = cleanHeap;
	return temp;
    }//O(logn)

	
    /*****************************************************
     * maxChildPos(int)  ---  helper fxn for removeMax()
     * Returns index of least child, or
     * -1 if no children, or if input pos is not in ArrayList
     * Postcondition: Tree unchanged
     *****************************************************/
    private int maxChildPos( int pos )
    {
	int leftChild = -1;
	int rightChild = -1;
	if (pos == 0) {
	    leftChild = 1;
	    rightChild = 2;
	}
	else {
	    leftChild = pos * 2;
	    rightChild = pos * 2 + 1;
	}

	//does the heap contain the children of the parent node
	if (_heap.size() < rightChild) {
	    if (_heap.get(leftChild) > _heap.get(rightChild))
		return leftChild;
	    else
		return rightChild;
	}
	return -1;
    }//O(1)
    

    //************ aux helper fxns ***************
    private Integer maxOf( Integer a, Integer b )
    {
	if ( a.compareTo(b) < 0 )
	    return b;
	else
	    return a;
    }

    //swap for an ArrayList
    private void swap( int pos1, int pos2 )
    {
	_heap.set( pos1, _heap.set( pos2, _heap.get(pos1) ) );
    }
    //********************************************



    //main method for testing
    public static void main( String[] args )
    {

	ALHeapMax pile = new ALHeapMax();

	pile.add(2);
	System.out.println(pile);
	pile.add(4);
	System.out.println(pile);
	pile.add(6);
	System.out.println(pile);
	pile.add(8);
	System.out.println(pile);
	pile.add(10);
	System.out.println(pile);
	pile.add(1);
	System.out.println(pile);
	pile.add(3);
	System.out.println(pile);
	pile.add(5);
	System.out.println(pile);
	pile.add(7);
	System.out.println(pile);
	pile.add(9);
	System.out.println(pile);

	System.out.println(pile.maxChildPos(0));
	System.out.println(pile.maxChildPos(1));
	System.out.println(pile.maxChildPos(2));
	System.out.println(pile.maxChildPos(3));

	System.out.println("removing " + pile.removeMax() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMax() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMax() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMax() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMax() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMax() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMax() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMax() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMax() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMax() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMax() + "...");
	System.out.println(pile);
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main()

}//end class ALHeapMax
