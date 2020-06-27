package test.pavka.module4.task2;

import by.pavka.module4.task2.exception.NullArrayException;
import by.pavka.module4.task2.handler.JaggedArrayHandler;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class JaggedArrayHandlerTest {
  @Test
  public void test1() throws NullArrayException {
    int[][] array = {{2, 2, 3}, {1, -2, -3}, {0}, {777}, {}};
    JaggedArrayHandler handler = new JaggedArrayHandler();
    handler.sortByMin(array, true);
    int[][] expected = {{777}, {2, 2, 3}, {}, {0}, {1, -2, -3}};
    for (int i = 0; i < 5; i++) {
      assertEquals(array[i], expected[i]);
    }
  }

  @Test
  public void test2() throws NullArrayException {
    int[][] array = {{1, 2}, {5, 10}, {3, 3, 3, 3}};
    JaggedArrayHandler handler = new JaggedArrayHandler();
    handler.sortBySum(array, false);
    int[][] expected = {{1, 2}, {3, 3, 3, 3}, {5, 10}};
    for (int i = 0; i < 3; i++) {
      assertEquals(array[i], expected[i]);
    }
  }

  @Test
  public void test3() throws NullArrayException {
    int[][] array = {{1, 2}, {5, 10}, {-3, 3, 3, 3}, {1, 2}};
    JaggedArrayHandler handler = new JaggedArrayHandler();
    handler.sortByMin(array, false);
    int[][] expected = {{-3, 3, 3, 3}, {1, 2}, {1, 2}, {5, 10}};
    for (int i = 0; i < 4; i++) {
      assertEquals(array[i], expected[i]);
    }
  }

  @Test(expectedExceptions = NullArrayException.class, expectedExceptionsMessageRegExp = "Null is" +
          " not allowed")
  public void test4() throws NullArrayException {
    int[][] array = {{1, 2}, {5, 10}, {-3, 3, 3, 3}, null};
    JaggedArrayHandler handler = new JaggedArrayHandler();
    handler.sortByMin(array, false);

  }
}
