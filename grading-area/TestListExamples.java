import static org.junit.Assert.*;
import org.junit.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class IsMoon implements StringChecker {
  public boolean checkString(String s) {
    return s.equalsIgnoreCase("moon");
  }
}

public class TestListExamples {
  @Test(timeout = 500)
  public void testMergeRightEnd() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testFilter() {
    List<String> input = new ArrayList<>();
    input.add("test");
    input.add("testt");
    input.add("no");

    List<String> expected = new ArrayList<>();
    expected.add("test");
    expected.add("testt");
    StringChecker sc = new StringChecker() {
        public boolean checkString(String s) {
            return s.contains("t");
        }
    };
    assertEquals(expected, ListExamples.filter(input,sc));
  }

  @Test(timeout = 500)
  public void testMerge() {
    List<String> first = new ArrayList<>();
    first.add("a");
    first.add("b");
    first.add("d");

    List<String> second = new ArrayList<>();
    second.add("b");
    second.add("c");
    second.add("e");

    List<String> expected = new ArrayList<>();
    expected.add("a");
    expected.add("b");
    expected.add("b");
    expected.add("c");
    expected.add("d");
    expected.add("e");

    assertEquals(expected, ListExamples.merge(first,second));
  }
}
