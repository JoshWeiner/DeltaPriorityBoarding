import java.util.NoSuchElementException;
public class RunMed {

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
    * @param num is the integer to be added to the arrays
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

  } //O (n^2)

  public int getMedian() {

    if (lowerInts.isEmpty() && upperInts.isEmpty()) {
      return -1;
    }
    else if (lowerInts.isEmpty()) {
      return upperInts.get(0);
    }
    else if (upperInts.isEmpty()) {
      return lowerInts.get(0);
    }
    else {
      if (upperInts.size() > lowerInts.size()) {
        return upperInts.get(0);
      }
      else if (lowerInts.size() > upperInts.size()) {
        return lowerInts.get(0);
      }
      else
        return (lowerInts.get(0) + upperInts.get(0)) / 2;
    }
  }



  public static void main(String[] args) {
  }

}
