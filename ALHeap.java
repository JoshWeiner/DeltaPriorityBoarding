/*****************************************************
 * class ALHeap
 * SKELETON
 * Implements a min heap using an ArrayList as underlying container
 *****************************************************/

import java.util.ArrayList;

public class ALHeap
{

  //instance vars
  private ArrayList<Integer> _heap;

  /*****************************************************
   * default constructor  ---  inits empty heap
   *****************************************************/
  public ALHeap()
  {
    _heap = new ArrayList<Integer>();
    _heap.add(-1);
  }



  /*****************************************************
   * toString()  ---  overrides inherited method
   * Returns either
   * a) a level-order traversal of the tree (simple version)
   * b) ASCII representation of the tree (more complicated, more fun)
   *****************************************************/
  public String toString()
  {
    String retStr = "";
    if (isEmpty())
      return retStr;
    else {
      return _heap.get(1) + recursiveToString(1, true);
    }
  }//O(?)

  private String recursiveToString(int pos, boolean isLeft) {
    //pos is parent node
    String retStr = "";
    String leftStr = "";
    String rightStr = "";

    int leftChild = pos * 2;
    int rightChild = pos * 2 + 1;
    System.out.println(leftChild);

    if (leftChild < _heap.size()) {
      leftStr += _heap.get(leftChild);
      if (rightChild < _heap.size()) {
         rightStr += _heap.get(rightChild);
      }
    }
    retStr = leftStr + " " + rightStr;
    if (isLeft)
      retStr += System.lineSeparator();

      if (leftChild < _heap.size()) {
        retStr += recursiveToString(leftChild, true);
        if (rightChild < _heap.size()) {
           recursiveToString(rightChild, false);
        }
      }
    return retStr;
  }

  /*****************************************************
   * boolean isEmpty()
   * Returns true if no meaningful elements in heap, false otherwise
   *****************************************************/
  public boolean isEmpty()
  {
    return _heap.size() < 2;
  }//O(?)


  /*****************************************************
   * Integer peekMin()
   * Returns min value in heap
   * Postcondition: Heap remains unchanged.
   *****************************************************/
   /*
  public Integer peekMin()
  {
    if (!isEmpty()) {
			Integer minVal = heap.get(0);
			heap.set(0, heap.get(heap.size()-1));  // Move last to position 0
			heap.remove(heap.size()-1);
			minHeapify(heap, 0);
			return minVal;
		}
  }//O(?)


  /*****************************************************
   * add(Integer)
   * Inserts an element in the heap
   * Postcondition: Tree exhibits heap property.
   *****************************************************/
  public void add( Integer addVal )
  {
    _heap.add(addVal);

    int tempParent = 0;


    int tempLeftChild = tempParent * 2;
    int tempRightChild = tempParent * 2 + 1;
  }//O(?)


  /*****************************************************
   * removeMin()  ---  means of removing an element from heap
   * Removes and returns least element in heap.
   * Postcondition: Tree maintains heap property.
   *****************************************************/
   /*
  public Integer removeMin()
  {
  }//O(?)


  /*****************************************************
   * minChildPos(int)  ---  helper fxn for removeMin()
   * Returns index of least child, or
   * -1 if no children, or if input pos is not in ArrayList
   * Postcondition: Tree unchanged
   *****************************************************/
  private int minChildPos( int pos )
  {
    int leftChild = pos * 2;
    int rightChild = pos * 2 + 1;

    //does the heap contain the children of the parent node
    if (_heap.size() < rightChild) {
      if (_heap.get(leftChild) < _heap.get(rightChild))
        return leftChild;
      else
        return rightChild;
    }
    return -1;
  }//O(1)


  //************ aux helper fxns ***************
  private Integer minOf( Integer a, Integer b )
  {
    if ( a.compareTo(b) < 0 )
	    return a;
    else
	    return b;
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
      ALHeap pile = new ALHeap();

      pile.add(2);
      System.out.println(pile);
      System.out.println(System.lineSeparator());
      pile.add(4);
      System.out.println(pile);
      System.out.println(System.lineSeparator());

      pile.add(6);
      System.out.println(pile);
      System.out.println(System.lineSeparator());

      pile.add(8);
      System.out.println(pile);
      System.out.println(System.lineSeparator());

      pile.add(10);
      System.out.println(pile);
      System.out.println(System.lineSeparator());

      pile.add(1);
      System.out.println(pile);
      System.out.println(System.lineSeparator());

      pile.add(3);
      System.out.println(pile);
      System.out.println(System.lineSeparator());

      pile.add(5);
      System.out.println(pile);
      System.out.println(System.lineSeparator());

      pile.add(7);
      System.out.println(pile);
      System.out.println(System.lineSeparator());

      pile.add(9);
      System.out.println(pile);
      System.out.println(System.lineSeparator());

      /*
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class ALHeap
