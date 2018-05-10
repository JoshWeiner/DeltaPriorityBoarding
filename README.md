# DeltaPriorityBoarding
Joshua Weiner
<br>
Larry Wong
<br>
George Liang

## v1 Implementations
Here, each individual's implementation of Array Priority Queue is detailed with explanations
<br><br>
**These are also aspects we all agreed on in our original implementations:**
<br>

| George | Josh | Larry |
| --- | --- | --- |
| testing | **public void add(String str)** <br> The add method runs in O(1) time as specified by the Java API for ArrayPriorityQueues. This was done with the following design consideration: my queue is unsorted and does not sort Strings as they are added to the array. Instead, new Strings are added at the end of the ArrayPriorityQueue, which enables the method to run in constant time. | 123 |
|   | **public String peekMin() ** <br> The peekMin() method runs in O(n) time as specified by the Java API for ArrayPriorityQueues. This was done because our APQ implementation is unordered. Therefore, my peekMin() method runs in O(n) time in the worst case as it traverses the entire queue to find the minimum value. This method will run an average time of O(n). |   |


# Characterizing The Time Complexity
We followed the API in order to implement our ArrayPriorityQueue
## add(String) v2
Add has a time complexity of O(1) because we decided to keep our ArrayList unsorted and add new elements to the end.
## removeMin() v2

## peekMin() v2








<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
### always remember to go to class, kids
