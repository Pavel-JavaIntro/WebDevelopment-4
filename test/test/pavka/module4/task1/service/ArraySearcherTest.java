package test.pavka.module4.task1.service;

import by.pavka.module4.task1.entity.ArrayWrapper;
import by.pavka.module4.task1.entity.SearchCriteria;
import by.pavka.module4.task1.exception.ArrayWrapperException;
import by.pavka.module4.task1.service.ArraySearcher;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class ArraySearcherTest {
  @Test
  public void searchInSortedArrayTest1() throws ArrayWrapperException {
    ArrayWrapper arrayWrapper = new ArrayWrapper(new int[] {-4, 0, 2, 55, 109, 111});
    int expected = 3;
    int actual = new ArraySearcher().searchInSortedArray(arrayWrapper, 55);
    assertEquals(actual, expected);
  }

  @Test
  public void searchInSortedArrayTest2() throws ArrayWrapperException {
    ArrayWrapper arrayWrapper = new ArrayWrapper(new int[] {-4, 0, 2, 55, 109, 111});
    int expected = -1;
    int actual = new ArraySearcher().searchInSortedArray(arrayWrapper, 56);
    assertEquals(actual, expected);
  }

  @Test
  public void searchMinTest() throws ArrayWrapperException {
    ArrayWrapper arrayWrapper = new ArrayWrapper(new int[] {-4, 0, -222, 55, -109, 111});
    int expected = -222;
    int actual = new ArraySearcher().searchMin(arrayWrapper);
    assertEquals(actual, expected);
  }

  @Test
  public void searchPrineTest() throws ArrayWrapperException {
    ArrayWrapper arrayWrapper = new ArrayWrapper(new int[] {-4, 0, 2, 17, 9, 105});
    List<Integer> expected = new ArrayList<>();
    expected.add(2);
    expected.add(17);
    List<Integer> actual =
        new ArraySearcher().findElementsByCriteria(arrayWrapper, SearchCriteria.PRIME);
    assertEquals(actual, expected);
  }

  @Test
  public void searchFibonacciTest() throws ArrayWrapperException {
    ArrayWrapper arrayWrapper = new ArrayWrapper(new int[] {-4, 0, 2, 17, 9, 3});
    List<Integer> expected = new ArrayList<>();
    expected.add(2);
    expected.add(3);
    List<Integer> actual =
            new ArraySearcher().findElementsByCriteria(arrayWrapper, SearchCriteria.FIBONACCI);
    assertEquals(actual, expected);
  }

  @Test
  public void searchThreeDigitTest() throws ArrayWrapperException {
    ArrayWrapper arrayWrapper = new ArrayWrapper(new int[] {-444, 0, 209, -175, 909, 3});
    List<Integer> expected = new ArrayList<>();
    expected.add(209);
    expected.add(-175);
    List<Integer> actual =
            new ArraySearcher().findElementsByCriteria(arrayWrapper, SearchCriteria.THREE_DIGIT);
    assertEquals(actual, expected);
  }
}
