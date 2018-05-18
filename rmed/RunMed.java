import java.util.NoSuchElementException;
import java.util.ArrayList;
public class RunMed {

  private ArrayList<Integer> nums;
  private ALHeapMax lowerInts;
  private ALHeapMin upperInts;

  public RunMed() {
    nums = new ArrayList<Integer>();
    lowerInts = new ALHeapMax();
    upperInts = new ALHeapMin();
  }

  /*
  add() Preconditions:
    * @param num is the integer to be added to the arrays
  */
  public void add(int num) {
      if (num < lowerInts.peekMax()) {
      lowerInts.add(num);
    }
    else
      upperInts.add(num);

    if (lowerInts.size() + 1 < upperInts.size()) {
      while (lowerInts.size() - 1 > upperInts.size()) {
	  upperInts.add(lowerInts.removeMax());
      }
    }
    else {
      while (upperInts.size() - 1 > lowerInts.size()) {
	  lowerInts.add(upperInts.removeMin());
      }
    }

  } //O (n^2)

  public int getMedian() {

    if (lowerInts.isEmpty() && upperInts.isEmpty()) {
      return -1;
    }
    else if (lowerInts.isEmpty()) {
      return upperInts.peekMin();
    }
    else if (upperInts.isEmpty()) {
      return lowerInts.peekMax();
    }
    else {
      if (upperInts.size() > lowerInts.size()) {
        return upperInts.peekMin();
      }
      else if (lowerInts.size() > upperInts.size()) {
        return lowerInts.peekMax();
      }
      else
        return (lowerInts.peekMax() + upperInts.peekMin()) / 2;
    }
  }



  public static void main(String[] args) {
  }

}
