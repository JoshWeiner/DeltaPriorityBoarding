public class RunMed.java {

  private ArrayList<Integer> nums;
  private ALMaxHeap lowerInts;
  private ALHeapMin upperInts;

  public RunMed() {
    nums = new ArrayList<Integer>();
    lowerInts = new ALMaxHeap();
    upperInts = new ALHeapMin();
  }

  /*
  add() Preconditions:
    * @param lowerInts is a max-heap, with the highest integer in the heap at the root
    * @param upperInts is a min-heap, with the lowest integer at the top of the heat at the root
    * @param ints is an ArrayList of integers
  */
  public void add(int num) {
    if (num < lowerInts[0]) {
      lowerInts.add(num);
    }
    else
      upperInts.add(num);

    if (lowerInts.size() + 1 < upperInts.size()) {
      while (lowerInts.size() - 1 > upperInts.size()) {
        upperInts.add(lowerInts.remove(0));
      }
    }
    else {
      while (upperInts.size() - 1 > lowerInts.size()) {
        lowerInts.add(upperInts.remove(0));
      }
    }

  }


  /*
  Preconditions:
    * @param lowerInts is a max-heap, with the highest integer in the heap at the root
    * @param upperInts is a min-heap, with the lowest integer at the top of the heat at the root
    * @param ints is an ArrayList of integers
  */

  public static void main(String[] args) {

  }

}
