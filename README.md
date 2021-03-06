# DeltaPriorityBoarding
Joshua Weiner
<br>
Larry Wong
<br>
George Liang
<br>
Ryan Kim

## v1 Implementations
**Here, each individual's implementation of Array Priority Queue is detailed with explanations:**
<br>

| gliang | jweiner | lwong |
| --- | --- | --- |
| **public void add(String str)** <br> <ul><li> My add method was designed around the O(1) runtime stated in the Java API for all priority queues. The only way to achieve this was adding to the end of an ArrayList unsorted so no shifting would be done even if the number of elements gets larger. </li></ul> | **public void add(String str)** <br> <ul><li>The add method runs in O(1) time as specified by the Java API for ArrayPriorityQueues. This was done with the following design consideration: my queue is unsorted and does not sort Strings as they are added to the array. Instead, new Strings are added at the end of the ArrayPriorityQueue, which enables the method to run in constant time.</li></ul> | **public void add(String str)** <br> <ul><li>Similar to my teammate's implementations, my method runs at constant time by utilizing ArryList's default add method to add the String to the end of the array. This process is independent of other elements in ArrayList.</li></ul>|
| **public String peekMin()** <br> <ul><li>My implementation of peekMin() also follows the API for PriorityQueue, so it must have a runtime of O(n). This can be achieved by looking through each element and just comparing its priority to the priority of the element next in the Priority Queue. Since the ArrayList is only traversed once for each element, I can confidently say my method runs in O(n) time. </li></ul> | **public String peekMin()** <br> <ul><li>The peekMin() method runs in O(n) time as specified by the Java API for ArrayPriorityQueues. This was done because our APQ implementation is unordered. Therefore, my peekMin() method runs in O(n) time in the worst case as it traverses the entire queue to find the minimum value. This method will run an average time of O(n).</li></ul> |  **public String peekMin()** <br> <ul><li> Because my add method does not place any element in any sort of order, my peekMin() has to traverse through the ArrayList using the "reign-of-champion" algorithm. This means that this method runs at linear time.</li></ul>|
| **public String removeMin()** <br> <ul><li>This implementation of removeMin() follows the API for an ArrayPriorityQueue, so it must have a runtime of O(n). This can be achieved by looking through each element and comparing its priority to the priority of the next element in the Priority Queue. Since the ArrayList is only traversed once for each element, I can confidently say my method runs in O(n) time. </li></ul> | **public String removeMin()** <br> <ul><li>My removeMin() method runs in O(n) time as specified by the Java API for ArrayPriorityQueues. This was done similarly to peekMin(), because our APQ implementation is unordered. Therefore, my removeMin() method runs in O(n) time in the worst case as it traverses the entire queue to find the minimum value, then calls the remove() function for ArrayLists when it gets to the minimum element's index. I can say that this method will run an average time of O(n).</li></ul> |  **public String removeMin()** <br> <ul><li>Because my add method does not place any element in any sort of order, my removeMin() has to traverse through the ArrayList using the same algorithm as my peekMin() method. This means that this method runs at linear time.</li></ul>|

# Characterizing The Time Complexity
We followed the API in order to implement our ArrayPriorityQueue. This dictated the structure of our ArrayPriorityQueue, which meant elements were added to the queue in an unordered fashion, and then removed based on priority. This avoided the potential complication of having to resort the APQ upon every insertion of an element, which could create large runtimes for large arrays, and made the implementation of our methods straightforwards.
## add(String) v2
Our add method has a time complexity of O(1) because we decided to keep our ArrayList unsorted and add new elements to the end. <br>
The average runtime of this is O(1), with a worst case of O(1).
## peekMin() v2
This method has a time complexity of O(n) because it traverses through all the elements in the queue to find and return the minimum value. This is consistent with the API's documentation of this method. <br>
The average runtime of this is O(n), with a worst case of O(n).
## removeMin() v2
Similar to peekMin(), this method has a time complexity of O(n) because it traverses through all the elements in the queue to find and return the minimum value and uses the built-in ArrayList method to remove that element. This is consistent with the API. <br>
The average runtime of this is O(n), with a worst case of O(n).

# Heap To-do (COMPLETED!)
- Create a constructor so that we have a heap to begin with. (YES)
- Make sure we have a toString in order to verify our heap works (YES)
- implement isEmpty() (YES)
- implement add method (YES)
- implement minChildPos (YES)
- implement peekMin() (YES)
- implement removeMin() (YES)

# Heap Method Descriptions

| Method | Runtime | Description/Algo | Types |
| --- | --- | --- | --- |
| **int getSize()** | O(1) | Returns the size of the heap by returning the size of the underlying container. | <ul><li> Same in both Min and Max heaps </li></ul> |
| **String toString()** | O(n) | Returns a level-order traversal of the heap. Nodes are separated by level. | <ul><li> Same in both Min and Max heaps </li></ul> |
| **boolean isEmpty()** | O(1) | Returns true if no meaningful elements in heap, false otherwise (e.g. is ArrayList size == 0 ?) | <ul><li> Same in both Min and Max heaps </li></ul> |
| **Integer peek()** | O(1) | Returns the root of the heap, else return null of heap is empty. The heap remains unchanged. | <ul><li> **Min Heap:** peekMin(), the root is the smallest Integer </li><li> **Max Heap:** peekMax(), the root is the largest Integer </li></ul> |
| **void add(Integer)** | O(logn) | Algo: <ul><li> 1) Add the new element to an available spot on the bottom row (as a leaf)</li><li> 2) Check to see if this element is ordered with respect to its parent </li><li> 3) If not, swap with the parent else the element remains there </li><li> 4) Repeat steps 2-3 until the element can no longer swap, This means that the tree exhibits heap property.</li> | <ul><li> Same in both Min and Max heaps </li> <li> **Min Heap:** Swaps until it is the smallest element wrt the elements below it </li><li> **Max Heap:** Swaps until it is the largest element wrt the elements below it</li></ul> |
| **Integer remove(Integer)** | O(logn) | Algo:<li> 1) Remove the element from the tree creating a hole </i> <li> 2) Go to the node that is farthest right at the lowest level in the current half of the tree and move that node to the hole </li> <li> 3) Compare with all the children left and right, then replace the current element with the child that is smaller so that child is promoted as a parent. </li> <li> 4) Repeat steps 2-3 until the held element from 2 has no child node to swap with. This means that the tree exhibits heap property</li><li>Returns the removed node</li></ul>| <ul><li> **Min Heap:** removeMin() </li><li> **Max Heap:** removeMax() </li></ul> |
