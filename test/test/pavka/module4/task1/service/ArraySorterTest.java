package test.pavka.module4.task1.service;

import by.pavka.module4.task1.entity.ArrayWrapper;
import by.pavka.module4.task1.exception.ArrayWrapperException;
import by.pavka.module4.task1.service.ArraySorter;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ArraySorterTest {
  @Test
  public void sortBubbleTest() throws ArrayWrapperException {
    ArrayWrapper arrayWrapper = new ArrayWrapper(new int[] {-5, 33, -4, 1, -7, 0});
    ArrayWrapper expected = new ArrayWrapper(new int[] {-7, -5, -4, 0, 1, 33});
    new ArraySorter().sortByBubble(arrayWrapper, false);
    assertEquals(arrayWrapper, expected);
  }

  @Test
  public void sortSelectionTest() throws ArrayWrapperException {
    ArrayWrapper arrayWrapper = new ArrayWrapper(new int[] {-5, 33, 4, 0, 1, -7, 0});
    ArrayWrapper expected = new ArrayWrapper(new int[] {33, 4, 1, 0, 0, -5, -7});
    new ArraySorter().sortBySelection(arrayWrapper, true);
    assertEquals(arrayWrapper, expected);
  }

  @Test
  public void sortShellTest() throws ArrayWrapperException {
    ArrayWrapper arrayWrapper = new ArrayWrapper(new int[] {-5, 33, 4, 0, 1, -7, 0});
    ArrayWrapper expected = new ArrayWrapper(new int[] {-7, -5, 0, 0, 1, 4, 33});
    new ArraySorter().sortByShell(arrayWrapper, false);
    assertEquals(arrayWrapper, expected);
  }
}
