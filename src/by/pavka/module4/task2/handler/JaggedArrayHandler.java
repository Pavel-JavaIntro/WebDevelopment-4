package by.pavka.module4.task2.handler;

import by.pavka.module4.task2.exception.NullArrayException;

import java.util.Arrays;
import java.util.Comparator;

public class JaggedArrayHandler {
  private static final String MESSAGE = "Null is not allowed";

  public void sortByMax(int[][] twoDimArray, boolean descend) throws NullArrayException {
    Comparator<int[]> comparator =
            (o1, o2) -> findMaxInt(o1) - findMaxInt(o2);
    sortArray(twoDimArray, comparator);
    if (descend) {
      revertArray(twoDimArray);
    }
  }

  public void sortByMin(int[][] twoDimArray, boolean descend) throws NullArrayException {
    Comparator<int[]> comparator =
            (o1, o2) -> findMinInt(o1) - findMinInt(o2);
    sortArray(twoDimArray, comparator);
    if (descend) {
      revertArray(twoDimArray);
    }
  }

  public void sortBySum(int[][] twoDimArray, boolean descend) throws NullArrayException {
    Comparator<int[]> comparator =
            (o1, o2) -> calculateSum(o1) - calculateSum(o2);
    sortArray(twoDimArray, comparator);
    if (descend) {
      revertArray(twoDimArray);
    }
  }

  private <T> void sortArray(T[] array, Comparator<T> comparator) throws NullArrayException {
    if (array == null) {
      throw new NullArrayException(MESSAGE);
    }
    boolean sorted = false;
    while (!sorted) {
      sorted = true;
      for (int i = 0; i < array.length - 1; i++) {
        if (array[i] == null || array[i + 1] == null) {
          throw new NullArrayException(MESSAGE);
        }
        if (comparator.compare(array[i], array[i + 1]) > 0) {
          T temp = array[i];
          array[i] = array[i + 1];
          array[i + 1] = temp;
          sorted = false;
        }
      }
    }
  }

  private <T> void revertArray(T[] array) {
    int length = array.length;
    for (int i = 0; i < length / 2; i++) {
      T temp = array[i];
      array[i] = array[length - 1 - i];
      array[length - 1 - i] = temp;
    }
  }

  private int calculateSum(int[] array) {
    int sum = 0;
    if (array != null) {
      for (int i = 0; i < array.length; i++) {
        sum += array[i];
      }
    }
    return sum;
  }

  private int findMaxInt(int[] array) {
    Integer[] arr;
    try {
      arr = obtainSortedIntArray(array);
    } catch (NullArrayException e) {
      return 0;
    }
    int max = 0;
    if (arr.length != 0) {
      max = arr[arr.length - 1];
    }
    return max;
  }

  private int findMinInt(int[] array) {
    Integer[] arr;
    try {
      arr = obtainSortedIntArray(array);
    } catch (NullArrayException e) {
      return 0;
    }
    int min = 0;
    if (arr.length != 0) {
      min = arr[0];
    }
    return min;
  }

  private Integer[] obtainSortedIntArray(int[] array) throws NullArrayException {
    if (array == null) {
      throw new NullArrayException(MESSAGE);
    }
    Integer[] arr = Arrays.stream(array).boxed().toArray(Integer[]::new);
    Comparator<Integer> comparator = (o1, o2) -> o1 - o2;
    sortArray(arr, comparator);
    return arr;
  }
}
