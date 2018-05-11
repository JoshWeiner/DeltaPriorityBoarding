# DeltaPriorityBoarding
Joshua Weiner
<br>
Larry Wong
<br>
George Liang

## v1 Implementations
**Here, each individual's implementation of Array Priority Queue is detailed with explanations:**
<br>

| gliang | jweiner | lwong |
| --- | --- | --- |
| **public void add(String str)** <br> <ul><li> My add method was designed around the O(1) runtime stated in the Java API for all priority queues. The only way to achieve this was adding to the end of an ArrayList unsorted so no shifting would be done even if the number of elements gets larger. </li></ul> | **public void add(String str)** <br> <ul><li>The add method runs in O(1) time as specified by the Java API for ArrayPriorityQueues. This was done with the following design consideration: my queue is unsorted and does not sort Strings as they are added to the array. Instead, new Strings are added at the end of the ArrayPriorityQueue, which enables the method to run in constant time.</li></ul> | **public void add(String str)** <br> <ul><li>Similar to my teammate's implementations, my method runs at constant time by utilizing ArryList's default add method to add the String to the end of the array. This process is independent of other elements in ArrayList.</li></ul>|
| **public String peekMin()** <br> <ul><li> My implementation of peekMin() also follows the API for PriorityQueue, so it must have a runtime of O(n). This can be achieved by looking through each element and just comparing its priority to the priority of the element next in the Priority Queue. Since the ArrayList is only traversed once for each element, I can confidently say my method runs in O(n) time. </li></ul> | **public String peekMin()** <br> <ul><li>The peekMin() method runs in O(n) time as specified by the Java API for ArrayPriorityQueues. This was done because our APQ implementation is unordered. Therefore, my peekMin() method runs in O(n) time in the worst case as it traverses the entire queue to find the minimum value. This method will run an average time of O(n).</li></ul> |  **public String peekMin()** <br> <ul><li> Because my add method does not place any element in any sort of order, my peekMin() has to traverse through the ArrayList using the "reign-of-champion" algorithm.|


# Characterizing The Time Complexity
We followed the API in order to implement our ArrayPriorityQueue
## add(String) v2
Add has a time complexity of O(1) because we decided to keep our ArrayList unsorted and add new elements to the end.
## removeMin() v2

## peekMin() v2








<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
### always remember to go to class, kids
